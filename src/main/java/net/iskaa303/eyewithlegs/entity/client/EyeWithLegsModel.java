// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

package net.iskaa303.eyewithlegs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.iskaa303.eyewithlegs.entity.custom.EyeWithLegsEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

import net.iskaa303.eyewithlegs.entity.animations.ModAnimationDefinitions;


public class EyeWithLegsModel<T extends Entity> extends HierarchicalModel<T> {
	private final ModelPart eye_with_legs;
	private final ModelPart head;

    public EyeWithLegsModel(ModelPart root) {
		this.eye_with_legs = root.getChild("eye_with_legs");
        this.head = eye_with_legs.getChild("head");
    }

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition eye_with_legs = partdefinition.addOrReplaceChild("eye_with_legs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 19.0F, 0.1964F, 0.0F, 3.1416F, 0.0F));

		PartDefinition head = eye_with_legs.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, -0.1964F));

		PartDefinition upper_jaw = head.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, -5.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, 2.1964F));

		PartDefinition cube_r1 = upper_jaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(4, 1).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(4, 2).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(4, 4).addBox(2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(3, 3).addBox(-3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.193F, 0.2392F, 0.2182F, 0.0F, 0.0F));

		PartDefinition lower_jaw = head.addOrReplaceChild("lower_jaw", CubeListBuilder.create().texOffs(0, 9).addBox(-2.0F, 0.0F, -5.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -5.0F, 2.1964F));

		PartDefinition cube_r2 = lower_jaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 0).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(4, 5).addBox(2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition leg2 = eye_with_legs.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.8F, -0.5F));

		PartDefinition leg1 = eye_with_legs.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.8F, -0.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((EyeWithLegsEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1f);
		this.animate(((EyeWithLegsEntity) entity).attackAnimationState, ModAnimationDefinitions.BITE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, 0.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, 0.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		eye_with_legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return eye_with_legs;
	}
}