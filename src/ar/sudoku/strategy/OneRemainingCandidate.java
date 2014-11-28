package ar.sudoku.strategy;

import ar.sudoku.model.Cell;
import ar.sudoku.model.Grid;

/**
 * Created by andrewro on 2014-11-26.
 */
public class OneRemainingCandidate implements SolverStrategy {
    @Override
    public void solve(Grid grid) {

    }

    private void processCell(Cell cell) {
        if (cell.getValue()== 0 && cell.getCandidates().size() == 1) {
            cell.setValue(cell.getCandidates().get(0));
        }
    }
}
