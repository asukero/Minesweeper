/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.isen.cir58.group6.minesweeper.controller.graphical.listeners;

import fr.isen.cir58.group6.minesweeper.controller.CancelController;
import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Listener on the quit Menu or cancel button calls cancelController to either kill the program or close a frame
 * @author Thomas Fossati / Guillaume Catto
 */
public class CancelListener extends MouseAdapter implements ActionListener {

    private boolean isFromCustomGameFrame;
    private CancelController controller;

    public CancelListener(boolean isFromCustomGameFrame) {
        this.isFromCustomGameFrame = isFromCustomGameFrame;
        this.controller = CancelController.getInstance();
    }

    private void dispatchEvent(AWTEvent e) {
        if (!this.isFromCustomGameFrame) {
            this.controller.killProgram();
        } else {
            this.controller.closeFrame();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dispatchEvent(e);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispatchEvent(e);
    }

}
