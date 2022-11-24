package cards;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Hero extends Card implements Cloneable {
    public Hero(CardInput cardInput, int health) {
        super(cardInput);
        this.health = health;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "health=" + health +
                ", mana=" + mana +
                ", description='" + description + '\'' +
                ", colors=" + colors +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     *
     * @param hero
     * @return
     */
    static public ObjectNode cardMapper (Hero hero) {

        ObjectNode hero1 = mapper.createObjectNode();
        hero1.put("mana", hero.mana);
        hero1.put("description", hero.description);

        ArrayNode arrayNode = mapper.createArrayNode();
        for(String color : hero.colors) {
            arrayNode.add(color);
        }
        hero1.set("colors", arrayNode);
        hero1.put("name", hero.name);
        hero1.put("health", hero.health);

        return hero1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Hero clone = (Hero) super.clone();
        return clone;
    }
}

