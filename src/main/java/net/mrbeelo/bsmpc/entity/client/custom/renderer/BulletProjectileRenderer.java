package net.mrbeelo.bsmpc.entity.client.custom.renderer;

import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.entity.custom.BulletProjectileEntity;

public class BulletProjectileRenderer extends ProjectileEntityRenderer<BulletProjectileEntity> {
    public static final Identifier TEXTURE = BsmpC.id("textures/entity/bullet/bullet.png");


    public BulletProjectileRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(BulletProjectileEntity entity) {
        return TEXTURE;
    }
}
