package play;

import actions.Actions;
import actions.Attacks;
import actions.Debug;
import actions.Statistics;
import cards.Card;
import cards.Hero;
import cards.Minion;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import decks.Decks;
import format.Format;
import game.Game;
import game.StartGame;
import main.Main;
import table.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static server.Server.*;

public class Play {

    // method playGame starts a new game initiating player's one deck, player's
    // two deck,player's one hand, player's two hand, the table and an array
    // counting the cards on every row

    /**
     *
     * @param gameNr
     * @param outputFinal
     */
    public static void playGame(int gameNr, ArrayNode outputFinal) {
        ArrayList<Card> chosenDeckOne = Format.copyDeckOne(playerOneDecks,
                                                           games,gameNr);
        ArrayList<Card> chosenDeckTwo = Format.copyDeckTwo(playerTwoDecks,
                                                           games, gameNr);
        ArrayList<Card> handOne=  new ArrayList<>();
        ArrayList<Card> handTwo=  new ArrayList<>();
        ArrayList<Integer> countCardsOnRows = new ArrayList<>();

        // initialize the ArrayList with 0
        for(int i = 0; i < 4; i++)
            countCardsOnRows.add(0);

        StartGame startGame = games.get(gameNr).getStartGame();
        Table playTable = new Table(0, 0, chosenDeckOne,chosenDeckTwo,handOne, handTwo,
                         0, startGame.getStartingPlayer(), startGame.getPlayerOneHero(),
                                    startGame.getPlayerTwoHero(), countCardsOnRows);
        Table.setPlayTable(playTable);

        // dau carti in mana
        // if turnCounter is divisible with 2 it means that a whole round ended.
        if(Table.getPlayTable().getTurnCounter() % 2 == 0) {
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
        for(Actions action : games.get(gameNr).getActions()) {
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
                    Debug.getPlayerTurn(action, outputFinal, games.get(gameNr).getStartGame());
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
                    Statistics.getTotalGamesPlayed(action, outputFinal, games);
                    break;
                case ("getPlayerOneWins"):
                    Statistics.getPlayerOneWins(action,outputFinal,games);
                    break;
                case ("getPlayerTwoWins"):
                    Statistics.getPlayerTwoWins(action,outputFinal,games);
                    break;
                case ("endPlayerTurn"):
                    Attacks.endTurn(action, outputFinal, games.get(gameNr).getStartGame());
                    break;
                case ("placeCard"):
                    Attacks.placeCard(action, outputFinal, games.get(gameNr).getStartGame());
                    break;
                case ("cardUsesAttack"):
                    Attacks.cardUsesAttack(action, outputFinal, games.get(gameNr).getStartGame());
                    break;
                case ("cardUsesAbility"):
                    Attacks.cardUsesAbility(action, outputFinal, games.get(gameNr).getStartGame());
                    break;
                case ("useAttackHero"):
                    Attacks.useAttackHero(action, outputFinal, games.get(gameNr).getStartGame());
                    break;
                case ("useHeroAbility"):
                    Attacks.useHeroAbility(action, outputFinal, games.get(gameNr).getStartGame());
                    break;
                case ("useEnvironmentCard"):
                    Attacks.useEnvironmentCard(action, outputFinal,
                                              games.get(gameNr).getStartGame());
                    break;
            }
        }
    }
}
