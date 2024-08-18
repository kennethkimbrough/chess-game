public class ChessBoard {
    private Piece[][] board;
    private List<Move> moveHistory;

    public ChessBoard() {
        board = new Piece[8][8];
        moveHistory = new ArrayList<>();
        initializeBoard();
    }


 public void undoLastMove() {
        if (!moveHistory.isEmpty()) {
            Move lastMove = moveHistory.remove(moveHistory.size() - 1);
            Piece piece = board[lastMove.getEndRow()][lastMove.getEndCol()];
            board[lastMove.getStartRow()][lastMove.getStartCol()] = piece;
            board[lastMove.getEndRow()][lastMove.getEndCol()] = null;
        }
    }

 public void movePiece(int startRow, int startCol, int endRow, int endCol) {
        // Validate the move
        if (!isValidMove(startRow, startCol, endRow, endCol)) {
            return;
        }
        Piece piece = board[startRow][startCol];
        board[endRow][endCol] = piece;
        board[startRow][startCol] = null;
        moveHistory.add(new Move(startRow, startCol, endRow, endCol));
    }

public ChessBoard() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize white pieces
        board[0][0] = new Rook(true);
        board[0][1] = new Knight(true);
        board[0][2] = new Bishop(true);
        board[0][3] = new Queen(true);
        board[0][4] = new King(true);
        board[0][5] = new Bishop(true);
        board[0][6] = new Knight(true);
        board[0][7] = new Rook(true);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(true);
        }

        // Initialize black pieces
        board[7][0] = new Rook(false);
        board[7][1] = new Knight(false);
        board[7][2] = new Bishop(false);board[7][3] = new Queen(false);
        board[7][4] = new King(false);
        board[7][5] = new Bishop(false);
        board[7][6] = new Knight(false);
        board[7][7] = new Rook(false);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(false);
        }
    }

 public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void castle(int kingRow, int kingCol, int rookRow, int rookCol) {
        // Ensure the king and rook have not moved
        if (board[kingRow][kingCol] instanceof King && board[rookRow][rookCol] instanceof Rook) {
            King king = (King) board[kingRow][kingCol];
            Rook rook = (Rook) board[rookRow][rookCol];
            if (!king.hasMoved() && !rook.hasMoved()) {
                // Ensure there are no pieces between the king and rook
                int direction = (rookCol > kingCol) ? 1 : -1; for (int col = kingCol + direction; col != rookCol; col += direction) {
                    if (board[kingRow][col] != null) {
                        return;
                    }
                }
                // Ensure the king is not in check, and does not pass through or end up in a square under attack
                if (!isInCheck(kingRow, kingCol) && !isInCheck(kingRow, kingCol + direction) && !isInCheck(kingRow, kingCol + 2 * direction)) {
                    // Perform castling
                    movePiece(kingRow, kingCol, kingRow, kingCol + 2 * direction);
                    movePiece(rookRow, rookCol, kingRow, kingCol + direction);
                    king.setMoved(true);
                    rook.setMoved(true);                }
            }
        }
    }

    public void enPassant(int pawnRow, int pawnCol, int targetRow, int targetCol) {
        // Ensure the pawn is in the correct position to perform en passant
        if (board[pawnRow][pawnCol] instanceof Pawn) {
            Pawn pawn = (Pawn) board[pawnRow][pawnCol];           if (pawn.isWhite() && pawnRow == 3 && targetRow == 2 && board[targetRow + 1][targetCol] instanceof Pawn) {
                // Perform en passant
                movePiece(pawnRow, pawnCol, targetRow, targetCol);
                board[targetRow + 1][targetCol] = null;
            } else if (!pawn.isWhite() && pawnRow == 4 && targetRow == 5 && board[targetRow - 1][targetCol] instanceof Pawn) {
                // Perform en passant
                movePiece(pawnRow, pawnCol, targetRow, targetCol);
                board[targetRow - 1][targetCol] = null;
            }
        }
    }

public boolean isCheckmate(int kingRow, int kingCol) {
        if (!isInCheck(kingRow, kingCol)) {
            return false;
        }
        // Check if there are any valid moves to get the king out of check
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.isWhite() == board[kingRow][kingCol].isWhite()) {
                    for (int newRow = 0; newRow < 8; newRow++) {
                        for (int newCol = 0; newCol < 8; newCol++) {
                            if (piece.isValidMove(row, col, newRow, newCol, board)) {Piece temp = board[newRow][newCol];
                                board[newRow][newCol] = piece;
                                board[row][col] = null;
                                boolean stillInCheck = isInCheck(kingRow, kingCol);
                                board[row][col] = piece;
                                board[newRow][newCol] = temp;
                                if (!stillInCheck) {
                                    return false;
                                }
                            }
                        }
                    }
                }            
            }
        }
        return true;
    }

    public boolean isInCheck(int kingRow, int kingCol) {
        // Check if any opponent piece can move to the king's position
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.isWhite() != board[kingRow][kingCol].isWhite()) {
                    if (piece.isValidMove(row, col, kingRow, kingCol, board)) {
                        return true; }
                }
            }
        }
        return false;
    }

    public void promotePawn(int pawnRow, int pawnCol, String newPieceType) {
        if (board[pawnRow][pawnCol] instanceof Pawn) {
            Pawn pawn = (Pawn) board[pawnRow][pawnCol];
            if ((pawn.isWhite() && pawnRow == 0) || (!pawn.isWhite() && pawnRow == 7)) {
                switch (newPieceType.toLowerCase()) {
                    case "queen":
                        board[pawnRow][pawnCol] = new Queen(pawn.isWhite());
                        break;
                    case "rook":
                        board[pawnRow][pawnCol] = new Rook(pawn.isWhite());
                        break;
                    case "bishop":
                        board[pawnRow][pawnCol] = new Bishop(pawn.isWhite());
                        break;
                    case "knight":
                        board[pawnRow][pawnCol] = new Knight(pawn.isWhite());
                        break;                    default:
                        board[pawnRow][pawnCol] = new Queen(pawn.isWhite());
                        break;
                }
            }
        }
    }

    public void movePiece(int startRow, int startCol, int endRow, int endCol) {
        // Validate the move
        if (!isValidMove(startRow, startCol, endRow, endCol)) {           return;
        }
        Piece piece = board[startRow][startCol];
        board[endRow][endCol] = piece;
        board[startRow][startCol] = null;
    }

    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }







