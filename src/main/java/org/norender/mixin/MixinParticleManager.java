package org.norender.mixin;

import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleManager.class)
public class MixinParticleManager {
    @Inject(method = "renderParticles", at = @At("HEAD"), cancellable = true)
    public void onRenderParticles(MatrixStack matrices, VertexConsumerProvider.Immediate vertexConsumers, LightmapTextureManager lightmapTextureManager, Camera camera, float tickDelta, CallbackInfo info) {
        if (NoRender.getInstance().isEnabled9()) {
            info.cancel();
        }
    }
}
