package cards;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;
import server.*;
import helpme.*;

import java.util.ArrayList;

public class  Card implements Cloneable {
    int mana;
    int attackDamage;
    int health;
    String description;
    ArrayList<String> colors;
    String name;

    int hasAttackedThisRound;

     public static ObjectMapper mapper = new ObjectMapper();

     // DONE

    /**
     *
     * @param cardInput
     */
    public Card(CardInput cardInput) {
        this.mana = cardInput.getMana();
        this.attackDamage = cardInput.getAttackDamage();
        this.health = cardInput.getHealth();
        this.description = cardInput.getDescription();
        this.colors = cardInput.getColors();
        this.name = cardInput.getName();
    }

    // DONE

    /**
     *
     * @param card
     */
    public Card(Card card) {
        this.mana = card.getMana();
        this.attackDamage = card.getAttackDamage();
        this.health = card.getHealth();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    /**
     *
     * @param card
     * @return
     */
    public static ObjectNode cardMapperEnvironement (Card card) {
        ObjectNode cardMapped = mapper.createObjectNode();
        cardMapped.put("mana", card.mana);
//        cardMapped.put("attackDamage", card.attackDamage);
//        cardMapped.put("health", card.health);
        cardMapped.put("description", card.description);

        ArrayNode arrayNode = mapper.createArrayNode();
        for(String color : card.colors) {
            arrayNode.add(color);
        }
        cardMapped.set("colors", arrayNode);
        cardMapped.put("name", card.name);

        return cardMapped;
    };

//     mapeaza cartea

    /**
     *
     * @param card
     * @return
     */
    public static ObjectNode cardMapperMinion (Card card) {
        ObjectNode cardMapped = mapper.createObjectNode();
        cardMapped.put("mana", card.mana);
        cardMapped.put("attackDamage", card.attackDamage);
        cardMapped.put("health", card.health);
        cardMapped.put("description", card.description);

        ArrayNode arrayNode = mapper.createArrayNode();
            for(String color : card.colors) {
            arrayNode.add(color);
        }
        cardMapped.set("colors", arrayNode);
        cardMapped.put("name", card.name);

        return cardMapped;
    };

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHasAttackedThisRound() {
        return hasAttackedThisRound;
    }

    public void setHasAttackedThisRound(int hasAttackedThisRound) {
        this.hasAttackedThisRound = hasAttackedThisRound;
    }

    // TODO

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Card clone = (Card) super.clone();
        clone.colors = new ArrayList<>();
        clone.colors.addAll(colors);
        return clone;
    }

    @Override
    public String toString() {
        return "Card{" +
                "mana=" + mana +
                ", attackDamage=" + attackDamage +
                ", health=" + health +
                ", description='" + description + '\'' +
                ", colors=" + colors +
                ", name='" + name + '\'' +
                '}';
    }
}

