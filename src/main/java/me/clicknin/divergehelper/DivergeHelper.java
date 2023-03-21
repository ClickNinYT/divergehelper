package me.clicknin.divergehelper;

import io.github.bluestaggo.mcdiverge.ItemTooltip;
import me.clicknin.divergehelper.helper.ItemHelper;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivergeHelper implements ModInitializer {
    public static final String MOD_ID = "divergehelper";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Item exampleItem = ItemHelper.registerItem(new ItemExample(2006), new ItemTooltip("Example Item"), "/assets/divergehelper/item/example_item.png", 5, 2);

    @Override
    public void onInitialize(){
        LOGGER.info("DivergeHelper initialized.");
    }
}
