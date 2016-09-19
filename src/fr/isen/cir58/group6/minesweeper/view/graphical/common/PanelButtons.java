/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.common;

import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.CancelListener;
import fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame.NewGamePanelRadioButtons;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Panel with an ok button and a cancel button
 * @author Thomas Fossati / Guillaume Catto
 */
public class PanelButtons extends JPanel {

    public PanelButtons(LayoutManager layout, boolean isFromCustomGameFrame,ArrayList<SettingsPanel> settingsPanel, NewGamePanelRadioButtons newGamePanelRadioButtons) {
        super(layout);
        
        this.add(new OkButton("Ok", isFromCustomGameFrame, settingsPanel, newGamePanelRadioButtons));
        JButton cancel = new JButton("Cancel");
        cancel.addMouseListener(new CancelListener(isFromCustomGameFrame));
        this.add(cancel);
    }

}
