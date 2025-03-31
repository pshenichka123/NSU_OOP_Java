package View;

import Model.Minefield.Minefield;
import Model.Model;
import View.windows.AboutWindow;
import View.windows.LeaderboardWindow;
import View.windows.NewGameWindow;
import View.windows.mainWindow.MainWindow;
import View.windows.mainWindow.VisualMinefield;
import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {


    Model model;
    Controller controller;


    AboutWindow aboutWindow;
    NewGameWindow newGameWindow;
    MainWindow mainWindow;
    LeaderboardWindow leaderboardWindow;


    public View() {

        model = new Model();
        mainWindow = new MainWindow(model.getMinefield());
        controller = new Controller(model);
        setListeners();
        setFieldListeners(getVisualMinefield());
    }

    public void start() {
        showMainWindow(model.getMinefield());

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


    private void setListeners() {

        getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setGameRunning(false);
                closeAll();
            }
        });
        getAboutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAboutWindow();
            }
        });
        getHighScoresButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void setFieldListeners(VisualMinefield visualMinefield) {
        for (int i = 0; i < visualMinefield.getSize1(); i++) {
            for (int j = 0; j < visualMinefield.getSize2(); j++) {
                JButton button = visualMinefield.getMineButton(i, j);
                int finalI = i;
                int finalJ = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        controller.buttonPressed(finalI, finalJ);
                        mainWindow = new MainWindow(model.getMinefield());
                    }
                });


            }
        }


    }


}
