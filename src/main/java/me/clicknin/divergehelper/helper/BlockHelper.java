package me.clicknin.divergehelper.helper;

import io.github.bluestaggo.mcdiverge.ItemTooltip;
import me.clicknin.divergehelper.mixin.BlockAccessor;
import me.clicknin.divergehelper.util.TextureUtil;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.StepSound;

import static io.github.bluestaggo.mcdiverge.ItemTooltip.items;

public class BlockHelper {
    public static Block registerBlock(Block block, ItemTooltip tooltip, StepSound stepSound, int lightValue, float resistance, float hardness, String texture, int atlasX, int atlasY) {
        ((BlockAccessor) block).setStepSound(stepSound);
        ((BlockAccessor) block).setLightValue(lightValue);
        ((BlockAccessor) block).setResistance(resistance);
        ((BlockAccessor) block).setHardness(hardness);
        block.blockIndexInTexture = TextureUtil.addToTerrain(texture, atlasX, atlasY);
        items[block.blockID] = tooltip;
        Item.itemsList[block.blockID] = new ItemBlock(block.blockID - Block.blocksList.length);
        return block;
    }
}
