package ar.sudoku.strategy;

import ar.sudoku.model.Grid;
import ar.sudoku.model.Group;

/**
 * Created by andrewro on 2014-11-26.
 */
public abstract class GroupedStrategy implements SolverStrategy {
    @Override
    public void solve(Grid grid) {
        for (Group group: grid.getColumns()) { processGroup(group); }
        for (Group group: grid.getRows())    { processGroup(group); }
        for (Group group: grid.getSquares()) { processGroup(group); }
    }

    public abstract void processGroup(Group group);
}
