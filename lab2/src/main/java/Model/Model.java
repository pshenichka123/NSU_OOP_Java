package Model;

import Model.Minefield.Minefield;

import java.util.Objects;

public class Model {
    private Minefield minefield;

    private boolean isgamerwon = false;
    private boolean isgamerlost = false;
    private boolean isgamestarted = false;

    public boolean isIsgamestarted() {
        return isgamestarted;
    }

    public void setIsgamestarted(boolean isgamestarted) {
        this.isgamestarted = isgamestarted;
    }

    public boolean isIsgamerwon() {
        return isgamerwon;
    }

    public void setIsgamerwon(boolean isgamerwon) {
        this.isgamerwon = isgamerwon;
    }

    public boolean isIsgamerlost() {
        return isgamerlost;
    }

    public void setIsgamerlost(boolean isgamerlost) {
        this.isgamerlost = isgamerlost;
    }

    public Minefield getMinefield() {
        return minefield;
    }


    public Model() {
        minefield = new Minefield(new Integer[]{12, 12}, 10);
    }

    public Model(Integer[] sizes, int bombs) {
        minefield = new Minefield(sizes, bombs);
    }

    public void act(int i, int j) {
        minefield.act(i, j);
        isGamerLost(i, j);
        isGamerWon();
        System.out.println(getMinefield().getUnopenedCellsCount());
    }

    private void isGamerLost(int i, int j) {
        if (minefield.getCell(i, j).isMineHere()) {
            isgamerlost = true;
            isgamerwon = false;
            minefield.setVisible();
        }
    }

    private void isGamerWon() {
        if (minefield.getUnopenedCellsCount() == 0) {
            isgamerwon = true;
            isgamerlost = false;
        }
    }

    public void changeFlagState(int j, int i) {
        minefield.changeFlagState(i, j);
    }
}
