package cards;

import actions.Abilities;
import fileio.CardInput;

public final class TheRipper extends Minion implements Cloneable, Abilities {
    /**
     *
     * @param enemy
     */
    public void ability(final Minion enemy) {
        if (enemy.attackDamage < 2) {
            enemy.attackDamage = 0;
        } else {
            enemy.attackDamage -= 2;
        }
    }

    /**
     *
     * @param cardInput
     */
    public TheRipper(final CardInput cardInput) {
        super(cardInput);
        super.setAbility(1);
    }

    /**
     *
     * @param card
     * @param health
     * @param attackDamage
     * @param row
     * @param frozen
     * @param ability
     * @param tank
     */
    public TheRipper(final Card card, final int health, final int attackDamage,
                     final int row, final int frozen, final int ability, final int tank) {
        super(card, health, attackDamage, row, frozen, ability, tank);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */

    public Object clone() throws CloneNotSupportedException {
        TheRipper clone = (TheRipper) super.clone();
        return clone;
    }
}
