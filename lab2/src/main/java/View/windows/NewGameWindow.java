package View.windows;

import View.View;
import View.windows.mainWindow.MainWindow;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameWindow extends JFrame {


    // Первое поле с подписью
    JLabel label1 = new JLabel("По горизонтали:");
    JTextField field1 = new JTextField();

    // Второе поле с подписью
    JLabel label2 = new JLabel("По вертикали:");
    JTextField field2 = new JTextField();
    JLabel label3 = new JLabel("Количество мин:");
    JTextField field3 = new JTextField();
    // Кнопка подтверждения
    JButton confirmButton = new JButton("Подтвердить");

    public NewGameWindow(Controller controller, View view) {
        new JFrame("Ввод чисел");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 300);
        setLayout(new GridLayout(4, 2, 10, 10)); // 3 строки, 2 колонки, отступы 10px

        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(label3);
        add(field3);
        add(new JLabel()); // Пустая ячейка для выравнивания
        add(confirmButton);
        // Центрируем окно и делаем его видимым
        setLocationRelativeTo(null);
        setVisible(true);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int num1 = Integer.parseInt(field1.getText());
                int num2 = Integer.parseInt(field2.getText());
                int mines = Integer.parseInt((field3.getText()));
                controller.recreateModel(num1, num2, mines);
                view.getMainWindow().getGamePanel().newMineField(controller.getModel().getMinefield());
                view.setListeners();
                view.setFieldListeners(view.getVisualMinefield());
                view.getMainWindow().update(controller.getModel());
                view.getMainWindow().pack();

                dispose();

            }
        });

        // Добавляем компоненты на форму

    }


}
