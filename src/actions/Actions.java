package actions;

import fileio.ActionsInput;
import fileio.Coordinates;

public class Actions {
    private String command;
    private int handIdx;
    private Coordinates cardAttacker;
    private Coordinates cardAttacked;
    private int affectedRow;
    private int playerIdx;
    private int x;
    private int y;

    /**
     * @param actionsInput
     */
    public Actions(final ActionsInput actionsInput) {
        this.command = actionsInput.getCommand();
        this.handIdx = actionsInput.getHandIdx();
        this.cardAttacker = actionsInput.getCardAttacker();
        this.cardAttacked = actionsInput.getCardAttacked();
        this.affectedRow = actionsInput.getAffectedRow();
        this.playerIdx = actionsInput.getPlayerIdx();
        this.x = actionsInput.getX();
        this.y = actionsInput.getY();
    }

    /**
     *
     * @return
     */
    public String getCommand() {
        return command;
    }

    /**
     *
     * @param command
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     *
     * @return
     */
    public int getHandIdx() {
        return handIdx;
    }

    /**
     *
     * @param handIdx
     */
    public void setHandIdx(final int handIdx) {
        this.handIdx = handIdx;
    }

    /**
     *
     * @return
     */
    public Coordinates getCardAttacker() {
        return cardAttacker;
    }

    /**
     *
     * @param cardAttacker
     */
    public void setCardAttacker(final Coordinates cardAttacker) {
        this.cardAttacker = cardAttacker;
    }

    /**
     *
     * @return
     */
    public Coordinates getCardAttacked() {
        return cardAttacked;
    }

    /**
     *
     * @param cardAttacked
     */
    public void setCardAttacked(final Coordinates cardAttacked) {
        this.cardAttacked = cardAttacked;
    }

    /**
     *
     * @return
     */
    public int getAffectedRow() {
        return affectedRow;
    }

    /**
     *
     * @param affectedRow
     */
    public void setAffectedRow(final int affectedRow) {
        this.affectedRow = affectedRow;
    }

    /**
     *
     * @return
     */
    public int getPlayerIdx() {
        return playerIdx;
    }

    /**
     *
     * @param playerIdx
     */
    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

}
