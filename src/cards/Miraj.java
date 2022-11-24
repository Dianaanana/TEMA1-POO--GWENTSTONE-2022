package cards;

import actions.Abilities;
import fileio.CardInput;

// randul din fata
public final class Miraj extends Minion implements Cloneable, Abilities {
    /**
     * @param enemy
     */
    public void ability(final Minion enemy) {
        int healthBuff;
        healthBuff = enemy.getHealth();
        enemy.setHealth(this.getHealth());
        this.setHealth(healthBuff);
    }

    /**
     * @param cardInput
     */
    public Miraj(final CardInput cardInput) {
        super(cardInput);
        super.setAbility(1);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Miraj clone = (Miraj) super.clone();
        return clone;
    }
}
