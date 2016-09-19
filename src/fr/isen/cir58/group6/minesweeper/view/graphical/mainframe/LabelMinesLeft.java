/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe;

import fr.isen.cir58.group6.minesweeper.model.Grid;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * Displays the mines left
 * @author Thomas Fossati / Guillaume Catto
 */
public class LabelMinesLeft extends JLabel implements Observer {

    static final String MESSAGE = "Remaining mines: ";

    public LabelMinesLeft(Grid grid) {
        super(LabelMinesLeft.MESSAGE + grid.getMinesLeft());

        grid.addObserver(this);
    }
/**
 * Observes the Grid model to update the number of mines left
 */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Grid) {
            Grid grid = (Grid) arg;
            this.setText(LabelMinesLeft.MESSAGE + grid.getMinesLeft());
        }

    }

}
