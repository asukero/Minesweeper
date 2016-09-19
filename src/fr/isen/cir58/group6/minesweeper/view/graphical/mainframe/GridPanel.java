/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe;

import javax.swing.JPanel;
import java.awt.LayoutManager;
import fr.isen.cir58.group6.minesweeper.model.*;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

/**
 * Panel which contains n*m buttons
 * @author Thomas Fossati / Guillaume Catto
 */
public class GridPanel extends JPanel implements Observer {
    public CellSprites cellSprites = null;

    public GridPanel(LayoutManager layout, Grid grid, boolean isText) {
        super(layout);

        grid.addObserver(this);

        int sizeX = grid.getSizeX();
        int sizeY = grid.getSizeY();
        
        if (!isText) {
            this.cellSprites = new CellSprites();
        }

        for (int i = 0; i < sizeY; i++) {
            ArrayList<CellButton> line = new ArrayList<>(sizeX);

            for (int j = 0; j < sizeX; j++) {
                CellButton g = new CellButton(grid.getGrid().get(i).get(j), this, isText);
                line.add(g);
                this.add(g);
            }
        }

        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        
    }
}
