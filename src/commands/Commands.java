package commands;

import cards.Card;
import cards.Hero;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import decks.Decks;

import java.util.ArrayList;


public class Commands {
    static ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * @param input
     * @return
     */
    public static ArrayNode getPlayerDeck(ArrayList<Card> input) {
        ArrayNode outputArray = mapper.createArrayNode();
        Decks.decksMapper(input);
        return outputArray;
    }

    /**
     *
     * @param hero
     * @return
     */
    public static ObjectNode getPlayerHero(Hero hero) {
        ObjectNode outputHero = mapper.createObjectNode();
        Hero.cardMapper(hero);
        return outputHero;
    }
}
