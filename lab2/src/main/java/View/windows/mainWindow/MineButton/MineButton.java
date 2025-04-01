package View.windows.mainWindow.MineButton;

import Model.Minefield.Cell;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MineButton extends JButton {
    int buttonSize = 60;

    public MineButton(Cell cell) {
        System.out.println(MineButton.class);

        URL imageUrl = chooseURL(cell);

        assert imageUrl != null;
        ImageIcon icon = new ImageIcon(imageUrl);
        new JButton(icon);
        setPreferredSize(new Dimension(buttonSize, buttonSize));
        Image image = icon.getImage();
        Image scaled = image.getScaledInstance(buttonSize, buttonSize, Image.SCALE_FAST);
        ImageIcon scaledIcon = new ImageIcon((scaled));
        setIcon(scaledIcon);


    }

    public void update(Cell cell) {
        URL imageUrl = chooseURL(cell);

        assert imageUrl != null;
        ImageIcon icon = new ImageIcon(imageUrl);
        Image image = icon.getImage();
        Image scaled = image.getScaledInstance(buttonSize, buttonSize, Image.SCALE_FAST);
        ImageIcon scaledIcon = new ImageIcon((scaled));
        setIcon(scaledIcon);

    }

    private URL chooseURL(Cell cell) {
        URL imageUrl = null;
        if (cell.isOpened()) {
            if (cell.isMineHere()) {
                imageUrl = MineButton.class.getResource("/pics/mine" + ".png");
            } else {
                imageUrl = MineButton.class.getResource("/pics/" + cell.getNum() + ".png");
            }
        } else if (cell.isFlagsSet()) {
            imageUrl = MineButton.class.getResource("/pics/flag.png");

        } else {
            imageUrl = MineButton.class.getResource("/pics/unopened.png");

        }

        return imageUrl;
    }
}
