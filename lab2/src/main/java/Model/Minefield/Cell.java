package Model.Minefield;

import View.View;

import java.util.Vector;

public class Cell {
    private boolean opened = false;
    private boolean mineHere = false;

    public Cell(Vector<Integer> integers) {
        setCoords(integers);
    }

    public Vector<Integer> getCoords() {
        return coords;
    }

    public void setCoords(Vector<Integer> coords) {
        this.coords = new Vector<Integer>(coords);
    }

    private Vector<Integer> coords;
    private int num;
    private boolean isFlagsSet = false;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public boolean isFlagsSet() {
        return isFlagsSet;
    }

    public void setFlagsSet(boolean flagsSet) {
        isFlagsSet = flagsSet;
    }


    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
        setFlagsSet(false);
    }

    public boolean isMineHere() {
        return mineHere;
    }

    public void setMineHere(boolean mineHere) {
        this.mineHere = mineHere;
        this.setNum(10);
    }


    public Cell() {
    }

    Cell(boolean ismineHere, int num, Vector<Integer> coords) {
        setMineHere(ismineHere);
        setNum(num);
        setCoords(coords);
    }


}