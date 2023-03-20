package me.clicknin.divergehelper.mixin;

import me.clicknin.divergehelper.util.CustomTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.src.RenderEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.clicknin.divergehelper.util.TextureUtil.textureList;

@Mixin(value = Minecraft.class, remap = false)
public class MinecraftMixin {

    @Shadow public RenderEngine renderEngine;

    @Inject(method = "startGame", at = @At("TAIL"))
    private void addTextures(CallbackInfo callbackInfo) {
        for (CustomTexture texture : textureList) {
            renderEngine.setupTexture(texture.atlas, renderEngine.getTexture(texture.atlasFile));
        }
    }
}
