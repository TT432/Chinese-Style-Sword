package cn.mcmod.chinese_sword.item;

import cn.mcmod.chinese_sword.Constants;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class WeaponTiers {
    public static final WeaponTier WOOD = new WeaponTier("wood", (IItemTier) ItemTier.WOOD, ItemTags.PLANKS.getName());

    public static final WeaponTier STONE = new WeaponTier("stone", (IItemTier) ItemTier.STONE,
            new ResourceLocation("forge:cobblestone"));

    public static final WeaponTier IRON = new WeaponTier("iron", (IItemTier) ItemTier.IRON,
            new ResourceLocation("forge:ingots/iron"));

    public static final WeaponTier GOLD = new WeaponTier("gold", (IItemTier) ItemTier.GOLD,
            new ResourceLocation("forge:ingots/gold"));

    public static final WeaponTier DIAMOND = new WeaponTier("diamond", (IItemTier) ItemTier.DIAMOND,
            new ResourceLocation("forge:gems/diamond"));

    public static final WeaponTier NETHERITE = new WeaponTier("netherite", (IItemTier) ItemTier.NETHERITE,
            new ResourceLocation("forge:ingots/netherite"));

    public static final WeaponTier COPPER = new WeaponTier("copper", Constants.MODID, 1, 200, 5.0F, 1.5F, 8,
            new ResourceLocation("forge:ingots/copper"));

    public static final WeaponTier BRONZE = new WeaponTier("bronze", Constants.MODID, 2, 320, 5.75F, 2.0F, 12,
            new ResourceLocation("forge:ingots/bronze"));

    public static final WeaponTier STEEL = new WeaponTier("steel", Constants.MODID, 2, 480, 6.5F, 2.5F, 14,
            new ResourceLocation("forge:ingots/steel"));

    public static final WeaponTier SILVER = new WeaponTier("silver", Constants.MODID, 1, 48, 5.0F, 1.5F, 16,
            new ResourceLocation("forge:ingots/silver"));

    public static final WeaponTier INVAR = new WeaponTier("invar", Constants.MODID, 2, 440, 6.0F, 2.2F, 12,
            new ResourceLocation("forge:ingots/invar"));

    public static final WeaponTier PLATINUM = new WeaponTier("platinum", Constants.MODID, 3, 1024, 4.0F, 3.5F, 18,
            new ResourceLocation("forge:ingots/platinum"));

    public static final WeaponTier ELECTRUM = new WeaponTier("electrum", Constants.MODID, 1, 180, 3.5F, 2.0F, 8,
            new ResourceLocation("forge:ingots/electrum"));

    public static final WeaponTier NICKEL = new WeaponTier("nickel", Constants.MODID, 1, 200, 4.5F, 2.0F, 6,
            new ResourceLocation("forge:ingots/nickel"));

    public static final WeaponTier LEAD = new WeaponTier("lead", Constants.MODID, 1, 240, 4.5F, 2.0F, 5,
            new ResourceLocation("forge:ingots/lead"));
}
