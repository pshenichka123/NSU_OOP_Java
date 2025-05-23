package View.windows.mainWindow;

import Model.Minefield.Minefield;
import Model.Model;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    MenuPanel menuPanel;
    GamePanel gamePanel;

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void stopTimer() {
        gamePanel.stopTimer();
    }

    public void setGamePanel(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        setLocationRelativeTo(null);
        setResizable(true);
        revalidate();
        repaint();
        pack();
    }


    public MainWindow(Minefield minefield) {

        new JFrame("Мин Нет");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        menuPanel = new MenuPanel();
        gamePanel = new GamePanel(minefield);
        add(menuPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setResizable(true);
        revalidate();
        repaint();
        pack();

    }


    public void update(Model model) {
        gamePanel.update(model);

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
