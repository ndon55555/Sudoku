public class SudokuUtils {
    public static ICell[][] validBoard(ICell[][] cells) {
        if (cells == null) {
            throw new NullPointerException("Expected 2D array of ICells but received null.");
        }

        if (cells.length == 9 && cells[0].length == 9) {
            return cells;
        }

        throw new IllegalArgumentException("Invalid board dimensions. Row length: "
                + cells.length + " Col length: " + cells[0].length);
    }

    public static ICell[] validDimension(ICell[] dimension) {
        if (dimension == null) {
            throw new NullPointerException("Expected 1D array of ICells but received null.");
        }

        if (dimension.length == 9) {
            return dimension;
        }

        throw new IllegalArgumentException("Invalid length: " + dimension.length);
    }

    public static ICell[][] validSection(ICell[][] section) {
        if (section == null) {
            throw new NullPointerException("Expeected 2D array of ICells but received null.");
        }

        if (section.length == 3 && section[0].length == 3) {
            return section;
        }

        throw new IllegalArgumentException("Invalid section dimensions. Row length: "
                + section.length + " Col length: " + section[0].length);
    }
}
