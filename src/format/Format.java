package format;

import cards.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import decks.Decks;
import fileio.ActionsInput;
import game.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static server.Server.games;

public class Format {

    ArrayList<Card> chosenDeckOne;
    ArrayList<Card> chosenDeckTwo;


//    public void Format(ArrayList<Card> chosenDeckOne, ArrayList<Card> chosenDeckTwo, Decks playerOneDecks, Decks playerTwoDecks, ArrayList<Game> games, int gameNr) {
//        // La fiecare game fac un pachet auxiliar si fac shuffle la el ca sa nu modific pachetul original
//        // indexul deckului playerului 1 si 2
//        int deckIndexPlayerOne = games.get(gameNr).getStartGame().getPlayerOneDeckIdx();
//        int deckIndexPlayerTwo = games.get(gameNr).getStartGame().getPlayerTwoDeckIdx();
//        // deckurile 1 si 2
//        ArrayList<Card> deckOne = playerOneDecks.getDecks().get(deckIndexPlayerOne);
//        ArrayList<Card> deckTwo = playerTwoDecks.getDecks().get(deckIndexPlayerTwo);
//
//        for(int i = 0 ; i < deckOne.size(); i++) {
//            Card cardOne = new Card(deckOne.get(i));
//            chosenDeckOne.add(cardOne);
//        }
//
//        for(int i = 0 ; i < deckTwo.size(); i++) {
//            Card cardTwo = new Card(deckTwo.get(i));
//            chosenDeckOne.add(cardTwo);
//        }
//        Collections.shuffle(chosenDeckOne, new Random(games.get(gameNr).getStartGame().getShuffleSeed()));
//        Collections.shuffle(chosenDeckTwo, new Random(games.get(gameNr).getStartGame().getShuffleSeed()));
////        this.chosenDeckOne = chosenDeckOne;
////        this.chosenDeckTwo = chosenDeckTwo;
//    }

    public ArrayList<Card> getChosenDeckOne() {
        return chosenDeckOne;
    }

    public void setChosenDeckOne(ArrayList<Card> chosenDeckOne) {
        this.chosenDeckOne = chosenDeckOne;
    }

    public ArrayList<Card> getChosenDeckTwo() {
        return chosenDeckTwo;
    }

    public void setChosenDeckTwo(ArrayList<Card> chosenDeckTwo) {
        this.chosenDeckTwo = chosenDeckTwo;
    }

    /**
     *
     * @param playerOneDecks
     * @param games
     * @param gameNr
     * @return
     */
    public static ArrayList<Card> copyDeckOne (Decks playerOneDecks,ArrayList<Game> games, int gameNr) {

        // La fiecare game fac un pachet auxiliar si fac shuffle la el ca sa nu modific pachetul original
        ArrayList<Card> chosenDeckOne = new ArrayList<>();
        // indexul deckului playerului 1 si 2
        int deckIndexPlayerOne = games.get(gameNr).getStartGame().getPlayerOneDeckIdx();
        // deckurile 1 si 2
        ArrayList<Card> deckOne = playerOneDecks.getDecks().get(deckIndexPlayerOne);

        for(int i = 0 ; i < deckOne.size(); i++) {
            try {
                Card cardOne = deckOne.get(i);
                chosenDeckOne.add((Card) cardOne.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Collections.shuffle(chosenDeckOne, new Random(games.get(gameNr).getStartGame().getShuffleSeed()));
        return  chosenDeckOne;
    }

    /**
     *
     * @param playerTwoDecks
     * @param games
     * @param gameNr
     * @return
     */
    public static ArrayList<Card> copyDeckTwo (Decks playerTwoDecks, ArrayList<Game> games, int gameNr) {

        // La fiecare game fac un pachet auxiliar si fac shuffle la el ca sa nu modific pachetul original
        ArrayList<Card> chosenDeckTwo = new ArrayList<>();

        // indexul deckului playerului 1 si 2
        int deckIndexPlayerTwo = games.get(gameNr).getStartGame().getPlayerTwoDeckIdx();
        // deckurile 1 si 2
        ArrayList<Card> deckTwo = playerTwoDecks.getDecks().get(deckIndexPlayerTwo);

        for(int i = 0 ; i < deckTwo.size(); i++) {
            try {
                Card cardTwo = deckTwo.get(i);
                chosenDeckTwo.add((Card) cardTwo.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        Collections.shuffle(chosenDeckTwo, new Random(games.get(gameNr).getStartGame().getShuffleSeed()));
        return chosenDeckTwo;
    }

    /**
     *
     * @param card
     * @return
     */
    public static int checkCard (Card card) {
        switch (card.getName()) {
            case "Disciple" :
                return 1;
            case "Goliath" :
                return 1;
            case "Sentinel" :
                return 1;
            case "Winterfell" :
                return 2;
            case "Berserker" :
                return 1;
            case "The Cursed One" :
                return 1;
            case "Miraj" :
                return 1;
            case "Heart Hound" :
                return 2;
            case "Warden" :
                return 1;
            case "Firestorm" :
                return 2;
            case "The Ripper" :
                return 1;
        }
        return -1;
    }

    /**
     *
     * @param card
     * @return
     */
    public static int checkCardRow (Card card) {
        // 1 pt randul din fata 2 pt spate 3 daca e environement
        switch (card.getName()) {
            case "Disciple" :  // da
                return 2;
            case "Goliath" : // da
                return 1;
            case "Sentinel" : // da
                return 2;
            case "Winterfell" : // da
                return 3;
            case "Berserker" :  // da
                return 2;
            case "The Cursed One" :  //da
                return 2;
            case "Miraj" : // da
                return 1;
            case "Heart Hound" :  // da
                return 3;
            case "Warden" : // da
                return 1;
            case "Firestorm" : //da
                return 3;
            case "The Ripper": // da
                return 1;
        }
        return -1;
    }
}
