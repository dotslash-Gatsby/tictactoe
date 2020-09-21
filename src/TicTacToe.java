
import java.io.InputStream;
import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private InputStream is;

    public static void main(String[] args) {

        TicTacToe ttt = new TicTacToe(System.in);
        ttt.playGame();

    }

    public TicTacToe(InputStream input) {

        board = new char[3][3];
        is = input;
    }

    public TicTacToe(InputStream input, char[][] testBoard) {

        board = testBoard;
        is = input;
    }

    public void playGame() {

        boolean win = false;
        int turn = 0; // 0 is for player 1 and 1 is for player 2
        String winner = "";
        boolean tie = false;

        System.out.println("Welcome! Here is your board");

        // initial printing of the board
        System.out.print("\n\n");
        board = newPrintBoard();
        System.out.print("\nMoves can be made by inputting coordinates in the format of x y. (e.g., 1 2)\n\n");

        while (!win) {

            if (turn == 0) {

                board = placePiece(turn);
                turn = 1;
                printboard();
                win = checkWin('X');
                tie = checkTie();
                if (tie)
                    break;
                if (win)
                    winner = "Player 1";
            } else {
                board = placePiece(turn);
                turn = 0;
                printboard();
                win = checkWin('O');
                tie = checkTie();
                if (tie)
                    break;
                if (win)
                    winner = "Player 2";
            }

        }
        if (win) {
            System.out.println(winner + " Wins!");
            tie = false;
        }
        if (tie)
            System.out.println("It's a tie!");

    }

    public char[][] newPrintBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("------");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("------");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);

        return board;
    }

    public char[][] placePiece(int turn) {

        int moveX;
        int moveY;
        String player;
        String moves;
        String[] positions;
        Scanner input = new Scanner(is).useDelimiter("\\A");
        boolean validMove = false;

        // setting the players to be printed out
        if (turn == 0)
            player = "Player 1 (X) ";
        else
            player = "Player 2 (O) ";

        while (!validMove) {
            System.out.println(player + "where would you like to move?");

            moves = input.nextLine();
            System.out.print("Moves: " + moves + "\n");
            positions = moves.split(" ");
            moveX = Integer.parseInt(positions[0]);
            System.out.print("MoveX: " + moveX+ "\n");
            moveY = Integer.parseInt(positions[1]);
            System.out.print("MoveY: " + moveY+ "\n");
            

            if (moveX > 2 || moveY > 2) {
                System.out.println("Please place a piece within the bounds (x: 2 y: 2)");

            } else if (board[moveX][moveY] == '-') {

                // valid move and sets the according piece
                validMove = true;

                if (turn == 0)
                    board[moveX][moveY] = 'X';

                else
                    board[moveX][moveY] = 'O';

            } else {
                System.out.println("You can't put a piece there! Try again!");
            }

        }

        return board;

    }

    public void printboard() {
        System.out.println("\n\n");
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("------");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("------");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("\n\n");
    }

    public boolean checkWin(char piece) {

        // check rows
        // row 0
        if (board[0][0] == piece) {
            if (board[0][1] == piece) {
                if (board[0][2] == piece) {
                    return true;
                } // if
            } // if
        } // if

        // check row 1
        if (board[1][0] == piece) {
            if (board[1][1] == piece) {
                if (board[1][2] == piece) {
                    return true;
                } // if
            } // if
        } // if

        // check row 2
        if (board[2][0] == piece) {
            if (board[2][1] == piece) {
                if (board[2][2] == piece) {
                    return true;
                } // if
            } // if
        } // if

        // check columns
        // check column 1
        if (board[0][0] == piece) {
            if (board[1][0] == piece) {
                if (board[2][0] == piece) {
                    return true;
                } // if
            } // if
        } // if

        // check column 2
        if (board[0][1] == piece) {
            if (board[1][1] == piece) {
                if (board[2][1] == piece) {
                    return true;
                } // if
            } // if
        } // if
          // check column 3
        if (board[0][2] == piece) {
            if (board[1][2] == piece) {
                if (board[2][2] == piece) {
                    return true;
                } // if
            } // if
        } // if

        // check diagnol 1
        if (board[0][0] == piece) {
            if (board[1][1] == piece) {
                if (board[2][2] == piece) {
                    return true;
                } // if
            } // if
        } // if

        // check diagnol 2
        if (board[0][2] == piece) {
            if (board[1][1] == piece) {
                if (board[2][0] == piece) {
                    return true;
                } // if
            } // if
        } // if

        return false;

    }// checkWin

    public boolean checkTie() {

        int tieCount = 0; // this counts the squares with piece on them

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != '-') {
                    tieCount++;
                } // if
            } // for
        } // for
        if (tieCount == 9)
            return true;
        else
            return false;

    }// checkTie

}// tictactoe class
