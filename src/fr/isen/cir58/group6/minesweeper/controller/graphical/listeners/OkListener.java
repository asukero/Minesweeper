/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller.graphical.listeners;

import fr.isen.cir58.group6.minesweeper.controller.OkController;
import fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame.LevelRadioButton;
import fr.isen.cir58.group6.minesweeper.view.graphical.common.OkButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Listener on the Ok button, calls Ok controller
 * @author Thomas Fossati / Guillaume Catto
 */
public class OkListener extends MouseAdapter {

    private OkController controller;
    private boolean isFromCustomGameFrame;
    /**
     * 
     * @param isFromCustomGameFrame 
     */
    public OkListener(boolean isFromCustomGameFrame) {
        this.isFromCustomGameFrame = isFromCustomGameFrame;
        this.controller = OkController.getInstance();
    }
    private void initCustomGame(OkButton button) {
        int rows = Integer.parseInt(button.getSettingsPanel().get(0).getTextfield().getText());
        int columns = Integer.parseInt(button.getSettingsPanel().get(1).getTextfield().getText());
        int mines = Integer.parseInt(button.getSettingsPanel().get(2).getTextfield().getText());

        this.controller.initNewCustomGame(this.isFromCustomGameFrame, rows, columns, mines);

    }
/**
 * Depending of the location of the Ok button (the new game frame or the custom game frame) calls the initCustomGame method with the value given by the sliders/textfields
 * or when it is located in the new game frame gets the values from the radio buttons and/or the sliders/textfields
 */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e != null) {
            if (e.getSource() instanceof JButton) {
                OkButton button = (OkButton) e.getSource();
                
                if (button.getNewGamePanelRadioButtons() != null) { //if not the button is located in the custom game frame
                    Enumeration<AbstractButton> radioButtons = button.getNewGamePanelRadioButtons().getButtonGroup().getElements();
                    //gets all the radio buttons elements
                    while (radioButtons.hasMoreElements()) {
                        LevelRadioButton radioButton = (LevelRadioButton) radioButtons.nextElement();
                        
                        if (radioButton.isSelected()) {
                            
                            if (radioButtons.hasMoreElements()) { //if not then it means that the last radio button selected is the custom game radio button
                                this.controller.initNonCustomGame(radioButton.getLevel());
                            } else {
                                initCustomGame(button);

                            }

                        }

                    }
                } else {
                    initCustomGame(button);
                }

            }

        }
    }

}
