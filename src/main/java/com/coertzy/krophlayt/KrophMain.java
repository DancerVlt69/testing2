package com.coertzy.krophlayt;

import com.coertzy.krophlayt.entity.KrophEntityTypes;
import com.coertzy.krophlayt.entity.client.ElfRenderer;
import com.coertzy.krophlayt.items.KrophItems;
import com.coertzy.krophlayt.structures.KrophStructures;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KrophMain.MOD_ID)
public class KrophMain {
    public static final String MOD_ID = "krophlayt";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogManager.getLogger();

    public KrophMain() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        GeckoLib.initialize();

        KrophStructures.register(eventBus);
        KrophItems.register(eventBus);
        KrophEntityTypes.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            EntityRenderers.register(KrophEntityTypes.ELF.get(), ElfRenderer::new);
        });
    }
}
