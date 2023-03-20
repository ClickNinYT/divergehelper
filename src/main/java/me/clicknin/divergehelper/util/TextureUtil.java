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
    public static List<CustomTexture> textureList = new ArrayList<CustomTexture>();
    public static int addToAtlas(String textureFile, String atlasFile, int x, int y) {
        BufferedImage atlas = null;
        BufferedImage texture = null;
        try {
            atlas = ImageIO.read(Objects.requireNonNull(Minecraft.class.getResourceAsStream(atlasFile)));
            texture = ImageIO.read(Objects.requireNonNull(Minecraft.class.getResourceAsStream(textureFile)));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        atlas.getSubimage(x * 16, y * 16, 16, 16).setData(texture.getData());
        textureList.add(new CustomTexture(atlas, atlasFile));
        return y * 32 + x;
    }
}
