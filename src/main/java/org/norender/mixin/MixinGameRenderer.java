package org.norender.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class MixinGameRenderer {
    @Inject(method = "renderHand", at = @At("HEAD"), cancellable = true)
    public void onRenderHand(MatrixStack matrices, Camera camera, float tickDelta, CallbackInfo info) {
        if (NoRender.getInstance().isEnabled6()) {
            info.cancel();
        }
    }

    @Inject(method = "shouldRenderBlockOutline", at = @At("HEAD"), cancellable = true)
    public void onShouldRenderBlockOutline(CallbackInfoReturnable<Boolean> info) {
        if (NoRender.getInstance().isEnabled7()) {
            info.cancel();
        }
    }
}