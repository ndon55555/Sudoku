// Represents a row or column in a Sudoku board
public abstract class ABoardComponent implements IBoardComponent {
    private ICell[] cells;

    // constructor
    public ABoardComponent(ICell[] cells) {
        this.cells = SudokuUtils.validDimension(cells);
    }

    @Override
    public boolean hasValue(SudokuValue sv) {
        for (ICell c : cells) {
            if (c.getValue().equals(sv)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void removeValue(SudokuValue sv) {
        for (ICell cell : this.cells) {
            cell.remove(sv);
        }
    }
}
