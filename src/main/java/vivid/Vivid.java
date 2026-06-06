package vivid;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import vivid.common.Config;
import vivid.common.Constants;
import vivid.common.blocks.VividBlocks;
import vivid.common.items.VividItems;
import vivid.logging.VividLogger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Constants.MODID)
public class Vivid {
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "vivid" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);

    // Creates a creative tab with the id "vivid:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.vivid")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> VividItems.VIVID_DUST_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(VividItems.VIVID_DUST_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(VividBlocks.VIVID_DUST_BLOCK.get());
                output.accept(VividBlocks.VIVID_ORE_BLOCK.get());
                output.accept(VividBlocks.VIVID_DEEPSLATE_ORE_BLOCK.get());
                output.accept(VividItems.SCORCHED_DUST_ITEM.get());
                output.accept(VividBlocks.SCORCHED_DUST_BLOCK.get());
                output.accept(VividBlocks.SCORCHED_ORE_BLOCK.get());
                output.accept(VividItems.UMBRAL_DUST_ITEM.get());
                output.accept(VividBlocks.UMBRAL_DUST_BLOCK.get());
                output.accept(VividBlocks.UMBRAL_ORE_BLOCK.get());
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Vivid(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        VividBlocks.BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        VividItems.ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Vivid) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        VividLogger.log("HELLO FROM COMMON SETUP");

        VividItems.itemNames().forEach(item -> VividLogger.log(String.format("ITEM >> %s", item)));
        VividBlocks.blockNames().forEach(block -> VividLogger.log(String.format("BLOCK >> %s", block)));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        VividLogger.log("HELLO from server starting");
    }
}
