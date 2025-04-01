package View.windows;

import View.View;
import View.windows.mainWindow.MainWindow;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameWindow extends JFrame {

    public NewGameWindow(Controller controller, View view) {


        JFrame frame = new JFrame("Ввод чисел");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLayout(new GridLayout(4, 2, 10, 10)); // 3 строки, 2 колонки, отступы 10px

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
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Проверка ввода (опционально)
                try {
                    int num1 = Integer.parseInt(field1.getText());
                    int num2 = Integer.parseInt(field2.getText());
                    int mines = Integer.parseInt((field3.getText()));
                    frame.dispose();
                    controller.recreateModel(num1, num2, mines);
                    MainWindow newmainWindow = new MainWindow(controller.getModel().getMinefield());
                    view.closeMainWindow();
                    view.setMainWindow(newmainWindow);
                    view.showMainWindow(controller.getModel().getMinefield());
                    view.closeNewGameWindow();
                    view.setListeners();
                    view.setFieldListeners(view.getVisualMinefield());
                    System.out.println("Введенные числа: " + num1 + ", " + num2);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ошибка: введите числа!");
                    return;
                }


            }
        });

        // Добавляем компоненты на форму
        frame.add(label1);
        frame.add(field1);
        frame.add(label2);
        frame.add(field2);
        frame.add(label3);
        frame.add(field3);
        frame.add(new JLabel()); // Пустая ячейка для выравнивания
        frame.add(confirmButton);
        // Центрируем окно и делаем его видимым
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
