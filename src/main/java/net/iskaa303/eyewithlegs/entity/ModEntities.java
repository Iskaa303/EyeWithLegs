package net.iskaa303.eyewithlegs.entity;

import net.iskaa303.eyewithlegs.EyeWithLegs;
import net.iskaa303.eyewithlegs.entity.custom.EyeWithLegsEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EyeWithLegs.MOD_ID);

    public static final RegistryObject<EntityType<EyeWithLegsEntity>> EYE_WITH_LEGS =
            ENTITY_TYPES.register("eye_with_legs", () -> EntityType.Builder.of(EyeWithLegsEntity::new, MobCategory.MONSTER)
                    .sized(0.4f, 0.5f).build("eye_with_legs"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
