public interface ICell extends Comparable<ICell> {
    SudokuValue getValue();

    void remove(SudokuValue sv);

    boolean canBeFilled();

    FilledCell filledVersion();

    Position getPosition();
}
