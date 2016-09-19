/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller;

import fr.isen.cir58.group6.minesweeper.MainController;

/**
 * Singleton
 *
 * @author Thomas Fossati / Guillaume Catto
 */
public class EndGameController {

    private MainController mainController;

    private EndGameController() {
    }

    public static EndGameController getInstance() {
        return EndGameControllerHolder.INSTANCE;
    }

    private static class EndGameControllerHolder {

        private static final EndGameController INSTANCE = new EndGameController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    /**
     * starts a new game with the same x,y and mines nb as the previous game and sets the boolean to close/hide the frames 
     */
    public void restartGame() {
        this.mainController.getGameModel().setCurrentGameFrameClosed(true);
        this.mainController.getGameModel().setScoresFrameClosed(true);
        this.mainController.startGame(this.mainController.getGrid().getSizeX(), this.mainController.getGrid().getSizeY(), this.mainController.getGrid().getMinesNumber(), false, this.mainController.getGrid().getLevel());
        this.mainController.getGameModel().setCustomGameFrameVisible(false);
    }
}
