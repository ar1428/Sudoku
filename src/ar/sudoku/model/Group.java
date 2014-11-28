package ar.sudoku.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrewro on 2014-11-26.
 */
public class Group {
    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    private List<Cell> cells;

    public Group() {
        this(null);
    }

    public Group(List<Cell> cells) {
        if (cells == null) {
            this.cells = new LinkedList<Cell>();
        } else {
            this.cells = cells;
        }
    }
}
