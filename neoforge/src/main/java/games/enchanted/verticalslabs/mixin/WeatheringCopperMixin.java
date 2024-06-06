package games.enchanted.verticalslabs.mixin;

import games.enchanted.verticalslabs.block.SpecialBlockMaps;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(WeatheringCopper.class)
@SuppressWarnings("unused")
public interface WeatheringCopperMixin {
    @Inject(
        at = @At("HEAD"),
        method = "getPrevious(Lnet/minecraft/world/level/block/Block;)Ljava/util/Optional;",
        cancellable = true
    )
    private static void getPrevious(Block block, CallbackInfoReturnable<Optional<Block>> ci){
        if(SpecialBlockMaps.WEATHERING_COPPER_MAP != null) {
            Block previous = SpecialBlockMaps.WEATHERING_COPPER_MAP.inverse().get(block);
            if(previous != null) {
                ci.setReturnValue(Optional.of(previous));
            }
        }
    }

    @Inject(
        at = @At("HEAD"),
        method = "getFirst(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/world/level/block/Block;",
        cancellable = true
    )
    private static void getFirst(Block block, CallbackInfoReturnable<Block> ci){
        if(SpecialBlockMaps.WEATHERING_COPPER_MAP != null) {
            Block first = block;
            Block previous;
            while((previous = SpecialBlockMaps.WEATHERING_COPPER_MAP.inverse().get(first)) != null) {
                first = previous;
            }
            if(first != block) {
                ci.setReturnValue(first);
            }
        }
    }

    @Inject(
        at = @At("HEAD"),
        method = "getNext(Lnet/minecraft/world/level/block/Block;)Ljava/util/Optional;",
        cancellable = true
    )
    private static void getNext(Block block, CallbackInfoReturnable<Optional<Block>> ci){
        if(SpecialBlockMaps.WEATHERING_COPPER_MAP != null) {
            Block next = SpecialBlockMaps.WEATHERING_COPPER_MAP.get(block);
            if(next != null) {
                ci.setReturnValue(Optional.of(next));
            }
        }
    }
}