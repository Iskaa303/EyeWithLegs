package net.iskaa303.eyewithlegs;

import com.mojang.logging.LogUtils;
import net.iskaa303.eyewithlegs.entity.ModEntities;
import net.iskaa303.eyewithlegs.entity.client.EyeWithLegsRenderer;
import net.iskaa303.eyewithlegs.event.PhantomSpawnHandler;
import net.iskaa303.eyewithlegs.item.ModCreativeModTabs;
import net.iskaa303.eyewithlegs.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EyeWithLegs.MOD_ID)
public class EyeWithLegs {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "eye_with_legs";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public EyeWithLegs()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(PhantomSpawnHandler.class);
        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.EYE_WITH_LEGS.get(), EyeWithLegsRenderer::new);
        }
    }
}
