package actions;

import cards.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.Coordinates;
import format.Format;
import game.StartGame;
import table.Table;
import static cards.Card.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Attacks extends Actions{
    public Attacks(ActionsInput actionsInput) {
        super(actionsInput);
    }

    /**
     *
     * @param action
     * @param outputFinal
     * @param startGame
     */
    public static void playerOnePlaceCard (Actions action, ArrayNode outputFinal, StartGame startGame) {
        int cardIndex = action.getHandIdx();
        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();

        ArrayList<Card> deckOne = Table.getPlayTable().getHandPlayerOne();

        if(deckOne.size() > cardIndex) {
            int check = Format.checkCardRow(deckOne.get(cardIndex));
//            1 -- front row || 2 -- back row || 3 -- environement
            if (check == 3) {
                Error.putErrorEnvironement(action, outputFinal, cardIndex);
            } else {
                // check mana
                if (deckOne.get(cardIndex).getMana() > Table.getPlayTable().getManaPlayerOne()) {
                    Error.putErrorMana(action, outputFinal, cardIndex);
                    return;
                }
                // get row
                int row;
                if(check == 2) {
                    row = 3;
                } else {
                    row  = 2;
                }
                // check row full
                if (Table.getPlayTable().getTable()[row][4] != null) {
                    Error.putErrorFullRow(action,outputFinal,cardIndex);
                    return;
                }

                Card cardToBePut = deckOne.get(cardIndex);
                deckOne.remove(cardIndex);
                Table.getPlayTable().setManaPlayerOne(Table.getPlayTable().getManaPlayerOne() - cardToBePut.getMana());
                ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
                int position = vector.get(row);
                Table.getPlayTable().getTable()[row][position] = cardToBePut;
                // todo sa incrementez pe row in vectorul care retine pozitia
//                ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
                int pos = vector.get(row) + 1;
                // TODO sa verific daca e bn???
                vector.set(row, pos);
            }
        }
    }

    public static void playerTwoPlaceCard (Actions action, ArrayNode outputFinal, StartGame startGame) {
        int cardIndex = action.getHandIdx();
        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();

        ArrayList<Card> deckTwo = Table.getPlayTable().getHandPlayerTwo();

        if(deckTwo.size() > cardIndex) {
            int check = Format.checkCardRow(deckTwo.get(cardIndex));
            // daca e unu cartea se pune pe first row, daca e 2 se pune in spate daca e 3 se printeaza eroare
            if(check == 3) {
                Error.putErrorEnvironement(action, outputFinal, cardIndex);

//            } else {
//                // check mana
//                if(deckTwo.get(cardIndex).getMana() > Table.getPlayTable().getManaPlayerTwo()) {
//                    Error.putErrorMana(action, outputFinal, cardIndex);
//                    return;
//                }
//                // get row
//                int row;
//                if(check == 2) {
//                    row = 0;
//                } else {
//                    row = 1;
//                }
//                // check row full
//                if (Table.getPlayTable().getTable()[row][4] != null) {
//                    Error.putErrorFullRow(action,outputFinal,cardIndex);
//                    return;
//                }
//
//                Card cardToBePut = deckTwo.get(cardIndex);
//                deckTwo.remove(cardIndex);
//                Table.getPlayTable().setManaPlayerOne(Table.getPlayTable().getManaPlayerOne() - cardToBePut.getMana());
//                ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
//                int position = vector.get(row);
//                Table.getPlayTable().getTable()[row][position] = cardToBePut;
//                // todo sa incrementez pe row in vectorul care retine pozitia
////                ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
//                int pos = vector.get(row) + 1;
//                // TODO sa verific daca e bn???
//                vector.set(row, pos);
//            }
            } else if (check == 2) {            // row 0
                // check mana
                if(deckTwo.get(cardIndex).getMana() > Table.getPlayTable().getManaPlayerTwo()) {
                    Error.putErrorMana(action,outputFinal,cardIndex);
                    return;
                }

                // check row full
                if (Table.getPlayTable().getTable()[0][4] != null) {
                    Error.putErrorFullRow(action,outputFinal,cardIndex);
                    return;
                }

                Card cardToBePut = deckTwo.get(cardIndex);
                deckTwo.remove(cardIndex);
                Table.getPlayTable().setManaPlayerTwo(Table.getPlayTable().getManaPlayerTwo() - cardToBePut.getMana());
                ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
                int position = Table.getPlayTable().getCountCardsOnRows().get(0);
                Table.getPlayTable().getTable()[0][position] = cardToBePut;
                // todo sa incrementez pe row in vectorul care retine pozitia
                int pos = vector.get(0) + 1;
                // TODO sa verific daca e bn???
                vector.set(0, pos);

            } else {            // row 1
                // check mana
                if(deckTwo.get(cardIndex).getMana() > Table.getPlayTable().getManaPlayerTwo()) {
                    Error.putErrorMana(action,outputFinal,cardIndex);
                    return;
                }

                // check row full
                if (Table.getPlayTable().getTable()[1][4] != null) {
                    Error.putErrorFullRow(action,outputFinal,cardIndex);
                    return;
                }

                Card cardToBePut = deckTwo.get(cardIndex);
                deckTwo.remove(cardIndex);
                Table.getPlayTable().setManaPlayerTwo(Table.getPlayTable().getManaPlayerTwo() - cardToBePut.getMana());
                int position = Table.getPlayTable().getCountCardsOnRows().get(1);
                Table.getPlayTable().getTable()[1][position] = cardToBePut;
                // todo sa incrementez pe row in vectorul care retine pozitia
                ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
                int pos = vector.get(1) + 1;
                // TODO sa verific daca e bn???
                vector.set(1, pos);
            }
        }
    }

    // TODO
    public static void placeCard (Actions action, ArrayNode outputFinal, StartGame startGame) {
        int cardIndex = action.getHandIdx();
        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();

        // daca e par e randul playerului One
        if(turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            playerOnePlaceCard(action,outputFinal,startGame);
        } else {                // player 2
            playerTwoPlaceCard(action,outputFinal,startGame);
        }
    }


    public static void cardUsesAttack (Actions action, ArrayNode outputFinal, StartGame startGame) {
        Coordinates attacker = action.getCardAttacker();
        Coordinates attacked = action.getCardAttacked();

        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();
        if(turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            if (attacked.getX() != 0 && attacked.getX() != 1) {
               Error.putErrorNotAttackingEnemy(action, outputFinal);
                return;
            }
        } else {
            if (attacked.getX() != 2 && attacked.getX() != 3) {
                Error.putErrorNotAttackingEnemy(action, outputFinal);
                return;
            }
        }

        Card[][] table = Table.getPlayTable().getTable();
        Card attackerCard = table[attacker.getX()][attacker.getY()];
        if (attackerCard.getHasAttackedThisRound() == 1) {
            Error.putErrorAlreadyAttacked(action, outputFinal);
            return;
        }

        if (!(attackerCard instanceof Minion)) {
            return;
        }

        Minion attackerMinion = (Minion) attackerCard;
        if (attackerMinion.getFrozen() == 1) {
           Error.putErrorAttackerFrozen(action, outputFinal);
            return;
        }

        int startRow, endRow;
        if (turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            startRow = 0;
            endRow = 2;

        } else {
            startRow = 2;
            endRow = 4;
        }

        boolean tankExists = false;
        for (int r = startRow; r < endRow; r++) {
            for (int c = 0; c < 5; c++) {
                if (!(table[r][c] instanceof Minion)) {
                    continue;
                }

                Minion minion = (Minion) table[r][c];
                if (minion.getTank() == 1) {
                    tankExists = true;
                }
            }
        }

        Card attackedCard = table[attacked.getX()][attacked.getY()];
        if (!(attackedCard instanceof Minion)) {
            return;
        }

        Minion attackedMinion = (Minion) attackedCard;
        if (tankExists && attackedMinion.getTank() == 0) {
           Error.putErrorAttackedNotTank(action, outputFinal);
            return;
        }

        attackedMinion.setHealth(attackedMinion.getHealth() - attackerMinion.getAttackDamage());
        removeDeadCards(table[attacked.getX()], attacked.getX());
        attackerCard.setHasAttackedThisRound(1);
    }

    // TODO
    public static void endTurn (Actions action, ArrayNode outputFinal, StartGame startGame) {
        // todo cand se termina tura unui jucator cartile care sunt frozen se dezgheata

        // daca se incepe o tura noua se da o carte noua si se da mana +1 pana la 10

        if(Table.getPlayTable().getTurnCounter() % 2 == 1) {
            // dau o carte noua la fiecare + mana++
            // todo if exista carte
            if(Table.getPlayTable().getChosenDeckOne() != null && Table.getPlayTable().getChosenDeckOne().size() > 0) {
                Card cardAddInHandOne = Table.getPlayTable().getChosenDeckOne().get(0);
                Table.getPlayTable().getHandPlayerOne().add(cardAddInHandOne);
                //Table.getPlayTable().setHandPlayerOne(Table.getPlayTable().getHandPlayerOne());
                Table.getPlayTable().getChosenDeckOne().remove(0);
            }
            int manaToBeGiven = (Table.getPlayTable().getTurnCounter() + 1) / 2 + 1;
            if(manaToBeGiven > 10)
                manaToBeGiven = 10;
            Table.getPlayTable().setManaPlayerOne(Table.getPlayTable().getManaPlayerOne() + manaToBeGiven);

            if(Table.getPlayTable().getChosenDeckTwo() != null && Table.getPlayTable().getChosenDeckTwo().size() > 0) {
                Card cardAddInHandTwo = Table.getPlayTable().getChosenDeckTwo().get(0);
                Table.getPlayTable().getHandPlayerTwo().add(cardAddInHandTwo);
                //Table.getPlayTable().setHandPlayerTwo(Table.getPlayTable().getHandPlayerTwo());
                Table.getPlayTable().getChosenDeckTwo().remove(0);
            }

            Table.getPlayTable().setManaPlayerTwo(Table.getPlayTable().getManaPlayerTwo() + manaToBeGiven);
        }

        int startRow, endRow;
        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();
        if(turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            startRow = 2;
            endRow = 4;
        } else {
            startRow = 0;
            endRow = 2;
        }

        Card[][] table = Table.getPlayTable().getTable();
        for (int r = startRow; r < endRow; r++) {
            for (int c = 0; c < 5; c++) {
                if (!(table[r][c] instanceof Minion)) {
                    continue;
                }

                Minion minion = (Minion) table[r][c];
                minion.setHasAttackedThisRound(0);
                minion.setFrozen(0);
            }
        }

        Table.getPlayTable().getHeroPlayerOne().setHasAttackedThisRound(0);
        Table.getPlayTable().getHeroPlayerTwo().setHasAttackedThisRound(0);
        Table.getPlayTable().setTurnCounter(Table.getPlayTable().getTurnCounter() + 1);
    }

    // TODO
    public static void cardUsesAbility (Actions action, ArrayNode outputFinal, StartGame startGame) {
        Coordinates attacker = action.getCardAttacker();
        Coordinates attacked = action.getCardAttacked();
        int turnCounter = Table.getPlayTable().getTurnCounter();
        int startingPlayer = startGame.getStartingPlayer();

        // verific  daca cartea  atacatorului nu e frozen
        if(turnCounter % 2 == 0 && startingPlayer == 1 || turnCounter % 2 == 1 && startingPlayer == 2) {
            cardUsesAbilityHelper(action,outputFinal,startGame,Table.getPlayTable().getHandPlayerOne(),1,attacker,attacked);
        } else {
            cardUsesAbilityHelper(action,outputFinal,startGame,Table.getPlayTable().getHandPlayerTwo(),2,attacker,attacked);
        }
    }

    public static void cardUsesAbilityHelper (Actions action, ArrayNode outputFinal, StartGame startGame,ArrayList<Card> currentPlayerDeck, int playerIndex,  Coordinates attackerCoord, Coordinates attackedCoord) {
        Card[][] table = Table.getPlayTable().getTable();

        Minion attacker = (Minion) table[attackerCoord.getX()][attackerCoord.getY()];
        Minion attacked = (Minion) table[attackedCoord.getX()][attackedCoord.getY()];

        if (attacker != null && attacker.getFrozen() == 1) {
           Error.putErrorAttackerFrozen(action, outputFinal);
            return;
        }

        // TODO verific daca a folosit ability sau attack runda aia
        if (attacker != null && attacker.getHasAttackedThisRound() == 1) {
            Error.putErrorAlreadyAttacked(action, outputFinal);
            return;
        }

        // verific daca atacatorul e Disciple
        if (attacker != null && attacker.getName().equals("Disciple")) {
            if (playerIndex == 1) {
                if (attackedCoord.getX() != 2 && attackedCoord.getX() != 3) {
                   Error.putErrorAllyCard(action, outputFinal);
                    return;
                }
            } else {
                if (attackedCoord.getX() != 0 && attackedCoord.getX() != 1) {
                   Error.putErrorAllyCard(action, outputFinal);
                    return;
                }
            }
        }

        // verific daca e The Ripper, Miraj sau The Cursed One
        if (attacker != null && Objects.equals(attacker.getName(), "The Ripper")
                || attacker != null && Objects.equals(attacker.getName(), "Miraj")
                || attacker != null && Objects.equals(attacker.getName(), "The Cursed One")) {
            if(playerIndex == 1) {
                if(attackedCoord.getX() != 0 && attackedCoord.getX() != 1) {
                   Error.putErrorNotAttackingEnemy(action,outputFinal);
                    return;
                }
            } else {
                if(attackedCoord.getX() != 2 && attackedCoord.getX() != 3) {
                   Error.putErrorNotAttackingEnemy(action,outputFinal);
                    return;
                }
            }
        }

        // verific daca exista carte de tip tank (pe front row)
//        if(playerIndex == 1) {
//            for(int c = 0; c < 5; c++) {
//                if(table[2][c] == null) {
////                    continue;
//                    break;
//                }
//                Minion minion = (Minion) table[2][c];
//                System.out.println("the minion i m looking for : " + minion);
//                System.out.println("the minions tank : " + minion.getTank());
//                if(minion.getTank() == 0) {
//                    // verific daca a fost selectata pt atac
//                    if(table[2][c] != attacked) {
//                        putErrorAttackedNotTank(action,outputFinal);
//                    }
//                }
//            }
//
//        } else {
//            for(int c = 0; c < 5; c++) {
//                if(table[1][c] == null) {
////                    continue;
//                    break;
//                }
//                Minion minion=  (Minion) table[1][c];
//                if(minion.getTank() == 0) {
//                    // verific daca a fost selectata pt atac
//                    if(table[1][c] != attacked) {
//                        putErrorAttackedNotTank(action,outputFinal);
//                    }
//                }
//            }
//
//        }


        int startRow, endRow;
        if (playerIndex == 1) {
            startRow = 0;
            endRow = 2;
        } else {
            startRow = 2;
            endRow = 4;
        }

        boolean tankExists = false;
        for (int r = startRow; r < endRow; r++) {
            for (int c = 0; c < 5; c++) {
                if (!(table[r][c] instanceof Minion)) {
                    continue;
                }

                Minion minion = (Minion) table[r][c];
                if (minion.getTank() == 1) {
                    tankExists = true;
                }
            }
        }

        if (attacker != null && !attacker.getName().equals("Disciple") && tankExists && attacked.getTank() == 0) {
           Error.putErrorAttackedNotTank(action, outputFinal);
            return;
        }

        // TODO call ability
        if(attacker != null) {
            switch (attacker.getName()) {
                case "The Cursed One" :
                    TheCursedOne attackerSpecial1 = (TheCursedOne) attacker;
                    attackerSpecial1.ability(attacked);
                    removeDeadCards(table[attackedCoord.getX()], attackedCoord.getX());
                    break;
                case "Miraj":
                    Miraj attackerSpecial2 = (Miraj) attacker;
                    attackerSpecial2.ability(attacked);
                    break;
                case "The Ripper":
                    TheRipper attackerSpecial3 = (TheRipper) attacker;
                    attackerSpecial3.ability(attacked);
                    break;
                case "Disciple":
                    Disciple attackerSpecial4 = (Disciple) attacker;
                    attackerSpecial4.ability(attacked);
                    break;
            }
        }

        if (attacker != null) {
            attacker.setHasAttackedThisRound(1);
        }
    }

    public static void useAttackHero (Actions action, ArrayNode outputFinal, StartGame startGame) {
        Coordinates attacker = action.getCardAttacker();
        Card[][] table = Table.getPlayTable().getTable();
        Card attackerCard = table[attacker.getX()][attacker.getY()];
        Minion attackerMinion = (Minion) attackerCard;
        if (attackerMinion.getFrozen() == 1) {
           Error.putErrorAttackerFrozen(action, outputFinal);
            return;
        }

        if (attackerCard.getHasAttackedThisRound() == 1) {
            Error.putErrorAlreadyAttacked(action, outputFinal);
            return;
        }

        int startRow, endRow;
        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();
        Hero attackedHero;
        if (turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            startRow = 0;
            endRow = 2;
            attackedHero = Table.getPlayTable().getHeroPlayerTwo();
        } else {
            startRow = 2;
            endRow = 4;
            attackedHero = Table.getPlayTable().getHeroPlayerOne();
        }

        boolean tankExists = false;
        for (int r = startRow; r < endRow; r++) {
            for (int c = 0; c < 5; c++) {
                if (!(table[r][c] instanceof Minion)) {
                    continue;
                }

                Minion minion = (Minion) table[r][c];
                if (minion.getTank() == 1) {
                    tankExists = true;
                }
            }
        }

        if (tankExists) {
           Error.putErrorAttackedNotTank(action, outputFinal);
            return;
        }

        attackedHero.setHealth(attackedHero.getHealth() - attackerMinion.getAttackDamage());
        attackerCard.setHasAttackedThisRound(1);
        if (attackedHero.getHealth() <= 0) {
            ObjectNode output = mapper.createObjectNode();
            String outputMessage;
            if (turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
                outputMessage = "Player one killed the enemy hero.";
                // aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                Table.getPlayTable().setPlayerOneWins(Table.getPlayTable().getPlayerOneWins() + 1);
            } else {
                outputMessage = "Player two killed the enemy hero.";
                // aaaaaaaaaaaaaaaaaaaaaaaaaaaa
                Table.getPlayTable().setPlayerTwoWins(Table.getPlayTable().getPlayerTwoWins() + 1);
            }
            output.put("gameEnded", outputMessage);
            outputFinal.add(output);
        }
    }


    public static void useHeroAbility (Actions action, ArrayNode outputFinal, StartGame startGame) {
        Hero hero;
        int mana;
        int firstAllyRow, lastAllyRow, firstEnemyRow, lastEnemyRow;

        int turnCounter = Table.getPlayTable().getTurnCounter();
        int playerIndex = startGame.getStartingPlayer();
        if (turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            hero = Table.getPlayTable().getHeroPlayerOne();
            mana = Table.getPlayTable().getManaPlayerOne();
            firstAllyRow = 2;
            lastAllyRow = 3;
            firstEnemyRow = 0;
            lastEnemyRow = 2;
        } else {
            hero = Table.getPlayTable().getHeroPlayerTwo();
            mana = Table.getPlayTable().getManaPlayerTwo();
            firstAllyRow = 0;
            lastAllyRow = 2;
            firstEnemyRow = 2;
            lastEnemyRow = 3;
        }

        if(hero.getMana() > mana) {
           Error.putErrorManaHero(action, outputFinal);
            return;
        }

        if (hero.getHasAttackedThisRound() == 1) {
           Error.putErrorHeroAlreadyAttacked(action, outputFinal);
            return;
        }

        int affectedRow = action.getAffectedRow();
        Card[][] table = Table.getPlayTable().getTable();
        Card[] row = table[affectedRow];
        switch(hero.getName()) {
            case "Lord Royce":
                if (!(affectedRow >= firstEnemyRow && affectedRow <= lastEnemyRow)) {
                   Error.putErrorHeroNotAttackingEnemy(action, outputFinal);
                    return;
                }

                LordRoyce lordRoyce = (LordRoyce) hero;
                lordRoyce.ability(row);
                break;

            case "Empress Thorina":
                if (!(affectedRow >= firstEnemyRow && affectedRow <= lastEnemyRow)) {
                   Error.putErrorHeroNotAttackingEnemy(action, outputFinal);
                    return;
                }

                EmpressThorina empressThorina = (EmpressThorina) hero;
                empressThorina.ability(row, affectedRow);
                break;
            case "General Kocioraw":
                if (!(affectedRow >= firstAllyRow && affectedRow <= lastAllyRow)) {
                   Error.putErrorHeroNotAttackingAlly(action, outputFinal);
                    return;
                }

                Kocioraw generalKocioraw = (Kocioraw) hero;
                generalKocioraw.ability(row);
                break;
            case "King Mudface":
                if (!(affectedRow >= firstAllyRow && affectedRow <= lastAllyRow)) {
                   Error.putErrorHeroNotAttackingAlly(action, outputFinal);
                    return;
                }

                KingMudface kingMudface = (KingMudface) hero;
                kingMudface.ability(row);
                break;
        }

        mana -= hero.getMana();
        if (turnCounter % 2 == 0 && playerIndex == 1 || turnCounter % 2 == 1 && playerIndex == 2) {
            Table.getPlayTable().setManaPlayerOne(mana);
        } else {
            Table.getPlayTable().setManaPlayerTwo(mana);
        }
        hero.setHasAttackedThisRound(1);
    }

    public static void useEnvironmentCard (Actions action, ArrayNode outputFinal, StartGame startGame) {
        int cardIndex = action.getHandIdx();
        int affectedRow = action.getAffectedRow();
        int turnCounter = Table.getPlayTable().getTurnCounter();
        int startingPlayer = startGame.getStartingPlayer();

        if(turnCounter % 2 == 0 && startingPlayer == 1 || turnCounter % 2 == 1 && startingPlayer == 2) {
            userEnvironmentCardHelper(action, outputFinal, cardIndex, affectedRow, Table.getPlayTable().getHandPlayerOne(), 1);
        } else {
            userEnvironmentCardHelper(action, outputFinal, cardIndex, affectedRow, Table.getPlayTable().getHandPlayerTwo(), 2);
        }
    }

    public static void userEnvironmentCardHelper(Actions action, ArrayNode outputFinal, int cardIndex, int affectedRow,
                                                 ArrayList<Card> currentPlayerDeck, int playerIndex)  {
        int check = Format.checkCardRow(currentPlayerDeck.get(cardIndex));
        Card cardToBePlayed = currentPlayerDeck.get(cardIndex);
        if (check != 3) {
            ObjectNode output = mapper.createObjectNode();
            output.put("command", action.getCommand());
            output.put("handIdx", cardIndex);
            output.put("affectedRow", affectedRow);
            String outputError = "Chosen card is not of type environment.";
            output.put("error", outputError);
            outputFinal.add(output);
            return;
        } else {
            // check mana
            int mana;
            if (playerIndex == 1) {
                mana = Table.getPlayTable().getManaPlayerOne();
            } else {
                mana = Table.getPlayTable().getManaPlayerTwo();
            }

            if (currentPlayerDeck.get(cardIndex).getMana() > mana) {
                ObjectNode output = mapper.createObjectNode();
                output.put("affectedRow", affectedRow);
                output.put("command", action.getCommand());
                String outputError = "Not enough mana to use environment card.";
                output.put("error", outputError);
                output.put("handIdx", cardIndex);
                outputFinal.add(output);
                return;
            }

            if (playerIndex == 1 && affectedRow != 0 && affectedRow != 1 || playerIndex == 2 && affectedRow != 2 && affectedRow != 3) {
                ObjectNode output = mapper.createObjectNode();
                output.put("affectedRow", affectedRow);
                output.put("command", action.getCommand());
                String outputError = "Chosen row does not belong to the enemy.";
                output.put("error", outputError);
                output.put("handIdx", cardIndex);
                outputFinal.add(output);
                return;
            }

            Card[][] table = Table.getPlayTable().getTable();
            switch(cardToBePlayed.getName()) {
                case "Firestorm":
                    for (int c = 0; c < 5; c++) {
                        // TODO table[][ultimul element] != null
                        if (table[affectedRow][c] == null) {
                            continue;
                        }

                        table[affectedRow][c].setHealth(table[affectedRow][c].getHealth() - 1);
                    }
                    removeDeadCards(table[affectedRow], affectedRow);
                    break;
                case "Winterfell":
                    for (int c = 0; c < 5; c++) {
                        if (table[affectedRow][c] == null) {
                            continue;
                        }

                        if (!(table[affectedRow][c] instanceof Minion)) {
                            continue;
                        }

                        Minion minion = (Minion) table[affectedRow][c];
                        minion.setFrozen(1);
                    }
                    break;
                case "Heart Hound":
                    int reflectedRow = 3 - affectedRow;
                    if (table[reflectedRow][4] != null) {
                        ObjectNode output = mapper.createObjectNode();
                        output.put("affectedRow", affectedRow);
                        output.put("command", action.getCommand());
                        String outputError = "Cannot steal enemy card since the player's row is full.";
                        output.put("error", outputError);
                        output.put("handIdx", cardIndex);
                        outputFinal.add(output);
                        return;
                    }

                    Card maxHealthCard = table[affectedRow][0];
                    for (int c = 1; c < 4; c++) {
                        Card card = table[affectedRow][c];
                        if (card == null) {
                            continue;
                        }

                        if (card.getHealth() > maxHealthCard.getHealth()) {
                            maxHealthCard = card;
                        }
                    }

                    if (maxHealthCard == null) {
                        return;
                    }

                    ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
                    int reflectedPos = vector.get(reflectedRow);
                    table[reflectedRow][reflectedPos] = maxHealthCard;
                    vector.set(reflectedRow, reflectedPos + 1);

                    int affectedPos = vector.get(affectedRow);
                    table[affectedRow][affectedPos] = null;
                    vector.set(reflectedRow, reflectedPos - 1);
                    break;
            }

            currentPlayerDeck.remove(cardIndex);
            mana -= cardToBePlayed.getMana();
            if (playerIndex == 1) {
                Table.getPlayTable().setManaPlayerOne(mana);
            } else {
                Table.getPlayTable().setManaPlayerTwo(mana);
            }
        }
    }

    // metoda de remove dead cards
    public static void removeDeadCards(Card[] cardRow, int row) {
        if (cardRow == null) {
            return;
        }

        for (int c = 0; c < 5; c++) {
            if (cardRow[c] == null) {
                continue;
            }
            if (cardRow[c].getHealth() <= 0) {
                cardRow[c] = null;
            }
        }

        int firstNullPosition = -1;
        for (int c = 0; c < 5; c++) {
            if (cardRow[c] == null) {
                firstNullPosition = c;
                break;
            }
        }

        if (firstNullPosition == -1) {
            return;
        }

        for (int c = firstNullPosition + 1; c < 5; c++) {
            if (cardRow[c] == null) {
                continue;
            }

            cardRow[firstNullPosition] = cardRow[c];
            cardRow[c] = null;
            firstNullPosition++;
        }

        ArrayList<Integer> vector = Table.getPlayTable().getCountCardsOnRows();
        vector.set(row, firstNullPosition);
    }
}