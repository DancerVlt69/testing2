package com.coertzy.krophlayt.events;

import com.coertzy.krophlayt.entity.KrophEntityTypes;
import com.coertzy.krophlayt.entity.custom.Elf;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.coertzy.krophlayt.KrophMain.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventBusEventsKR {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(KrophEntityTypes.ELF.get(), Elf.setAttributes());
    }
}
