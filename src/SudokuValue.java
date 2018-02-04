public enum SudokuValue {
    ONE ("1"), TWO ("2"), THREE ("3"),
    FOUR ("4"), FIVE ("5"), SIX ("6"),
    SEVEN ("7"), EIGHT ("8"), NINE ("9"),
    NONE ("X");

    private final String representation;

    SudokuValue(String representation) {
        this.representation = representation;
    }

    public String toString() {
        return this.representation;
    }
}
