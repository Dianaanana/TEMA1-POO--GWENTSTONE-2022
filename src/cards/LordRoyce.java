package cards;

import fileio.CardInput;

public class LordRoyce extends Hero implements Cloneable {
    public LordRoyce(CardInput cardInput, int health) {
        super(cardInput, health);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        LordRoyce clone = (LordRoyce) super.clone();
        return clone;
    }

    /**
     *
     * @param row
     */
    public void ability(Card[] row) {
        if (row == null) {
            return;
        }

        Card highestAttackCard = null;
        for (int c = 0; c < 5; c++) {
            if (row[c] == null) {
                continue;
            }

            if (highestAttackCard == null || row[c].getAttackDamage() > highestAttackCard.getAttackDamage()) {
                highestAttackCard = row[c];
            }
        }

        if (highestAttackCard == null) {
            return;
        }

        Minion minion = (Minion) highestAttackCard;
        minion.setFrozen(1);
    }
}

