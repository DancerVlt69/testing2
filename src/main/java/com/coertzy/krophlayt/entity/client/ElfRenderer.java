package com.coertzy.krophlayt.entity.client;

import com.coertzy.krophlayt.KrophMain;
import com.coertzy.krophlayt.entity.custom.Elf;
import com.coertzy.krophlayt.entity.variatons.ElfVariant;
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
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class ElfRenderer extends GeoEntityRenderer<Elf> {
    public static final Map<ElfVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(ElfVariant.class), (p_114874_) -> {
                p_114874_.put(ElfVariant.DEFAULT,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf.png"));
                p_114874_.put(ElfVariant.ONE,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_2.png"));
                p_114874_.put(ElfVariant.TWO,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_3.png"));
                p_114874_.put(ElfVariant.THREE,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_4.png"));
                p_114874_.put(ElfVariant.FOUR,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_5.png"));
                p_114874_.put(ElfVariant.FIVE,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_6.png"));
                p_114874_.put(ElfVariant.SIX,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_7.png"));
                p_114874_.put(ElfVariant.SEVEN,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_8.png"));
                p_114874_.put(ElfVariant.EIGHT,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_9.png"));
                p_114874_.put(ElfVariant.NINE,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_10.png"));
                p_114874_.put(ElfVariant.TEN,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_11.png"));
                p_114874_.put(ElfVariant.ELEVEN,
                        new ResourceLocation(KrophMain.MOD_ID, "textures/entity/elf/elf_12.png"));
            });

    public ElfRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ElfModel());
        this.shadowRadius = 0.3f;
    }

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
