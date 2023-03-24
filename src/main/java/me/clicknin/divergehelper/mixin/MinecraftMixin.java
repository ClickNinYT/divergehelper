package me.clicknin.divergehelper.mixin;

import me.clicknin.divergehelper.DivergeHelper;
import me.clicknin.divergehelper.util.CustomTexture;
import me.clicknin.divergehelper.util.TextureUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.src.RenderEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Mixin(value = Minecraft.class, remap = false)
public class MinecraftMixin {

    @Shadow public RenderEngine renderEngine;

    @Inject(method = "startGame", at = @At("TAIL"))
    private void addTextures(CallbackInfo callbackInfo) {
        BufferedImage itemAtlas = null;
        BufferedImage terrainAtlas = null;
        try {
            itemAtlas = ImageIO.read(Objects.requireNonNull(Minecraft.class.getResourceAsStream("/gui/items.png")));
            terrainAtlas = ImageIO.read(Objects.requireNonNull(Minecraft.class.getResourceAsStream("/terrain.png")));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        for (CustomTexture texture : TextureUtil.itemTextureList) {
            DivergeHelper.LOGGER.info("Adding texture " + texture.textureFile + " to /gui/items.png in slot " + (texture.y * 32 + texture.x));
            BufferedImage textureImg = null;
            try {
                textureImg = ImageIO.read(Objects.requireNonNull(Minecraft.class.getResourceAsStream(texture.textureFile)));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            itemAtlas.getSubimage(texture.x * 16, texture.y * 16, 16, 16).setData(textureImg.getData());
        }
        for (CustomTexture texture : TextureUtil.terrainTextureList) {
            DivergeHelper.LOGGER.info("Adding texture " + texture.textureFile + " to /terrain.png in slot " + (texture.y * 32 + texture.x));
            BufferedImage textureImg = null;
            try {
                textureImg = ImageIO.read(Objects.requireNonNull(Minecraft.class.getResourceAsStream(texture.textureFile)));
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            terrainAtlas.getSubimage(texture.x * 16, texture.y * 16, 16, 16).setData(textureImg.getData());
        }
        renderEngine.setupTexture(itemAtlas, renderEngine.getTexture("/gui/items.png"));
        renderEngine.setupTexture(terrainAtlas, renderEngine.getTexture("/terrain.png"));
    }
}
