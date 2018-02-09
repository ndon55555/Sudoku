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
