package ar.sudoku;

/**
 * Created by andrewro on 2014-11-26.
 */
public class InvalidSudokuGrid extends Exception {
    public InvalidSudokuGrid(String message) {
        super(message);
    }
}
