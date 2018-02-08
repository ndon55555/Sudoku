// Represents a row or column or section in a Sudoku board
public abstract class ABoardComponent implements IBoardComponent {
    private ICell[] cells;

    // constructor
    public ABoardComponent(ICell[] cells) {
        this.cells = SudokuUtils.validComponent(cells);
    }

    @Override
    public void removeValue(SudokuValue sv) {
        for (ICell cell : this.cells) {
            cell.remove(sv);
        }
    }

    @Override
    public boolean isUnique() {
        for (ICell cell : this.cells) {
            if (cell instanceof UnfilledCell) {
                return false;
            }
        }

        return true;
    }
}
