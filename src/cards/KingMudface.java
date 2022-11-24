package cards;

import fileio.CardInput;

public class KingMudface extends Hero implements Cloneable {
    public KingMudface(CardInput cardInput, int health) {
        super(cardInput, health);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        KingMudface clone = (KingMudface) super.clone();
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

        for (int c = 0; c < 5; c++) {
            if (row[c] == null) {
                continue;
            }

            row[c].setHealth(row[c].getHealth() + 1);
        }
    }
}
