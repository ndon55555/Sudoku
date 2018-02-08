public abstract class ACell implements ICell {
    private Position position;

    public ACell(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(ICell that) {
        return this.position.compareTo(that.getPosition());
    }

    @Override
    public int hashCode() {
        return this.position.hashCode();
    }

    @Override
    public boolean equals(Object that) {
        return (that instanceof ICell) && (this.hashCode() == that.hashCode());
    }
}