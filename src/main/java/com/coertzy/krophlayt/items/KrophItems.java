package com.coertzy.krophlayt.items;

import com.coertzy.krophlayt.KrophCMT;
import com.coertzy.krophlayt.KrophMain;
import com.coertzy.krophlayt.entity.KrophEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KrophItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KrophMain.MOD_ID);

    public static final RegistryObject<Item> ELF_SPAWN_EGG = ITEMS.register("elf_spawn_egg",
            () -> new ForgeSpawnEggItem(KrophEntityTypes.ELF,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(KrophCMT.KROPHLAYT)));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }
}
