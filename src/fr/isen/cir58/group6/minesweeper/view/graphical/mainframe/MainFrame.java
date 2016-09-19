/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe;

import fr.isen.cir58.group6.minesweeper.controller.EndGameController;
import fr.isen.cir58.group6.minesweeper.controller.ScoresController;
import fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.menu.MenuBarView;
import javax.swing.JFrame;
import java.util.Observable;
import java.util.Observer;
import fr.isen.cir58.group6.minesweeper.model.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * Main Frame of the game, displays the Grid Panel and the bottom panel
 * @author Thomas Fossati / Guillaume Catto
 */
public class MainFrame extends JFrame implements Observer {

    static final String TITLE = "Minesweeper";

    public MainFrame(Grid grid, GameModel gameModel, TimerModel timer) {
        super(MainFrame.TITLE);

        grid.addObserver(this);
        gameModel.addObserver(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(grid.getSizeX() * 45, grid.getSizeY() * 50);
        this.setLayout(new BorderLayout(10, 10));
        this.setJMenuBar(new MenuBarView());
        this.add(new GridPanel(new GridLayout(grid.getSizeY(), grid.getSizeX()), grid, false), BorderLayout.CENTER);
        this.add(new BottomPanel(new FlowLayout(FlowLayout.CENTER, 15, 5), grid, timer), BorderLayout.SOUTH);
        this.setVisible(true);

    }

    /**
     * Observe the Grid model to display a message when the game is finished and restart the game
     * Observe the gameModel to shutdown the program or to kill the previous main frame to instantiate the new one when a new custom game is launched
     * 
     */
    @Override
    public void update(Observable o, Object arg) {
        // code
        if (arg instanceof Grid) {
            Grid grid = (Grid) arg;
            if (grid.getIsFinished()) {

                int res = -1;
                if (grid.getIsWinner()) {
                    ScoresController scoresController = ScoresController.getInstance();
                    scoresController.sendScores();
                    res = JOptionPane.showOptionDialog(null, "Game Over. You win !", "Message", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);
                } else {

                    res = JOptionPane.showOptionDialog(null, "Game Over. You Loose !", "Message", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);

                }
                if (res == 0) {
                    EndGameController end = EndGameController.getInstance();
                    end.restartGame();
                }

            }

        }
        if (arg instanceof GameModel) {
            GameModel gameModel = (GameModel) arg;
            if (gameModel.getShutDown()) {
                this.setVisible(false);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
            if (gameModel.isCurrentGameFrameClosed()) {
                this.setVisible(false);
                this.dispose();
                gameModel.setCurrentGameFrameClosed(false);
            }

        }

    }
}
