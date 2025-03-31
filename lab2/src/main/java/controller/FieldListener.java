package controller;

import View.windows.mainWindow.VisualMinefield;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldListener {
    public Integer[] getCoords() {
        return coords;
    }

    public void setCoords(Integer[] coords) {
        this.coords = coords;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    private Integer[] coords = {0, 0};
    private boolean pressed = false;


    FieldListener(VisualMinefield visualMinefield) {
        int size1 = visualMinefield.getSize1();
        int size2 = visualMinefield.getSize2();
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {

                int finalI = i;
                int finalJ = j;
                visualMinefield.getMineButton(i, j).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pressed = true;
                        coords[0] = finalI;
                        coords[1] = finalJ;
                    }
                });

            }
        }


    }


}
