package me.clicknin.divergehelper.helper;

import io.github.bluestaggo.mcdiverge.ItemTooltip;
import me.clicknin.divergehelper.util.TextureUtil;
import net.minecraft.src.Item;

import java.util.HashMap;

public class ItemHelper {
    public static HashMap<Integer, ItemTooltip> itemTooltipList = new HashMap<Integer, ItemTooltip>();
    public static Item registerItem(Item item, ItemTooltip tooltip, int id, String texture, int atlasX, int atlasY) {
        item.setIconIndex(TextureUtil.addToAtlas(texture, "/gui/items.png", atlasX, atlasY));
        itemTooltipList.put(id, tooltip);
        return item;
    }
}
