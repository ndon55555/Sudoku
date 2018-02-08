public class SudokuUtils {
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
