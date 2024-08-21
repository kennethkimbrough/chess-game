
public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String toString() {
        return isWhite ? "B" : "b";
    }
}
