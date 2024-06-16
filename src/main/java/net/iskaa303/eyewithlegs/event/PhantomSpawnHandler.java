package net.iskaa303.eyewithlegs.event;

import net.iskaa303.eyewithlegs.EyeWithLegs;
import net.iskaa303.eyewithlegs.entity.ModEntities;
import net.iskaa303.eyewithlegs.entity.custom.EyeWithLegsEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PhantomSpawnHandler {
    @SubscribeEvent
    public static void onPhantomSpawn(MobSpawnEvent.FinalizeSpawn event) {
        if (event.getEntity() instanceof Phantom) {
            Level level = (Level) event.getLevel();
            event.getEntity();
            if (!level.isClientSide) {
                for (int i = 0; i < 3; i++) {
                    EyeWithLegsEntity eyeWithLegsEntity = new EyeWithLegsEntity(ModEntities.EYE_WITH_LEGS.get(), level); // Change EntityType.ZOMBIE to your custom entity type
                    eyeWithLegsEntity.moveTo(event.getX(), event.getY(), event.getZ(), event.getEntity().getYRot(), 0);
                    level.addFreshEntity(eyeWithLegsEntity);
                }
            }
        }
    }
}
