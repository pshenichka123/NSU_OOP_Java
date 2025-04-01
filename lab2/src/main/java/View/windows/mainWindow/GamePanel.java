package View.windows.mainWindow;

import Model.Minefield.Minefield;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    TimerPanel timerPanel;
    VisualMinefield visualMinefield;

    public GamePanel(Minefield minefield) {
        timerPanel = new TimerPanel();
        setLayout(new BorderLayout());
        visualMinefield = new VisualMinefield(minefield);
        add(visualMinefield, BorderLayout.CENTER);
        add(timerPanel, BorderLayout.NORTH);
    }


    public VisualMinefield getVisualMinefield() {
        return visualMinefield;
    }


    public void update(Model model) {

        visualMinefield.update(model);
    }
}
