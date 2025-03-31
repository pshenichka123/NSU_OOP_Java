package Model;

import Model.Minefield.Cell;
import Model.Minefield.Minefield;

public class Model {
    private boolean isModelAndViewAreSync = false;
    private boolean isGameRunning = true;
    private Minefield minefield;


    public Minefield getMinefield() {
        return minefield;
    }

    public void recreateMinefield(Integer[] size, Integer bombs) {
        minefield = new Minefield(size, bombs);
    }


    public boolean isModelAndViewAreSync() {
        return isModelAndViewAreSync;
    }

    public void setModelAndViewAreSync(boolean modelAndViewAreSync) {
        isModelAndViewAreSync = modelAndViewAreSync;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }


    public Model() {
        minefield = new Minefield(new Integer[]{9, 9}, 10);
    }

    public void update(Integer[] coords) {
        Cell cell = minefield.getCell(coords[0], coords[1]);
        if (cell.isFlagsSet()) {
            return;
        }
        if (cell.isMineHere()) {
            cell.setOpened(true);
            setModelAndViewAreSync(false);
            setGameRunning(false);
            return;
        }
        cell.setOpened(true);
        setModelAndViewAreSync(false);
        return;
    }


}
