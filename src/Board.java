import java.util.HashMap;
import java.util.Map;

public class Board {
    private ICell[][] cells;

    // constructor
    public Board() {
        this.cells = new ICell[9][9];

        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                this.cells[r][c] = new UnfilledCell();
            }
        }
    }

    // constructor
    public Board(FilledCell[][] board) {
        this();
        board = SudokuUtils.validBoard(board);

        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[r].length; c++) {
                if (board[r][c] != null) {
                    this.fill(board[r][c], new Position(r, c));
                }
            }
        }
    }

    // 0 <= r < 9
    private Row getRow(int r) {
        return new Row(this.cells[r]);
    }

    // 0 <= c < 9
    private Column getCol(int c) {
        ICell[] col = new ICell[9];

        for (int r = 0; r < cells.length; r++) {
            col[r] = cells[r][c];
        }

        return new Column(col);
    }

    // 0 <= s < 9
    private Section getSection(int startR, int startC) {
        if (startR % 3 != 0 || startC % 3 != 0) {
            return this.getSection(startR - (startR % 3), startC - (startC % 3));
        } else {
            ICell[] section = new ICell[9];
            int i = 0;

            for (int r = startR; r < startR + 3; r++) {
                for (int c = startC; c < startC + 3; c++) {
                    section[i] = this.cells[r][c];
                    i++;
                }
            }

            return new Section(section);
        }
    }

    public void solve() {
        while (!isSolved()) {
            Map<ICell, Position> fillableCellsToPosn = getFillableCells();
            fill(fillableCellsToPosn);
        }
    }

    private Map<ICell, Position> getFillableCells() {
        Map<ICell, Position> fillableCellsToPosn = new HashMap<>();

        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells[0].length; c++) {
                if (cells[r][c].canBeFilled()) {
                    fillableCellsToPosn.put(cells[r][c], new Position(r, c));
                }
            }
        }

        return fillableCellsToPosn;
    }

    private void fill(Map<ICell, Position> fillableCellsToPosn) {
        for (ICell cellToFill : fillableCellsToPosn.keySet()) {
            Position cellPosn = fillableCellsToPosn.get(cellToFill);
            fill(cellToFill, cellPosn);
        }
    }

    private void fill(ICell cellToFill, Position cellPosn) {
        ICell filledVersion = cellToFill.filledVersion();
        SudokuValue valToRemove = filledVersion.getValue();
        Row cellRow = this.getRow(cellPosn.getX());
        Column cellCol = this.getCol(cellPosn.getY());
        Section cellSection = this.getSection(cellPosn.getX(), cellPosn.getY());
        cellRow.removeValue(valToRemove);
        cellCol.removeValue(valToRemove);
        cellSection.removeValue(valToRemove);
        this.cells[cellPosn.getX()][cellPosn.getY()] = filledVersion;
    }

    public boolean isSolved() {
        for (ICell[] row : this.cells) {
            for (ICell cell : row) {
                if (cell instanceof UnfilledCell) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSolved() {
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

    public String toString() {
        StringBuilder result = new StringBuilder("-------------------\n");

        for (ICell[] row : this.cells) {
            result.append("|").append(row[0]).append("|");

            for (int c = 1; c < row.length; c++) {
                result.append(row[c].toString()).append("|");
            }

            result.append("\n-------------------\n");
        }

        return result.toString();
    }
}
