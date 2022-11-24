package cards;

import fileio.CardInput;

public class Winterfall extends Card implements Cloneable {
    /**
     *
     * @param cardInput
     */
    public Winterfall(final CardInput cardInput) {
        super(cardInput);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Winterfall clone = (Winterfall) super.clone();
        return clone;
    }
}
