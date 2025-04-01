package Model.Minefield;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Minefield {
    private Integer size1;
    private Integer size2;

    public Integer getBombCount() {
        return bombCount;
    }

    public void setBombCount(Integer bombCount) {
        this.bombCount = bombCount;
    }

    private Integer bombCount = 10;
    private Cell[][] cells;

    public Integer getSize1() {
        return size1;
    }

    public void setSize1(Integer size1) {
        this.size1 = size1;
    }

    public Integer getSize2() {
        return size2;
    }

    public void setSize2(Integer size2) {
        this.size2 = size2;
    }


    public Cell getCell(Integer size1, Integer size2) {
        return cells[size1][size2];
    }

    public Minefield(Integer[] size, Integer bombCount) {
        setSize1(size[0]);
        setSize2(size[1]);
        cells = new Cell[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                cells[i][j] = new Cell();
            }
        }
        List<Integer> idxWhereMine = sampleWithoutReplacement(bombCount, size[0] * size[1]);
        putBombs(cells, idxWhereMine);
        putNums(cells);

    }


    public static List<Integer> sampleWithoutReplacement(int k, int m) {
        if (k > m) {
            throw new IllegalArgumentException("k cannot be greater than m");
        }
        Random random = new Random();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < k; i++) {
            int j = i + random.nextInt(m - i); // Случайный индекс от i до m-1
            Collections.swap(numbers, i, j);   // Меняем местами
        }
        return numbers.subList(0, k);
    }


    private void putBombs(Cell[][] Cells, List<Integer> mineIdx) {
        for (int idx : mineIdx) {
            int coords[] = {idx % size1, idx / size2};
            cells[coords[0]][coords[1]].setMineHere(true);

        }
    }

    private void putNums(Cell[][] cells) {
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                // Если текущая клетка — бомба, пропускаем
                if (cells[i][j].isMineHere()) {
                    continue;
                }

                int bombCount = 0;

                // Проверяем 8 соседей (включая диагонали)
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        // Пропускаем текущую клетку
                        if (di == 0 && dj == 0) {
                            continue;
                        }

                        int ni = i + di; // Новый индекс строки
                        int nj = j + dj; // Новый индекс столбца

                        // Проверяем, не вышли ли за границы массива
                        if (ni >= 0 && ni < size1 && nj >= 0 && nj < size2) {
                            if (cells[ni][nj].isMineHere()) {
                                bombCount++;
                            }
                        }
                    }
                }

                // Записываем количество бомб вокруг
                cells[i][j].setNum(bombCount);
            }
        }
    }

    public boolean act(int i, int j) {

        Cell cell = cells[i][j];
        if (cell.isFlagsSet()) {
            return false;
        }
        if (cell.isMineHere()) {
            cell.setOpened(true);
            return true;
        }
        cell.setOpened(true);
        //chek opened nearby
        if (cell.getNum() == 0) {
            for (int di = -1; di <= 1; di++) {
                for (int dj = -1; dj <= 1; dj++) {
                    // Пропускаем текущую клетку
                    if (di == 0 && dj == 0) {
                        continue;
                    }

                    int ni = i + di; // Новый индекс строки
                    int nj = j + dj; // Новый индекс столбца

                    // Проверяем, не вышли ли за границы массива
                    if (ni >= 0 && ni < size1 && nj >= 0 && nj < size2) {
                        if (cells[ni][nj].getNum() == 0) {
                            if (!cells[ni][nj].isOpened()) {
                                act(ni, nj);
                            }
                        }
                        cells[ni][nj].setOpened(true);

                    }
                }

            }

        }
        return false;
    }

    public void changeFlagState(int i, int j) {
        Cell cell = cells[i][j];

        cell.setFlagsSet(!cell.isFlagsSet());
    }

    public void setVisible() {
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                cells[i][j].setOpened(true);

            }
        }
    }
}