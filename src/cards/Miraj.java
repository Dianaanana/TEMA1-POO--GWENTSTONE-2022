package cards;

import actions.Abilities;
import fileio.CardInput;

// randul din fata
public class Miraj extends Minion implements Cloneable, Abilities {
    /**
     *
     * @param enemy
     */
    public void ability(Minion enemy) {
        int healthBuff;
        healthBuff = enemy.health;
        enemy.health = this.health;
        this.health = healthBuff;
    }

    /**
     *
     * @param cardInput
     */
    public Miraj(CardInput cardInput) {
        super(cardInput);
        super.ability = 1;
    }

    /**
     * \
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Miraj clone = (Miraj) super.clone();
        return clone;
    }
}
