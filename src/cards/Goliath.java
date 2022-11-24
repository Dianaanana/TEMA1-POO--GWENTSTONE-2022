package cards;

import fileio.CardInput;

// e tank
// randul din fata
public class Goliath extends Minion implements Cloneable {
    /**
     *
     * @param cardInput
     */
    public Goliath(CardInput cardInput) {
        super(cardInput);
        super.setTank(1);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException  {
        Goliath clone = (Goliath) super.clone();
        return clone;
    }
}
