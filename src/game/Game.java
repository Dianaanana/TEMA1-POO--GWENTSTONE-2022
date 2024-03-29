package game;

import actions.Actions;
import cards.Hero;
import fileio.ActionsInput;
import fileio.StartGameInput;
import helpme.Helpme;

import java.util.ArrayList;

public class Game {

    StartGame startGame;
    ArrayList<Actions> actions;

//    public Game(GameInput startGameInput, ArrayList<ActionsInput> actions) {
//        startGameInput.getStartGame();
//        //System.out.println(startGameInput.getStartGame());
//    }

    /**
     * @param startGameInput
     * @param actionsInputs
     */
    public Game(StartGameInput startGameInput, ArrayList<ActionsInput> actionsInputs) {
        StartGame startGameAux = new StartGame(startGameInput);
        startGameAux.setPlayerOneDeckIdx(startGameInput.getPlayerOneDeckIdx());
        startGameAux.setPlayerTwoDeckIdx(startGameInput.getPlayerTwoDeckIdx());
        startGameAux.setShuffleSeed(startGameInput.getShuffleSeed());
        startGameAux.setStartingPlayer(startGameInput.getStartingPlayer());

        Hero heroOne = Helpme.heroAssign(startGameInput.getPlayerOneHero());
        //System.out.println(heroOne.getHealth());
        startGameAux.setPlayerOneHero(heroOne);

        Hero heroTwo = Helpme.heroAssign(startGameInput.getPlayerTwoHero());
        startGameAux.setPlayerTwoHero(heroTwo);

        this.startGame = startGameAux;

        ArrayList<Actions> arrayListActions = new ArrayList<>();
        for (ActionsInput actionsInput : actionsInputs) {
            Actions actions1 = new Actions(actionsInput);
            arrayListActions.add(actions1);
        }
        this.actions = arrayListActions;

    }

    public StartGame getStartGame() {
        return startGame;
    }

    public void setStartGame(StartGame startGame) {
        this.startGame = startGame;
    }

    public ArrayList<Actions> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Actions> actions) {
        this.actions = actions;
    }
}
