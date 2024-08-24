import java.util.Scanner;

import java.util.Scanner;

public class main {
    private Board board;
    private MachineLearningModel model;

    public main() {
        this.board = new Board();
        this.model = new MachineLearningModel(100); // Assuming the constructor takes an integer argument
    }

    public static void main(String[] args) {
        main game = new main();
        game.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your move (e.g., e2 e4): ");
            String moveInput = scanner.nextLine();
            Move move = parseMove(moveInput);
            board.movePiece(move.getStartRow(), move.getStartCol(), move.getEndRow(), move.getEndCol());
            board.printBoard();
            Move predictedMove = predictMove();
            board.movePiece(predictedMove.getStartRow(), predictedMove.getStartCol(), predictedMove.getEndRow(), predictedMove.getEndCol());
            board.printBoard();
        }
    }

    private Move parseMove(String moveInput) {
        String[] parts = moveInput.split(" ");
        int startRow = parts[0].charAt(1) - '1';
        int startCol = parts[0].charAt(0) - 'a';
        int endRow = parts[1].charAt(1) - '1';
        int endCol = parts[1].charAt(0) - 'a';
        return new Move(startRow, startCol, endRow, endCol);
    }

    private Move predictMove() {
        int[] prediction = model.predict(board);
        return new Move(prediction[0], prediction[1], prediction[2], prediction[3]);
    }
}
  private Board board;
  private MachineLearningModel model;

  public main () {
    this.board = new Board();
    this.model = new MachineLearningModel();
  }

  public void playGame() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Enter your move (e.g. e2-e4): ");
      String moveInput = scanner.nextLine();
      Move move = parseMove(moveInput);
      if (move == null) {
        System.out.println("Invalid move. Try again!");
        continue;
      }
      board.makeMove(move);
      System.out.println("Board after your move:");
      System.out.println(board.toString());
      Move predictedMove = predictMove();
      System.out.println("Predicted move: " + predictedMove);
      board.makeMove(predictedMove);
      System.out.println("Board after predicted move:");
      System.out.println(board.toString());
    }
  }

  private Move parseMove(String moveInput) {
    // Implement move parsing logic here
    return null;
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
