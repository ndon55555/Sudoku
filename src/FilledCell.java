import java.util.LinkedList;
import java.util.List;

public class FilledCell extends ACell {
    private SudokuValue value;

    FilledCell(Position position, SudokuValue value) {
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
    public FilledCell filledVersion() {
        return this;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public List<SudokuValue> getPossibleNumbers() {
        List<SudokuValue> possibleNumbers = new LinkedList<>();
        possibleNumbers.add(this.value);

        return possibleNumbers;
    }

    @Override
    public ICell deepCopy() {
        return new FilledCell(this.getPosition(), this.value);
    }
}
