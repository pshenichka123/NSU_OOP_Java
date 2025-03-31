package View.windows.mainWindow;

import Model.Minefield.Minefield;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    VisualMinefield visualMinefield;

    public GamePanel(Minefield minefield) {
        setLayout(new BorderLayout());
        visualMinefield = new VisualMinefield(minefield);
        add(visualMinefield, BorderLayout.CENTER);

    }


    public VisualMinefield getVisualMinefield() {
        return visualMinefield;
    }


    public void update(Minefield minefield) {

        visualMinefield.update(minefield);
    }
}
