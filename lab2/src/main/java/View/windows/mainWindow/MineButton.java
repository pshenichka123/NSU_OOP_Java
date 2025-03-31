package View.windows.mainWindow;

import Model.Minefield.Cell;

import javax.swing.*;
import java.awt.*;

public class MineButton extends JButton {


    MineButton(Cell cell) {
        super();
        int buttonSize = 60;
        setPreferredSize(new Dimension(buttonSize, buttonSize));


    }


}
