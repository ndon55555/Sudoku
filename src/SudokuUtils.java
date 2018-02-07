public class SudokuUtils {
    public static ICell[][] validBoard(FilledCell[][] cells) {
        if (cells == null) {
            throw new NullPointerException("Expected 2D array of FilledCells but received null.");
        }

        if (cells.length == 9 && cells[0].length == 9) {
            return cells;
        }

        throw new IllegalArgumentException("Invalid board dimensions. Row length: "
                + cells.length + " Col length: " + cells[0].length);
    }

    public static ICell[] validComponent(ICell[] component) {
        if (component == null) {
            throw new NullPointerException("Expected 1D array of ICells but received null.");
        }

        if (component.length == 9) {
            return component;
        }

        throw new IllegalArgumentException("Invalid length: " + component.length);
    }
}
