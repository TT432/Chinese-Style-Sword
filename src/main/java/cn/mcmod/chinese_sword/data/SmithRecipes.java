package cn.mcmod.chinese_sword.data;

import java.util.function.Consumer;

import cn.mcmod.chinese_sword.item.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.SmithingRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.data.ForgeRecipeProvider;

public class SmithRecipes extends ForgeRecipeProvider {

    public SmithRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        addSmithing(consumer, Items.WOODEN_SWORD, ItemRegistry.WOODEN_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.WOODEN_CHINESE_SWORD.get());
        addSmithing(consumer, Items.WOODEN_SWORD, ItemRegistry.WOODEN_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.WOODEN_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.STONE_SWORD, ItemRegistry.STONE_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.STONE_CHINESE_SWORD.get());
        addSmithing(consumer, Items.STONE_SWORD, ItemRegistry.STONE_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.STONE_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.IRON_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.IRON_CHINESE_SWORD.get());
        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.IRON_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.IRON_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.GOLDEN_SWORD, ItemRegistry.GOLDEN_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.GOLDEN_CHINESE_SWORD.get());
        addSmithing(consumer, Items.GOLDEN_SWORD, ItemRegistry.GOLDEN_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.GOLDEN_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.DIAMOND_SWORD, ItemRegistry.DIAMOND_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.DIAMOND_CHINESE_SWORD.get());
        addSmithing(consumer, Items.DIAMOND_SWORD, ItemRegistry.DIAMOND_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.DIAMOND_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.NETHERITE_SWORD, ItemRegistry.NETHERITE_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.NETHERITE_CHINESE_SWORD.get());
        addSmithing(consumer, Items.NETHERITE_SWORD, ItemRegistry.NETHERITE_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.NETHERITE_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.STEEL_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.STEEL_CHINESE_SWORD.get());
        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.STEEL_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.STEEL_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.PLATINUM_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.PLATINUM_CHINESE_SWORD.get());
        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.PLATINUM_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.PLATINUM_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.ELECTRUM_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.ELECTRUM_CHINESE_SWORD.get());
        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.ELECTRUM_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.ELECTRUM_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.INVAR_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.INVAR_CHINESE_SWORD.get());
        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.INVAR_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.INVAR_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.SILVER_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.SILVER_CHINESE_SWORD.get());
        addSmithing(consumer, Items.IRON_SWORD, ItemRegistry.SILVER_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.SILVER_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.STONE_SWORD, ItemRegistry.NICKEL_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.NICKEL_CHINESE_SWORD.get());
        addSmithing(consumer, Items.STONE_SWORD, ItemRegistry.NICKEL_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.NICKEL_ANCIENT_SWORD.get());

        addSmithing(consumer, Items.STONE_SWORD, ItemRegistry.LEAD_CHINESE_SWORD_SHEATH.get(),
                ItemRegistry.LEAD_CHINESE_SWORD.get());
        addSmithing(consumer, Items.STONE_SWORD, ItemRegistry.LEAD_ANCIENT_SWORD_SHEATH.get(),
                ItemRegistry.LEAD_ANCIENT_SWORD.get());
    }

    private void addSmithing(Consumer<IFinishedRecipe> consumer, Item base, Item sheath, Item output) {
        SmithingRecipeBuilder.smithing(Ingredient.of(base), Ingredient.of(sheath), output)
                .unlocks("ingredient", has(sheath)).save(consumer, output.getRegistryName().toString() + "_smithing");
    }
}
