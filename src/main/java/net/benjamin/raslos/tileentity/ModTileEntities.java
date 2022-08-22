package net.benjamin.raslos.tileentity;

import net.benjamin.raslos.RaslosMod;
import net.benjamin.raslos.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, RaslosMod.MOD_ID);

    public static final RegistryObject<TileEntityType<FireImbuerTile>> FIRE_IMBUER_TILE_ENTITY
            = TILE_ENTITIES.register("fire_imbuer_tile_entity", () -> TileEntityType.Builder.create(
            () -> new FireImbuerTile(), ModBlocks.FIRE_IMBUER.get()).build(null));


    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}

