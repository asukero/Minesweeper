/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller.graphical.listeners;

import fr.isen.cir58.group6.minesweeper.controller.MenuController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

/**
 * Listener on Menu, calls Menu Controller
 * @author Thomas Fossati / Guillaume Catto
 */
public class MenuListener extends MouseAdapter implements ActionListener {

    private MenuController controller;

    public MenuListener() {
        this.controller = MenuController.getInstance();
    }
/**
 * Depending of the MenuItem calls the controller's method to display the custom grame frame or the score frame 
 */
    private void dispatchEvent(JMenuItem menuItem) {
        switch (menuItem.getText()) {
            case "Custom":
                this.controller.displayCustomGameFrame();
                break;
            case "Scores":
                this.controller.displayScoresFrame();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            dispatchEvent(menuItem);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JMenuItem) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            dispatchEvent(menuItem);
        }
    }

}
