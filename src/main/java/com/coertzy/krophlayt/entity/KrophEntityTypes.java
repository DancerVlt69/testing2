package com.coertzy.krophlayt.entity;

import com.coertzy.krophlayt.entity.custom.Elf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.coertzy.krophlayt.KrophMain.MOD_ID;

public class KrophEntityTypes {
    public static final DeferredRegister<EntityType<?>> MOD_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MOD_ID);

    public static final RegistryObject<EntityType<Elf>> ELF =
            MOD_ENTITY_TYPES.register("elf",
                    () -> EntityType.Builder.of(Elf::new, MobCategory.CREATURE)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(MOD_ID, "elf").toString()));


    public static void register(IEventBus eventBus) {
        MOD_ENTITY_TYPES.register(eventBus);
    }
}
