package controller;

import Model.Model;

public class Controller {
    public void setModel(Model model) {
        this.model = model;
    }

    Model model;


    public Controller() {
        model = new Model();
    }


    public void revealCell(int i, int j) {

        model.act(i, j);

    }

    public void changeFlagState(int i, int j) {
        model.changeFlagState(j, i);
    }

    public void recreateModel(int num1, int num2, int mines) {
        model = new Model(new Integer[]{num1, num2}, mines);

    }

    public Model getModel() {
        return model;
    }
}
