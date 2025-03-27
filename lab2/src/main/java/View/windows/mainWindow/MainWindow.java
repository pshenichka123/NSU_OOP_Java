package View.windows.mainWindow;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {


    MenuPanel menuPanel;
    GamePanel gamePanel;
    public  MainWindow(){

        new JFrame("Мин Нет");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        menuPanel=new MenuPanel();

        add(menuPanel,BorderLayout.NORTH);
        setSize(600, 500);
        setLocationRelativeTo(null);
    }
    get()

}
