package cards;

import fileio.CardInput;

// randul din spate
public class Sentinel extends Minion implements Cloneable {
    public Sentinel(CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Sentinel clone = (Sentinel) super.clone();
        return clone;
    }
}
