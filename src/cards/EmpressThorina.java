package cards;

import actions.Attacks;
import fileio.CardInput;

import static helpme.MagicNumber.MAX_CARDS;

public final class EmpressThorina extends Hero implements Cloneable {
    public EmpressThorina(final CardInput cardInput, final int health) {
        super(cardInput, health);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        EmpressThorina clone = (EmpressThorina) super.clone();
        return clone;
    }

    /**
     * @param row
     * @param rowIndex
     */
    public void ability(final Card[] row, final int rowIndex) {
        if (row == null) {
            return;
        }

        Card highestHealthCard = null;
        for (int c = 0; c < MAX_CARDS; c++) {
            if (row[c] == null) {
                continue;
            }

            if (highestHealthCard == null || row[c].getHealth() > highestHealthCard.getHealth()) {
                highestHealthCard = row[c];
            }
        }

        if (highestHealthCard == null) {
            return;
        }

        Minion minion = (Minion) highestHealthCard;
        minion.setHealth(0);
        Attacks.removeDeadCards(row, rowIndex);
    }
}
