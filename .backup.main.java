public class Main {
  private Board board;
  private MachineLearningModel model;

  public Main () {
    this.board = new Board();
    this.model = new MachineLearningModel();
  }

  public void playGame() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Enter your move (e.g. e2-e4): ");
      String moveInput = scanner.nextLine();
      if (moveInput.equalsIgnoreCase("undo")) {
        board.undoLastMove();
        System.out.println("Last move undone.");
        System.out.println(board.toString());
        continue;
      }
      Move move = parseMove(moveInput);      
if (move == null) {
        System.out.println("Invalid move. Try again!");
        continue;
      }
      board.movePiece(move.getStartRow(), move.getStartCol(), move.getEndRow(), move.getEndCol());
      System.out.println("Board after your move:");
      System.out.println(board.toString());
      Move predictedMove = predictMove();
      System.out.println("Predicted move: " + predictedMove);
      board.makeMove(predictedMove);
      // Check if the move puts the opponent's king in check
      if (board.isInCheck(opponentKingRow, opponentKingCol)) {
         System.out.println("Check!");
          // Check if the move results in a checkmate
          if (board.isCheckmate(opponentKingRow, opponentKingCol)) {
              System.out.println("Checkmate! " + currentPlayer + " wins!");
              break;
          }
      }
      System.out.println(board.toString());
    }
  }

private Move parseMove(String moveInput) {
    if (moveInput.matches("[a-h][1-8]-[a-h][1-8]")) {
        String[] parts = moveInput.split("-");
        String from = parts[0];
        String to = parts[1];
        int fromRow = 8 - Character.getNumericValue(from.charAt(1));
        int fromCol = from.charAt(0) - 'a';
        int toRow = 8 - Character.getNumericValue(to.charAt(1));
        int toCol = to.charAt(0) - 'a';
        return new Move(fromRow, fromCol, toRow, toCol);
    } else {
        return null;
    }
}

  private Move predictMove() {
    // Use the machine learning model to predict the move
    Instance instance = new Instance(board.getFeatures());
    double[] prediction = model.predict(instance);
    Move predictedMove = new Move(prediction[0], prediction[1]);
    return predictedMove;
  }

public static void main(String[] args) {
    ChessGame game = new ChessGame();
        game.playGame();
  }
}



