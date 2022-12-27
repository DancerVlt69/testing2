package com.coertzy.krophlayt.entity.client;

import com.coertzy.krophlayt.entity.custom.Elf;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static com.coertzy.krophlayt.KrophMain.MOD_ID;

public class ElfModel extends AnimatedGeoModel<Elf> {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(Elf entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }

    @Override
    public ResourceLocation getModelLocation(Elf object) {
        return new ResourceLocation(MOD_ID, "geo/elf.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Elf object) {
        return ElfRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationFileLocation(Elf animatable) {
        return new ResourceLocation(MOD_ID, "animations/elf.animation.json");
    }
}
