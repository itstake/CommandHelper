package com.laytonsmith.abstraction.enums;

import com.laytonsmith.PureUtilities.ClassLoading.DynamicEnum;
import com.laytonsmith.annotations.MDynamicEnum;
import com.laytonsmith.annotations.MEnum;
import com.laytonsmith.core.Static;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@MDynamicEnum("Sound")
public abstract class MCSound<Concrete> extends DynamicEnum<MCSound.MCVanillaSound, Concrete> {

	// To be filled by the implementer
	protected static Map<String, MCSound> mappings;

	public static MCSound NULL = null;

	public MCSound(MCVanillaSound mcVanillaSound, Concrete concrete) {
		super(mcVanillaSound, concrete);
	}

	public static MCSound valueOf(String test) throws IllegalArgumentException {
		if (mappings == null) {
			return null;
		}
		MCSound ret = mappings.get(test);
		if (ret == null) {
			throw new IllegalArgumentException("Unknown sound: " + test);
		}
		return ret;
	}

	public static Set<String> types() {
		if (NULL == null) { // docs mode
			Set<String> dummy = new HashSet<>();
			for (final MCVanillaSound s : MCVanillaSound.values()) {
				dummy.add(s.name());
			}
			return dummy;
		}
		return new TreeSet<>(mappings.keySet());
	}

	public static Collection<MCSound> values() {
		if (NULL == null) { // docs mode
			ArrayList<MCSound> dummy = new ArrayList<>();
			for (final MCVanillaSound s : MCVanillaSound.values()) {
				dummy.add(new MCSound<Object>(s, null) {
					@Override
					public String name() {
						return s.name();
					}

					@Override
					public String concreteName() {
						return s.name();
					}
				});
			}
			return dummy;
		}
		return mappings.values();
	}

	@MEnum("VanillaSound")
	public enum MCVanillaSound {
		AMBIENCE_CAVE,
		AMBIENCE_RAIN,
		AMBIENCE_THUNDER,
		ANVIL_BREAK,
		ANVIL_LAND,
		ANVIL_USE,
		ARROW_HIT,
		BURP,
		CHEST_CLOSE,
		CHEST_OPEN,
		CLICK,
		DOOR_CLOSE,
		DOOR_OPEN,
		DRINK,
		EAT,
		EXPLODE,
		FALL_BIG,
		FALL_SMALL,
		FIRE,
		FIRE_IGNITE,
		FIZZ,
		FUSE,
		GLASS,
		HURT_FLESH,
		ITEM_BREAK,
		ITEM_PICKUP,
		LAVA,
		LAVA_POP,
		LEVEL_UP,
		MINECART_BASE,
		MINECART_INSIDE,
		NOTE_BASS,
		NOTE_PIANO,
		NOTE_BASS_DRUM,
		NOTE_STICKS,
		NOTE_BASS_GUITAR,
		NOTE_SNARE_DRUM,
		NOTE_PLING,
		ORB_PICKUP,
		PISTON_EXTEND,
		PISTON_RETRACT,
		PORTAL,
		PORTAL_TRAVEL,
		PORTAL_TRIGGER,
		SHOOT_ARROW,
		SPLASH,
		SPLASH2,
		STEP_GRASS,
		STEP_GRAVEL,
		STEP_LADDER,
		STEP_SAND,
		STEP_SNOW,
		STEP_STONE,
		STEP_WOOD,
		STEP_WOOL,
		SUCCESSFUL_HIT,
		SWIM,
		WATER,
		WOOD_CLICK,
		// Mob sounds
		BAT_DEATH,
		BAT_HURT,
		BAT_IDLE,
		BAT_LOOP,
		BAT_TAKEOFF,
		BLAZE_BREATH,
		BLAZE_DEATH,
		BLAZE_HIT,
		CAT_HISS,
		CAT_HIT,
		CAT_MEOW,
		CAT_PURR,
		CAT_PURREOW,
		CHICKEN_IDLE,
		CHICKEN_HURT,
		CHICKEN_EGG_POP,
		CHICKEN_WALK,
		COW_IDLE,
		COW_HURT,
		COW_WALK,
		CREEPER_HISS,
		CREEPER_DEATH,
		ENDERDRAGON_DEATH,
		ENDERDRAGON_GROWL,
		ENDERDRAGON_HIT,
		ENDERDRAGON_WINGS,
		ENDERMAN_DEATH,
		ENDERMAN_HIT,
		ENDERMAN_IDLE,
		ENDERMAN_TELEPORT,
		ENDERMAN_SCREAM,
		ENDERMAN_STARE,
		GHAST_SCREAM,
		GHAST_SCREAM2,
		GHAST_CHARGE,
		GHAST_DEATH,
		GHAST_FIREBALL,
		GHAST_MOAN,
		HORSE_DEATH,
		HORSE_SKELETON_HIT,
		IRONGOLEM_DEATH,
		IRONGOLEM_HIT,
		IRONGOLEM_THROW,
		IRONGOLEM_WALK,
		MAGMACUBE_WALK,
		MAGMACUBE_WALK2,
		MAGMACUBE_JUMP,
		PIG_IDLE,
		PIG_DEATH,
		PIG_WALK,
		SHEEP_IDLE,
		SHEEP_SHEAR,
		SHEEP_WALK,
		SILVERFISH_HIT,
		SILVERFISH_KILL,
		SILVERFISH_IDLE,
		SILVERFISH_WALK,
		SKELETON_IDLE,
		SKELETON_DEATH,
		SKELETON_HURT,
		SKELETON_WALK,
		SLIME_ATTACK,
		SLIME_WALK,
		SLIME_WALK2,
		SPIDER_IDLE,
		SPIDER_DEATH,
		SPIDER_WALK,
		WITHER_DEATH,
		WITHER_HURT,
		WITHER_IDLE,
		WITHER_SHOOT,
		WITHER_SPAWN,
		WOLF_BARK,
		WOLF_DEATH,
		WOLF_GROWL,
		WOLF_HOWL,
		WOLF_HURT,
		WOLF_PANT,
		WOLF_SHAKE,
		WOLF_WALK,
		WOLF_WHINE,
		ZOMBIE_METAL,
		ZOMBIE_WALK,
		ZOMBIE_WOOD,
		ZOMBIE_WOODBREAK,
		ZOMBIE_IDLE,
		ZOMBIE_DEATH,
		ZOMBIE_HURT,
		ZOMBIE_INFECT,
		ZOMBIE_UNFECT,
		ZOMBIE_REMEDY,
		ZOMBIE_PIG_IDLE,
		ZOMBIE_PIG_ANGRY,
		ZOMBIE_PIG_DEATH,
		ZOMBIE_PIG_HURT,
		// Dig Sounds
		DIG_WOOL,
		DIG_GRASS,
		DIG_GRAVEL,
		DIG_SAND,
		DIG_SNOW,
		DIG_STONE,
		DIG_WOOD,
		// Fireworks
		FIREWORK_BLAST,
		FIREWORK_BLAST2,
		FIREWORK_LARGE_BLAST,
		FIREWORK_LARGE_BLAST2,
		FIREWORK_TWINKLE,
		FIREWORK_TWINKLE2,
		FIREWORK_LAUNCH,
		// Horses
		HORSE_ANGRY,
		HORSE_ARMOR,
		HORSE_BREATHE,
		HORSE_GALLOP,
		HORSE_HIT,
		HORSE_IDLE,
		HORSE_JUMP,
		HORSE_LAND,
		HORSE_SADDLE,
		HORSE_SOFT,
		HORSE_WOOD,
		DONKEY_ANGRY,
		DONKEY_DEATH,
		DONKEY_HIT,
		DONKEY_IDLE,
		HORSE_SKELETON_DEATH,
		HORSE_SKELETON_IDLE,
		HORSE_ZOMBIE_DEATH,
		HORSE_ZOMBIE_HIT,
		HORSE_ZOMBIE_IDLE,
		// Villager
		VILLAGER_DEATH,
		VILLAGER_HAGGLE,
		VILLAGER_HIT,
		VILLAGER_IDLE,
		VILLAGER_NO,
		VILLAGER_YES,
		UNKNOWN(MCVersion.NEVER);

		private final MCVersion since;

		MCVanillaSound() {
			this(MCVersion.MC1_0);
		}

		MCVanillaSound(MCVersion since) {
			this.since = since;
		}

		public boolean existsInCurrent() {
			return Static.getServer().getMinecraftVersion().gte(since);
		}
	}
}
