public class Test {
    public static void main(String[] args) {
        FilledCell[][] board = new FilledCell[9][9];

        board[0][0] = new FilledCell(SudokuValue.FIVE);
        board[0][1] = new FilledCell(SudokuValue.THREE);
        board[0][4] = new FilledCell(SudokuValue.SEVEN);

        board[1][0] = new FilledCell(SudokuValue.SIX);
        board[1][3] = new FilledCell(SudokuValue.ONE);
        board[1][4] = new FilledCell(SudokuValue.NINE);
        board[1][5] = new FilledCell(SudokuValue.FIVE);

        board[2][1] = new FilledCell(SudokuValue.NINE);
        board[2][2] = new FilledCell(SudokuValue.EIGHT);
        board[2][7] = new FilledCell(SudokuValue.SIX);

        board[3][0] = new FilledCell(SudokuValue.EIGHT);
        board[3][4] = new FilledCell(SudokuValue.SIX);
        board[3][8] = new FilledCell(SudokuValue.THREE);

        board[4][0] = new FilledCell(SudokuValue.FOUR);
        board[4][3] = new FilledCell(SudokuValue.EIGHT);
        board[4][5] = new FilledCell(SudokuValue.THREE);
        board[4][8] = new FilledCell(SudokuValue.ONE);

        board[5][0] = new FilledCell(SudokuValue.SEVEN);
        board[5][4] = new FilledCell(SudokuValue.TWO);
        board[5][8] = new FilledCell(SudokuValue.SIX);

        board[6][1] = new FilledCell(SudokuValue.SIX);
        board[6][6] = new FilledCell(SudokuValue.TWO);
        board[6][7] = new FilledCell(SudokuValue.EIGHT);

        board[7][3] = new FilledCell(SudokuValue.FOUR);
        board[7][4] = new FilledCell(SudokuValue.ONE);
        board[7][5] = new FilledCell(SudokuValue.NINE);
        board[7][8] = new FilledCell(SudokuValue.FIVE);

        board[8][4] = new FilledCell(SudokuValue.EIGHT);
        board[8][7] = new FilledCell(SudokuValue.SEVEN);
        board[8][8] = new FilledCell(SudokuValue.NINE);

        Board b = new Board(board);
        System.out.println(b);
        b.solve();
        System.out.println(b);
    }
}
