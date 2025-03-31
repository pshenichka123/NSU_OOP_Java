package controller;

import Model.Minefield.Cell;
import Model.Minefield.Minefield;
import Model.Model;
import View.View;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.constant.Constable;

public class Controller {
    Model model;
    View view;
    FieldListener fieldListener;

    public Controller() {
        model = new Model();
        view = new View(model.getMinefield());
        fieldListener = new FieldListener(view.getVisualMinefield());
        setVievers();
    }

    public void control() {
        while (model.isGameRunning()) {
            if (!model.isModelAndViewAreSync()) {
                view.showMainWindow(model.getMinefield());
                model.setModelAndViewAreSync(true);
            }

            if (fieldListener.isPressed()) {
                model.update(fieldListener.getCoords());
                fieldListener.setPressed(false);
            }
            System.out.println("bdfb");

        }
        System.out.println("lalaal");
    }

    public void setVievers() {
        view.getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        view.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setGameRunning(false);
                view.closeAll();
            }
        });
        view.getAboutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.showAboutWindow();
            }
        });
        view.getHighScoresButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }


}
