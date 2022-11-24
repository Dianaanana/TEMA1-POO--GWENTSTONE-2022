package cards;

import fileio.CardInput;

public final class Kocioraw extends Hero implements Cloneable {
    /**
     *
     * @param cardInput
     * @param health
     */
    public Kocioraw(final CardInput cardInput, final int health) {
        super(cardInput, health);
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Kocioraw clone = (Kocioraw) super.clone();
        return clone;
    }

    /**
     * @param row
     */
    public void ability(final Card[] row) {
        if (row == null) {
            return;
        }

        for (int c = 0; c < 5; c++) {
            if (row[c] == null) {
                continue;
            }

            row[c].setAttackDamage(row[c].getAttackDamage() + 1);
        }
    }
}

