package cards;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Minion extends Card implements Cloneable {
    int row;
    int frozen;
    int ability;
    int tank;

    public Minion(Card card, int health, int attackDamage, int row, int frozen, int ability, int tank) {
        super(card);
        this.health = health;
        this.attackDamage = attackDamage;
        this.row = row;
        this.frozen = frozen;
        this.ability = ability;
        this.tank = tank;
    }

    public Minion(CardInput cardInput) {
        super(cardInput);
        this.health =  cardInput.getHealth();
        this.attackDamage = cardInput.getAttackDamage();
    }

    public int getFrozen() {
        return frozen;
    }

    public void setFrozen(int frozen) {
        this.frozen = frozen;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public ObjectNode CardMapper(Minion minion) {
        ObjectNode minion1 = mapper.createObjectNode();
        minion1.put("mana", minion.mana);
        minion1.put("attackDamage", minion.attackDamage);
        minion1.put("health", minion.health);
        minion1.put("description", minion.description);

        ArrayNode arrayNode = mapper.createArrayNode();
        for(String color : minion.colors) {
            arrayNode.add(color);
        }
        minion1.set("colors", arrayNode);
        minion1.put("name", minion.name);

        return minion1;
    }

    public Object clone() throws CloneNotSupportedException {
        Minion clone = (Minion) super.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "row=" + row +
                ", frozen=" + frozen +
                ", ability=" + ability +
                ", tank=" + tank +
                ", mana=" + mana +
                ", attackDamage=" + attackDamage +
                ", health=" + health +
                ", description='" + description + '\'' +
                ", colors=" + colors +
                ", name='" + name + '\'' +
                ", hasAttackedThisRound=" + hasAttackedThisRound +
                '}';
    }
}

