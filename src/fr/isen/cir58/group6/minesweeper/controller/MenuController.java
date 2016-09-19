/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller;

import fr.isen.cir58.group6.minesweeper.MainController;

/**
 * Singleton
 * @author thomas
 */
public class MenuController extends Controller {

    private MainController mainController;

    public MenuController() {

    }

    public static MenuController getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final MenuController INSTANCE = new MenuController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

    }

    public void displayCustomGameFrame() {
        this.mainController.getGameModel().setCustomGameFrameVisible(true);
    }

    public void displayScoresFrame() {
        this.mainController.getGameModel().setScoresFrameVisible(true);
    }

}
