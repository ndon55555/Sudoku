public interface ICell {
    SudokuValue getValue();

    void remove(SudokuValue sv);

    boolean canBeFilled();

    FilledCell filledVersion();

    Position getPosition();
}
