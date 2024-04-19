package com.beanbot.instrumentus.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CopperSoulFireFlameParticle extends RisingParticle {

    protected CopperSoulFireFlameParticle(ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
        super(level, x, y, z, dX, dY, dZ);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public void move(double pX, double pY, double pZ) {
        this.setBoundingBox(this.getBoundingBox().move(pX, pY, pZ));
        this.setLocationFromBoundingbox();
    }

    public float getQuadSize(float pScaleFactor) {
        float f = ((float)this.age + pScaleFactor) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f * 0.5F);
    }

    public int getLightColor(float pPartialTick) {
        float f = ((float)this.age + pPartialTick) / (float)this.lifetime;
        f = Mth.clamp(f, 0.0F, 1.0F);
        int i = super.getLightColor(pPartialTick);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f * 15.0F * 16.0F);
        if (j > 240) {
            j = 240;
        }

        return j | k << 16;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            CopperSoulFireFlameParticle copperSoulFireFlameParticle = new CopperSoulFireFlameParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
            copperSoulFireFlameParticle.pickSprite(this.sprite);
            return copperSoulFireFlameParticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class SmallFlameProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public SmallFlameProvider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            CopperSoulFireFlameParticle copperSoulFireFlameParticle = new CopperSoulFireFlameParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
            copperSoulFireFlameParticle.pickSprite(this.sprite);
            copperSoulFireFlameParticle.scale(0.5F);
            return copperSoulFireFlameParticle;
        }
    }
}
