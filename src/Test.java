import ar.sudoku.GridBuilder;
import ar.sudoku.model.Grid;

/**
 * Created by andrewro on 2014-11-26.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Grid grid = GridBuilder.fromString(
                ".1.9....4\n" +
                "6.5..3.2.\n" +
                "...25....\n" +
                "..1..94..\n" +
                ".96.7.38.\n" +
                "..73.....\n" +
                "....32...\n" +
                ".3....8.1\n" +
                "1....7.5.\n"
        );

        grid.print_grid();
    }
}
