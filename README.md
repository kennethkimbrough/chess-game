# chessProgram

# Simple Chess Program in Java

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

   ```bash
   git clone https://github.com/your-username/simple-chess-java.git
   cd simple-chess-java
Compile the Java files.

bash
Copy code
javac Main.java ChessBoard.java Piece.java King.java Queen.java Rook.java Bishop.java Knight.java Pawn.java
Running the Program
Run the compiled Java program.

bash
Copy code
java Main
The chessboard will be displayed in the console. Enter your moves in the format startRow startCol endRow endCol.

Example: To move a piece from (1, 0) to (2, 0), enter 1 0 2 0.
Example
plaintext
Copy code
- - - - - - - -
P P P P P P P P
- - - - - - - -
- - - - - - - -
- - - - - - - -
- - - - - - - -
p p p p p p p p
r n b q k b n r
Enter your move (e.g., 1 0 2 0 to move a piece from (1, 0) to (2, 0)):
1 0 2 0

- - - - - - - -
- P P P P P P P
P - - - - - - -
- - - - - - - -
- - - - - - - -
- - - - - - - -
p p p p p p p p
r n b q k b n r
To Do
Implement full chess rules and move validation.
Add game state checks (e.g., check, checkmate).
Create a graphical user interface (GUI) for a better user experience.
Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue if you have any suggestions or improvements.

License
This project is licensed under the MIT License - see the LICENSE file for details.

css
Copy code

Feel free to modify the content to better fit your needs, such as updating the repos
