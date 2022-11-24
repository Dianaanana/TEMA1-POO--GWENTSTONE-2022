package cards;

import actions.Abilities;
import fileio.CardInput;

// randul din spate
public class TheCursedOne extends Minion implements Cloneable, Abilities {
    /**
     *
     * @param enemy
     */
    public void ability(Minion enemy) {
        int buff;
        buff = enemy.attackDamage;
        enemy.attackDamage = enemy.health;
        enemy.health = buff;
    }

    /**
     *
     * @param cardInput
     */
    public TheCursedOne(CardInput cardInput) {
        super(cardInput);
        super.ability = 1;
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        TheCursedOne clone = (TheCursedOne) super.clone();
        return clone;
    }
}
