package play;

import actions.Actions;
import actions.Attacks;
import actions.Debug;
import actions.Statistics;
import cards.Card;
import com.fasterxml.jackson.databind.node.ArrayNode;
import format.Format;
import game.StartGame;
import table.Table;

import java.util.ArrayList;

import static helpme.MagicNumber.MAX_ROW;
import static server.Server.*;

public final class Play {

    // method playGame starts a new game initiating player's one deck, player's
    // two deck,player's one hand, player's two hand, the table and an array
    // counting the cards on every row

    /**
     * @param gameNr
     * @param outputFinal
     */
    public static void playGame(final int gameNr, final ArrayNode outputFinal) {
        ArrayList<Card> chosenDeckOne = Format.copyDeckOne(getPlayerOneDecks(),
                getGames(), gameNr);
        ArrayList<Card> chosenDeckTwo = Format.copyDeckTwo(getPlayerTwoDecks(),
                getGames(), gameNr);
        ArrayList<Card> handOne = new ArrayList<>();
        ArrayList<Card> handTwo = new ArrayList<>();
        ArrayList<Integer> countCardsOnRows = new ArrayList<>();

        // initialize the ArrayList with 0
        for (int i = 0; i < MAX_ROW; i++) {
            countCardsOnRows.add(0);
        }

        StartGame startGame = getGames().get(gameNr).getStartGame();
        Table playTable = new Table(0, 0, chosenDeckOne, chosenDeckTwo, handOne, handTwo,
                0, startGame.getStartingPlayer(), startGame.getPlayerOneHero(),
                startGame.getPlayerTwoHero(), countCardsOnRows);
        Table.setPlayTable(playTable);

        // dau carti in mana
        // if turnCounter is divisible with 2 it means that a whole round ended.
        if (Table.getPlayTable().getTurnCounter() % 2 == 0) {
            // todo if exista carte
            Card cardAddInHandOne = Table.getPlayTable().getChosenDeckOne().get(0);
            Table.getPlayTable().getHandPlayerOne().add(cardAddInHandOne);
            //Table.getPlayTable().setHandPlayerOne(Table.getPlayTable().getHandPlayerOne());
            Table.getPlayTable().getChosenDeckOne().remove(0);
            Table.getPlayTable().setManaPlayerOne(1);

            Card cardAddInHandTwo = Table.getPlayTable().getChosenDeckTwo().get(0);
            Table.getPlayTable().getHandPlayerTwo().add(cardAddInHandTwo);
            //Table.getPlayTable().setHandPlayerOne(Table.getPlayTable().getHandPlayerTwo());
            Table.getPlayTable().getChosenDeckTwo().remove(0);
            Table.getPlayTable().setManaPlayerTwo(1);

        }

        // executing all commands
        for (Actions action : getGames().get(gameNr).getActions()) {
            switch (action.getCommand()) {
                case ("getCardsInHand"):
                    Debug.getCardsInHand(action, outputFinal);
                    break;
                case ("getPlayerDeck"):
                    Debug.getPlayerDeck(action, outputFinal);
                    break;
                case ("getCardsOnTable"):
                    Debug.getCardsOnTable(action, outputFinal);
                    break;
                case ("getPlayerTurn"):
                    Debug.getPlayerTurn(action, outputFinal, getGames().get(gameNr).getStartGame());
                    break;
                case ("getPlayerHero"):
                    Debug.getPlayerHero(action, outputFinal);
                    break;
                case ("getCardAtPosition"):
                    Debug.getCardAtPosition(action, outputFinal);
                    break;
                case ("getPlayerMana"):
                    Debug.getPlayerMana(action, outputFinal);
                    break;
                case ("getEnvironmentCardsInHand"):
                    Debug.getEnvironmentCardsInHand(action, outputFinal);
                    break;
                case ("getFrozenCardsOnTable"):
                    Debug.getFrozenCardsOnTable(action, outputFinal);
                    break;
                case ("getTotalGamesPlayed"):
                    Statistics.getTotalGamesPlayed(action, outputFinal, getGames());
                    break;
                case ("getPlayerOneWins"):
                    Statistics.getPlayerOneWins(action, outputFinal, getGames());
                    break;
                case ("getPlayerTwoWins"):
                    Statistics.getPlayerTwoWins(action, outputFinal, getGames());
                    break;
                case ("endPlayerTurn"):
                    Attacks.endTurn(action, outputFinal, getGames().get(gameNr).getStartGame());
                    break;
                case ("placeCard"):
                    Attacks.placeCard(action, outputFinal, getGames().get(gameNr).getStartGame());
                    break;
                case ("cardUsesAttack"):
                    Attacks.cardUsesAttack(action, outputFinal, getGames().get(gameNr).getStartGame());
                    break;
                case ("cardUsesAbility"):
                    Attacks.cardUsesAbility(action, outputFinal, getGames().get(gameNr).getStartGame());
                    break;
                case ("useAttackHero"):
                    Attacks.useAttackHero(action, outputFinal, getGames().get(gameNr).getStartGame());
                    break;
                case ("useHeroAbility"):
                    Attacks.useHeroAbility(action, outputFinal, getGames().get(gameNr).getStartGame());
                    break;
                case ("useEnvironmentCard"):
                    Attacks.useEnvironmentCard(action, outputFinal,
                            getGames().get(gameNr).getStartGame());
                    break;
                default:
                    break;
            }
        }
    }
}
