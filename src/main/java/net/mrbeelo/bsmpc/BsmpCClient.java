package net.mrbeelo.bsmpc;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.world.biome.FoliageColors;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.block.entity.ModBlockEntities;
import net.mrbeelo.bsmpc.block.entity.renderer.PedestalBlockEntityRenderer;
import net.mrbeelo.bsmpc.entity.ModEntities;
import net.mrbeelo.bsmpc.entity.client.ModEntityModelLayers;
import net.mrbeelo.bsmpc.entity.client.custom.model.NukeModel;
import net.mrbeelo.bsmpc.entity.client.custom.model.SnekModel;
import net.mrbeelo.bsmpc.entity.client.custom.renderer.BulletProjectileRenderer;
import net.mrbeelo.bsmpc.entity.client.custom.renderer.NukeRenderer;
import net.mrbeelo.bsmpc.entity.client.custom.renderer.SnekRenderer;
import net.mrbeelo.bsmpc.fluid.ModFluids;
import net.mrbeelo.bsmpc.particle.ModParticles;
import net.mrbeelo.bsmpc.util.ModModelPredicates;

public class BsmpCClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KOKAINA_CROP, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RUBY_TRAPDOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROSE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ROSE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CS_SAPLING, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CS_DOOR, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CS_TRAPDOOR, RenderLayer.getCutout());

		ParticleFactoryRegistry.getInstance().register(ModParticles.SPARKLE_PARTICLE, EndRodParticle.Factory::new);

		ModModelPredicates.registerModelPredicates();

		BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.SNEK, SnekModel::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.SNEK, SnekRenderer::new);
		EntityRendererRegistry.register(ModEntities.POKE_BALL_PROJECTILE, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.BULLET_PROJECTILE, BulletProjectileRenderer::new);
		EntityRendererRegistry.register(ModEntities.PURIFY_BOMB_PROJECTILE, ArrowEntityRenderer::new);

		FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_FROOTOP, ModFluids.FLOWING_FROOTOP,
				SimpleFluidRenderHandler.coloredWater(0xFFFFA500));
		BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
				ModFluids.STILL_FROOTOP, ModFluids.FLOWING_FROOTOP);

		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ?
				BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefaultColor(), ModBlocks.CS_LEAVES);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> FoliageColors.getDefaultColor(), ModBlocks.CS_LEAVES);
	}
}