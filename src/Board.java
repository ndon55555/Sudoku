import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board {
    private ICell[][] cells;

    // constructor
    public Board(FilledCell[][] board) {
        this.cells = new ICell[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == null) {
                    cells[r][c] = new UnfilledCell();
                } else {
                    List<SudokuValue> listWithSingleVal= new LinkedList<>();
                    listWithSingleVal.add(board[r][c].getValue());
                    cells[r][c] = new UnfilledCell(listWithSingleVal);
                }
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (this.cells[r][c].canBeFilled()) {
                    this.fill(this.cells[r][c], new Position(r, c));
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
            ICell[][] section = new ICell[3][3];

            for (int r = startR; r < startR + 3; r++) {
                for (int c = startC; c < startC + 3; c++) {
                    section[r - startR][c - startC] = this.cells[r][c];
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

    public String toString() {
        String result = "-------------------\n";

        for (int r = 0; r < cells.length; r++) {
            result += "|" + cells[r][0] + "|";

            for (int c = 1; c < cells[0].length; c++) {
                result += cells[r][c].toString() + "|";
            }

            result += "\n-------------------\n";
        }

        return result;
    }
}
