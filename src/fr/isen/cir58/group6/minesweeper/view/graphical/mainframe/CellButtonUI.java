/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe;

import java.awt.Color;
import javax.swing.plaf.metal.MetalButtonUI;

/**
 * UI created to display a CellButton properly
 * @author Thomas Fossati / Guillaume Catto
 */
public class CellButtonUI extends MetalButtonUI {
    private Color disabledTextCustomColor = null;
    
    CellButtonUI(Color c) {
        super();
        this.disabledTextCustomColor = c;
    }
    
    CellButtonUI() {
        super();
    }
    
    /**
     * disabledTextColor getter
     * @return will return the text color when a CellButton is disabled
     */
    @Override
    public Color getDisabledTextColor() {
        if (this.disabledTextCustomColor == null) {
            return super.getDisabledTextColor();
        }
        
        return this.disabledTextCustomColor;
   }

    /**
     * disabledTextColor setter
     * @param c color to set
     */
    public void setDisabledTextCustomColor(Color c) {
        this.disabledTextCustomColor = c;
    }
}
