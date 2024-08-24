public class ChessGame {
    private Board board;

    public ChessGame() {
        board = new Board();
    }

    public void makeMove(Move move) {
        board.movePiece(move.getStartRow(), move.getStartCol(), move.getEndRow(), move.getEndCol());
    }

    public void printBoard() {
        board.printBoard();
    }
}
