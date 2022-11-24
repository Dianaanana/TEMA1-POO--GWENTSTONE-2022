package cards;

import actions.Abilities;
import fileio.CardInput;

import java.util.ArrayList;

// randul din spate
public class Disciple extends Minion implements Cloneable, Abilities {
    public void ability(Minion teammate) {
        teammate.health += 2;
    }

    /**
     *
     * @param cardInput
     */
    public Disciple(CardInput cardInput) {
        super(cardInput);
        super.ability = 1;
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
