/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.controller.graphical.listeners;

import fr.isen.cir58.group6.minesweeper.controller.NewGameMenuController;
import fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.menu.MenuItemLevel;
import fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.menu.NewSubMenu;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Listener on MenuItemLevel or NewSubMenu
 * @author Thomas Fossati / Guillaume Catto
 */
public class NewGameListener extends MouseAdapter implements ActionListener {

    private NewGameMenuController controller;

    public NewGameListener() {
        this.controller = NewGameMenuController.getInstance();
    }
    
    
    /**
     * Depending of the submenu, either calls the method to initiate a new game with a non custom game level or to display the new game frame
     */
    private void dispatchEvent(AWTEvent e) {
        if (e.getSource() instanceof MenuItemLevel) {

            MenuItemLevel menuLevel = (MenuItemLevel) e.getSource();
            this.controller.initNewGame(menuLevel.getLevel());
        }
        if (e.getSource() instanceof NewSubMenu) {

            NewSubMenu menu = (NewSubMenu) e.getSource();
            this.controller.launchNewGameFrame();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dispatchEvent(e);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispatchEvent(e);
    }

}
