package net.mrbeelo.bsmpc.particle.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class MobiliumParticle extends SpriteBillboardParticle {
    protected MobiliumParticle(ClientWorld world, double x, double y, double z, double xd, double yd, double zd, SpriteProvider spriteSet) {
        super(world, x, y, z, xd, yd, zd);
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;
        this.scale *= 0.75F;
        this.maxAge = 20;
        this.setSpriteForAge(spriteSet);
        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;
    }

    /*@Override
    public void tick() {
        super.tick();
        fadeOut();
    }

    private void fadeOut() {
        this.alpha = 1.0F - ((float)age / (float)maxAge);
    }

     */

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType particleType, ClientWorld level, double x, double y, double z, double dx, double dy, double dz) {
            return new MobiliumParticle(level, x, y, z, dx, dy, dz, this.sprites);
        }
    }
}
