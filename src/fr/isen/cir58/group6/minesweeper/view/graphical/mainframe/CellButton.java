/*
 * ISEN 2014~2015
 */
package fr.isen.cir58.group6.minesweeper.view.graphical.mainframe;

import fr.isen.cir58.group6.minesweeper.controller.graphical.listeners.CellListener;
import fr.isen.cir58.group6.minesweeper.model.*;
import java.awt.Color;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * a JButton extended for a square in the graphical view
 * @author Thomas Fossati / Guillaume Catto
 */
public class CellButton extends JButton implements Observer {

    private int x, y;

    /**
     * the hidden square text of the button
     */
    public static final String HIDDEN = "";

    /**
     * the mine tag square text of the button
     */
    public static final String MINE_TAG = "!";

    /**
     * the unknown tag square text of the button
     */
    public static final String UNKNOWN_TAG = "?";

    /**
     * the empty square text of the button
     */
    public static final String EMPTY = "";

    /**
     * the mine square text of the button
     */
    public static final String MINE = "x";
    private GridPanel gridPanel;
    private CellButtonUI cellButtonUI;
    private boolean isText = true;
    private boolean isColorInitialized = false;
    
    /**
     * the constructor needed to create a CellButton object
     * @param square the square which will be observed
     * @param gridPanel the grid panel which will contain the CellButton objects
     * @param isText boolean to choose between displaying the CellButton objects with a simple text or an icon
     */
    public CellButton(Square square, GridPanel gridPanel, boolean isText) {
        super("");
        this.x = square.getX();
        this.y = square.getY();
        this.gridPanel = gridPanel;
        this.isText = isText;
        square.addObserver(this);
        
        this.cellButtonUI = new CellButtonUI();
        this.setUI(this.cellButtonUI);
        
        if (!isText) {
            this.setSprite(square);
        }
        
        this.addMouseListener(new CellListener(this.x, this.y));
    }
    
    /**
     * needed to set the text of the CellButton object
     * @param square observed by the CellButton object
     */
    public void setText(Square square) {
            if (square.getIsMine() && square.getGrid().getIsDebug() && !square.getGrid().getIsFinished()) {
                this.setText(MINE);
            } else {
                switch (square.getStatus()) {
                    case HIDDEN:
                        this.setText(HIDDEN);
                        break;
                    case MINE_TAG:
                        this.setText(MINE_TAG);
                        break;
                    case UNKNOWN_TAG:
                        this.setText(UNKNOWN_TAG);
                        break;
                    case NUMBER:
                        if (square.getAdjacentMines() == 0 || square.getGrid().getIsFinished()) {
                            this.setText(EMPTY);
                        } else { // will give the adjacent mines if not EMPTY
                            System.out.println(this.ui);
                            this.setText(Integer.toString(square.getAdjacentMines()));
                        }
                        this.setEnabled(false);
                        break;
                    case MINE:
                        this.setText(MINE);
                        this.setEnabled(false);
                        break;
                    default:
                        this.setText("");
                        break;
                }
            }
    }
    
    private Color setTextColorDisabled(Square square) {
        Color c = null;
        int adjacentMines = square.getAdjacentMines();
        
        switch (adjacentMines) {
            case 1:
                c = Color.BLUE;
                break;
            case 2:
                c = new Color(0,214,70); //dark green
                break;
            case 3:
                c = Color.RED;
                break;
            case 4:
                c = new Color(255, 141, 141);
                break;
            case 5:
                c = Color.CYAN;
                break;
            case 6:
                c = Color.ORANGE;
                break;
            case 7:
                c = Color.GRAY;
                break;
            case 8:
                c = Color.DARK_GRAY;
                break;
            default:
                c = Color.BLACK;
                break;
        }
        
        return c;
    }
    
    /**
     * needed to set the sprite of the CellButton object
     * @param square observed by the CellButton object
     */
    public void setSprite(Square square) {
        CellSprites sprites = this.gridPanel.cellSprites;
        Image sprite = null;
        boolean spriteChanged = false;
        
        if (square.getIsMine() && square.getGrid().getIsDebug() && !square.getGrid().getIsFinished()) {
                sprite = sprites.getMine();
                spriteChanged = true;
        } else {
            switch (square.getStatus()) {
                case HIDDEN:
                    sprite = sprites.getHidden();
                    spriteChanged = true;
                    break;
                case MINE_TAG:
                    sprite = sprites.getMineTag();
                    spriteChanged = true;
                    break;
                case UNKNOWN_TAG:
                    sprite = sprites.getUnknownTag();
                    spriteChanged = true;
                    break;
                case NUMBER:
                    if (square.getAdjacentMines() == 0 || square.getGrid().getIsFinished()) {
                        this.setText(EMPTY);
                    } else { // will give the adjacent mines if not EMPTY
                        this.setText(Integer.toString(square.getAdjacentMines()));
                    }
                    
                    this.setEnabled(false);
                    break;
                case MINE:
                    sprite = sprites.getMine();
                    spriteChanged = true;
                    this.setEnabled(false);
                    break;
                default:
                    this.setText("");
                    break;
            }
        }

        if (spriteChanged) {
            ImageIcon img = new ImageIcon(sprite);
            this.setIcon(img);
            this.setDisabledIcon(img);
        } else {
            this.setIcon(null);
        }
    }

    @Override
    public void update(Observable o, Object arg) {    
        if (arg instanceof Square) {
            if (!this.isColorInitialized) {
                Color c = this.setTextColorDisabled((Square) arg);
                this.cellButtonUI.setDisabledTextCustomColor(c);
                this.isColorInitialized =  true;
            }
            
            if (this.isText) {
                this.setText((Square) arg);
            } else {
                this.setSprite((Square) arg);
            }
        }
    }
}
