/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller.graphical.listeners;

import fr.isen.cir58.group6.minesweeper.controller.SliderController;
import fr.isen.cir58.group6.minesweeper.view.graphical.common.SliderTextField;
import fr.isen.cir58.group6.minesweeper.view.graphical.common.SettingsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener on Jtextfield, calls SliderController
 * @author Thomas Fossati / Guillaume Catto
 */
public class TextFieldListener implements ActionListener {

    private SliderController controller;

    public TextFieldListener() {
        this.controller = SliderController.getInstance();
    }
/**
 * 
 * when actionPerformed, calls the controller to send the new value to the slider model 
 */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof SliderTextField) {
            SliderTextField textField = (SliderTextField) e.getSource();

            if (textField.getParent() instanceof SettingsPanel) {
                SettingsPanel settingsPanel = (SettingsPanel) textField.getParent();


                try {
                    this.controller.setValue(settingsPanel.getGameSetting(), textField.getText());
                    this.controller.setCustomGameRadioButton();
                    
                } catch (NumberFormatException ex) {
                    System.err.println(ex.toString());
                    textField.setText(textField.getDefaultText());
                    this.controller.setValue(settingsPanel.getGameSetting(), textField.getDefaultText());
                    
                } catch (Exception ex) {
                    System.err.println(ex.toString());
                    textField.setText(textField.getDefaultText());
                    this.controller.setValue(settingsPanel.getGameSetting(), textField.getDefaultText());
                }

            }
        }
    }

}
