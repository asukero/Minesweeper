/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.menu;

import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.NewGameListener;
import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;

/**
 * JMenu with each MenuItemLevel
 * @author Thomas Fossati / Guillaume Catto
 */
public class NewSubMenu extends JMenu {
    
    public NewSubMenu(String s) {
        super(s);
        this.setMnemonic(KeyEvent.VK_N);
        this.addMouseListener(new NewGameListener());
        this.add(new MenuItemLevel(GameLevel.Beginner));
        this.add(new MenuItemLevel(GameLevel.Intermediate));
        this.add(new MenuItemLevel(GameLevel.Expert));
        this.add(new MenuItemLevel(GameLevel.Custom));
        
    }
    
}
