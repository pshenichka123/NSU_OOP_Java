package View.windows;

import javax.swing.*;
import java.awt.*;

public class LeaderboardWindow extends  JFrame {
    public LeaderboardWindow(){
        new JFrame("Про Мин Нет");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        String text="Игра Мин Нет это аналог сапера на windows, " +
                "предлагающий возможность самому выбрать размер поля и количество мин на нём, а также время. " +
                "У вас есть возможность попасть в таблицу рекордов, если ваше прохождение будет достаточно быстрым" ;
        JPanel aboutText=new JPanel(new FlowLayout());
        aboutText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JTextArea jTextArea=new JTextArea(text);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);
        // Добавляем элементы меню
        jTextArea.setFont(new Font(text,Font.BOLD,14));
        jTextArea.setDisabledTextColor(Color.BLACK);
        add(jTextArea,BorderLayout.NORTH);
        setSize(600, 500);
        setLocationRelativeTo(null);
        jTextArea.setEnabled(false);
    }




}
