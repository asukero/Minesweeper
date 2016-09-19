/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper;

import fr.isen.cir58.group6.minesweeper.controller.CancelController;
import fr.isen.cir58.group6.minesweeper.controller.CellController;
import fr.isen.cir58.group6.minesweeper.controller.EndGameController;
import fr.isen.cir58.group6.minesweeper.controller.MenuController;
import fr.isen.cir58.group6.minesweeper.controller.NewGameMenuController;
import fr.isen.cir58.group6.minesweeper.controller.OkController;
import fr.isen.cir58.group6.minesweeper.controller.ScoresController;
import fr.isen.cir58.group6.minesweeper.controller.SliderController;
import fr.isen.cir58.group6.minesweeper.controller.console.ConsoleController;
import fr.isen.cir58.group6.minesweeper.model.BadMinePercentageException;
import fr.isen.cir58.group6.minesweeper.model.FileManager;
import fr.isen.cir58.group6.minesweeper.model.GameLevel;
import fr.isen.cir58.group6.minesweeper.model.GameModel;
import fr.isen.cir58.group6.minesweeper.model.Grid;
import fr.isen.cir58.group6.minesweeper.model.Slider;
import fr.isen.cir58.group6.minesweeper.model.TimerModel;
import fr.isen.cir58.group6.minesweeper.view.console.ConsoleView;
import fr.isen.cir58.group6.minesweeper.view.graphical.CustomGameFrame.CustomGameFrame;
import fr.isen.cir58.group6.minesweeper.view.graphical.NewGameFrame.NewGameFrame;
import fr.isen.cir58.group6.minesweeper.view.graphical.mainframe.MainFrame;
import fr.isen.cir58.group6.minesweeper.view.graphical.scoresframe.ScoresFrame;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * main class of the Minesweeper, initiate and instanciate the Minesweeper
 * models view and controllers
 *
 * @author Thomas Fossati / Guillame Catto
 *
 */
public class MainController {

    private Grid grid;
    private GameModel gameModel;
    private Slider slider;
    private TimerModel timer;
    private FileManager fileManager;

    private boolean graphicMode = true;
    private boolean debugMode = false;

    private CellController cellController;
    private CancelController cancelController;
    private MenuController customGameController;
    private OkController okController;
    private NewGameMenuController newGameController;
    private SliderController sliderController;
    private EndGameController endGameController;
    private ScoresController scoresController;

    /**
     * checks the game mode, graphic mode or console mode
     *
     * @param graphicMode
     */
    public MainController(boolean graphicMode, boolean debugMode) {
        this.graphicMode = graphicMode;
        this.debugMode = debugMode;
        if (!graphicMode) {
            initConsoleGame();
        } else {
            initGraphicGame();
        }

    }

    /**
     * initiate the graphic mode, the gameModel, the slider model, the newGame
     * Frame and the controllers
     */
    private void initGraphicGame() {
        this.gameModel = new GameModel();
        this.slider = new Slider();
        NewGameFrame n = initNewGameFrame();

        CustomGameFrame c = new CustomGameFrame(this.slider, this.gameModel);

        this.gameModel.addObserver(n);
        this.gameModel.addObserver(c);

        initControllers();
    }

    private void initConsoleGame() {
        this.createGrid(10, 12, 10, false, GameLevel.Custom);
        ConsoleView view = new ConsoleView(grid, true);
        ConsoleController controller = new ConsoleController(grid, view);
        controller.loop();
    }

    /**
     * instantiate the model grid
     *
     * @param mines either a percentage or a number of mines
     *
     */
    public void createGrid(int x, int y, double mines, boolean isPercentage, GameLevel level) {
        try {
            this.grid = new Grid(y, x, mines, this.debugMode, isPercentage, level);
        } catch (BadMinePercentageException e) {

        }
    }

    /**
     * sets the timer, the main frame, the grid and the scores frame, is called
     * either to launch a new game or to restart the game
     *
     * @param mines either a percentage or a number of mines
     *
     */
    public void startGame(int x, int y, double mines, boolean isPercentage, GameLevel level) {
        if (this.timer != null) {
            this.timer.resetTimer();
        }

        this.gameModel.setScoresFrameClosed(true);
        this.gameModel.setScoresFrameVisible(false);
        initScoresFrame(FileManager.DEFAULTFILEPATHXML,true);
        this.createGrid(x, y, mines, isPercentage, level);

        this.timer = new TimerModel();
        this.timer.stopTimer();
        MainFrame mainFrame = new MainFrame(this.grid, this.gameModel, this.timer);

    }

    public NewGameFrame initNewGameFrame() {

        return new NewGameFrame(this.slider, this.gameModel);
    }

    public ScoresFrame initScoresFrame(String filepath, boolean isXML) {
        try {
            this.fileManager = new FileManager(filepath, true);
            ScoresFrame s = new ScoresFrame(this.fileManager.getScores());

            this.gameModel.setScoresFrameClosed(false);
            this.gameModel.addObserver(s);
            return s;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            if (isXML) {
                return initScoresFrame(FileManager.DEFAULTFILEPATHXML, true);
            } else {
                return initScoresFrame(FileManager.DEFAULTFILEPATH, false);
            }

        }

    }

    /**
     * Instantiate all the controllers needed for the graphic mode, each one is
     * a singleton to be able to have the same main controller in its attributes
     * when they are called by the listeners a singleton
     */
    private void initControllers() {

        this.cellController = CellController.getInstance();
        this.cellController.setMainController(this);
        this.cancelController = CancelController.getInstance();
        this.cancelController.setMainController(this);
        this.okController = OkController.getInstance();
        this.okController.setMainController(this);
        this.customGameController = MenuController.getInstance();
        this.customGameController.setMainController(this);
        this.newGameController = NewGameMenuController.getInstance();
        this.newGameController.setMainController(this);
        this.sliderController = SliderController.getInstance();
        this.sliderController.setMainController(this);
        this.endGameController = EndGameController.getInstance();
        this.endGameController.setMainController(this);
        this.scoresController = ScoresController.getInstance();
        this.scoresController.setMainController(this);

    }

    public Grid getGrid() {
        return grid;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public Slider getSlider() {
        return slider;
    }

    public TimerModel getTimer() {
        return timer;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public boolean isGraphicMode() {
        return this.graphicMode;
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

}
