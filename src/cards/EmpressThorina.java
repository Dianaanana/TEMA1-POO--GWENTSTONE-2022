package cards;

import actions.Attacks;
import fileio.CardInput;

public class EmpressThorina extends Hero implements Cloneable {
    public EmpressThorina(CardInput cardInput, int health) {
        super(cardInput, health);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException  {
        EmpressThorina clone = (EmpressThorina) super.clone();
        return clone;
    }

    /**
     *
     * @param row
     * @param rowIndex
     */
    public void ability(Card[] row, int rowIndex) {
        if (row == null) {
            return;
        }

        Card highestHealthCard = null;
        for (int c = 0; c < 5; c++) {
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
