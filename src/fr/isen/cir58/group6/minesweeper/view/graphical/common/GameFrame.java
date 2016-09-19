/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.common;

import fr.isen.cir58.group6.minesweeper.model.GameModel;
import fr.isen.cir58.group6.minesweeper.model.GameSettings;
import fr.isen.cir58.group6.minesweeper.model.Slider;
import fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame.NewGamePanelRadioButtons;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 * Parent class of CustomGameFrame and NewGameFrame which had the same methods addsettingsPanel() to display the settings selection Panel
 * @author Thomas Fossati / Guillaume Catto
 */
public class GameFrame extends JFrame implements Observer {

    public GameFrame(String title) {
        super(title);
    }
    /**
     * 
     * @param isCustomGameFrame checks to display the radiobuttons or not
     * @param slider is required to get the number of mines max for the mines' slider
     */
    public void addSettingsPanel(boolean isCustomGameFrame, Slider slider, GameModel gameModel) {

        NewGamePanelRadioButtons newGamePanelRadioButtons = new NewGamePanelRadioButtons(new GridLayout(5, 1, 10, 0), gameModel);

        if (!isCustomGameFrame) {
            this.add(newGamePanelRadioButtons);

        }
        ArrayList<SettingsPanel> settingsPanel = new ArrayList<>();

        SettingsPanel sPRows = new SettingsPanel(new FlowLayout(FlowLayout.CENTER, 20, 0), GameSettings.Rows, 9, 24, Slider.rowsDefVal);

        settingsPanel.add(sPRows);
        this.add(sPRows);
        SettingsPanel sPColumns = new SettingsPanel(new FlowLayout(FlowLayout.CENTER, 20, 0), GameSettings.Columns, 9, 30, Slider.colsDefVal);
        settingsPanel.add(sPColumns);
        this.add(sPColumns);
        SettingsPanel sPMines = new SettingsPanel(new FlowLayout(FlowLayout.CENTER, 20, 0), GameSettings.Mines, 10, slider.getCurrentMinesLength(), Slider.minesDefVal);
        settingsPanel.add(sPMines);
        this.add(sPMines);

        slider.addObserver(sPRows);
        slider.addObserver(sPColumns);
        slider.addObserver(sPMines);

        if (isCustomGameFrame) {
            this.add(new PanelButtons(new FlowLayout(FlowLayout.RIGHT, 20, 5), isCustomGameFrame, settingsPanel,null));

        } else {
            this.add(new PanelButtons(new FlowLayout(FlowLayout.RIGHT, 20, 5), isCustomGameFrame, settingsPanel,newGamePanelRadioButtons));

        }

    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
