package me.clicknin.divergehelper.mixin;

import net.minecraft.src.Block;
import net.minecraft.src.StepSound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = Block.class, remap = false)
public interface BlockAccessor {
   @Invoker("setResistance")
   Block setResistance(float resistance);

    @Invoker("setStepSound")
    Block setStepSound(StepSound stepSound);

    @Invoker("setLightOpacity")
    Block setLightOpacity(int lightOpacity);

    @Invoker("setLightValue")
    Block setLightValue(float lightValue);

    @Invoker("setHardness")
    Block setHardness(float hardness);
}
