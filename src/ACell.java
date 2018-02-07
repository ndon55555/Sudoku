public abstract class ACell implements ICell {
    private Position position;

    public ACell(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
}