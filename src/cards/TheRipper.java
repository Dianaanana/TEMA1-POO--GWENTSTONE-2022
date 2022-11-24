package cards;

import actions.Abilities;
import fileio.CardInput;

// randul din fata
public class TheRipper extends Minion implements Cloneable, Abilities {
    /**
     *
     * @param enemy
     */
    public void ability(Minion enemy) {
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
    public TheRipper(CardInput cardInput) {
        super(cardInput);
        super.ability = 1;
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
    public TheRipper(Card card, int health, int attackDamage, int row, int frozen, int ability, int tank) {
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
