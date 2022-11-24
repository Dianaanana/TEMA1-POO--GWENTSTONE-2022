package cards;

import fileio.CardInput;

import static helpme.MagicNumber.MAX_CARDS;

public final class KingMudface extends Hero implements Cloneable {
    public KingMudface(final CardInput cardInput, final int health) {
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
    public void ability(final Card[] row) {
        if (row == null) {
            return;
        }

        for (int c = 0; c < MAX_CARDS; c++) {
            if (row[c] == null) {
                continue;
            }

            row[c].setHealth(row[c].getHealth() + 1);
        }
    }
}
