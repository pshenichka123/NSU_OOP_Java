package Model;

import Model.Minefield.Minefield;

public class Model {
    private boolean isGameEnded = false;
    private Minefield minefield;
    private boolean win = false;

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }


    public Minefield getMinefield() {
        return minefield;
    }

    public void recreateMinefield(Integer[] size, Integer bombs) {
        minefield = new Minefield(size, bombs);
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        isGameEnded = gameEnded;
    }


    public Model() {
        minefield = new Minefield(new Integer[]{9, 9}, 10);
    }

    public Model(Integer[] sizes, int bombs) {
        minefield = new Minefield(sizes, bombs);

    }

    public void act(int i, int j) {
        setGameEnded(minefield.act(i, j));
        if (isGameEnded()) {
            setWin(false);
        }
        if (isGameEnded() && !isWin()) {

            minefield.setVisible();
        }

    }

    public void changeFlagState(int j, int i) {
        minefield.changeFlagState(i, j);
    }
}
