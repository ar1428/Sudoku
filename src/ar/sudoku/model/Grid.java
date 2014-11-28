package ar.sudoku.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrewro on 2014-11-26.
 */
public class Grid {
    public static final int GRID_SIZE = 9;
    public static final int SQUARE_SIZE = 3;
    private Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];
    private Group[] rows = new Group[GRID_SIZE];
    private Group[] columns = new Group[GRID_SIZE];
    private Group[][] squares = new Group[SQUARE_SIZE][SQUARE_SIZE];

    public Grid() {
        // build cells
        for (int col = 0; col < GRID_SIZE; col++) {
            List<Cell> column_cells = new LinkedList<Cell>();
            for (int row = 0; row < GRID_SIZE; row++) {
                Cell cell = new Cell();
                column_cells.add(cell);
                this.cells[col][row] = cell;
            }
            columns[col] = new Group(column_cells);
        }

        // build rows
        for (int row = 0; row < GRID_SIZE; row++) {
            List<Cell> row_cells = new LinkedList<Cell>();
            for (int col = 0; col < GRID_SIZE; col++) {
                row_cells.add(this.cells[col][row]);
            }
            rows[row] = new Group(row_cells);
        }

        // build squares
        for (int row = 0; row < SQUARE_SIZE; row++) {
            for (int col = 0; col < SQUARE_SIZE; col++) {
                squares[col][row] = new Group();
            }
        }
        for (int row = 0; row < GRID_SIZE; row++) {
           int square_row = (row + 1) / SQUARE_SIZE - 1;
           for (int col = 0; col < GRID_SIZE; col++) {
              int square_col = (col + 1) / SQUARE_SIZE - 1;
              squares[square_col][square_row].getCells().add(cells[col][row]);
           }
        }
    }

    public Cell getCell(int col, int row) {
        return cells[col][row];
    }

    public List<Group> getRows() {
        return Arrays.asList(rows);
    }

    public List<Group> getColumns() {
        return Arrays.asList(columns);
    }

    public List<Group> getSquares() {
        ArrayList<Group> result = new ArrayList<Group>();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                result.add(squares[i][j]);
            }
        }
        return result;
    }

    public boolean isComplete() {
        for (int col = 0; col < GRID_SIZE; col++) {
            for (int row = 0; row < GRID_SIZE; row++) {
                if (this.cells[col][row].getValue() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void print_grid() {
        // TODO: Respect the GRID_SIZE
        System.out.println("+---+---+---+");

        for (int row = 0; row < GRID_SIZE; row++) {
            System.out.print("|");
            for (int col = 0; col < GRID_SIZE; col++) {
                int value = cells[col][row].getValue();
                System.out.print(value == 0 ? " " : value);
                if ((col+1) % 3 == 0) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((row+1) % 3 == 0) {
                System.out.println("+---+---+---+");
            }
        }

    }
}
