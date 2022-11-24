package cards;

import fileio.CardInput;

public class Firestorm extends Card implements Cloneable {
    public Firestorm(CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException  {
        Firestorm clone = (Firestorm) super.clone();
        return clone;
    }
}
