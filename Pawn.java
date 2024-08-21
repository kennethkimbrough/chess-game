
public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String toString() {
        return isWhite ? "P" : "p";
    }
}
