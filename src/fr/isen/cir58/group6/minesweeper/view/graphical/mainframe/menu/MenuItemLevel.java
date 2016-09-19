/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.menu;

import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.MenuListener;
import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.NewGameListener;
import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * JMenuItem for each level of the game
 * @author Thomas Fossati / Guillaume Catto
 */
public class MenuItemLevel extends JMenuItem {

    private GameLevel level;

    public MenuItemLevel(GameLevel level) {
        super(level.toString());
        this.level = level;
        switch (level) {
            case Beginner:
                NewGameListener bListener = new NewGameListener();
                this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK));
                this.setMnemonic(KeyEvent.VK_B);
                this.addActionListener(bListener);
                this.addMouseListener(bListener);
                break;
            case Intermediate:
                NewGameListener iListener = new NewGameListener();
                this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
                this.setMnemonic(KeyEvent.VK_I);
                this.addActionListener(iListener);
                this.addMouseListener(iListener);
                break;
            case Expert:
                NewGameListener eListener = new NewGameListener();
                this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
                this.setMnemonic(KeyEvent.VK_E);
                this.addActionListener(eListener);
                this.addMouseListener(eListener);
                break;

            case Custom:
                MenuListener cListener = new MenuListener();
                this.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
                this.setMnemonic(KeyEvent.VK_C);
                this.addActionListener(cListener);
                this.addMouseListener(cListener);
                break;
            default:
                break;

        }

    }

    public GameLevel getLevel() {
        return level;
    }

}
