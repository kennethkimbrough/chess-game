abstract class Piece {
    boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract String toString();
}
