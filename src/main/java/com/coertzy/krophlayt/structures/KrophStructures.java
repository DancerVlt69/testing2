package com.coertzy.krophlayt.structures;

import com.coertzy.krophlayt.KrophMain;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KrophStructures {
    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, KrophMain.MOD_ID);

    public static final RegistryObject<StructureFeature<?>> SKY_STRUCTURES =
            DEFERRED_REGISTRY_STRUCTURE.register("sky_structures", KrophSkyStructures::new);

    public static void register (IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }
}
