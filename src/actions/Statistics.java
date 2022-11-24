package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Game;
import game.StartGame;
import server.Server;
import table.Table;

import java.util.ArrayList;

import static cards.Card.mapper;

public class Statistics extends Actions{
    public Statistics(ActionsInput actionsInput) {
        super(actionsInput);
    }

    // TODO
    public static void getTotalGamesPlayed (Actions action, ArrayNode outputFinal, ArrayList<Game> games) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("output", Server.getInstance().gamePlayed);
        outputFinal.add(output);
    }

    // TODO
    public static void getPlayerOneWins (Actions action, ArrayNode outputFinal, ArrayList<Game> games) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("output", Table.getPlayTable().getPlayerOneWins());
        outputFinal.add(output);
    }

    // TODO
    public static void getPlayerTwoWins (Actions action, ArrayNode outputFinal, ArrayList<Game> games) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("output", Server.getInstance().gamePlayed -  Table.getPlayTable().getPlayerOneWins());
        outputFinal.add(output);
    }
}
