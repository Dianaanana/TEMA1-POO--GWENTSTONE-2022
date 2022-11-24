package cards;

import fileio.CardInput;

public final class Berserker extends Minion implements Cloneable {
    public Berserker(final CardInput cardInput) {
        super(cardInput);
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
    public Berserker(final Card card, final int health, final int attackDamage,
                     final int row, final int frozen, final int ability, final int tank) {
        super(card, health, attackDamage, row, frozen, ability, tank);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Berserker clone = (Berserker) super.clone();
        return clone;
    }
}
