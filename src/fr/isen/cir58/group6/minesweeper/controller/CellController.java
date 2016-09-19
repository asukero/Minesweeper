/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller;

import fr.isen.cir58.group6.minesweeper.MainController;
import fr.isen.cir58.group6.minesweeper.model.Square;
import fr.isen.cir58.group6.minesweeper.model.Status;
import fr.isen.cir58.group6.minesweeper.model.TimerModel;

/**
 * Singleton
 *
 * @author thomas
 */
public class CellController extends Controller {

    private MainController mainController;

    private CellController() {
    }

    public static CellController getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final CellController INSTANCE = new CellController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

    }

    /**
     * calls the tagSquare() method from Square model depending of the coords
     * given and the status of the square
     */
    public void rightClick(int x, int y) {
        initTimer();
        switch (this.mainController.getGrid().getGrid().get(y).get(x).getStatus()) {
            case MINE_TAG:
                this.mainController.getGrid().tagSquare(x, y, Status.UNKNOWN_TAG);
                break;
            case UNKNOWN_TAG:
                this.mainController.getGrid().deleteTag(x, y);
                break;
            default:
                this.mainController.getGrid().tagSquare(x, y, Status.MINE_TAG);
                break;
        }
    }

    /**
     * calls revealSquare() from square model depending of the coords
     */
    public void leftClik(int x, int y) {
        initTimer();

        this.mainController.getGrid().revealSquare(x, y);

    }
    /**
     * called by leftClick(), starts the timer at the first move
     */
    public void initTimer() {
        if (this.mainController.getGrid().getIsFirstMove()) {
            this.mainController.getTimer().startTimer();
        }
    }

}
