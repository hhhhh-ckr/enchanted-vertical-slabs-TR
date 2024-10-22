package games.enchanted.verticalslabs;

import games.enchanted.verticalslabs.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;
import java.util.function.Supplier;

public class EnchantedVerticalSlabsMod {
    public static void initBeforeRegistration() {
        EnchantedVerticalSlabsConstants.LOG.info("{} is loading in a {} environment!", EnchantedVerticalSlabsConstants.MOD_NAME, Services.PLATFORM.getPlatformName());
    }

    @SuppressWarnings("unchecked")
    public static <R, T extends R> T register(ResourceKey<? extends Registry<R>> registryKey, Supplier<T> entry, ResourceLocation key) {
        Registry<R> registry = Objects.requireNonNull( BuiltInRegistries.REGISTRY.getValue((ResourceKey) registryKey));
        return Registry.register(registry, key, entry.get());
    }
}