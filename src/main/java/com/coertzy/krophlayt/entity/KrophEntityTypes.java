package com.coertzy.krophlayt.entity;

import com.coertzy.krophlayt.KrophMain;
import com.coertzy.krophlayt.entity.custom.Elf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KrophEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, KrophMain.MOD_ID);

    public static final RegistryObject<EntityType<Elf>> ELF =
            ENTITY_TYPES.register("elf",
                    () -> EntityType.Builder.of(Elf::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(KrophMain.MOD_ID, "elf").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
