package net.iskaa303.eyewithlegs.entity.ai.goal;

import net.iskaa303.eyewithlegs.entity.custom.EyeWithLegsEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class EyeWithLegsAttackGoal extends MeleeAttackGoal {
    private final EyeWithLegsEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public EyeWithLegsAttackGoal(PathfinderMob pEyeWithLegs, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pEyeWithLegs, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.entity = ((EyeWithLegsEntity) pEyeWithLegs);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pLivingEntity, double pDist) {
        if (isEnemyWithinAttackRange(pLivingEntity, pDist)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if (isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ());
                performAttack(pLivingEntity);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackRange(LivingEntity pLivingEntity, double pDistance) {
        return pDistance <= this.getAttackReachSqr(pLivingEntity);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }

    protected void performAttack(LivingEntity pLivingEntity) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pLivingEntity);
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }
}
