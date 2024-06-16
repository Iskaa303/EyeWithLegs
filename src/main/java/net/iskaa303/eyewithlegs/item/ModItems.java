package net.iskaa303.eyewithlegs.item;

import net.iskaa303.eyewithlegs.EyeWithLegs;
import net.iskaa303.eyewithlegs.entity.ModEntities;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EyeWithLegs.MOD_ID);

    public static final RegistryObject<Item> EYE_WITH_LEGS_SPAWN_EGG = ITEMS.register("eye_with_legs_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.EYE_WITH_LEGS, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
