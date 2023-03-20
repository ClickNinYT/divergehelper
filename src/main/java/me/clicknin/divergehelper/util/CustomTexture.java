package me.clicknin.divergehelper.util;

import java.awt.image.BufferedImage;

public class CustomTexture {
    public BufferedImage atlas;
    public String atlasFile;
    public CustomTexture(BufferedImage atlas, String atlasFile) {
        this.atlas = atlas;
        this.atlasFile = atlasFile;
    }
}
