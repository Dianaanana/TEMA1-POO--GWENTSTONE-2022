package cards;

import fileio.CardInput;

public final class Firestorm extends Card implements Cloneable {
    /**
     *
     * @param cardInput
     */
    public Firestorm(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Firestorm clone = (Firestorm) super.clone();
        return clone;
    }
}
