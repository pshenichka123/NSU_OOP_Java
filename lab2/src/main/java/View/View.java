package View;

import Model.Minefield.Minefield;
import View.windows.AboutWindow;
import View.windows.LeaderboardWindow;
import View.windows.NewGameWindow;
import View.windows.mainWindow.MainWindow;
import View.windows.mainWindow.VisualMinefield;

import javax.swing.*;
import java.awt.*;

public class View {

    AboutWindow aboutWindow;
    NewGameWindow newGameWindow;
    MainWindow mainWindow;
    LeaderboardWindow leaderboardWindow;


    public View(Minefield minefield) {
        mainWindow = new MainWindow(minefield) {
        };
    }


    public void showMainWindow(Minefield minefield) {
        if (mainWindow == null) {
            mainWindow = new MainWindow(minefield);
        }
        mainWindow.setVisible(true);
    }

    public void showAboutWindow() {
        if (aboutWindow == null) {
            aboutWindow = new AboutWindow();
        }
        aboutWindow.setVisible(true);
    }

    public void showNewGameWindow() {
        if (newGameWindow == null) {
            newGameWindow = new NewGameWindow();
        }
        newGameWindow.setVisible(true);
    }

    public void showLeaderboardWindow() {
        if (leaderboardWindow == null) {
            leaderboardWindow = new LeaderboardWindow();
        }
        leaderboardWindow.setVisible(true);
    }

    public void showAll(Minefield minefield) {
        showAboutWindow();
        showMainWindow(minefield);
        showNewGameWindow();
        showLeaderboardWindow();
    }

    public void closeMainWindow() {
        if (mainWindow != null) mainWindow.dispose();
    }

    public void closeAboutWindow() {
        if (aboutWindow != null) aboutWindow.dispose();
    }

    public void closeNewGameWindow() {
        if (newGameWindow != null) newGameWindow.dispose();
    }

    public void closeAll() {
        closeMainWindow();
        closeAboutWindow();
        closeNewGameWindow();
    }


    public JButton getNewGameButton() {
        return mainWindow.getNewGameButton();
    }

    public JButton getExitButton() {
        return mainWindow.getExitButton();
    }

    public JButton getAboutButton() {
        return mainWindow.getAboutButton();
    }

    public JButton getHighScoresButton() {
        return mainWindow.getHighScoresButton();
    }

    public VisualMinefield getVisualMinefield() {
        return mainWindow.getVisualMinefield();
    }

}
