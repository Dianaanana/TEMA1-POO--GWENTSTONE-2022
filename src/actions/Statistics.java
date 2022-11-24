package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import game.Game;
import server.Server;
import table.Table;

import java.util.ArrayList;

import static cards.Card.mapper;

public class Statistics extends Actions {
    public Statistics(final ActionsInput actionsInput) {
        super(actionsInput);
    }

    /**
     *
     * @param action
     * @param outputFinal
     * @param games
     */
    public static void getTotalGamesPlayed(final Actions action, final ArrayNode outputFinal,
                                           final ArrayList<Game> games) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("output", Server.getInstance().getGamePlayed());
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     * @param games
     */
    public static void getPlayerOneWins(final Actions action, final ArrayNode outputFinal,
                                        final ArrayList<Game> games) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("output", Table.getPlayTable().getPlayerOneWins());
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     * @param games
     */
    public static void getPlayerTwoWins(final Actions action, final ArrayNode outputFinal,
                                        final ArrayList<Game> games) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("output", Server.getInstance().getGamePlayed() -
                   Table.getPlayTable().getPlayerOneWins());
        outputFinal.add(output);
    }
}
