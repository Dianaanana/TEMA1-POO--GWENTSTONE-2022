package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.Coordinates;

import static cards.Card.getMapper;

public final class Error {
    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorManaHero(final Actions action, final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Not enough mana to use hero's ability.";
        output.put("error", outputError);
        outputFinal.add(output);
    }


    /**
     *
     * @param action
     * @param outputFinal
     * @param cardIndex
     */
    public static void putErrorMana(final Actions action, final ArrayNode outputFinal,
                                    final int cardIndex) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        String outputError = "Not enough mana to place card on table.";
        output.put("error", outputError);
        output.put("handIdx", cardIndex);
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     * @param cardIndex
     */
    public static void putErrorEnvironement(final Actions action, final ArrayNode outputFinal,
                                            final int cardIndex) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        String outputError = "Cannot place environment card on table.";
        output.put("error", outputError);
        output.put("handIdx", cardIndex);
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     * @param cardIndex
     */
    public static void putErrorFullRow(final Actions action, final ArrayNode outputFinal,
                                       final int cardIndex) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        String outputError = "Cannot place card on table since row is full.";
        output.put("error", outputError);
        output.put("handIdx", cardIndex);
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorNotAttackingEnemy(final Actions action,
                                                 final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        output.set("cardAttacker", Coordinates.mapperCoordinates(action.getCardAttacker()));
        output.set("cardAttacked", Coordinates.mapperCoordinates(action.getCardAttacked()));
        String outputError = "Attacked card does not belong to the enemy.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorAlreadyAttacked(final Actions action, final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
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

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorAttackerFrozen(final Actions action, final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
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

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorAttackedNotTank(final Actions action, final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
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

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorAllyCard(final Actions action, final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        output.set("cardAttacker", Coordinates.mapperCoordinates(action.getCardAttacker()));
        output.set("cardAttacked", Coordinates.mapperCoordinates(action.getCardAttacked()));
        String outputError = "Attacked card does not belong to the current player.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorHeroAlreadyAttacked(final Actions action,
                                                   final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Hero has already attacked this turn.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorHeroNotAttackingEnemy(final Actions action,
                                                     final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Selected row does not belong to the enemy.";
        output.put("error", outputError);
        outputFinal.add(output);
    }

    /**
     *
     * @param action
     * @param outputFinal
     */
    public static void putErrorHeroNotAttackingAlly(final Actions action,
                                                    final ArrayNode outputFinal) {
        ObjectNode output = getMapper().createObjectNode();
        output.put("command", action.getCommand());
        output.put("affectedRow", action.getAffectedRow());
        String outputError = "Selected row does not belong to the current player.";
        output.put("error", outputError);
        outputFinal.add(output);
    }
}
