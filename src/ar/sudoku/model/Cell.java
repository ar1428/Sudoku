package ar.sudoku.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by andrewro on 2014-11-26.
 */
public class Cell {
    private int value;
    private List<Integer> candidates;

    public List<Integer> getCandidates() {
        return candidates;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        this.candidates.clear();
    }

    public void removeCandidate(int number) {
        this.candidates.remove(number);
    }

    public Cell() {
        this.candidates = new LinkedList<Integer>();
        for (int number = 1; number <= 9; number++) {
            candidates.add(number);
        }
    }
}
