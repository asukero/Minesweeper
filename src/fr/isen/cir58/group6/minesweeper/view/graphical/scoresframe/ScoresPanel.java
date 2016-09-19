/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.scoresframe;

import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import fr.isen.cir58.group6.minesweeper.model.Scores;
import fr.isen.cir58.group6.minesweeper.model.TimerModel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Display the scores for each non custom level
 * @author Thomas Fossati / Guillaume Catto
 */
public class ScoresPanel extends JPanel {

    public ScoresPanel(LayoutManager layout, Scores scores, GameLevel gameLevel) {
        super(layout);
        this.setBorder(new EmptyBorder(10,10,10,10));
        JLabel title = new JLabel(gameLevel.toString() + ":");
        Font font = title.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        title.setFont(font.deriveFont(attributes));
        this.add(title);

        switch (gameLevel) {
            case Beginner:
                ArrayList<Long> arrayB = scores.getBeginnerScores();

                for (int i = 0; i < arrayB.size(); i++) {

                    this.add(new JLabel(Integer.toString(i+1) + ". " + TimerModel.convertTime(arrayB.get(i))));
                }
                break;
            case Intermediate:
                ArrayList<Long> arrayI = scores.getIntermediateScores();
                for (int i = 0; i < arrayI.size(); i++) {

                    this.add(new JLabel(Integer.toString(i+1) + ". " + TimerModel.convertTime(arrayI.get(i))));
                }
                break;
            case Expert:
                ArrayList<Long> arrayE = scores.getExpertScores();
                for (int i = 0; i < arrayE.size(); i++) {

                    this.add(new JLabel(Integer.toString(i+1) + ". " + TimerModel.convertTime(arrayE.get(i))));
                }
                break;

        }
    }

}
