/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller;

import fr.isen.cir58.group6.minesweeper.MainController;
import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import fr.isen.cir58.group6.minesweeper.model.Scores;
import java.util.ArrayList;

/**
 * Singleton
 *
 * @author Thomas Fossati / Guillaume Catto
 */
public class ScoresController extends Controller {

    private MainController mainController;

    private ScoresController() {
    }

    public static ScoresController getInstance() {
        return ScoresControllerHolder.INSTANCE;
    }

    private static class ScoresControllerHolder {

        private static final ScoresController INSTANCE = new ScoresController();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;

    }

    public void sendScores() {
        long time = this.mainController.getTimer().getTime();
        GameLevel level = this.mainController.getGrid().getLevel();
        Scores scores = this.mainController.getFileManager().getScores();

        switch (level) {
            case Beginner:
                ArrayList<Long> arrayB = scores.getBeginnerScores();

                checkScores(arrayB, time, scores);
                break;
            case Intermediate:
                ArrayList<Long> arrayI = scores.getBeginnerScores();

                checkScores(arrayI, time, scores);
                break;
            case Expert:
                ArrayList<Long> arrayE = scores.getBeginnerScores();

                checkScores(arrayE, time, scores);
                break;
            default:
                break;

        }
    }

    /**
     * compare the time from the last game and the scores stored in the XML file
     * and writes the new times in the scores if the new time is better
     */
    public void checkScores(ArrayList<Long> array, long time, Scores scores) {
        if (time < array.get(array.size() - 1)) { //if the new time is better than the last stored
            array.add(time);
            array.sort(null); //sort the values in natural ordening
            array.remove(array.size() - 1); // remove the last value
            this.mainController.getFileManager().writeXMLScores(scores);
            this.mainController.getGameModel().setScoresFrameClosed(true);
            this.mainController.getGameModel().addObserver(this.mainController.initScoresFrame(this.mainController.getFileManager().getFilePath(),true));
        }
    }

}
