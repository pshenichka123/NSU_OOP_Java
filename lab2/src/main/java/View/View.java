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
import java.awt.event.*;

public class View {


    Controller controller;


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
                controller.getModel().setGameEnded(false);
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
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            controller.revealCell(finalI, finalJ);
                            mainWindow.update(controller.getModel());
                        }
                        if (SwingUtilities.isRightMouseButton(e)) {
                            controller.changeFlagState(finalI, finalJ);
                            mainWindow.update(controller.getModel());
                        }
                    }
                });


            }
        }


    }


}
