package net.iskaa303.eyewithlegs.event;

import net.iskaa303.eyewithlegs.EyeWithLegs;
import net.iskaa303.eyewithlegs.entity.ModEntities;
import net.iskaa303.eyewithlegs.entity.custom.EyeWithLegsEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EyeWithLegs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents
{
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.EYE_WITH_LEGS.get(), EyeWithLegsEntity.createAttributes().build());
    }
}
