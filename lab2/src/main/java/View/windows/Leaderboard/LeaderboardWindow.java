package View.windows.Leaderboard;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Leaderboard extends JFrame {
    private final String FILE_NAME = "leaderboard.txt";

    private JTable table;
    private DefaultTableModel tableModel;


    private void createAndShowGUI() {
        new JFrame("Таблица рекордов");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Панель для ввода данных
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel nameLabel = new JLabel("Ник игрока:");
        JTextField nameField = new JTextField();
        JLabel timeLabel = new JLabel("Время (сек):");
        JTextField timeField = new JTextField();

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(timeLabel);
        inputPanel.add(timeField);

        // Кнопка добавления
        JButton addButton = new JButton("Добавить результат");
        addButton.addActionListener(e -> {
            try {
                String nickname = nameField.getText();
                int time = Integer.parseInt(timeField.getText());
                addRecord(nickname, time);
                nameField.setText("");
                timeField.setText("");
                loadLeaderboard();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Пожалуйста, введите корректное время!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Таблица рекордов
        tableModel = new DefaultTableModel(new Object[]{"Место", "Ник", "Время (сек)"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Добавляем компоненты на форму
        add(inputPanel, BorderLayout.NORTH);
        add(addButton, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void addRecord(String nickname, int time) {
        List<PlayerRecord> records = readRecords();
        records.add(new PlayerRecord(nickname, time));
        Collections.sort(records);
        writeRecords(records);
    }

    private List<PlayerRecord> readRecords() {
        List<PlayerRecord> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String nickname = parts[0];
                    int time = Integer.parseInt(parts[1]);
                    records.add(new PlayerRecord(nickname, time));
                }
            }
        } catch (IOException e) {
            // Файл не существует или ошибка чтения - вернем пустой список
        }

        return records;
    }

    private void writeRecords(List<PlayerRecord> records) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (PlayerRecord record : records) {
                writer.println(record.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Ошибка при сохранении рекордов!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadLeaderboard() {
        List<PlayerRecord> records = readRecords();
        tableModel.setRowCount(0); // Очищаем таблицу

        int place = 1;
        for (PlayerRecord record : records) {
            tableModel.addRow(new Object[]{place++, record.nickname, record.time});
        }
    }
}
