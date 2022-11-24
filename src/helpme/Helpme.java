package helpme;

import cards.*;
import fileio.CardInput;

public final class Helpme {
    private Helpme() {
    }

    /**
     * @param cardInput
     * @return
     */
    public static Card cardAssign(final CardInput cardInput) {
        switch (cardInput.getName()) {
            case "Disciple":
                return new Disciple(cardInput);
            case "Goliath":
                return new Goliath(cardInput);
            case "Sentinel":
                return new Sentinel(cardInput);
            case "Winterfell":
                return new Winterfall(cardInput);
            case "Berserker":
                return new Berserker(cardInput);
            case "The Cursed One":
                return new TheCursedOne(cardInput);
            case "Miraj":
                return new Miraj(cardInput);
            case "Heart Hound":
                return new HeartHound(cardInput);
            case "Warden":
                return new Warden(cardInput);
            case "Firestorm":
                return new Firestorm(cardInput);
            case "The Ripper":
                return new TheRipper(cardInput);
            default:
                return null;
        }
    }

    /**
     * @param cardInput
     * @return
     */
    public static Hero heroAssign(final CardInput cardInput) {
        switch (cardInput.getName()) {
            case "General Kocioraw":
                return new Kocioraw(cardInput, MagicNumber.HERO_HEALTH);
            case "King Mudface":
                return new KingMudface(cardInput, MagicNumber.HERO_HEALTH);
            case "Lord Royce":
                return new LordRoyce(cardInput, MagicNumber.HERO_HEALTH);
            case "Empress Thorina":
                return new EmpressThorina(cardInput, MagicNumber.HERO_HEALTH);
            default:
                return null;
        }
    }
}
