package View.windows.mainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerPanel extends JPanel {
    private Timer timer;
    private int seconds = 0;

    TimerPanel() {
        new JPanel();
        JLabel timerLabel = new JLabel("0");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timerLabel);

        // Создаем таймер с интервалом 1000 мс (1 секунда)
        timer = new Timer(1000, new ActionListener() {
            private int seconds = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timerLabel.setText("Секунд: " + seconds);
            }
        });

        // Запускаем таймер


    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public int getTime() {
        return seconds;
    }


}
