package me.clicknin.divergehelper.helper;

import me.clicknin.divergehelper.util.TextureUtil;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemTooltip;
import net.minecraft.src.StepSound;
import net.minecraft.src.ItemBlock;

import static net.minecraft.src.ItemTooltip.items;

public class BlockHelper {
    public static Block registerBlock(Block block, ItemTooltip tooltip, StepSound stepSound, int lightValue, float resistance, float hardness, String texture, int atlasX, int atlasY) {
        block.setStepSound(stepSound);
        block.setLightValue(lightValue);
        block.setResistance(resistance);
        block.setHardness(hardness);
        block.blockIndexInTexture = TextureUtil.addToTerrain(texture, atlasX, atlasY);
        items[block.blockID] = tooltip;
        Item.itemsList[block.blockID] = new ItemBlock(block.blockID - 10000);
        return block;
    }
}
