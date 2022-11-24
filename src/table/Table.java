package table;

import cards.Card;
import cards.Hero;
import cards.Minion;

import java.util.ArrayList;

// clasa Tabla de joc va fi Singleton ptc va suferi multe modificari
// si sa nu fie nevoie de instantieri multe si
// degeaba
public class Table {
    private static Card[][] table ;
    private int manaPlayerOne;
    private int manaPlayerTwo;

    private ArrayList<Card> chosenDeckOne;
    private ArrayList<Card> chosenDeckTwo;
    private  ArrayList<Card> handPlayerOne;
    private ArrayList<Card> handPlayerTwo;
    private int turnCounter;
    private int playerOneWins;
    private int playerTwoWins;

    private ArrayList<Integer> countCardsOnRows;
    private int startingPlayer;
    private Hero heroPlayerOne;
    private Hero heroPlayerTwo;
    private static Table playTable = null;

    private Table() {}

    public static Table getPlayTable() {
        if(playTable == null) {
            playTable = new Table();
        }
        return playTable;
    }

    /**
     *
     * @param manaPlayerOne
     * @param manaPlayerTwo
     * @param chosenDeckOne
     * @param chosenDeckTwo
     * @param handPlayerOne
     * @param handPlayerTwo
     * @param turnCounter
     * @param startingPlayer
     * @param heroPlayerOne
     * @param heroPlayerTwo
     * @param countCardsOnRows
     */
    public Table(int manaPlayerOne, int manaPlayerTwo, ArrayList<Card> chosenDeckOne, ArrayList<Card> chosenDeckTwo, ArrayList<Card> handPlayerOne, ArrayList<Card> handPlayerTwo, int turnCounter, int startingPlayer, Hero heroPlayerOne, Hero heroPlayerTwo, ArrayList<Integer> countCardsOnRows) {
        Table.table = new Card[4][5];
        this.manaPlayerOne = manaPlayerOne;
        this.manaPlayerTwo = manaPlayerTwo;
        this.chosenDeckOne = chosenDeckOne;
        this.chosenDeckTwo = chosenDeckTwo;
        this.handPlayerOne = handPlayerOne;
        this.handPlayerTwo = handPlayerTwo;
        this.countCardsOnRows = countCardsOnRows;
        this.turnCounter = turnCounter;
        this.startingPlayer = startingPlayer;
        this.heroPlayerOne = heroPlayerOne;
        this.heroPlayerTwo = heroPlayerTwo;
    }


    public Card[][] getTable() {
        return table;
    }

    public void setTable(Card[][] table) {
        this.table = table;
    }

    public int getManaPlayerOne() {
        return manaPlayerOne;
    }

    public void setManaPlayerOne(int manaPlayerOne) {
        this.manaPlayerOne = manaPlayerOne;
    }

    public int getManaPlayerTwo() {
        return manaPlayerTwo;
    }

    public void setManaPlayerTwo(int manaPlayerTwo) {
        this.manaPlayerTwo = manaPlayerTwo;
    }

    public int getStartingPlayer() {
        return startingPlayer;
    }

    public void setStartingPlayer(int startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    public ArrayList<Card> getChosenDeckOne() {
        return chosenDeckOne;
    }

    public void setChosenDeckOne(ArrayList<Card> chosenDeckOne) {
        this.chosenDeckOne = chosenDeckOne;
    }

    public ArrayList<Card> getChosenDeckTwo() {
        return chosenDeckTwo;
    }

    public void setchosenDeckTwo(ArrayList<Card> getChosenDeckTwo) {
        this.chosenDeckTwo = getChosenDeckTwo;
    }

    public int getTurnCounter() {
        return turnCounter;
    }

    public void setTurnCounter(int turnCounter) {
        this.turnCounter = turnCounter;
    }

    public Hero getHeroPlayerOne() {
        return heroPlayerOne;
    }

    public void setHeroPlayerOne(Hero heroPlayerOne) {
        this.heroPlayerOne = heroPlayerOne;
    }

    public Hero getHeroPLayerTwo() {
        return heroPlayerTwo;
    }

    public Hero getHeroPlayerTwo() {
        return heroPlayerTwo;
    }

    public int getPlayerOneWins() {
        return playerOneWins;
    }

    public void setPlayerOneWins(int playerOneWins) {
        this.playerOneWins = playerOneWins;
    }

    public int getPlayerTwoWins() {
        return playerTwoWins;
    }

    public void setPlayerTwoWins(int playerTwoWins) {
        this.playerTwoWins = playerTwoWins;
    }

    public void setHeroPlayerTwo(Hero heroPlayerTwo) {
        this.heroPlayerTwo = heroPlayerTwo;
    }

    public void setHeroPLayerTwo(Hero heroPLayerTwo) {
        this.heroPlayerTwo = heroPLayerTwo;
    }

    public static void setPlayTable(Table playTable) {
        Table.playTable = playTable;
    }

    public void setChosenDeckTwo(ArrayList<Card> chosenDeckTwo) {
        this.chosenDeckTwo = chosenDeckTwo;
    }

    public ArrayList<Card> getHandPlayerOne() {
        return handPlayerOne;
    }

    public void setHandPlayerOne(ArrayList<Card> handPlayerOne) {
        this.handPlayerOne = handPlayerOne;
    }

    public ArrayList<Card> getHandPlayerTwo() {
        return handPlayerTwo;
    }

    public ArrayList<Integer> getCountCardsOnRows() {
        return countCardsOnRows;
    }

    public void setCountCardsOnRows(ArrayList<Integer> countCardsOnRows) {
        this.countCardsOnRows = countCardsOnRows;
    }

    public void setHandPlayerTwo(ArrayList<Card> handPlayerTwo) {
        this.handPlayerTwo = handPlayerTwo;
    }
}
