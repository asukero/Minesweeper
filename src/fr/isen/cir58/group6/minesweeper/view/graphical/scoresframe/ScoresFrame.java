/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.scoresframe;

import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import fr.isen.cir58.group6.minesweeper.model.GameModel;
import fr.isen.cir58.group6.minesweeper.model.Scores;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 * Displays the score saved in the score model
 * @author Thomas Fossati / Guillaume Catto
 */
public class ScoresFrame extends JFrame implements Observer {

    private static final String TITLE = "Scores";

    public ScoresFrame(Scores scores) throws HeadlessException {
        super(ScoresFrame.TITLE);

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(500, 300);
        this.setLayout(new GridLayout(1, 3, 0, 0));
        this.add(new ScoresPanel(new GridLayout(scores.getBeginnerScores().size() + 1, 1), scores, GameLevel.Beginner));
        this.add(new ScoresPanel(new GridLayout(scores.getIntermediateScores().size() + 1, 1), scores, GameLevel.Intermediate));
        this.add(new ScoresPanel(new GridLayout(scores.getExpertScores().size() + 1, 1), scores, GameLevel.Expert));

        this.setVisible(false);

    }
/**
 * Observes the gamemodel to update the frame when it has to not be visible or to be closed
 */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof GameModel) {
            GameModel gameModel = (GameModel) arg;
            if (gameModel.isScoresFrameVisible()) {
                this.setVisible(true);
            } else {
                this.setVisible(false);
            }
            if (gameModel.isScoresFrameClosed()) {
                this.setVisible(false);
                gameModel.deleteObserver(this);
                this.dispose();
            }

        }
    }

}
