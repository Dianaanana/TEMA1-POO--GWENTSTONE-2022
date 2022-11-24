package cards;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.CardInput;

import java.util.ArrayList;

public class Card implements Cloneable {
    private int mana;
    private int attackDamage;
    private int health;
    private String description;
    private ArrayList<String> colors;
    private String name;
    private int hasAttackedThisRound;

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * @param cardInput
     */
    public Card(final CardInput cardInput) {
        this.mana = cardInput.getMana();
        this.attackDamage = cardInput.getAttackDamage();
        this.health = cardInput.getHealth();
        this.description = cardInput.getDescription();
        this.colors = cardInput.getColors();
        this.name = cardInput.getName();
    }

    /**
     * @param card
     */
    public Card(final Card card) {
        this.mana = card.getMana();
        this.attackDamage = card.getAttackDamage();
        this.health = card.getHealth();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    /**
     * @param card
     * @return
     */
    public static ObjectNode cardMapperEnvironement(final Card card) {
        ObjectNode cardMapped = mapper.createObjectNode();
        cardMapped.put("mana", card.getMana());
        cardMapped.put("description", card.description);

        ArrayNode arrayNode = mapper.createArrayNode();
        for (String color : card.colors) {
            arrayNode.add(color);
        }
        cardMapped.set("colors", arrayNode);
        cardMapped.put("name", card.name);

        return cardMapped;
    }

    /**
     * @param card
     * @return
     */
    public static ObjectNode cardMapperMinion(final Card card) {
        ObjectNode cardMapped = mapper.createObjectNode();
        cardMapped.put("mana", card.getMana());
        cardMapped.put("attackDamage", card.attackDamage);
        cardMapped.put("health", card.health);
        cardMapped.put("description", card.description);

        ArrayNode arrayNode = mapper.createArrayNode();
        for (String color : card.colors) {
            arrayNode.add(color);
        }
        cardMapped.set("colors", arrayNode);
        cardMapped.put("name", card.name);

        return cardMapped;
    }

    /**
     *
     * @return
     */
    public final int getMana() {
        return mana;
    }

    /**
     *
     * @param mana
     */
    public final void setMana(final int mana) {
        this.setMana(mana);
    }

    /**
     *
     * @return
     */
    public final String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public final void setDescription(final String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public final int getAttackDamage() {
        return attackDamage;
    }

    /**
     *
     * @param attackDamage
     */
    public final void setAttackDamage(final int attackDamage) {
        this.attackDamage = attackDamage;
    }

    /**
     *
     * @return
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @param health
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     *
     * @return
     */
    public final ArrayList<String> getColors() {
        return colors;
    }

    /**
     *
     * @param colors
     */
    public final void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    /**
     *
     * @return
     */
    public final String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public static ObjectMapper getMapper() {
        return mapper;
    }

    /**
     *
     * @param mapper
     */
    public static void setMapper(ObjectMapper mapper) {
        Card.mapper = mapper;
    }

    /**
     *
     * @param name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public final int getHasAttackedThisRound() {
        return hasAttackedThisRound;
    }

    /**
     *
     * @param hasAttackedThisRound
     */
    public final void setHasAttackedThisRound(final int hasAttackedThisRound) {
        this.hasAttackedThisRound = hasAttackedThisRound;
    }

    /**
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        Card clone = (Card) super.clone();
        clone.colors = new ArrayList<>();
        clone.colors.addAll(colors);
        return clone;
    }
}

