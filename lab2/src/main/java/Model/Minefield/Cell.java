package Model.Minefield;

public class Cell {
    private boolean opened = false;
    private boolean mineHere = false;
    private int num;
    private boolean isFlagsSet = false;
    private boolean stateChanged = false;


    public boolean isStateChanged() {
        return stateChanged;
    }

    public void setStateChanged(boolean stateChanged) {
        this.stateChanged = stateChanged;
    }
    
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
        setStateChanged(true);
    }


    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
        setStateChanged(true);
    }

    public boolean isMineHere() {
        return mineHere;
    }

    public void setMineHere(boolean mineHere) {
        this.mineHere = mineHere;
    }


    public Cell() {
    }

    Cell(boolean ismineHere, int num) {
        setMineHere(ismineHere);
        setNum(num);
        setStateChanged(true);
    }


}
