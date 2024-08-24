# ChessProgram

## Simple Chess Program in Java

This is a simple chess program implemented in Java. It initializes a chessboard with pieces and allows for basic piece movement through console input.

## Features

- Initializes a standard 8x8 chessboard with pieces in their starting positions.
- Allows for basic piece movement using console input.
- Displays the current state of the chessboard after each move.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.

### Installation

1. Clone the repository or download the source code.
2. Navigate to the `src` directory.
3. Compile the Java files:
   ```sh
   javac -d ../bin chess/*.java pieces/*.java ml/*.java
   ```
4. Run the program:
   ```sh
   java -cp ../bin chess.Main
   ```

## Project Structure

```
chess-game/
    bin/
        chess/
            ChessBoard.class
            ChessGUI.class
            TestChessGame.class
        ml/
        pieces/
            Bishop.class
            King.class
            Knight.class
            Pawn.class
            Piece.class
            Queen.class
            Rook.class
    src/
        Instance.java
        chess/
            ChessBoard.java
            ChessGUI.java
            Main.java
            TestChessGame.java
        ml/
            MachineLearningModel.java
        pieces/
            Bishop.java
            King.java
            Knight.java
            Pawn.java
            Piece.java
            Queen.java
            Rook.java
```

Feel free to modify the content to better fit your needs.
