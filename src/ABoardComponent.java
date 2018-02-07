// Represents a row or column in a Sudoku board
public abstract class ABoardComponent implements IBoardComponent {
    private ICell[] dimension;

    // constructor
    public ABoardComponent(ICell[] dimension) {
        this.dimension = SudokuUtils.validDimension(dimension);
    }

    @Override
    public boolean hasValue(SudokuValue sv) {
        for (ICell c : dimension) {
            if (c.getValue().equals(sv)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void removeValue(SudokuValue sv) {
        for (int i = 0; i < dimension.length; i++) {
            this.dimension[i].remove(sv);
        }
    }
}
