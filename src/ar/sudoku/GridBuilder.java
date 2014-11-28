package ar.sudoku;

import ar.sudoku.model.Grid;

/**
 * Created by andrewro on 2014-11-26.
 */


public class GridBuilder {

    public static Grid fromString(String gridDefinition) throws InvalidSudokuGrid {
        Grid grid = new Grid();
        String[] lines = gridDefinition.split("\n");
        if (lines.length != ar.sudoku.model.Grid.GRID_SIZE) {
            throw new InvalidSudokuGrid("too many lines in input");
        }
        int row = 0;
        for (String line: lines) {
            if (line.length() != ar.sudoku.model.Grid.GRID_SIZE) {
                throw new InvalidSudokuGrid("line is too long: [" + line + "]");
            }
            char[] line_chars = line.toCharArray();
            for (int col = 0; col < ar.sudoku.model.Grid.GRID_SIZE; col++) {
                int number = 0;
                if (line_chars[col] != '.') {
                    number = Character.digit(line_chars[col], 10);
                }
                grid.getCell(col, row).setValue(number);
            }

            row++;
        }
        return grid;
    }

    private int getNumberFromStringPosition(String string, int position) {
        return Integer.parseInt(string.substring(position, position));
    }
}
