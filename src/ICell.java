import java.util.List;

public interface ICell extends Comparable<ICell>, DeepCloneable<ICell> {
    SudokuValue getValue();

    void remove(SudokuValue sv);

    FilledCell filledVersion();

    Position getPosition();

    List<SudokuValue> getPossibleNumbers();
}
