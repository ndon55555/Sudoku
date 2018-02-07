public class FilledCell extends ACell {
    private SudokuValue value;

    public FilledCell(Position position, SudokuValue value) {
        super(position);
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

    @Override
    public String toString() {
        return this.value.toString();
    }
}
