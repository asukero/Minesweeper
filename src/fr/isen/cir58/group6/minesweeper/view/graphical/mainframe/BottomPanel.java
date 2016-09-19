/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe;

import fr.isen.cir58.group6.minesweeper.model.Grid;
import fr.isen.cir58.group6.minesweeper.model.TimerModel;
import java.awt.LayoutManager;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Displays the nb of mines left and the timer
 * @author Thomas Fossati / Guillaume Catto
 */
public class BottomPanel extends JPanel implements Observer {

    private JLabel timerLabel;

    public BottomPanel(LayoutManager layout, Grid grid, TimerModel timer) {
        super(layout);
        this.add(new LabelMinesLeft(grid));
        this.timerLabel = new JLabel("Time : " + timer.getTimerValue());
        this.add(timerLabel);
        timer.addObserver(this);
        this.setVisible(true);
    }
/**
 * Observes the timer model
 */
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TimerModel) {
            TimerModel timer = (TimerModel) o;
            this.timerLabel.setText("Time: " + timer.getTimerValue());

        }

    }
}
