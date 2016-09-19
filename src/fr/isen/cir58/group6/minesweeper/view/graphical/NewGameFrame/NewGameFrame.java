/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame;

import fr.isen.cir58.group6.minesweeper.model.GameModel;
import fr.isen.cir58.group6.minesweeper.model.Slider;
import fr.isen.cir58.group6.minesweeper.view.graphical.common.GameFrame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.JFrame;

/**
 * display the newgame frame selction, is destroyed when the grid is created and is instantiated at program's launch or when the player wants to make a new game from the "New" SubMenu
 * @author Thomas Fossati / Guillaume Catto
 */
public class NewGameFrame extends GameFrame {

    public static final String TITLE = "New game";

    public NewGameFrame(Slider slider, GameModel gameModel) throws HeadlessException {
        super(NewGameFrame.TITLE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(new GridLayout(5, 1, 5, 0));
        this.addSettingsPanel(false,slider,gameModel);
        this.setVisible(true);
    }
/**
 *  Observe the gamemodel to see if it has to be disposed or not
 */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof GameModel) {
            GameModel gameModel = (GameModel) arg;
            if (gameModel.getShutDown()) {
                this.setVisible(false);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

            }
            if (gameModel.isNewGameFrameClosed()) {
                this.setVisible(false);
                this.dispose();
            }
        }

    }

}
