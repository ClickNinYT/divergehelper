package me.clicknin.divergehelper;

import me.clicknin.divergehelper.helper.BlockHelper;
import me.clicknin.divergehelper.helper.ItemHelper;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemTooltip;
import net.minecraft.src.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivergeHelper implements ModInitializer {
    public static final String MOD_ID = "divergehelper";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item exampleItem = ItemHelper.registerItem(new Item(2006), new ItemTooltip("The Blue Example Item"), "/assets/divergehelper/item/example_item.png", 5, 2);
    public static final Item exampleItem2 = ItemHelper.registerItem(new Item(2007), new ItemTooltip("The Red Example Item"), "/assets/divergehelper/item/example_item_2.png", 6, 2);
    public static final Block exampleBlock = BlockHelper.registerBlock(new Block(100, Material.wood), new ItemTooltip("Test Example Block"), null, 0, 0.5F, 0.5F, "/assets/divergehelper/block/example_block.png", 5, 0);

    @Override
    public void onInitialize(){
        LOGGER.info("DivergeHelper initialized.");
    }
}
