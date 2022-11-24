package cards;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Hero extends Card implements Cloneable {
    public Hero(final CardInput cardInput, final int health) {
        super(cardInput);
        this.setHealth(health);
    }

    /**
     * @param hero
     * @return
     */
    public static ObjectNode cardMapper(final Hero hero) {

        ObjectNode hero1 = getMapper().createObjectNode();
        hero1.put("mana", hero.getMana());
        hero1.put("description", hero.getDescription());

        ArrayNode arrayNode = getMapper().createArrayNode();
        for (String color : hero.getColors()) {
            arrayNode.add(color);
        }
        hero1.set("colors", arrayNode);
        hero1.put("name", hero.getName());
        hero1.put("health", hero.getHealth());

        return hero1;
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Hero clone = (Hero) super.clone();
        return clone;
    }
}

