package cards;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

public class Minion extends Card implements Cloneable {
    private int row;
    private int frozen;
    private int ability;
    private int tank;

    public Minion(final Card card, final int health, final int attackDamage,
                  final int row, final int frozen, final int ability, final int tank) {
        super(card);
        this.health = health;
        this.attackDamage = attackDamage;
        this.row = row;
        this.frozen = frozen;
        this.ability = ability;
        this.tank = tank;
    }

    public Minion(final CardInput cardInput) {
        super(cardInput);
        this.health =  cardInput.getHealth();
        this.attackDamage = cardInput.getAttackDamage();
    }

    public final int getRow() {
        return row;
    }

    public final void setRow(final int row) {
        this.row = row;
    }

    public final int getAbility() {
        return ability;
    }

    public final void setAbility(final int ability) {
        this.ability = ability;
    }

    public final int getFrozen() {
        return frozen;
    }

    public final void setFrozen(final int frozen) {
        this.frozen = frozen;
    }

    public final int getTank() {
        return tank;
    }

    public final void setTank(final int tank) {
        this.tank = tank;
    }

    /**
     *
     * @param minion
     * @return
     */
    public ObjectNode cardMapper(final Minion minion) {
        ObjectNode minion1 = mapper.createObjectNode();
        minion1.put("mana", minion.mana);
        minion1.put("attackDamage", minion.attackDamage);
        minion1.put("health", minion.health);
        minion1.put("description", minion.description);

        ArrayNode arrayNode = mapper.createArrayNode();
        for (String color : minion.colors) {
            arrayNode.add(color);
        }
        minion1.set("colors", arrayNode);
        minion1.put("name", minion.name);

        return minion1;
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Minion clone = (Minion) super.clone();
        return clone;
    }
}

