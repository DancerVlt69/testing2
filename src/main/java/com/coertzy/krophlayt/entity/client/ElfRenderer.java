package com.coertzy.krophlayt.entity.client;

import com.coertzy.krophlayt.entity.custom.Elf;
import com.coertzy.krophlayt.entity.variations.ElfVariant;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

import static com.coertzy.krophlayt.KrophMain.MOD_ID;

public class ElfRenderer extends GeoEntityRenderer<Elf> {
    public static final Map<ElfVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ElfVariant.class), (pVariant) -> {
                pVariant.put(ElfVariant.DEFAULT,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf.png"));
                pVariant.put(ElfVariant.ONE,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_2.png"));
                pVariant.put(ElfVariant.TWO,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_3.png"));
                pVariant.put(ElfVariant.THREE,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_4.png"));
                pVariant.put(ElfVariant.FOUR,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_5.png"));
                pVariant.put(ElfVariant.FIVE,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_6.png"));
                pVariant.put(ElfVariant.SIX,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_7.png"));
                pVariant.put(ElfVariant.SEVEN,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_8.png"));
                pVariant.put(ElfVariant.EIGHT,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_9.png"));
                pVariant.put(ElfVariant.NINE,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_10.png"));
                pVariant.put(ElfVariant.TEN,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_11.png"));
                pVariant.put(ElfVariant.ELEVEN,
                        new ResourceLocation(MOD_ID, "textures/entity/elf/elf_12.png"));
            });

    public ElfRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ElfModel());
        this.shadowRadius = 0.3f;
    }

    @NotNull
    @Override
    public ResourceLocation getTextureLocation(Elf instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(Elf animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if(animatable.isBaby()) {
            stack.scale(0.4F, 0.4F, 0.4F);
        } else {
            stack.scale(0.8F, 0.8F, 0.8F);
        }

        stack.mulPose(Quaternion.fromXYZDegrees(new Vector3f(0f, 90f, 0f)));

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
