package cards;

import fileio.CardInput;

public class HeartHound extends Card implements Cloneable {
    public HeartHound(CardInput cardInput) {
        super(cardInput);
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException  {
        HeartHound clone = (HeartHound) super.clone();
        return clone;
    }
}
