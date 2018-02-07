import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnfilledCell extends ACell {
    private List<SudokuValue> possibleNumbers;

    public UnfilledCell(Position position) {
        super(position);
        SudokuValue[] allNumbers = {
                SudokuValue.ONE, SudokuValue.TWO, SudokuValue.THREE,
                SudokuValue.FOUR, SudokuValue.FIVE, SudokuValue.SIX,
                SudokuValue.SEVEN, SudokuValue.EIGHT, SudokuValue.NINE
        };

        this.possibleNumbers = new ArrayList<>(Arrays.asList(allNumbers));
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
            return new FilledCell(super.getPosition(), this.possibleNumbers.get(0));
        }

        throw new IllegalStateException("Cannot obtain filled version.");
    }

    @Override
    public String toString() {
        return SudokuValue.NONE.toString();
    }
}
