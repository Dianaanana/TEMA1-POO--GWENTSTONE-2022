package table;

import cards.Card;
import cards.Hero;


import java.util.ArrayList;

public class Table {
    private static Card[][] table;
    private int manaPlayerOne;
    private int manaPlayerTwo;

    private ArrayList<Card> chosenDeckOne;
    private ArrayList<Card> chosenDeckTwo;
    private ArrayList<Card> handPlayerOne;
    private ArrayList<Card> handPlayerTwo;
    private int turnCounter;
    private int playerOneWins;
    private int playerTwoWins;

    private ArrayList<Integer> countCardsOnRows;
    private int startingPlayer;
    private Hero heroPlayerOne;
    private Hero heroPlayerTwo;
    private static Table playTable = null;

    /**
     *
     */
    private Table() {
    }

    /**
     *
     * @return
     */
    public static Table getPlayTable() {
        if (playTable == null) {
            playTable = new Table();
        }
        return playTable;
    }

    /**
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
    public Table(final int manaPlayerOne, final int manaPlayerTwo,
                 final ArrayList<Card> chosenDeckOne, final ArrayList<Card> chosenDeckTwo,
                 final ArrayList<Card> handPlayerOne, final ArrayList<Card> handPlayerTwo,
                 final int turnCounter, final int startingPlayer, final Hero heroPlayerOne,
                 final Hero heroPlayerTwo, final ArrayList<Integer> countCardsOnRows) {
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


    /**
     *
     * @return
     */
    public Card[][] getTable() {
        return table;
    }

    /**
     *
     * @param table
     */
    public void setTable(Card[][] table) {
        this.table = table;
    }

    /**
     *
     * @return
     */
    public int getManaPlayerOne() {
        return manaPlayerOne;
    }

    /**
     *
     * @param manaPlayerOne
     */
    public void setManaPlayerOne(final int manaPlayerOne) {
        this.manaPlayerOne = manaPlayerOne;
    }

    /**
     *
     * @return
     */
    public int getManaPlayerTwo() {
        return manaPlayerTwo;
    }

    /**
     *
     * @param manaPlayerTwo
     */
    public void setManaPlayerTwo(final int manaPlayerTwo) {
        this.manaPlayerTwo = manaPlayerTwo;
    }

    /**
     *
     * @return
     */
    public int getStartingPlayer() {
        return startingPlayer;
    }

    /**
     *
     * @param startingPlayer
     */
    public void setStartingPlayer(final int startingPlayer) {
        this.startingPlayer = startingPlayer;
    }

    /**
     *
     * @return
     */
    public ArrayList<Card> getChosenDeckOne() {
        return chosenDeckOne;
    }

    /**
     *
     * @param chosenDeckOne
     */
    public void setChosenDeckOne(final ArrayList<Card> chosenDeckOne) {
        this.chosenDeckOne = chosenDeckOne;
    }

    /**
     *
     * @return
     */
    public ArrayList<Card> getChosenDeckTwo() {
        return chosenDeckTwo;
    }

    /**
     *
     * @param getChosenDeckTwo
     */
    public void setchosenDeckTwo(final ArrayList<Card> getChosenDeckTwo) {
        this.chosenDeckTwo = getChosenDeckTwo;
    }

    /**
     *
     * @return
     */
    public int getTurnCounter() {
        return turnCounter;
    }

    /**
     *
     * @param turnCounter
     */
    public void setTurnCounter(final int turnCounter) {
        this.turnCounter = turnCounter;
    }

    /**
     *
     * @return
     */
    public Hero getHeroPlayerOne() {
        return heroPlayerOne;
    }

    /**
     *
     * @param heroPlayerOne
     */
    public void setHeroPlayerOne(final Hero heroPlayerOne) {
        this.heroPlayerOne = heroPlayerOne;
    }

    /**
     *
     * @return
     */
    public Hero getHeroPLayerTwo() {
        return heroPlayerTwo;
    }

    /**
     *
     * @return
     */
    public Hero getHeroPlayerTwo() {
        return heroPlayerTwo;
    }

    /**
     *
     * @return
     */
    public int getPlayerOneWins() {
        return playerOneWins;
    }

    /**
     *
     * @param playerOneWins
     */
    public void setPlayerOneWins(final int playerOneWins) {
        this.playerOneWins = playerOneWins;
    }

    /**
     *
     * @return
     */
    public int getPlayerTwoWins() {
        return playerTwoWins;
    }

    /**
     *
     * @param playerTwoWins
     */
    public void setPlayerTwoWins(final int playerTwoWins) {
        this.playerTwoWins = playerTwoWins;
    }

    /**
     *
     * @param heroPlayerTwo
     */
    public void setHeroPlayerTwo(final Hero heroPlayerTwo) {
        this.heroPlayerTwo = heroPlayerTwo;
    }

    /**
     *
     * @param heroPLayerTwo
     */
    public void setHeroPLayerTwo(final Hero heroPLayerTwo) {
        this.heroPlayerTwo = heroPLayerTwo;
    }

    /**
     *
     * @param playTable
     */
    public static void setPlayTable(final Table playTable) {
        Table.playTable = playTable;
    }

    /**
     *
     * @param chosenDeckTwo
     */
    public void setChosenDeckTwo(final ArrayList<Card> chosenDeckTwo) {
        this.chosenDeckTwo = chosenDeckTwo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Card> getHandPlayerOne() {
        return handPlayerOne;
    }

    /**
     *
     * @param handPlayerOne
     */
    public void setHandPlayerOne(final ArrayList<Card> handPlayerOne) {
        this.handPlayerOne = handPlayerOne;
    }

    /**
     *
     * @return
     */
    public ArrayList<Card> getHandPlayerTwo() {
        return handPlayerTwo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getCountCardsOnRows() {
        return countCardsOnRows;
    }

    /**
     *
     * @param countCardsOnRows
     */
    public void setCountCardsOnRows(final ArrayList<Integer> countCardsOnRows) {
        this.countCardsOnRows = countCardsOnRows;
    }

    /**
     *
     * @param handPlayerTwo
     */
    public void setHandPlayerTwo(final ArrayList<Card> handPlayerTwo) {
        this.handPlayerTwo = handPlayerTwo;
    }
}
