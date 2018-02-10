import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        // Easy
        Set<FilledCell> filledCells1 = new HashSet<>();

        filledCells1.add(new FilledCell(new Position(0, 0), SudokuValue.FIVE));
        filledCells1.add(new FilledCell(new Position(0, 1), SudokuValue.THREE));
        filledCells1.add(new FilledCell(new Position(0, 4), SudokuValue.SEVEN));

        filledCells1.add(new FilledCell(new Position(1, 0), SudokuValue.SIX));
        filledCells1.add(new FilledCell(new Position(1, 3), SudokuValue.ONE));
        filledCells1.add(new FilledCell(new Position(1, 4), SudokuValue.NINE));
        filledCells1.add(new FilledCell(new Position(1, 5), SudokuValue.FIVE));

        filledCells1.add(new FilledCell(new Position(2, 1), SudokuValue.NINE));
        filledCells1.add(new FilledCell(new Position(2, 2), SudokuValue.EIGHT));
        filledCells1.add(new FilledCell(new Position(2, 7), SudokuValue.SIX));

        filledCells1.add(new FilledCell(new Position(3, 0), SudokuValue.EIGHT));
        filledCells1.add(new FilledCell(new Position(3, 4), SudokuValue.SIX));
        filledCells1.add(new FilledCell(new Position(3, 8), SudokuValue.THREE));

        filledCells1.add(new FilledCell(new Position(4, 0), SudokuValue.FOUR));
        filledCells1.add(new FilledCell(new Position(4, 3), SudokuValue.EIGHT));
        filledCells1.add(new FilledCell(new Position(4, 5), SudokuValue.THREE));
        filledCells1.add(new FilledCell(new Position(4, 8), SudokuValue.ONE));

        filledCells1.add(new FilledCell(new Position(5, 0), SudokuValue.SEVEN));
        filledCells1.add(new FilledCell(new Position(5, 4), SudokuValue.TWO));
        filledCells1.add(new FilledCell(new Position(5, 8), SudokuValue.SIX));

        filledCells1.add(new FilledCell(new Position(6, 1), SudokuValue.SIX));
        filledCells1.add(new FilledCell(new Position(6, 6), SudokuValue.TWO));
        filledCells1.add(new FilledCell(new Position(6, 7), SudokuValue.EIGHT));

        filledCells1.add(new FilledCell(new Position(7, 3), SudokuValue.FOUR));
        filledCells1.add(new FilledCell(new Position(7, 4), SudokuValue.ONE));
        filledCells1.add(new FilledCell(new Position(7, 5), SudokuValue.NINE));
        filledCells1.add(new FilledCell(new Position(7, 8), SudokuValue.FIVE));

        filledCells1.add(new FilledCell(new Position(8, 4), SudokuValue.EIGHT));
        filledCells1.add(new FilledCell(new Position(8, 7), SudokuValue.SEVEN));
        filledCells1.add(new FilledCell(new Position(8, 8), SudokuValue.NINE));

        Board b1 = new Board(filledCells1);
        System.out.println(b1);
        long start1 = System.nanoTime();
        b1.solve();
        long end1 = System.nanoTime();
        System.out.println(b1);
        System.out.println("Took " + (end1 - start1) / 1000000000.0 + " seconds to solve.");
        System.out.println(b1.isValid());

        // Medium
        Set<FilledCell> filledCells2 = new HashSet<>();

        filledCells2.add(new FilledCell(new Position(0, 2), SudokuValue.SEVEN));
        filledCells2.add(new FilledCell(new Position(0, 3), SudokuValue.ONE));
        filledCells2.add(new FilledCell(new Position(0, 4), SudokuValue.TWO));
        filledCells2.add(new FilledCell(new Position(0, 8), SudokuValue.SIX));

        filledCells2.add(new FilledCell(new Position(1, 0), SudokuValue.ONE));
        filledCells2.add(new FilledCell(new Position(1, 1), SudokuValue.FOUR));
        filledCells2.add(new FilledCell(new Position(1, 2), SudokuValue.TWO));

        filledCells2.add(new FilledCell(new Position(2, 3), SudokuValue.FIVE));
        filledCells2.add(new FilledCell(new Position(2, 7), SudokuValue.ONE));

        filledCells2.add(new FilledCell(new Position(3, 1), SudokuValue.ONE));
        filledCells2.add(new FilledCell(new Position(3, 2), SudokuValue.EIGHT));
        filledCells2.add(new FilledCell(new Position(3, 3), SudokuValue.THREE));
        filledCells2.add(new FilledCell(new Position(3, 8), SudokuValue.FOUR));

        filledCells2.add(new FilledCell(new Position(4, 1), SudokuValue.FIVE));
        filledCells2.add(new FilledCell(new Position(4, 2), SudokuValue.SIX));
        filledCells2.add(new FilledCell(new Position(4, 3), SudokuValue.FOUR));
        filledCells2.add(new FilledCell(new Position(4, 5), SudokuValue.EIGHT));
        filledCells2.add(new FilledCell(new Position(4, 6), SudokuValue.THREE));
        filledCells2.add(new FilledCell(new Position(4, 7), SudokuValue.SEVEN));

        filledCells2.add(new FilledCell(new Position(5, 0), SudokuValue.SEVEN));
        filledCells2.add(new FilledCell(new Position(5, 5), SudokuValue.TWO));
        filledCells2.add(new FilledCell(new Position(5, 6), SudokuValue.EIGHT));
        filledCells2.add(new FilledCell(new Position(5, 7), SudokuValue.FIVE));

        filledCells2.add(new FilledCell(new Position(6, 1), SudokuValue.TWO));
        filledCells2.add(new FilledCell(new Position(6, 5), SudokuValue.SEVEN));

        filledCells2.add(new FilledCell(new Position(7, 6), SudokuValue.SIX));
        filledCells2.add(new FilledCell(new Position(7, 7), SudokuValue.TWO));
        filledCells2.add(new FilledCell(new Position(7, 8), SudokuValue.FIVE));

        filledCells2.add(new FilledCell(new Position(8, 0), SudokuValue.SIX));
        filledCells2.add(new FilledCell(new Position(8, 4), SudokuValue.FIVE));
        filledCells2.add(new FilledCell(new Position(8, 5), SudokuValue.ONE));
        filledCells2.add(new FilledCell(new Position(8, 6), SudokuValue.FOUR));

        Board b2 = new Board(filledCells2);
        System.out.println(b2);
        long start2 = System.nanoTime();
        b2.solve();
        long end2 = System.nanoTime();
        System.out.println(b2);
        System.out.println("Took " + (end2 - start2) / 1000000000.0 + " seconds to solve.");
        System.out.println(b2.isValid());

        // Hard
        Set<FilledCell> filledCells3 = new HashSet<>();

        filledCells3.add(new FilledCell(new Position(0, 4), SudokuValue.SEVEN));
        filledCells3.add(new FilledCell(new Position(0, 6), SudokuValue.NINE));
        filledCells3.add(new FilledCell(new Position(0, 7), SudokuValue.FIVE));

        filledCells3.add(new FilledCell(new Position(1, 2), SudokuValue.THREE));
        filledCells3.add(new FilledCell(new Position(1, 3), SudokuValue.SIX));
        filledCells3.add(new FilledCell(new Position(1, 6), SudokuValue.EIGHT));
        filledCells3.add(new FilledCell(new Position(1, 7), SudokuValue.SEVEN));

        filledCells3.add(new FilledCell(new Position(2, 1), SudokuValue.SIX));
        filledCells3.add(new FilledCell(new Position(2, 4), SudokuValue.EIGHT));
        filledCells3.add(new FilledCell(new Position(2, 8), SudokuValue.TWO));

        filledCells3.add(new FilledCell(new Position(3, 3), SudokuValue.EIGHT));
        filledCells3.add(new FilledCell(new Position(3, 7), SudokuValue.ONE));
        filledCells3.add(new FilledCell(new Position(3, 8), SudokuValue.SEVEN));

        filledCells3.add(new FilledCell(new Position(4, 1), SudokuValue.FIVE));
        filledCells3.add(new FilledCell(new Position(4, 7), SudokuValue.TWO));

        filledCells3.add(new FilledCell(new Position(5, 0), SudokuValue.THREE));
        filledCells3.add(new FilledCell(new Position(5, 1), SudokuValue.SEVEN));
        filledCells3.add(new FilledCell(new Position(5, 5), SudokuValue.FIVE));

        filledCells3.add(new FilledCell(new Position(6, 0), SudokuValue.TWO));
        filledCells3.add(new FilledCell(new Position(6, 4), SudokuValue.FOUR));
        filledCells3.add(new FilledCell(new Position(6, 7), SudokuValue.THREE));

        filledCells3.add(new FilledCell(new Position(7, 1), SudokuValue.FOUR));
        filledCells3.add(new FilledCell(new Position(7, 2), SudokuValue.ONE));
        filledCells3.add(new FilledCell(new Position(7, 5), SudokuValue.EIGHT));
        filledCells3.add(new FilledCell(new Position(7, 6), SudokuValue.SEVEN));

        filledCells3.add(new FilledCell(new Position(8, 1), SudokuValue.THREE));
        filledCells3.add(new FilledCell(new Position(8, 2), SudokuValue.FIVE));
        filledCells3.add(new FilledCell(new Position(8, 4), SudokuValue.NINE));

        Board b3 = new Board(filledCells3);
        System.out.println(b3);
        long start3 = System.nanoTime();
        b3.solve();
        long end3 = System.nanoTime();
        System.out.println(b3);
        System.out.println("Took " + (end3 - start3) / 1000000000.0 + " seconds to solve.");
        System.out.println(b3.isValid());

        // Evil
        Set<FilledCell> filledCells4 = new HashSet<>();

        filledCells4.add(new FilledCell(new Position(0, 2), SudokuValue.SEVEN));
        filledCells4.add(new FilledCell(new Position(0, 8), SudokuValue.EIGHT));

        filledCells4.add(new FilledCell(new Position(1, 3), SudokuValue.FOUR));
        filledCells4.add(new FilledCell(new Position(1, 6), SudokuValue.FIVE));
        filledCells4.add(new FilledCell(new Position(1, 8), SudokuValue.ONE));

        filledCells4.add(new FilledCell(new Position(2, 2), SudokuValue.FIVE));
        filledCells4.add(new FilledCell(new Position(2, 5), SudokuValue.NINE));
        filledCells4.add(new FilledCell(new Position(2, 6), SudokuValue.SIX));
        filledCells4.add(new FilledCell(new Position(2, 7), SudokuValue.TWO));

        filledCells4.add(new FilledCell(new Position(3, 0), SudokuValue.ONE));
        filledCells4.add(new FilledCell(new Position(3, 4), SudokuValue.SIX));

        filledCells4.add(new FilledCell(new Position(4, 1), SudokuValue.TWO));
        filledCells4.add(new FilledCell(new Position(4, 4), SudokuValue.SEVEN));
        filledCells4.add(new FilledCell(new Position(4, 7), SudokuValue.ONE));

        filledCells4.add(new FilledCell(new Position(5, 4), SudokuValue.TWO));
        filledCells4.add(new FilledCell(new Position(5, 8), SudokuValue.THREE));

        filledCells4.add(new FilledCell(new Position(6, 1), SudokuValue.SIX));
        filledCells4.add(new FilledCell(new Position(6, 2), SudokuValue.ONE));
        filledCells4.add(new FilledCell(new Position(6, 3), SudokuValue.FIVE));
        filledCells4.add(new FilledCell(new Position(6, 6), SudokuValue.THREE));

        filledCells4.add(new FilledCell(new Position(7, 0), SudokuValue.SEVEN));
        filledCells4.add(new FilledCell(new Position(7, 2), SudokuValue.EIGHT));
        filledCells4.add(new FilledCell(new Position(7, 5), SudokuValue.SIX));

        filledCells4.add(new FilledCell(new Position(8, 0), SudokuValue.THREE));
        filledCells4.add(new FilledCell(new Position(8, 6), SudokuValue.ONE));

        Board b4 = new Board(filledCells4);
        System.out.println(b4);
        long start4 = System.nanoTime();
        b4.solve();
        long end4 = System.nanoTime();
        System.out.println(b4);
        System.out.println("Took " + (end4 - start4) / 1000000000.0 + " seconds to solve.");
        System.out.println(b4.isValid());

        // Hardest Sudoku
        Set<FilledCell> filledCells5 = new HashSet<>();

        filledCells5.add(new FilledCell(new Position(0, 0), SudokuValue.EIGHT));

        filledCells5.add(new FilledCell(new Position(1, 2), SudokuValue.THREE));
        filledCells5.add(new FilledCell(new Position(1, 3), SudokuValue.SIX));

        filledCells5.add(new FilledCell(new Position(2, 1), SudokuValue.SEVEN));
        filledCells5.add(new FilledCell(new Position(2, 4), SudokuValue.NINE));
        filledCells5.add(new FilledCell(new Position(2, 6), SudokuValue.TWO));

        filledCells5.add(new FilledCell(new Position(3, 1), SudokuValue.FIVE));
        filledCells5.add(new FilledCell(new Position(3, 5), SudokuValue.SEVEN));

        filledCells5.add(new FilledCell(new Position(4, 4), SudokuValue.FOUR));
        filledCells5.add(new FilledCell(new Position(4, 5), SudokuValue.FIVE));
        filledCells5.add(new FilledCell(new Position(4, 6), SudokuValue.SEVEN));

        filledCells5.add(new FilledCell(new Position(5, 3), SudokuValue.ONE));
        filledCells5.add(new FilledCell(new Position(5, 7), SudokuValue.THREE));

        filledCells5.add(new FilledCell(new Position(6, 2), SudokuValue.ONE));
        filledCells5.add(new FilledCell(new Position(6, 7), SudokuValue.SIX));
        filledCells5.add(new FilledCell(new Position(6, 8), SudokuValue.EIGHT));

        filledCells5.add(new FilledCell(new Position(7, 2), SudokuValue.EIGHT));
        filledCells5.add(new FilledCell(new Position(7, 3), SudokuValue.FIVE));
        filledCells5.add(new FilledCell(new Position(7, 7), SudokuValue.ONE));

        filledCells5.add(new FilledCell(new Position(8, 1), SudokuValue.NINE));
        filledCells5.add(new FilledCell(new Position(8, 6), SudokuValue.FOUR));

        Board b5 = new Board(filledCells5);
        System.out.println(b5);
        long start5 = System.nanoTime();
        b5.solve();
        long end5 = System.nanoTime();
        System.out.println(b5);
        System.out.println("Took " + (end5 - start5) / 1000000000.0 + " seconds to solve.");
        System.out.println(b5.isValid());
    }
}
