package net.iskaa303.eyewithlegs.entity.ai.goal;

import net.iskaa303.eyewithlegs.entity.custom.EyeWithLegsEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class EyeWithLegsAttackGoal extends MeleeAttackGoal {
    private final EyeWithLegsEntity eyeWithLegs;
    private int raiseArmTicks;

    public EyeWithLegsAttackGoal(EyeWithLegsEntity pEyeWithLegs, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pEyeWithLegs, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.eyeWithLegs = pEyeWithLegs;
    }

    public void start() {
        super.start();
        this.raiseArmTicks = 0;
    }

    public void stop() {
        super.stop();
        this.eyeWithLegs.setAggressive(false);
    }

    public void tick() {
        super.tick();
        ++this.raiseArmTicks;
        if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
            this.eyeWithLegs.setAggressive(true);
        } else {
            this.eyeWithLegs.setAggressive(false);
        }

    }
}
