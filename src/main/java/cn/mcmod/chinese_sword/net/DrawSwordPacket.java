package cn.mcmod.chinese_sword.net;

import java.util.function.Supplier;

import cn.mcmod.chinese_sword.ChineseSword;
import cn.mcmod.chinese_sword.item.IDrawable;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SPlaySoundPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.network.NetworkEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.type.inventory.IDynamicStackHandler;

public class DrawSwordPacket {
    private final String message;

    public DrawSwordPacket(PacketBuffer buffer) {
        message = buffer.readUtf(Short.MAX_VALUE);
    }

    public DrawSwordPacket(String message) {
        this.message = message;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeUtf(this.message);
    }

    public void handler(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayerEntity player = ctx.get().getSender();
            if (ChineseSword.curiosLoaded) {
                // 判断饰品栏是否可用
                CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(itemHandler -> {
                    // 判断腰带栏（Belt）是否可用，饰品栏是自定义的所以可能会没有腰带栏。
                    itemHandler.getStacksHandler(SlotTypePreset.BELT.getIdentifier())
                            .ifPresent(stacksHandler -> drawSword(player, stacksHandler));
                });
            }

        });
        ctx.get().setPacketHandled(true);
    }

    private void drawSword(ServerPlayerEntity player, ICurioStacksHandler stacksHandler) {
        IDynamicStackHandler stackHandler = stacksHandler.getStacks();
        // 腰带栏不只有一个，从头遍历所有的腰带
        for (int i = 0; i < stackHandler.getSlots(); i++) {
            // 如果物品可以拔剑，则执行拔剑部分的代码并跳出循环。
            if (stackHandler.getStackInSlot(i).getItem() instanceof IDrawable) {
                // 先缓存主手的物品。
                ItemStack mainHandItem = player.getMainHandItem().copy();
                // 设置主手为腰带上的武器。
                player.setItemInHand(Hand.MAIN_HAND, stackHandler.getStackInSlot(i).copy());
                // 拔剑固定用主手拔，判断主手是否有物品并能否安置在物品栏内。
                // 后安置物品，避开吞物品的情况。
                // 不能，则丢出物品。
                if (!mainHandItem.isEmpty())
                    if (!player.addItem(mainHandItem))
                        player.drop(player.getMainHandItem(), false);
                // 播放拔剑音效，取玩家攻击音。
                // 不造成实际攻击。
                player.connection.send(new SPlaySoundPacket(SoundEvents.PLAYER_ATTACK_SWEEP.getLocation(),
                        SoundCategory.PLAYERS, player.position(), 1F, 1F));
                stackHandler.extractItem(i, 1, false);
                return;
            }
        }
    }

}
