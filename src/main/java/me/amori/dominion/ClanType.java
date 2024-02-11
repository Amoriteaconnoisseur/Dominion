package me.amori.dominion;

import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum ClanType {

    RAIDING(new ArmorTrim(TrimMaterial.REDSTONE, TrimPattern.SENTRY),
            new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, PotionEffect.INFINITE_DURATION, 0, false, false)),
    MINING(new ArmorTrim(TrimMaterial.AMETHYST, TrimPattern.WAYFINDER),
            new PotionEffect(PotionEffectType.FAST_DIGGING, PotionEffect.INFINITE_DURATION, 0, false, false)),
    FARMING(new ArmorTrim(TrimMaterial.EMERALD, TrimPattern.COAST),
            new PotionEffect(PotionEffectType.SATURATION, PotionEffect.INFINITE_DURATION, 0, false, false)),
    NEUTRAL(new ArmorTrim(TrimMaterial.GOLD, TrimPattern.DUNE), null),

    ADMIN(null, null)

    ;

    public static final int MAIN_CLANS = 4; // excludes admin class

    // Returns the clan type from string, otherwise null
    public static ClanType fromString(String str) {
        try {
            return ClanType.valueOf(str.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    private final ArmorTrim trim;
    private final PotionEffect potionEffect;
    ClanType(ArmorTrim trim, PotionEffect potionEffect) {
        this.trim = trim;
        this.potionEffect = potionEffect;
    }

    public ArmorTrim getTrim() {
        return trim;
    }

    public boolean hasTrim() {
        return trim != null;
    }

    public boolean hasPotionEffect() {
        return potionEffect != null;
    }

    public PotionEffect getPotionEffect() {
        return potionEffect;
    }
}
