package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import decks.Decks;
import fileio.*;
import game.*;
import play.Play;

import java.util.ArrayList;

public class Server {

    private static Decks playerOneDecks;
    private static Decks playerTwoDecks;
    private static ArrayList<Game> games;
    private int gamePlayed = 0;
    private static ArrayList<ActionsInput> actionsInput = new ArrayList<>();
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * @return
     */
    public static Decks getPlayerOneDecks() {
        return playerOneDecks;
    }

    /**
     *
     * @param playerOneDecks
     */
    public static void setPlayerOneDecks(final Decks playerOneDecks) {
        Server.playerOneDecks = playerOneDecks;
    }

    /**
     *
     * @return
     */
    public static Decks getPlayerTwoDecks() {
        return playerTwoDecks;
    }

    /**
     *
     * @param playerTwoDecks
     */
    public static void setPlayerTwoDecks(final Decks playerTwoDecks) {
        Server.playerTwoDecks = playerTwoDecks;
    }

    /**
     *
     * @return
     */
    public static ArrayList<Game> getGames() {
        return games;
    }

    /**
     *
     * @param games
     */
    public static void setGames(final ArrayList<Game> games) {
        Server.games = games;
    }

    /**
     *
     * @return
     */
    public int getGamePlayed() {
        return gamePlayed;
    }

    /**
     *
     * @param gamePlayed
     */
    public void setGamePlayed(final int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    /**
     *
     * @return
     */
    public static ArrayList<ActionsInput> getActionsInput() {
        return actionsInput;
    }

    /**
     *
     * @param actionsInput
     */
    public static void setActionsInput(final ArrayList<ActionsInput> actionsInput) {
        Server.actionsInput = actionsInput;
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
    public static void setMapper(final ObjectMapper mapper) {
        Server.mapper = mapper;
    }

    /**
     *
     * @param instance
     */
    public static void setInstance(final Server instance) {
        Server.instance = instance;
    }

    /**
     *
     */
    private static Server instance;

    /**
     *
     */
    public void resetServer() {
        instance = null;
    }

    /**
     *
     * @return
     */
    public static Server getInstance() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }

    /**
     *
     */
    public Server() {
    }


    /**
     * @param playerOneDecks
     * @param playerTwoDecks
     * @param games
     */
    public Server(final Decks playerOneDecks,final  Decks playerTwoDecks,
                  final ArrayList<Game> games) {
        this.playerOneDecks = playerOneDecks;
        this.playerTwoDecks = playerTwoDecks;
        this.games = games;
    }

    /**
     * @param inputData
     */
    public void ServerReadInput(final Input inputData) {
        playerOneDecks = new Decks(inputData.getPlayerOneDecks());
        playerTwoDecks = new Decks(inputData.getPlayerTwoDecks());
        games = new ArrayList<Game>();

        for (int i = 0; i < inputData.getGames().size(); i++) {
            GameInput gameInput = new GameInput();
            gameInput = inputData.getGames().get(i);

            gameInput.setStartGame(inputData.getGames().get(i).getStartGame());
            StartGameInput startGameInput = inputData.getGames().get(i).getStartGame();

            actionsInput = inputData.getGames().get(i).getActions();
            Game game = new Game(startGameInput, actionsInput);
            games.add(game);
        }
    }

    /**
     * @param playerOneDecks
     * @param playerTwoDecks
     * @param games
     * @param outputFinal
     */
    public void ServerRun(final Decks playerOneDecks, final Decks playerTwoDecks,
                          final ArrayList<Game> games, final ArrayNode outputFinal) {
        for (int i = 0; i < games.size(); i++) {
            gamePlayed++;
            Play.playGame(i, outputFinal);
        }
    }
}
