/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.menu;

import fr.isen.cir58.group6.minesweeper.model.GameModel;
import javax.swing.JMenuBar;

/**
 *
 * @author Thomas Fossati / Guillaume Catto
 */
public class MenuBarView extends JMenuBar{


    public MenuBarView() {
        this.add(new Menu("Game"));
        this.setVisible(true);
    }

   
    
    
}
