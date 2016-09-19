/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.controller.graphical.listeners;

import fr.isen.cir58.group6.minesweeper.controller.SliderController;
import fr.isen.cir58.group6.minesweeper.view.graphical.common.SettingsPanel;
import fr.isen.cir58.group6.minesweeper.view.graphical.common.SettingsSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Listener on JSlider, calls SliderController
 * @author Thomas Fossati / Guillaume Catto
 */
public class SliderListener implements ChangeListener {

    private SliderController controller;

    public SliderListener() {
        this.controller = SliderController.getInstance();
    }
    /**
     * when changed, calls the controller to send the new value to the slider model 
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof SettingsSlider) {
            SettingsSlider settingsSlider = (SettingsSlider) e.getSource();

            if (settingsSlider.getParent() instanceof SettingsPanel) {
                SettingsPanel settingPanel = (SettingsPanel) settingsSlider.getParent();

                this.controller.setValue(settingPanel.getGameSetting(), Integer.toString(settingsSlider.getValue()));
                this.controller.setCustomGameRadioButton();

            }

        }
    }

}
