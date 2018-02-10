public class Position implements Comparable<Position> {
    private final int x;
    private final int y;

    // constructor
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public int compareTo(Position that) {
        return (this.x != that.x) ? this.x - that.x : this.y - that.y;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 13 + this.x;
        hash = hash * 31 + this.y;

        return hash;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
