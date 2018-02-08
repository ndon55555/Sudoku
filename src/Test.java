import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<FilledCell> filledCells = new HashSet<>();

        filledCells.add(new FilledCell(new Position(0, 0), SudokuValue.FIVE));
        filledCells.add(new FilledCell(new Position(0, 1), SudokuValue.THREE));
        filledCells.add(new FilledCell(new Position(0, 4), SudokuValue.SEVEN));

        filledCells.add(new FilledCell(new Position(1, 0), SudokuValue.SIX));
        filledCells.add(new FilledCell(new Position(1, 3), SudokuValue.ONE));
        filledCells.add(new FilledCell(new Position(1, 4), SudokuValue.NINE));
        filledCells.add(new FilledCell(new Position(1, 5), SudokuValue.FIVE));

        filledCells.add(new FilledCell(new Position(2, 1), SudokuValue.NINE));
        filledCells.add(new FilledCell(new Position(2, 2), SudokuValue.EIGHT));
        filledCells.add(new FilledCell(new Position(2, 7), SudokuValue.SIX));

        filledCells.add(new FilledCell(new Position(3, 0), SudokuValue.EIGHT));
        filledCells.add(new FilledCell(new Position(3, 4), SudokuValue.SIX));
        filledCells.add(new FilledCell(new Position(3, 8), SudokuValue.THREE));

        filledCells.add(new FilledCell(new Position(4, 0), SudokuValue.FOUR));
        filledCells.add(new FilledCell(new Position(4, 3), SudokuValue.EIGHT));
        filledCells.add(new FilledCell(new Position(4, 5), SudokuValue.THREE));
        filledCells.add(new FilledCell(new Position(4, 8), SudokuValue.ONE));

        filledCells.add(new FilledCell(new Position(5, 0), SudokuValue.SEVEN));
        filledCells.add(new FilledCell(new Position(5, 4), SudokuValue.TWO));
        filledCells.add(new FilledCell(new Position(5, 8), SudokuValue.SIX));

        filledCells.add(new FilledCell(new Position(6, 1), SudokuValue.SIX));
        filledCells.add(new FilledCell(new Position(6, 6), SudokuValue.TWO));
        filledCells.add(new FilledCell(new Position(6, 7), SudokuValue.EIGHT));

        filledCells.add(new FilledCell(new Position(7, 3), SudokuValue.FOUR));
        filledCells.add(new FilledCell(new Position(7, 4), SudokuValue.ONE));
        filledCells.add(new FilledCell(new Position(7, 5), SudokuValue.NINE));
        filledCells.add(new FilledCell(new Position(7, 8), SudokuValue.FIVE));

        filledCells.add(new FilledCell(new Position(8, 4), SudokuValue.EIGHT));
        filledCells.add(new FilledCell(new Position(8, 7), SudokuValue.SEVEN));
        filledCells.add(new FilledCell(new Position(8, 8), SudokuValue.NINE));

        Board b = new Board(filledCells);
        System.out.println(b);
        b.solve();
        System.out.println(b);
        System.out.println(b.isValidSolved());
    }
}
