/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame;

import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import fr.isen.cir58.group6.minesweeper.model.GameModel;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JRadioButton;

/**
 * Swing radiobutton component allows the player to select the level
 * @author Thomas Fossati / Guillaume Catto
 */
public class LevelRadioButton extends JRadioButton implements Observer {

    private GameLevel level;

    public LevelRadioButton(GameLevel level, String s) {
        super(s);
        this.level = level;


    }

    public GameLevel getLevel() {
        return level;
    }

    /**
     * the Radiobuttons observe the slider model, when an action is performed on the textfiel or the slider, the radiobutton which has the level custom is selected 
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof GameModel) {
            GameModel gameModel = (GameModel) arg;
            if (gameModel.isCustomGameRadioButtonSelected()) {
                if (this.level == GameLevel.Custom) {
                    this.setSelected(true);
                } else {
                    this.setSelected(false);
                }
            }
        }
    }

}
