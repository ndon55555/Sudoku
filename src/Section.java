// Represents one of the nine 3x3 sub-squares on a Sudoku Board
public class Section implements IBoardComponent {
    private ICell[][] section;

    // constructor
    public Section(ICell[][] section) {
        this.section = SudokuUtils.validSection(section);
    }

    @Override
    public boolean hasValue(SudokuValue sv) {
        for (ICell[] row : this.section) {
            for (ICell cell : row) {
                if (cell.getValue().equals(sv)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void removeValue(SudokuValue sv) {
        for (ICell[] row : this.section) {
            for (ICell cell : row) {
                cell.remove(sv);
            }
        }
    }
}