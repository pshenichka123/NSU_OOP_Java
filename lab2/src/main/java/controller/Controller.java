package controller;

import Model.Model;
import View.View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    Model model;


    public Controller(Model modele) {
        model = modele;
    }


    public void buttonPressed(int i, int j) {

        model.act(i, j);

    }

}
