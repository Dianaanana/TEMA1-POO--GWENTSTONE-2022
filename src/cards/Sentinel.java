package cards;

import fileio.CardInput;

// randul din spate
public final class Sentinel extends Minion implements Cloneable {
    /**
     *
     * @param cardInput
     */
    public Sentinel(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Sentinel clone = (Sentinel) super.clone();
        return clone;
    }
}
