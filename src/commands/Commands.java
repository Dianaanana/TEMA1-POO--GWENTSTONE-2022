package commands;

import cards.Card;
import cards.Hero;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import decks.Decks;

import java.util.ArrayList;


public final class Commands {
    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static ObjectMapper getMapper() {
        return MAPPER;
    }


    private Commands() {
    }

    /**
     *
     * @param input
     * @return
     */
    private static ArrayNode getPlayerDeck(final ArrayList<Card> input) {
        ArrayNode outputArray = getMapper().createArrayNode();
//        ArrayNode outputArray = mapper.createArrayNode();
        Decks.decksMapper(input);
        return outputArray;
    }

    /**
     *
     * @param hero
     * @return
     */
    private static ObjectNode getPlayerHero(final Hero hero) {
        ObjectNode outputHero = getMapper().createObjectNode();
        Hero.cardMapper(hero);
        return outputHero;
    }
}
