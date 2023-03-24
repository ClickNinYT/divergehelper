package me.clicknin.divergehelper.helper;

import io.github.bluestaggo.mcdiverge.ItemTooltip;
import me.clicknin.divergehelper.util.TextureUtil;
import net.minecraft.src.Item;

import static io.github.bluestaggo.mcdiverge.ItemTooltip.items;

public class ItemHelper {

    public static Item registerItem(Item item, ItemTooltip tooltip, String texture, int atlasX, int atlasY) {
        item.setIconIndex(TextureUtil.addToItem(texture, atlasX, atlasY));
        items[item.shiftedIndex] = tooltip;
        return item;
    }
}
