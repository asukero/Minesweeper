/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.menu;

import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.CancelListener;
import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.MenuListener;
import fr.isen.cir58.group6.minesweeper.model.GameModel;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * JMenu "Game"
 * @author Thomas Fossati / Guillaume Catto
 */
public class Menu extends JMenu {

    public Menu(String s) {
        super(s);
        this.setMnemonic((KeyEvent.VK_G));
        this.add(new NewSubMenu("New"));
        
        
        JMenuItem scores = new JMenuItem("Scores");
        scores.setMnemonic(KeyEvent.VK_S);
        MenuListener scoresListener = new MenuListener();
        scores.addActionListener(scoresListener);
        scores.addMouseListener(scoresListener);
        this.add(scores);
        
        this.addSeparator();
        
        
        JMenuItem quit = new JMenuItem("Quit");
        quit.setMnemonic(KeyEvent.VK_Q);
        CancelListener quitListener = new CancelListener(false);
        quit.addActionListener(quitListener);
        quit.addMouseListener(quitListener);
        this.add(quit);
        
    }

}
