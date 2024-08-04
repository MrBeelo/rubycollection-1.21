package net.mrbeelo.rubycollection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.util.ModModelPredicates;

public class RubycollectionClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KOKAINA_CROP, RenderLayer.getCutout());

		ModModelPredicates.registerModelPredicates();
	}
}