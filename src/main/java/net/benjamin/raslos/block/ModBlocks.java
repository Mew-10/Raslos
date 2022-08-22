package net.benjamin.raslos.block;

import net.benjamin.raslos.RaslosMod;
import net.benjamin.raslos.block.custom.FireImbuerBlock;
import net.benjamin.raslos.item.ModItemGroup;
import net.benjamin.raslos.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, RaslosMod.MOD_ID);


    public static final RegistryObject<Block> FIREY_DIAMOND_BLOCK = registerBlock("firey_diamond_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).setRequiresTool().harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)));


    public static final RegistryObject<Block> FIRE_IMBUER = registerBlock("fire_imbuer",
            () -> new FireImbuerBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(4f).harvestTool(ToolType.PICKAXE)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}