package View.windows.mainWindow;

import View.buttons.AboutButton;
import View.buttons.ExitButton;
import View.buttons.HighScoresButton;
import View.buttons.NewGameButton;
import View.windows.AboutWindow;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    AboutButton aboutButton;
    ExitButton exitButton;

    public HighScoresButton getHighScoresButton() {
        return highScoresButton;
    }

    public AboutButton getAboutButton() {
        return aboutButton;
    }

    public ExitButton getExitButton() {
        return exitButton;
    }

    public NewGameButton getNewGameButton() {
        return newGameButton;
    }

    HighScoresButton highScoresButton;
    NewGameButton newGameButton;

    MenuPanel(){
        new JPanel(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(newGameButton= new NewGameButton());
        add(aboutButton=new AboutButton());
        add(exitButton=new ExitButton());
        add(highScoresButton=new HighScoresButton());

    }
}
