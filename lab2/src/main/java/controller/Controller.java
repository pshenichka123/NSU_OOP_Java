package controller;

import Model.Model;
import View.View;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;
    View view;


    public Controller(){
        model=new Model();
        view=new View();

        setVievers();
    }


    public void control(){
        while (model.isGameRunning())
        {
            model.update();
            view.showAll();
        }
        System.out.println("lalaal");
    }

    public void  setVievers(){

        view.getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        view.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setGameRunning(false);
                killListeners();
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

    public void  killListeners(){

        view.getExitButton().removeActionListener(view.getExitButton().getActionListeners()[0]);
        view.getAboutButton().removeActionListener(view.getAboutButton().getActionListeners()[0]);
        view.getHighScoresButton().removeActionListener(view.getHighScoresButton().getActionListeners()[0]);
        view.getNewGameButton().removeActionListener(view.getNewGameButton().getActionListeners()[0]);

    }





}
