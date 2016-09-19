/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.common;


import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.SliderListener;
import javax.swing.JSlider;

/**
 *
 * @author Thomas Fossati / Guillaume Catto
 */
public class SettingsSlider extends JSlider{

    public SettingsSlider(int min, int max, int value) {
        super(min, max, value);
        this.setMinorTickSpacing(1);
        this.setMajorTickSpacing(max/6);
        
        this.setPaintTicks(true);
        this.setPaintLabels(true);
        this.addChangeListener(new SliderListener());
    }
    
    
}
