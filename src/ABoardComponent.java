import java.util.HashSet;
import java.util.Set;

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
        Set<FilledCell> filled = new HashSet<>();

        for (ICell cell : this.cells) {
            if (cell instanceof FilledCell) {
                if (filled.contains(cell)) {
                    return false;
                } else {
                    filled.add((FilledCell) cell);
                }
            }
        }

        return true;
    }
}
