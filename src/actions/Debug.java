package actions;

import cards.Card;
import cards.Environement;
import cards.Hero;
import cards.Minion;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import decks.Decks;
import fileio.ActionsInput;
import format.Format;
import game.StartGame;
import helpme.Helpme;
import table.Table;

import java.util.ArrayList;

import static cards.Card.mapper;

public class Debug extends Actions{
    public Debug(ActionsInput actionsInput) {
        super(actionsInput);
    }


        public static void getCardsInHandPlayerOne (Actions action, ArrayNode outputFinal, ObjectNode output, ArrayNode hand) {
        if(Table.getPlayTable().getHandPlayerOne() == null) {
            ArrayList<Card> handOne = new ArrayList<>();
            Table.getPlayTable().setHandPlayerOne(handOne);
        } else {

            for(int i = 0; i < Table.getPlayTable().getHandPlayerOne().size(); i++) {
                int check = Format.checkCard(Table.getPlayTable().getHandPlayerOne().get(i));

                if(check == 1) {
                    ObjectNode minionInHand = mapper.createObjectNode();
                    minionInHand = Environement.cardMapperMinion(Table.getPlayTable().getHandPlayerOne().get(i));
                    hand.add(minionInHand);
                } else {
                    ObjectNode minionInHand = mapper.createObjectNode();
                    minionInHand = Environement.cardMapperEnvironement(Table.getPlayTable().getHandPlayerOne().get(i));
                    hand.add(minionInHand);
                }
            }
        }
        output.set("output", hand);
    }


    // TODO modularizare
    public static void getCardsInHand (Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("playerIdx", action.getPlayerIdx());

        ArrayNode hand = mapper.createArrayNode();
        if(action.getPlayerIdx() == 1) {
            getCardsInHandPlayerOne(action,outputFinal,output,hand);
        } else {
            if(Table.getPlayTable().getHandPlayerTwo() == null) {
                ArrayList<Card> handTwo = new ArrayList<>();
                Table.getPlayTable().setHandPlayerTwo(handTwo);
            } else {
                // TODO NU DECKMAPPERCURSED
                for(int i = 0; i < Table.getPlayTable().getHandPlayerTwo().size(); i++) {
                    int check = Format.checkCard(Table.getPlayTable().getHandPlayerTwo().get(i));
                    if(check == 1) {
                        ObjectNode minionInHand = mapper.createObjectNode();
                        minionInHand = Minion.cardMapperMinion(Table.getPlayTable().getHandPlayerTwo().get(i));
                        hand.add(minionInHand);
                    } else {
                        ObjectNode minionInHand = mapper.createObjectNode();
                        minionInHand = Card.cardMapperEnvironement(Table.getPlayTable().getHandPlayerTwo().get(i));
                        hand.add(minionInHand);
                    }
                }            }
            output.set("output", hand);
        }
        outputFinal.add(output);
    }

    // TODO Done
    public static void getPlayerDeck (Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("playerIdx", action.getPlayerIdx());

        ArrayNode deckOut = mapper.createArrayNode();
        if(action.getPlayerIdx() == 1) {
            if(Table.getPlayTable().getChosenDeckOne() == null) {
                ArrayList<Card> deckOne = new ArrayList<>();
                Table.getPlayTable().setChosenDeckOne(deckOne);
            } else {
                for(int i = 0; i < Table.getPlayTable().getChosenDeckOne().size(); i ++) {
                    int check = Format.checkCard(Table.getPlayTable().getChosenDeckOne().get(i));
                    if(check == 1) {
//                        System.out.println("este check = 1");
                        ObjectNode cardInDeck = mapper.createObjectNode();
                        cardInDeck = Minion.cardMapperMinion(Table.getPlayTable().getChosenDeckOne().get(i));
                        deckOut.add(cardInDeck);
                    } else {
                        ObjectNode cardInDeck = mapper.createObjectNode();
                        cardInDeck = Environement.cardMapperEnvironement(Table.getPlayTable().getChosenDeckOne().get(i));
                        deckOut.add(cardInDeck);
                    }
                }
            }
            output.set("output", deckOut);
        } else {
            if(Table.getPlayTable().getChosenDeckTwo() == null) {
                ArrayList<Card> deckTwo = new ArrayList<>();
                Table.getPlayTable().setChosenDeckTwo(deckTwo);
            } else {
                for(int i = 0; i < Table.getPlayTable().getChosenDeckTwo().size(); i ++) {
                    int check = Format.checkCard(Table.getPlayTable().getChosenDeckTwo().get(i));
                    if(check == 1) {
                        ObjectNode cardInDeck = mapper.createObjectNode();
                        cardInDeck = Minion.cardMapperMinion(Table.getPlayTable().getChosenDeckTwo().get(i));
                        deckOut.add(cardInDeck);
                    } else {
                        ObjectNode cardInDeck = mapper.createObjectNode();
                        cardInDeck = Environement.cardMapperEnvironement(Table.getPlayTable().getChosenDeckTwo().get(i));
                        deckOut.add(cardInDeck);
                    }
                }
            }
            output.set("output", deckOut);
        }
        outputFinal.add(output);
    }

    // TODO Done
    public static void getCardsOnTable (Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());

        ArrayNode table = mapper.createArrayNode();
        if(Table.getPlayTable().getTable() == null) {
            Card[][] tableEmpty = new Card[4][5];
            Table.getPlayTable().setTable(tableEmpty);
        } else {
//            table = Decks.decksMapper(Table.getPlayTable().getTable());
            ArrayNode cardsOnTable = mapper.createArrayNode();
            for(int i = 0; i < 4; i ++) {
                ArrayNode cardsOnRow = mapper.createArrayNode();
                for(int j = 0; j < 5; j++) {
                    if (Table.getPlayTable().getTable()[i][j] == null) {
                        continue;
                    } else {
                        ObjectNode cardOnTable = Minion.cardMapperMinion(Table.getPlayTable().getTable()[i][j]);
                        cardsOnRow.add(cardOnTable);
                    }
                }
                cardsOnTable.add(cardsOnRow);
            }
            output.set("output", cardsOnTable);
        }
        outputFinal.add(output);
    }

    // TODO Done
    public static void getPlayerTurn (Actions action, ArrayNode outputFinal, StartGame startGame) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());

        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();
        if(turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            output.put("output", 1);
        } else {
            output.put("output", 2);
        }

        outputFinal.add(output);
    }

    // TODO DONE
    public static void getPlayerHero (Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("playerIdx", action.getPlayerIdx());

        ObjectNode hero = mapper.createObjectNode();
        if(action.getPlayerIdx() == 1) {
            hero = Hero.cardMapper(Table.getPlayTable().getHeroPlayerOne());
        } else {
            hero = Hero.cardMapper(Table.getPlayTable().getHeroPlayerTwo());
        }
        output.set("output", hero);

        outputFinal.add(output);

    }

    // TODO
    public static void getCardAtPosition (Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("x", action.getX());
        output.put("y", action.getY());

        Card card = Table.getPlayTable().getTable()[action.getX()][action.getY()];
        if (card == null) {
            String outputError = "No card available at that position.";
            output.put("output", outputError);
            outputFinal.add(output);
            return;
        }

        ObjectNode cardAt = Environement.cardMapperMinion(card);
        output.set("output", cardAt);
        outputFinal.add(output);
    }

    // TODO
    public static void getPlayerMana (Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("playerIdx", action.getPlayerIdx());
        if(action.getPlayerIdx() == 1) {
            output.put("output", Table.getPlayTable().getManaPlayerOne());
        } else {
            output.put("output", Table.getPlayTable().getManaPlayerTwo());
        }
        outputFinal.add(output);
    }

    // TODO
    public static void getEnvironmentCardsInHand (Actions action, ArrayNode outputFinal) {
        int playerIdx = action.getPlayerIdx();

        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());
        output.put("playerIdx", playerIdx);

        ArrayList<Card> hand;
        if (playerIdx == 1) {
            hand = Table.getPlayTable().getHandPlayerOne();
        } else {
            hand = Table.getPlayTable().getHandPlayerTwo();
        }

        ArrayNode cardsNode = mapper.createArrayNode();
        for (int i = 0; i < hand.size(); i++) {
            int check = Format.checkCardRow(hand.get(i));
            if (check != 3)
                continue;

            ObjectNode cardInDeck = Environement.cardMapperEnvironement(hand.get(i));
            cardsNode.add(cardInDeck);
        }

        output.set("output", cardsNode);
        outputFinal.add(output);
    }
    // TODO
    public static void getFrozenCardsOnTable (Actions action, ArrayNode outputFinal) {
        ObjectNode output = mapper.createObjectNode();
        output.put("command", action.getCommand());

        if(Table.getPlayTable().getTable() == null) {
            Card[][] tableEmpty = new Card[4][5];
            Table.getPlayTable().setTable(tableEmpty);
        } else {
            ArrayNode cardsOnTable = mapper.createArrayNode();
            for(int i = 0; i < 4; i ++) {
                for(int j = 0; j < 5; j++) {
                    if (Table.getPlayTable().getTable()[i][j] == null) {
                        continue;
                    }

                    if (!(Table.getPlayTable().getTable()[i][j] instanceof Minion)) {
                        continue;
                    }

                    Minion minion = (Minion) (Table.getPlayTable().getTable()[i][j]);
                    if (minion.getFrozen() == 0) {
                        continue;
                    }

                    ObjectNode cardOnTable = Minion.cardMapperMinion(Table.getPlayTable().getTable()[i][j]);
                    cardsOnTable.add(cardOnTable);
                }
            }
            output.set("output", cardsOnTable);
        }
        outputFinal.add(output);
    }
}
