package net.innectis.innplugin.objects.owned;

import net.innectis.innplugin.player.PlayerGroup;

/**
 *
 * Enum containing the flags that are settable on owned objects
 */
public enum SwitchFlagType implements FlagType {

    // #FORMAT_START
    REDSTONE_TRIGGER    (1, "Redstone", PlayerGroup.GUEST);

    private final long flagBit;
    private final String flagName;
    private final PlayerGroup group;

    private SwitchFlagType(long flagBit, String name, PlayerGroup requiredGroup) {
        if (flagBit <= 0 || flagBit > 64) {
            throw new RuntimeException("Bit id must be between 1 and 64 (included).");
        }

        this.flagBit = (long) Math.pow(2L, flagBit - 1);
        this.flagName = name;
        this.group = requiredGroup;
    }

    /**
     * @inherit
     */
    @Override
    public final long getFlagBit() {
        return flagBit;
    }

    /**
     * @inherit
     */
    @Override
    public final String getFlagName() {
        return this.flagName;
    }

    /**
     * @inherit
     */
    @Override
    public final PlayerGroup getRequiredGroup() {
        return this.group;
    }

    /**
     * This method will find the flag with the given name.
     * @param name
     * @return NONE if no flag has been found
     */
    public static SwitchFlagType getFlag(String name) {
        for (SwitchFlagType flag : values()) {
            if (flag.getFlagName().equalsIgnoreCase(name)) {
                return flag;
            }
        }
        return null;
    }

}
