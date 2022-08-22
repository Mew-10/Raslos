package net.benjamin.raslos.item;

import net.benjamin.raslos.RaslosMod;
import net.benjamin.raslos.item.custom.ThunderStoneItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RaslosMod.MOD_ID);


    public static final RegistryObject<Item> FIREY_DIAMOND = ITEMS.register("firey_diamond",
            () -> new Item(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> THUNDER_STONE = ITEMS.register("thunder_stone",
            () -> new ThunderStoneItem(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
