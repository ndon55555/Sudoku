public class FilledCell implements ICell {
    private SudokuValue value;

    public FilledCell(SudokuValue value) {
        this.value = value;
    }

    @Override
    public SudokuValue getValue() {
        return this.value;
    }

    @Override
    public void remove(SudokuValue sv) {
        if (sv.equals(this.value)) {
            throw new IllegalArgumentException("This ICell has already been filled with the given SudokuValue to remove.");
        }
    }

    @Override
    public boolean canBeFilled() {
        return false;
    }

    @Override
    public FilledCell filledVersion() {
        return this;
    }

    public String toString() {
        return this.value.toString();
    }
}
