/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller;

import fr.isen.cir58.group6.minesweeper.MainController;
import fr.isen.cir58.group6.minesweeper.model.GameLevel;

/**
 * Singleton
 * @author Thomas Fossati / Guillaume Catto
 */
public class NewGameMenuController extends Controller {

    private MainController mainController;

    private NewGameMenuController() {
    }

    public static NewGameMenuController getInstance() {
        return NewGameControllerHolder.INSTANCE;
    }

    private static class NewGameControllerHolder {

        private static final NewGameMenuController INSTANCE = new NewGameMenuController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initNewGame(GameLevel level) {

        switch (level) {
            case Beginner:
                this.mainController.getGameModel().setCurrentGameFrameClosed(true);
                this.mainController.startGame(9, 9, 20, false,level);
                break;
            case Intermediate:
                this.mainController.getGameModel().setCurrentGameFrameClosed(true);
                this.mainController.startGame(16, 16, 40, false, level);
                break;
            case Expert:
                this.mainController.getGameModel().setCurrentGameFrameClosed(true);
                this.mainController.startGame(16, 30, 99, false, level);
                break;
            case Custom:
                break;
            default:
                break;

        }

    }

    public void launchNewGameFrame() {
        this.mainController.getGameModel().setCurrentGameFrameClosed(true);
        this.mainController.getGameModel().addObserver(this.mainController.initNewGameFrame());
    }
}
