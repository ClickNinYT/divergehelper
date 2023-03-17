package com.example.examplemod.mixin;

import com.example.examplemod.ExampleMod;
import net.minecraft.src.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiMainMenu.class, remap = false)
public class ExampleMixin {
    @Inject(method = "initGui", at = @At(value = "HEAD"))
    private void exampleMixin(CallbackInfo ci) {
        ExampleMod.LOGGER.info("This line is printed by an example mixin!");
    }
}
