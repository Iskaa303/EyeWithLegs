package net.iskaa303.eyewithlegs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.iskaa303.eyewithlegs.EyeWithLegs;
import net.iskaa303.eyewithlegs.entity.custom.EyeWithLegsEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EyeWithLegsRenderer extends MobRenderer<EyeWithLegsEntity, EyeWithLegsModel<EyeWithLegsEntity>>
{

    public EyeWithLegsRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EyeWithLegsModel<>(pContext.bakeLayer(ModModelLayers.EYE_WITH_LEGS_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(EyeWithLegsEntity eyeWithLegsEntity) {
        return new ResourceLocation(EyeWithLegs.MOD_ID, "textures/entity/eye_with_legs.png");
    }

    @Override
    public void render(EyeWithLegsEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(2f, 2f, 2f);

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
