/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import Session.*;
import java.util.*;

/**
 * This class represents a program that finds and prints the shortest path
 * for a knight on a chessboard using breadth-first search.
 */
public class ChessboardKnight {
    /**
     * The main method that interacts with the user, takes input, and prints the path.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create a chessboard graph
        Graph<ChessCoordinate> chessboard = createChessboard(rows, columns);

        while (true) {
            try {
                System.out.print("Enter <row1> <col1> <row2> <col2> or quit: ");
                String input = scanner.next();

                if (input.equalsIgnoreCase("quit")) {
                    System.out.println("Goodbye!");
                    break; // Exit the loop
                }

                int startRow = Integer.parseInt(input);
                int startCol = scanner.nextInt();
                int endRow = scanner.nextInt();
                int endCol = scanner.nextInt();

                ChessCoordinate start = new ChessCoordinate(startRow, startCol);
                ChessCoordinate end = new ChessCoordinate(endRow, endCol);

                if (startRow >= 0 && startCol >= 0 && endRow >= 0 && endCol >= 0 &&
                startRow < rows && startCol < columns && endRow < rows && endCol < columns) {

                    List<ChessCoordinate> path = chessboard.breadthFirstPath(start, end);
                    printChessboard(rows, columns, path);
                } else {
                    System.out.println("No path exists from " + start + " to " + end);
                    printChessboard(rows, columns, null); // Print an empty chessboard
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid integers or 'quit'.");
                scanner.nextLine(); // consume the invalid input
            }
        }
    }

    /**
     * Creates a chessboard graph with vertices representing chessboard coordinates
     * and edges representing valid knight moves between coordinates.
     *
     * @param rows    The number of rows on the chessboard.
     * @param columns The number of columns on the chessboard.
     * @return The created chessboard graph.
     */
    private static Graph<ChessCoordinate> createChessboard(int rows, int columns) {
        Graph<ChessCoordinate> chessboard = new AdjacencyGraph<>();
    
        // Add all vertices to the chessboard
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                chessboard.addValue(new ChessCoordinate(i, j));
            }
        }
    
        // Add edges for all possible knight moves from each vertex
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ChessCoordinate vertex = new ChessCoordinate(i, j);
                for (ChessCoordinate neighbor : getKnightMoves(vertex, rows, columns)) {
                    if (chessboard.contains(neighbor)) {
                        chessboard.connectUndirected(vertex, neighbor);
                    }
                }
            }
        }
    
        return chessboard;
    }
    
    /**
     * Calculates the valid knight moves from a given chessboard coordinate.
     *
     * @param position The starting chessboard coordinate.
     * @param rows     The number of rows on the chessboard.
     * @param columns  The number of columns on the chessboard.
     * @return A list of valid knight moves.
     */
    private static List<ChessCoordinate> getKnightMoves(ChessCoordinate position, int rows, int columns) {
        List<ChessCoordinate> moves = new ArrayList<>();
        int[][] possibleMoves = {
                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2},
                {1, -2}, {2, -1}, {2, 1}, {1, 2}
        };
    
        for (int[] move : possibleMoves) {
            int newRow = position.getRow() + move[0];
            int newCol = position.getCol() + move[1];
    
            if (isValidMove(newRow, newCol, rows, columns)) {
                moves.add(new ChessCoordinate(newRow, newCol));
            }
        }
    
        return moves;
    }

    /**
     * Checks if a move is valid within the chessboard boundaries.
     *
     * @param row     The target row.
     * @param col     The target column.
     * @param rows    The number of rows on the chessboard.
     * @param columns The number of columns on the chessboard.
     * @return True if the move is valid, false otherwise.
     */
    private static boolean isValidMove(int row, int col, int rows, int columns) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }

    /**
     * Prints the chessboard with the path of the knight.
     *
     * @param rows    The number of rows on the chessboard.
     * @param columns The number of columns on the chessboard.
     * @param path    The path of the knight.
     */
    private static void printChessboard(int rows, int columns, List<ChessCoordinate> path) {
        char[][] board = new char[rows][columns];
        boolean hasPath = path != null;

        for (int i = 0; i < rows; i++) {
            Arrays.fill(board[i], ' ');
        }
    
        int moveNumber = 1;
        
        if (hasPath) {
            for (ChessCoordinate position : path) {
                board[position.getRow()][position.getCol()] = (moveNumber == 1) ? 'S' : (moveNumber == path.size()) ? 'E' : (char) ('0' + moveNumber - 1);
                moveNumber++;
            }
        }
    
        for (int i = 0; i < rows; i++) {
            System.out.print("|");
            for (int j = 0; j < columns; j++) {
                System.out.print(hasPath ? board[i][j] : ' '); // Print a space for empty cells
                System.out.print("|");
            }
            System.out.println();
        }
    }
}

/**
 * Represents a coordinate on a chessboard.
 */
class ChessCoordinate {
    private int row;
    private int col;

    /**
     * Constructor for a chess coordinate.
     *
     * @param row The row of the coordinate.
     * @param col The column of the coordinate.
     */
    public ChessCoordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    /**
     * Checks if this ChessCoordinate is equal to another object.
     * Two ChessCoordinates are considered equal if they have the same row and column values.
     *
     * @param obj The object to compare with this ChessCoordinate.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        // Check for reference equality
        if (this == obj) return true;

        // Check if the object is null or of a different class
        if (obj == null || getClass() != obj.getClass()) return false;

        // Cast the object to ChessCoordinate
        ChessCoordinate that = (ChessCoordinate) obj;

        // Check for equality of row and column values
        return row == that.row && col == that.col; 
    }

    /**
     * Generates a hash code for this ChessCoordinate.
     * The hash code is based on the row and column values.
     *
     * @return The hash code for this ChessCoordinate.
     */
    @Override
    public int hashCode() {
        // Use Objects.hash to generate a hash code based on the fields
        return Objects.hash(row, col);
    }

    /**
     * Returns a string representation of this ChessCoordinate.
     * The string is in the format "(row, col)".
     *
     * @return The string representation of this ChessCoordinate.
     */
    @Override
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}
