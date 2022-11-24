package server;
import actions.Actions;
import cards.Card;
import cards.Hero;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import commands.Commands;
import decks.Decks;
import fileio.*;
import main.*;
import game.*;
import play.Play;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

// ar trb sa fac clasa asta singleton
//
//
// in clasa asta parsez tot inputul prin serverReadInput
// incep jocul prin serverRun
// pun output ul prin serverOutput

public class Server {

    public static Decks playerOneDecks;
    public static Decks playerTwoDecks;
    public static ArrayList<Game> games;
    public int gamePlayed = 0;
    public static ArrayList<ActionsInput> actionsInput = new ArrayList<>();
    static ObjectMapper mapper = new ObjectMapper();


    // singleton
    private static Server instance;
    public void resetServer() {
        instance = null;
    }
    public static Server getInstance() {
        if(instance == null) {
            instance = new Server();
        }
        return instance;
    }
    public Server() {};

    /**
     *
     * @param playerOneDecks
     * @param playerTwoDecks
     * @param games
     */
    public Server(Decks playerOneDecks, Decks playerTwoDecks, ArrayList<Game> games) {
        this.playerOneDecks = playerOneDecks;
        this.playerTwoDecks = playerTwoDecks;
        this.games = games;
    }

    /**
     *
     * @param inputData
     */
    public void ServerReadInput(Input inputData) {
        playerOneDecks = new Decks(inputData.getPlayerOneDecks());
        playerTwoDecks = new Decks(inputData.getPlayerTwoDecks());
        games = new ArrayList<Game>();

        for(int i = 0; i < inputData.getGames().size(); i++) {
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
     *
     * @param playerOneDecks
     * @param playerTwoDecks
     * @param games
     * @param outputFinal
     */
    public void ServerRun(Decks playerOneDecks, Decks playerTwoDecks, ArrayList<Game> games, ArrayNode outputFinal) {
        for(int i = 0; i < games.size(); i++) {
            gamePlayed++;
            Play.playGame(i, outputFinal);
        }
    }
}
