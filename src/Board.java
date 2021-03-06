import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Board implements DeepCloneable<Board> {
    private Set<UnfilledCell> unfilled;
    private Set<FilledCell> filled;

    // constructor
    private Board() {
        this.unfilled = new HashSet<>();
        this.filled = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                this.unfilled.add(new UnfilledCell(new Position(r, c)));
            }
        }
    }

    // constructor
    Board(Set<FilledCell> filledCells) {
        this();

        for (FilledCell cell : filledCells) {
            this.fillCell(cell);
        }
    }

    // 0 <= r < 9
    private Row getRow(int r) {
        Predicate<ICell> sameRow = cell -> cell.getPosition().getX() == r;

        return new Row(this.getSatisfying(sameRow).toArray(new ICell[9]));
    }

    // 0 <= c < 9
    private Column getCol(int c) {
        Predicate<ICell> sameCol = cell -> cell.getPosition().getY() == c;

        return new Column(this.getSatisfying(sameCol).toArray(new ICell[9]));
    }

    // 0 <= s < 9
    private Section getSection(int startR, int startC) {
        if (startR % 3 != 0 || startC % 3 != 0) {
            return this.getSection(startR - (startR % 3), startC - (startC % 3));
        }

        Predicate<ICell> sameSection = cell -> {
            Position cellPosn = cell.getPosition();
            int x = cellPosn.getX();
            int y = cellPosn.getY();

            return (startR <= x && x < startR + 3) && (startC <= y && y < startC + 3);
        };

        return new Section(this.getSatisfying(sameSection).toArray(new ICell[9]));
    }

    private ICell getNextUnfilledCell() {
        if (this.unfilled.isEmpty()) {
            return null;
        } else {
            UnfilledCell fewestPossibilities = this.unfilled.iterator().next();

            for (UnfilledCell cell : this.unfilled) {
                if (cell.getPossibleNumbers().size() < fewestPossibilities.getPossibleNumbers().size()) {
                    fewestPossibilities = cell;
                }
            }

            return fewestPossibilities;
        }
    }

    public void solve() {
        ICell cell = this.getNextUnfilledCell();

        if (cell != null) {
            for (SudokuValue val : cell.getPossibleNumbers()) {
                Board possibleBoard = this.deepCopy();
                ICell possibleFilledVersion = new FilledCell(cell.getPosition(), val);

                possibleBoard.fillCell(possibleFilledVersion);
                possibleBoard.solve();

                if (possibleBoard.isValid() && possibleBoard.isCompletelyFilled()) {
                    this.unfilled = possibleBoard.unfilled;
                    this.filled = possibleBoard.filled;
                    break;
                }
            }
        }
    }

    private Set<ICell> getSatisfying(Predicate<ICell> p) {
        Set<ICell> satisfyingElements = new HashSet<>();

        for (ICell cell : this.unfilled) {
            if (p.test(cell)) {
                satisfyingElements.add(cell);
            }
        }

        for (ICell cell : this.filled) {
            if (p.test(cell)) {
                satisfyingElements.add(cell);
            }
        }

        return satisfyingElements;
    }

    private void fillCell(ICell cellToFill) {
        FilledCell filledVersion = cellToFill.filledVersion();
        SudokuValue valToRemove = filledVersion.getValue();
        Position cellPosn = cellToFill.getPosition();
        Row cellRow = this.getRow(cellPosn.getX());
        Column cellCol = this.getCol(cellPosn.getY());
        Section cellSection = this.getSection(cellPosn.getX(), cellPosn.getY());
        cellRow.removeValue(valToRemove);
        cellCol.removeValue(valToRemove);
        cellSection.removeValue(valToRemove);
        this.unfilled.remove(cellToFill);
        this.filled.add(filledVersion);
    }

    public boolean isCompletelyFilled() {
        return this.unfilled.isEmpty();
    }

    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            if (!this.getRow(i).isUnique() || !this.getCol(i).isUnique()) {
                return false;
            }
        }

        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (!this.getSection(r, c).isUnique()) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public Board deepCopy() {
        return new Board(new HashSet<>(this.filled));
    }

    public String toString() {
        Set<ICell> allCells = new TreeSet<>();
        allCells.addAll(this.filled);
        allCells.addAll(this.unfilled);
        StringBuilder result = new StringBuilder("-------------------\n");

        for (ICell cell : allCells) {
            result.append("|").append(cell.toString());

            if (cell.getPosition().getY() == 8) {
                result.append("|\n-------------------\n");
            }
        }

        return result.toString();
    }
}