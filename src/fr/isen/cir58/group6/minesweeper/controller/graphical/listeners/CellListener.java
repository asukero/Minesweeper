/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.controller.graphical.listeners;

import fr.isen.cir58.group6.minesweeper.controller.CellController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 * Listener on CellButton, calls cellController 
 * @author Thomas Fossati / Guillaume Catto
 */
public class CellListener extends MouseAdapter {

    private CellController controller;
    private int x, y;
/**
 * needs to know the coordinates of the cell to pass them in argument of the controller methods 
 */
    public CellListener(int x, int y) {
        this.x = x;
        this.y = y;
        this.controller = CellController.getInstance();
    }
/**
 *  Depending of the mouse button either call leftclick or right click method of the controller
 */
    @Override
    public void mouseClicked(MouseEvent e) {

        if (SwingUtilities.isLeftMouseButton(e)) {

            this.controller.leftClik(this.x, this.y);

        } else if (SwingUtilities.isRightMouseButton(e)) {

            this.controller.rightClick(this.x, this.y);

        }
    }

}
