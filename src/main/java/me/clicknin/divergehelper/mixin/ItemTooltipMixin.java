package me.clicknin.divergehelper.mixin;

import io.github.bluestaggo.mcdiverge.ItemTooltip;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static io.github.bluestaggo.mcdiverge.ItemTooltip.items;
import static me.clicknin.divergehelper.helper.ItemHelper.itemTooltipList;

@Mixin(value = ItemTooltip.class, remap = false)
public class ItemTooltipMixin {
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addItemTooltip(CallbackInfo callbackInfo) {
        //items[12006] = new ItemTooltip("Example Item");
        for (int i : itemTooltipList.keySet()) {
            items[10000 + i] = (ItemTooltip) itemTooltipList.get((int)i);
        }
    }
}
