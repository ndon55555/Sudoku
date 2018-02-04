import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnfilledCell implements ICell {
    private List<SudokuValue> possibleNumbers;

    public UnfilledCell() {
        SudokuValue[] allNumbers = {
                SudokuValue.ONE, SudokuValue.TWO, SudokuValue.THREE,
                SudokuValue.FOUR, SudokuValue.FIVE, SudokuValue.SIX,
                SudokuValue.SEVEN, SudokuValue.EIGHT, SudokuValue.NINE
        };

        this.possibleNumbers = new ArrayList<>(Arrays.asList(allNumbers));
    }

    public UnfilledCell(List<SudokuValue> possibleNumbers) {
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
    public boolean canBeFilled() {
        return this.possibleNumbers.size() == 1;
    }

    @Override
    public FilledCell filledVersion() {
        if (this.canBeFilled()) {
            return new FilledCell(this.possibleNumbers.get(0));
        }

        throw new IllegalStateException("Cannot obtain filled version.");
    }

    public String toString() {
        return SudokuValue.NONE.toString();
    }
}
