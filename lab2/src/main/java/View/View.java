package View;

import View.buttons.AboutButton;
import View.buttons.ExitButton;
import View.buttons.HighScoresButton;
import View.buttons.NewGameButton;
import View.windows.AboutWindow;
import View.windows.LeaderboardWindow;
import View.windows.NewGameWindow;
import View.windows.mainWindow.MainWindow;

import javax.swing.*;
import java.awt.*;

public  class View {

    AboutWindow aboutWindow;
    NewGameWindow newGameWindow;
    MainWindow mainWindow;
    LeaderboardWindow leaderboardWindow;


    public View() {
        mainWindow = new MainWindow(){};
    }




    public void showMainWindow(){mainWindow.show();}
    public  void  showAboutWindow(){aboutWindow.show();}
    public  void showNewGameWindow(){newGameWindow.show();}
    public void showLeaderboardWindow(){leaderboardWindow.show();}
    public void showAll(){
        showAboutWindow();
        showMainWindow();
        showNewGameWindow();
        showLeaderboardWindow();
    }
    public void closeAll(){}



    public Button getNewGameButton() {
    mainWindow.get
    }

    public Button getExitButton() {
    }

    public Button getAboutButton() {
    }

    public Button getHighScoresButton() {
    }
}
