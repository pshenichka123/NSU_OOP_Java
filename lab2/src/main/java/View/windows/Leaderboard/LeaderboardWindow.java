package View.windows.Leaderboard;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class LeaderboardWindow extends JFrame {
    private final String FILE_NAME = "leaderboard.txt";

    private JTable table;
    private DefaultTableModel tableModel;


    public LeaderboardWindow() {
        super("Таблица рекордов"); // Используем super вместо создания нового JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Создаем модель таблицы с заголовками колонок
        tableModel = new DefaultTableModel(new Object[]{"Место", "Ник", "Время (сек)"}, 0);
        table = new JTable(tableModel);
        loadLeaderboard();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

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
        int place = 1;
        for (PlayerRecord record : records) {
            tableModel.addRow(new Object[]{place++, record.nickname, record.time});
        }
    }
}
