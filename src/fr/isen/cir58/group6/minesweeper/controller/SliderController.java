/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller;

import fr.isen.cir58.group6.minesweeper.MainController;
import fr.isen.cir58.group6.minesweeper.model.GameSettings;

/**
 * Singleton
 *
 * @author Thomas Fossati / Guillaume Catto
 */
public class SliderController extends Controller {

    private MainController mainController;
    public static int minRowsCols = 9;
    public static int maxRows = 24;
    public static int maxCols = 30;
    public static int minMines = 10;
    public static int maxMines = 999;

    private SliderController() {
    }

    public static SliderController getInstance() {
        return SliderControllerHolder.INSTANCE;
    }

    private static class SliderControllerHolder {

        private static final SliderController INSTANCE = new SliderController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

    }

    /**
     * Sets the value of the slider/textfield if the values exceed the min or
     * max value from rows, columns or mines slider throws an excepion
     */
    public void setValue(GameSettings gameSetting, String s) {

        int value = Integer.parseInt(s);

        try {
            switch (gameSetting) {
                case Rows:
                    if (value < minRowsCols || value > maxRows) {
                        throw new NumberFormatException();
                    }
                    this.mainController.getSlider().setCurrentRowsVal(value);
                    break;
                case Columns:
                    if (value < minRowsCols || value > maxCols) {
                        throw new NumberFormatException();
                    }
                    this.mainController.getSlider().setCurrentColsVal(value);
                    break;
                case Mines:
                    if (value < minMines || value > maxMines) {
                        throw new NumberFormatException();
                    }
                    this.mainController.getSlider().setCurrentMinesVal(value);
                    break;
                default:
                    throw new NumberFormatException();

            }

        } catch (NumberFormatException ex) {
            throw ex;

        }

    }

    public void setCustomGameRadioButton() {
        this.mainController.getGameModel().setCustomGameRadioButtonSelected(true);
    }

}
