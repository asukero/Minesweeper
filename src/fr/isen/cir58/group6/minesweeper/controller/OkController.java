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
public class OkController extends Controller {

    private MainController mainController;

    private OkController() {
    }

    public static OkController getInstance() {
        return OkControllerHolder.INSTANCE;
    }

    private static class OkControllerHolder {

        private static final OkController INSTANCE = new OkController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

    }

    public void initNewCustomGame(boolean isFromCustomGameFrame, int rows, int columns, int mines) {

        if (isFromCustomGameFrame) {
            this.mainController.getGameModel().setCurrentGameFrameClosed(true);
        }
        this.mainController.startGame(rows, columns, mines, false, GameLevel.Custom);
        this.mainController.getGameModel().setNewGameFrameClosed(true);
        this.mainController.getGameModel().setCustomGameFrameVisible(false);
    }

    public void initNonCustomGame(GameLevel level) {
        switch (level) {
            case Beginner:

                this.mainController.startGame(9, 9, 20, false, level);
                break;
            case Intermediate:
                this.mainController.startGame(16, 16, 40, false, level);
                break;
            case Expert:
                this.mainController.startGame(16, 30, 99, false, level);
                break;
            case Custom:
                break;
            default:
                break;

        }
        this.mainController.getGameModel().setNewGameFrameClosed(true);
    }
}
