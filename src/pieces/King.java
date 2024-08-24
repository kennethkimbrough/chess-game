
public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String toString() {
        return isWhite ? "K" : "k";
    }
}
