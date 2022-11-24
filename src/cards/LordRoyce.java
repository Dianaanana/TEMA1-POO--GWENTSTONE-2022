package cards;

import fileio.CardInput;

import static helpme.MagicNumber.COL5;

public final class LordRoyce extends Hero implements Cloneable {
    /**
     *
     * @param cardInput
     * @param health
     */
    public LordRoyce(final CardInput cardInput, final int health) {
        super(cardInput, health);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        LordRoyce clone = (LordRoyce) super.clone();
        return clone;
    }

    /**
     * @param row
     */
    public void ability(final Card[] row) {
        if (row == null) {
            return;
        }

        Card highestAttackCard = null;
        for (int c = 0; c < COL5; c++) {
            if (row[c] == null) {
                continue;
            }

            if (highestAttackCard == null || row[c].getAttackDamage()
                    > highestAttackCard.getAttackDamage()) {
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

