package cards;

import fileio.CardInput;

public final class HeartHound extends Card implements Cloneable {
    /**
     *
     * @param cardInput
     */
    public HeartHound(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        HeartHound clone = (HeartHound) super.clone();
        return clone;
    }
}
