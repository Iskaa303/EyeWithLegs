package net.iskaa303.eyewithlegs.item;

import net.iskaa303.eyewithlegs.EyeWithLegs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EyeWithLegs.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("eye_with_legs_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EYE_WITH_LEGS_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.eye_with_legs_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.EYE_WITH_LEGS_SPAWN_EGG.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
