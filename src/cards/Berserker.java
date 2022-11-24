package cards;

import fileio.CardInput;

// randul din spate
//
public class Berserker extends Minion implements Cloneable {
    public Berserker(CardInput cardInput) {
        super(cardInput);
    }

    public Berserker(Card card, int health, int attackDamage, int row, int frozen, int ability, int tank) {
        super(card, health, attackDamage, row, frozen, ability, tank);
    }

    public Object clone() throws CloneNotSupportedException {
        Berserker clone = (Berserker) super.clone();
        return clone;
    }
}
