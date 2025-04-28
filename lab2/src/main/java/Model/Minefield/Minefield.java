package Model.Minefield;

import java.util.*;

public class Minefield {
    private Integer size1;
    private Integer size2;
    private Integer bombCount;
    private Cell[][] cells;
    private Integer unopenedCellsCount;
    private Integer FlagCellsCount;

    public Integer getUnopenedCellsCount() {
        return unopenedCellsCount;
    }

    public void setUnopenedCellsCount(Integer unopenedCellsCount) {
        this.unopenedCellsCount = unopenedCellsCount;
    }

    public Integer getFlagCellsCount() {
        return FlagCellsCount;
    }

    public void setFlagCellsCount(Integer flagCellsCount) {
        FlagCellsCount = flagCellsCount;
    }


    public Integer getBombCount() {
        return bombCount;
    }

    public void setBombCount(Integer bombCount) {
        this.bombCount = bombCount;
    }


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
        setBombCount(bombCount);
        setFlagCellsCount(0);
        setUnopenedCellsCount(size1 * size2 - bombCount);
        cells = new Cell[size[0]][size[1]];
        for (int i = 0; i < size[0]; i++) {
            for (int j = 0; j < size[1]; j++) {
                Vector<Integer> coords = new Vector<Integer>();
                coords.add(i);
                coords.add(j);
                cells[i][j] = new Cell(coords);
            }
        }


    }


    public void addSafeMinesOnfield(Integer[] coords) {

        List<Integer> idxWhereMine = sampleWithoutReplacement(bombCount, size1 * size2, coords[0] * size1 + coords[1]);
        putBombs(cells, idxWhereMine);
        putNums(cells);
    }

    public static List<Integer> sampleWithoutReplacement(int k, int m, int guaranteeToBeeFree) {
        if (k > m - 1) {
            throw new IllegalArgumentException("k cannot be greater than m-1 (after exclusion)");
        }
        if (guaranteeToBeeFree < 0 || guaranteeToBeeFree >= m) {
            throw new IllegalArgumentException("guaranteeToBeeFree must be in [0, m-1)");
        }

        Random random = new Random();
        List<Integer> result = new ArrayList<>();

        // Генерируем числа от 0 до m-1, исключая guaranteeToBeeFree
        for (int i = 0; i < k; i++) {
            int next;
            do {
                next = random.nextInt(m);  // Берем случайное число из [0, m-1]
            } while (next == guaranteeToBeeFree || result.contains(next));  // Пропускаем guaranteeToBeeFree и уже выбранные

            result.add(next);
        }

        return result;
    }

    private void putBombs(Cell[][] Cells, List<Integer> mineIdx) {
        for (int idx : mineIdx) {
            int coords[] = {idx % size1, idx / size1};
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

    public void act(int i, int j) {
        Cell cell = cells[i][j];
        if (cell.isMineHere()) {
            cell.setOpened(true);
            return;
        }
        if (cell.isOpened()) {
            return;
        }


        Stack<Cell> stack = new Stack<Cell>();
        if (cell.getNum() == 0) {
            stack.push(cell);
        }
        unopenedCellsCount--;
        cell.setOpened(true);
        while (!stack.isEmpty()) {

            Cell curcell = stack.pop();


            if (curcell.getNum() != 0) {
                continue;
            }
            for (int di = -1; di <= 1; di++) {
                for (int dj = -1; dj <= 1; dj++) {
                    if (di == 0 && dj == 0) {
                        continue;
                    }
                    int ni = curcell.getCoords().get(0) + di; // Новый индекс строки
                    int nj = curcell.getCoords().get(1) + dj; // Новый индекс столбца

                    // Проверяем, не вышли ли за границы массива
                    if (ni >= 0 && ni < size1 && nj >= 0 && nj < size2) {

                        if (cells[ni][nj].isOpened()) {
                            continue;
                        }

                        if (cells[ni][nj].getNum() == 0) {
                            cells[ni][nj].setOpened(true);
                            unopenedCellsCount--;
                            stack.push(cells[ni][nj]);
                            continue;
                        }

                        unopenedCellsCount--;
                        cells[ni][nj].setOpened(true);


                    }
                }

            }
        }


    }

    public void changeFlagState(int i, int j) {
        Cell cell = cells[i][j];

        cell.setFlagsSet(!cell.isFlagsSet());
        if (cell.isFlagsSet()) {
            FlagCellsCount++;
        } else {
            FlagCellsCount--;
        }
    }

    public void setVisible() {
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                cells[i][j].setOpened(true);

            }
        }
    }
}