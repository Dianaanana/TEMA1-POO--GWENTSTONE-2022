package cards;

import actions.Abilities;
import fileio.CardInput;

public final class Disciple extends Minion implements Cloneable, Abilities {
    /**
     *
     * @param teammate
     */
    public void ability(final Minion teammate) {
        teammate.health += 2;
    }

    /**
     *
     * @param cardInput
     */
    public Disciple(final CardInput cardInput) {
        super(cardInput);
        super.setAbility(1);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException  {
        Disciple clone = (Disciple) super.clone();
        return clone;
    }
}
