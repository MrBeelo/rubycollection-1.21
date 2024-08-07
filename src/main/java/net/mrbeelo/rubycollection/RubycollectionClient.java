package net.mrbeelo.rubycollection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.block.entity.ModBlockEntities;
import net.mrbeelo.rubycollection.block.entity.renderer.PedestalBlockEntityRenderer;
import net.mrbeelo.rubycollection.entity.ModEntities;
import net.mrbeelo.rubycollection.entity.client.ModEntityModelLayers;
import net.mrbeelo.rubycollection.entity.client.custom.model.SnekModel;
import net.mrbeelo.rubycollection.entity.client.custom.renderer.SnekRenderer;
import net.mrbeelo.rubycollection.fluid.ModFluids;
import net.mrbeelo.rubycollection.util.ModModelPredicates;

public class RubycollectionClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KOKAINA_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout());

		ModModelPredicates.registerModelPredicates();

		BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNEK, SnekModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.SNEK, SnekRenderer::new);

		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_FROOTOP, ModFluids.FLOWING_FROOTOP,
				SimpleFluidRenderHandler.coloredWater(0xFFFFA500));
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
				ModFluids.STILL_FROOTOP, ModFluids.FLOWING_FROOTOP);
	}
}