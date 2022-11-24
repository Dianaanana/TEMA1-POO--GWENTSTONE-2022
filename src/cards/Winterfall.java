package cards;

import fileio.CardInput;

public class Winterfall extends Card implements Cloneable {
    public Winterfall(CardInput cardInput) {
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
