
public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String toString() {
        return isWhite ? "Q" : "q";
    }
}
