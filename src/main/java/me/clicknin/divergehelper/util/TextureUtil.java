package me.clicknin.divergehelper.util;

import me.clicknin.divergehelper.DivergeHelper;
import net.minecraft.client.Minecraft;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TextureUtil {
    public static List<CustomTexture> itemTextureList = new ArrayList<CustomTexture>();
    public static List<CustomTexture> terrainTextureList = new ArrayList<CustomTexture>();

    public static int addToItem(String textureFile, int x, int y) {
        itemTextureList.add(new CustomTexture(textureFile, x, y));
        return y * 32 + x;
    }

    public static int addToTerrain(String textureFile, int x, int y) {
        terrainTextureList.add(new CustomTexture(textureFile, x, y));
        return y * 32 + x;
    }
}
