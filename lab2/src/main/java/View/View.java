package View;

import View.windows.AboutWindow;
import View.windows.EndgameWindow;
import View.windows.Leaderboard.LeaderboardWindow;
import View.windows.NewGameWindow;
import View.windows.mainWindow.MainWindow;
import View.windows.mainWindow.VisualMinefield;
import controller.Controller;

import javax.swing.*;
import java.awt.event.*;

public class View {


    Controller controller;
    LeaderboardWindow leaderboard;

    AboutWindow aboutWindow;
    NewGameWindow newGameWindow;

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    MainWindow mainWindow;
    LeaderboardWindow leaderboardWindow;


    public View() {


        controller = new Controller();
        mainWindow = new MainWindow(controller.getModel().getMinefield());
        leaderboard = new LeaderboardWindow();
        setListeners();
        setFieldListeners(getVisualMinefield());
    }

    public void start() {
        showMainWindow();

    }

    public void showMainWindow() {
        if (mainWindow == null) {
            mainWindow = new MainWindow(controller.getModel().getMinefield());
        }
        mainWindow.setVisible(true);
    }

    public void showAboutWindow() {
        if (aboutWindow == null) {
            aboutWindow = new AboutWindow();
        }
        aboutWindow.setVisible(true);
    }

    private void showNewGameWindow() {
        if (newGameWindow == null) {
            newGameWindow = new NewGameWindow(controller, this);
        }
        newGameWindow.setVisible(true);
    }

    public void showLeaderboardWindow() {
        if (leaderboardWindow == null) {
            leaderboardWindow = new LeaderboardWindow();
        }
        leaderboardWindow.setVisible(true);
    }

    public void showAll() {
        showAboutWindow();
        showMainWindow();
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


    public void setListeners() {

        getNewGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewGameWindow();

            }
        });
        getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                showLeaderboardWindow();

            }
        });
    }


    public void setFieldListeners(VisualMinefield visualMinefield) {
        int size1 = controller.getModel().getMinefield().getSize1();
        int size2 = controller.getModel().getMinefield().getSize2();
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                JButton button = visualMinefield.getMineButton(i, j);
                int finalI = i;
                int finalJ = j;

                button.addMouseListener(new MouseAdapter() {


                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (!controller.getModel().isIsgamestarted()) {
                            controller.getModel().getMinefield().addSafeMinesOnfield(new Integer[]{finalI, finalJ});
                            controller.getModel().setIsgamestarted(true);
                        }

                        if (SwingUtilities.isLeftMouseButton(e)) {
                            if (controller.getModel().getMinefield().getCell(finalI, finalJ).isFlagsSet()) {
                                return;
                            }
                            controller.revealCell(finalI, finalJ);
                            mainWindow.update(controller.getModel());


                        }
                        if (SwingUtilities.isRightMouseButton(e)) {
                            controller.changeFlagState(finalI, finalJ);
                            mainWindow.update(controller.getModel());
                        }
                        if (controller.getModel().isIsgamerwon()) {
                            mainWindow.getGamePanel().getVisualMinefield();
                            showEndGameWindow(controller, mainWindow.getGamePanel().getTime());

                            mainWindow.stopTimer();
                        }
                        if (controller.getModel().isIsgamerlost()) {
                            mainWindow.stopTimer();
                        }
                    }
                });

            }
        }


    }

    private void showEndGameWindow(Controller controller, int time) {
        EndgameWindow endgameWindow = new EndgameWindow(controller, time, leaderboard);
    }


}
