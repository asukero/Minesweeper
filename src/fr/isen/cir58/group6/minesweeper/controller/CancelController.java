/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller;

import fr.isen.cir58.group6.minesweeper.MainController;

/**
 * Singleton
 * @author Thomas Fossati / Guillaume Catto
 */
public class CancelController extends Controller {

    private MainController mainController;

    private CancelController() {
    }

    public static CancelController getInstance() {
        return CancelControllerHolder.INSTANCE;
    }

    private static class CancelControllerHolder {

        private static final CancelController INSTANCE = new CancelController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

    }
    /**
     * modifiy the gamemodel to kill the program
     */
    public void killProgram() {
        this.mainController.getGameModel().setShutDown(true);
    }
    
    /**
     * modify the gamemodel to close the custom game frame
     */
    public void closeFrame() {
        this.mainController.getGameModel().setCustomGameFrameVisible(false);
    }
}
