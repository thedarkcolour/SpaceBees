package com.example.spacebees;

import com.example.spacebees.Features.SpaceBeesApicultureBlocks;
import com.example.spacebees.Features.SpaceBeesApicultureItems;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import forestry.api.client.IClientModuleHandler;
import forestry.apiculture.features.ApicultureItems;
import forestry.core.circuits.GuiSolderingIron;
import forestry.core.features.CoreBlocks;
import forestry.core.features.CoreMenuTypes;
import forestry.core.fluids.ForestryFluids;
import forestry.core.gui.ContainerNaturalistInventory;
import forestry.core.gui.GuiAlyzer;
import forestry.core.gui.GuiAnalyzer;
import forestry.core.gui.GuiEscritoire;
import forestry.core.gui.GuiNaturalistInventory;
import forestry.core.models.ClientManager;
import forestry.core.render.ForestryBewlr;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import org.slf4j.Logger;

public class CoreClientHandler implements IClientModuleHandler{
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void registerEvents (IEventBus modBus) {
        modBus.addListener(CoreClientHandler::bakeModels);
        modBus.addListener(CoreClientHandler::registerItemColors);
        modBus.addListener(CoreClientHandler::registerBlockColors);
        LOGGER.info("SpaceBees Debug: Register Events run");

    }   
    private static void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.register(ClientManager.FORESTRY_ITEM_COLOR, SpaceBeesApicultureBlocks.BEE_COMB.blockArray());
        event.register(ClientManager.FORESTRY_ITEM_COLOR, SpaceBeesApicultureItems.BEE_COMBS.itemArray());
        //event.register(ClientManager.FORESTRY_ITEM_COLOR, SpaceBeesApicultureItems.HONEY_DROPS.itemArray());

        LOGGER.info("SpaceBees Debug: RegisterItemColors run");

    }

    private static void registerBlockColors(RegisterColorHandlersEvent.Block event){
        event.register(ClientManager.FORESTRY_BLOCK_COLOR, SpaceBeesApicultureBlocks.BEE_COMB.blockArray());
        LOGGER.info("SpaceBees Debug: RegisteBlockColors run");

    }
    private static void bakeModels(ModelEvent.BakingCompleted event) {
		ClientManager.INSTANCE.onBakeModels(event);
	}
}
