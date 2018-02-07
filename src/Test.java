public class Test {
    public static void main(String[] args) {
        FilledCell[][] board = new FilledCell[9][9];

        board[0][0] = new FilledCell(new Position(0, 0), SudokuValue.FIVE);
        board[0][1] = new FilledCell(new Position(0, 1), SudokuValue.THREE);
        board[0][4] = new FilledCell(new Position(0, 4), SudokuValue.SEVEN);

        board[1][0] = new FilledCell(new Position(1, 0), SudokuValue.SIX);
        board[1][3] = new FilledCell(new Position(1, 3), SudokuValue.ONE);
        board[1][4] = new FilledCell(new Position(1, 4), SudokuValue.NINE);
        board[1][5] = new FilledCell(new Position(1, 5), SudokuValue.FIVE);

        board[2][1] = new FilledCell(new Position(2, 1), SudokuValue.NINE);
        board[2][2] = new FilledCell(new Position(2, 2), SudokuValue.EIGHT);
        board[2][7] = new FilledCell(new Position(2, 7), SudokuValue.SIX);

        board[3][0] = new FilledCell(new Position(3, 0), SudokuValue.EIGHT);
        board[3][4] = new FilledCell(new Position(3, 4), SudokuValue.SIX);
        board[3][8] = new FilledCell(new Position(3, 8), SudokuValue.THREE);

        board[4][0] = new FilledCell(new Position(4, 0), SudokuValue.FOUR);
        board[4][3] = new FilledCell(new Position(4, 3), SudokuValue.EIGHT);
        board[4][5] = new FilledCell(new Position(4, 5), SudokuValue.THREE);
        board[4][8] = new FilledCell(new Position(4, 8), SudokuValue.ONE);

        board[5][0] = new FilledCell(new Position(5, 0), SudokuValue.SEVEN);
        board[5][4] = new FilledCell(new Position(5, 4), SudokuValue.TWO);
        board[5][8] = new FilledCell(new Position(5, 8), SudokuValue.SIX);

        board[6][1] = new FilledCell(new Position(6, 1), SudokuValue.SIX);
        board[6][6] = new FilledCell(new Position(6, 6), SudokuValue.TWO);
        board[6][7] = new FilledCell(new Position(6, 7), SudokuValue.EIGHT);

        board[7][3] = new FilledCell(new Position(7, 3), SudokuValue.FOUR);
        board[7][4] = new FilledCell(new Position(7, 4), SudokuValue.ONE);
        board[7][5] = new FilledCell(new Position(7, 5), SudokuValue.NINE);
        board[7][8] = new FilledCell(new Position(7, 8), SudokuValue.FIVE);

        board[8][4] = new FilledCell(new Position(8, 4), SudokuValue.EIGHT);
        board[8][7] = new FilledCell(new Position(8, 7), SudokuValue.SEVEN);
        board[8][8] = new FilledCell(new Position(8, 8), SudokuValue.NINE);

        Board b = new Board(board);
        System.out.println(b);
        b.solve();
        System.out.println(b);
        System.out.println(b.isValidSolved());
    }
}
