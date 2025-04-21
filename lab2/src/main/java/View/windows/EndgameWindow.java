package View.windows;

import View.windows.Leaderboard.LeaderboardWindow;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndgameWindow extends JFrame {

    Controller controller;


    public EndgameWindow(Controller ctrlr, int time, LeaderboardWindow leaderboard) {

        new JFrame("Про Мин Нет");
        setSize(350, 400);
        setLayout(new GridLayout(2, 2, 10, 10));
        JLabel label1 = new JLabel("Ваше время прохождения:" + time + "секунд");
        JLabel label2 = new JLabel("Введите ник");
        JTextField field1 = new JTextField();
        add(label1);
        add(label2);
        add(field1);

        setLocationRelativeTo(null);
        setVisible(true);
        JButton confirmButton = new JButton("Подтвердить");

        add(label1);
        add(field1);
        add(confirmButton);
        pack();
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nic = (field1.getText());
                leaderboard.addRecord(nic, time);
                dispose();

            }
        });


    }


}
