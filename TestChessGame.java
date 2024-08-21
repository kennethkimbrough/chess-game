
public class TestChessGame {
    public static void main(String[] args) {
        ChessBoard board = new ChessBoard();
        board.printBoard();

        // Test valid move
        System.out.println("Testing valid move: Pawn from (1, 0) to (2, 0)");
        board.movePiece(1, 0, 2, 0);
        board.printBoard();

        // Test invalid move
        System.out.println("Testing invalid move: Pawn from (1, 0) to (3, 0)");
        board.movePiece(1, 0, 3, 0);
        board.printBoard();
    }
}
