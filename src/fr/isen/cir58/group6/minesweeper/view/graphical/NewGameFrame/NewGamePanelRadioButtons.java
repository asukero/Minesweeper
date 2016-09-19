/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame;

import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import fr.isen.cir58.group6.minesweeper.model.GameModel;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * JPanel for level selection
 * @author Thomas Fossati / Guillaume Catto
 */
public class NewGamePanelRadioButtons extends JPanel {

    private ButtonGroup buttonGroup;

    public NewGamePanelRadioButtons(LayoutManager layout, GameModel gameModel) {
        super(layout);
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.add(new JLabel("Select a level:"));

        ArrayList<LevelRadioButton> buttons = new ArrayList<>();
        buttons.add(new LevelRadioButton(GameLevel.Beginner, "Beginner: 10 mines in a 9x9 field"));
        buttons.get(0).setSelected(true);
        buttons.add(new LevelRadioButton(GameLevel.Intermediate, "Intermediate: 40 mines in a 16x40 field"));
        buttons.add(new LevelRadioButton(GameLevel.Expert, "Expert: 99 mines in a 16x30 field"));
        buttons.add(new LevelRadioButton(GameLevel.Custom, "Custom"));

        this.buttonGroup = new ButtonGroup();

        for (LevelRadioButton button : buttons) {
            this.buttonGroup.add(button);
            gameModel.addObserver(button);
            this.add(button);
        }
        
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

}
