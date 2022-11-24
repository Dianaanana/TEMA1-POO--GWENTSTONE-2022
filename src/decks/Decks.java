package decks;

import cards.Card;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import fileio.CardInput;
import fileio.DecksInput;
import helpme.Helpme;

import java.util.ArrayList;

public final class Decks {
    private int nrCardsInDeck;
    private int nrDecks;
    private ArrayList<ArrayList<Card>> decks = new ArrayList<>();

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * @param decksInput
     */
    public Decks(final DecksInput decksInput) {
        this.nrCardsInDeck = decksInput.getNrCardsInDeck();
        this.nrDecks = decksInput.getNrDecks();


        for (int i = 0; i < decksInput.getDecks().size(); i++) {
            ArrayList<Card> arrayList = new ArrayList<>();
            for (CardInput cardInput : decksInput.getDecks().get(i)) {
                Card cardToAdd = Helpme.cardAssign(cardInput);
                if (cardToAdd == null) {
                    continue;
                }


                arrayList.add(cardToAdd);
            }
            decks.add(arrayList);

        }

    }

    /**
     * @param deck
     * @return
     */
    public static ArrayNode decksMapper(final ArrayList<Card> deck) {
        ArrayNode cardsArray = mapper.createArrayNode();
        for (Card card : deck) {
            // VAD CE CARTI SUNT IN PACHET
            cardsArray.add(card.cardMapperMinion(card));
        }
        return cardsArray;
    }

    public int getNrCardsInDeck() {
        return nrCardsInDeck;
    }

    public void setNrCardsInDeck(final int nrCardsInDeck) {
        this.nrCardsInDeck = nrCardsInDeck;
    }

    public int getNrDecks() {
        return nrDecks;
    }

    public void setNrDecks(final int nrDecks) {
        this.nrDecks = nrDecks;
    }

    public ArrayList<ArrayList<Card>> getDecks() {
        return decks;
    }

    public void setDecks(final ArrayList<ArrayList<Card>> decks) {
        this.decks = decks;
    }
}
