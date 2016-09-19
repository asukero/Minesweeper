/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.common;

import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.OkListener;
import fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame.NewGamePanelRadioButtons;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * Okbutton is used in GameFrame's childs to valid the game selection (level, custom game etc...)
 * Needs to know the 3 settingsPanel and the radiobuttons to sends their values to his OkListener
 * @author Thomas Fossati / Guillaume Catto
 */
public class OkButton extends JButton{
    private ArrayList<SettingsPanel> settingsPanel;
    private NewGamePanelRadioButtons newGamePanelRadioButtons;

    public OkButton(String text, boolean isFromCustomGameFrame, ArrayList<SettingsPanel> settingsPanel, NewGamePanelRadioButtons newGamePanelRadioButtons) {
        super(text);
        this.addMouseListener(new OkListener(isFromCustomGameFrame));
        this.settingsPanel = settingsPanel;
        this.newGamePanelRadioButtons = newGamePanelRadioButtons;
                
        
    }

    public ArrayList<SettingsPanel> getSettingsPanel() {
        return settingsPanel;
    }

    public NewGamePanelRadioButtons getNewGamePanelRadioButtons() {
        return newGamePanelRadioButtons;
    }
    
    
    
}
