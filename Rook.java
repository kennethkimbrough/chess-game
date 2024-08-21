
public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String toString() {
        return isWhite ? "R" : "r";
    }
}
