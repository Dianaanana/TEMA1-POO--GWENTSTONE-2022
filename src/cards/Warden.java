package cards;

import fileio.CardInput;

public class Warden extends Minion implements Cloneable {
    /**
     *
     * @param cardInput
     */
    public Warden(CardInput cardInput) {
        super(cardInput);
        super.setTank(1);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Warden clone = (Warden) super.clone();
        return clone;
    }
}
