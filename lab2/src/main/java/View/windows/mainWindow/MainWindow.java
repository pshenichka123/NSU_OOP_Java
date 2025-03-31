package View.windows.mainWindow;

import Model.Minefield.Minefield;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    MenuPanel menuPanel;
    GamePanel gamePanel;

    public MainWindow(Minefield minefield) {

        new JFrame("Мин Нет");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        menuPanel = new MenuPanel();
        gamePanel = new GamePanel(minefield);
        add(menuPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        setSize(600, 500);
        setLocationRelativeTo(null);
        pack();
        setResizable(false);
    }

    public void update(Minefield minefield) {
        gamePanel.update(minefield);
    }

    public VisualMinefield getVisualMinefield() {
        return gamePanel.getVisualMinefield();
    }

    public JButton getNewGameButton() {
        return menuPanel.getNewGameButton();
    }

    public JButton getExitButton() {
        return menuPanel.getExitButton();
    }

    public JButton getAboutButton() {
        return menuPanel.getAboutButton();
    }

    public JButton getHighScoresButton() {
        return menuPanel.getHighScoresButton();
    }
}
