/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.common;

import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.TextFieldListener;
import fr.isen.cir58.group6.minesweeper.model.GameSettings;
import javax.swing.JTextField;

/**
 *
 * @author Thomas Fossati / Guillaume Catto
 */
public class SliderTextField extends JTextField{
    private String defaultText;

    public SliderTextField(String text, int columns, GameSettings gameSetting) {
        super(text, columns);
        this.defaultText = text;
        this.addActionListener(new TextFieldListener());
    }

    public String getDefaultText() {
        return defaultText;
    }
    
    

}
