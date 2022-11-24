package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.Coordinates;

import static cards.Card.mapper;

public class Error {
    public static void putErrorManaHero(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Not enough mana to use hero's ability.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorMana(Actions action, ArrayNode outputFinal, int cardIndex) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        String outputError = "Not enough mana to place card on table.";
        output.put("error", outputError);
        output.put("handIdx", cardIndex);
        outputFinal.add(output);
    }

    public static void putErrorEnvironement(Actions action, ArrayNode outputFinal, int cardIndex) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        String outputError = "Cannot place environment card on table.";
        output.put("error", outputError);
        output.put("handIdx", cardIndex);
        outputFinal.add(output);
    }

    public static void putErrorFullRow (Actions action, ArrayNode outputFinal, int cardIndex) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        String outputError = "Cannot place card on table since row is full.";
        output.put("error", outputError);
        output.put("handIdx", cardIndex);
        outputFinal.add(output);
    }

    public static void putErrorNotAttackingEnemy(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.set("cardAttacker", Coordinates.mapperCoordinates(action.getCardAttacker()));
        output.set("cardAttacked", Coordinates.mapperCoordinates(action.getCardAttacked()));
        String outputError = "Attacked card does not belong to the enemy.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorAlreadyAttacked(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        if (action.getCardAttacker() != null) {
            output.set("cardAttacker", Coordinates.mapperCoordinates(action.getCardAttacker()));
        }
        if (action.getCardAttacked() != null) {
            output.set("cardAttacked", Coordinates.mapperCoordinates(action.getCardAttacked()));
        }
        String outputError = "Attacker card has already attacked this turn.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorAttackerFrozen(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        if (action.getCardAttacker() != null) {
            output.set("cardAttacker", Coordinates.mapperCoordinates(action.getCardAttacker()));
        }
        if (action.getCardAttacked() != null) {
            output.set("cardAttacked", Coordinates.mapperCoordinates(action.getCardAttacked()));
        }
        String outputError = "Attacker card is frozen.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorAttackedNotTank(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        if (action.getCardAttacker() != null) {
            output.set("cardAttacker", Coordinates.mapperCoordinates(action.getCardAttacker()));
        }
        if (action.getCardAttacked() != null) {
            output.set("cardAttacked", Coordinates.mapperCoordinates(action.getCardAttacked()));
        }
        String outputError = "Attacked card is not of type 'Tank'.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorAllyCard(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.set("cardAttacker", Coordinates.mapperCoordinates(action.getCardAttacker()));
        output.set("cardAttacked", Coordinates.mapperCoordinates(action.getCardAttacked()));
        String outputError = "Attacked card does not belong to the current player.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorHeroAlreadyAttacked(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Hero has already attacked this turn.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorHeroNotAttackingEnemy(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Selected row does not belong to the enemy.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    public static void putErrorHeroNotAttackingAlly(Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Selected row does not belong to the current player.";
        output.put("error", outputError);
        outputFinal.add(output);
    }
}
