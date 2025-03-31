package View.windows.mainWindow;

import Model.Minefield.Cell;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MineButton extends JButton {


    MineButton(Cell cell) {

        URL imageUrl;
        if (cell.isOpened()) {
            if (cell.isMineHere()) {
                imageUrl = MineButton.class.getResource("/resources/unopened" + ".png");
            }
            imageUrl = MineButton.class.getResource("/resources/Minesweeper_" + cell.getNum() + ".png");
            System.out.println("/resources/Minesweeper_" + cell.getNum() + ".png");
            assert imageUrl != null;
            
        } else {
            System.out.println("/resources/unopened.png");

            imageUrl = MineButton.class.getResource("/resources/unopened.png");

        }


        int buttonSize = 60;
        assert imageUrl != null;
        ImageIcon icon = new ImageIcon(imageUrl);
        new JButton(icon);
        setPreferredSize(new Dimension(buttonSize, buttonSize));


    }


}
