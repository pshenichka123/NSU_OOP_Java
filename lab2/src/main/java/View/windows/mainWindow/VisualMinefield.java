package View.windows.mainWindow;

import Model.Minefield.Cell;
import Model.Minefield.Minefield;
import Model.Model;
import View.windows.mainWindow.MineButton.MineButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualMinefield extends JPanel {


    private MineButton[][] mineButtons;
    ActionListener greedListener;

    public VisualMinefield(Minefield minefield) {
        greedListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MineButton mineButton = (MineButton) e.getSource();
            }
        };

        int size1 = minefield.getSize1();
        int size2 = minefield.getSize2();
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        mineButtons = new MineButton[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                gbc.gridx = i;
                gbc.gridy = j;
                Cell cell = minefield.getCell(i, j);
                mineButtons[i][j] = new MineButton(cell);
                add(mineButtons[i][j], gbc);
            }
        }


    }


    public MineButton getMineButton(Integer x, Integer y) {
        return mineButtons[x][y];

    }


    public void update(Model model) {

        showAllField(model.getMinefield());

    }


    private void showAllField(Minefield minefield) {
        int size1 = minefield.getSize1();
        int size2 = minefield.getSize2();
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {

                mineButtons[i][j].update(minefield.getCell(i, j));

            }

        }


    }
};


