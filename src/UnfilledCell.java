import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnfilledCell extends ACell {
    private List<SudokuValue> possibleNumbers;

    UnfilledCell(Position position) {
        super(position);
        SudokuValue[] allNumbers = {
                SudokuValue.ONE, SudokuValue.TWO, SudokuValue.THREE,
                SudokuValue.FOUR, SudokuValue.FIVE, SudokuValue.SIX,
                SudokuValue.SEVEN, SudokuValue.EIGHT, SudokuValue.NINE
        };
        this.possibleNumbers = new ArrayList<>(Arrays.asList(allNumbers));
    }

    private UnfilledCell(Position position, List<SudokuValue> possibleNumbers) {
        super(position);
        this.possibleNumbers = possibleNumbers;
    }

    @Override
    public SudokuValue getValue() {
        return SudokuValue.NONE;
    }

    @Override
    public void remove(SudokuValue sv) {
        possibleNumbers.remove(sv);
    }

    @Override
    public FilledCell filledVersion() {
        if (this.possibleNumbers.size() == 1) {
            return new FilledCell(super.getPosition(), this.possibleNumbers.get(0));
        }

        throw new IllegalStateException("Cannot obtain filled version.");
    }

    @Override
    public String toString() {
        return SudokuValue.NONE.toString();
    }

    @Override
    public List<SudokuValue> getPossibleNumbers() {
        return this.possibleNumbers;
    }

    @Override
    public ICell deepCopy() {
        return new UnfilledCell(this.getPosition(), new ArrayList<>(this.possibleNumbers));
    }
}
