/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */

package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * The ShapeCreator class is responsible for creating tables and populating them with random values
 * for different shapes (Circle, Rectangle, and Triangle) in a MySQL database.
 */
public class ShapeCreator {

    private static final String DB_URL = "jdbc:mysql://localhost:3390/shapedb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Random random = new Random();

    /**
     * Creates tables for Circle, Rectangle, and Triangle in the database.
     */
    public static void createTables() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String createCircleTableSQL = "CREATE TABLE Circle (id INT PRIMARY KEY AUTO_INCREMENT, x DOUBLE, y DOUBLE, radius DOUBLE)";
            String createRectangleTableSQL = "CREATE TABLE Rectangle (id INT PRIMARY KEY AUTO_INCREMENT, x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE, x3 DOUBLE, y3 DOUBLE, x4 DOUBLE, y4 DOUBLE, width DOUBLE, height DOUBLE)";
            String createTriangleTableSQL = "CREATE TABLE Triangle (id INT PRIMARY KEY AUTO_INCREMENT, x1 DOUBLE, y1 DOUBLE, x2 DOUBLE, y2 DOUBLE, x3 DOUBLE, y3 DOUBLE, side1 DOUBLE, side2 DOUBLE, side3 DOUBLE)";

            try (PreparedStatement circleStatement = connection.prepareStatement(createCircleTableSQL);
                 PreparedStatement rectangleStatement = connection.prepareStatement(createRectangleTableSQL);
                 PreparedStatement triangleStatement = connection.prepareStatement(createTriangleTableSQL)) {
                circleStatement.executeUpdate();
                rectangleStatement.executeUpdate();
                triangleStatement.executeUpdate();

                System.out.println("Tables created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Populates the Circle, Rectangle, and Triangle tables with random values.
     */
    public static void populateTables() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String insertCircleSQL = "INSERT INTO Circle (x, y, radius) VALUES (?, ?, ?)";
            String insertRectangleSQL = "INSERT INTO Rectangle (x1, y1, x2, y2, x3, y3, x4, y4, width, height) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String insertTriangleSQL = "INSERT INTO Triangle (x1, y1, x2, y2, x3, y3, side1, side2, side3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement circleStatement = connection.prepareStatement(insertCircleSQL);
                 PreparedStatement rectangleStatement = connection.prepareStatement(insertRectangleSQL);
                 PreparedStatement triangleStatement = connection.prepareStatement(insertTriangleSQL)) {

                for (int i = 0; i < 10; i++) {
                    double xCircle = random.nextInt(20) + 1;
                    double yCircle = random.nextInt(20) + 1;
                    double radius = random.nextInt(20) + 1;

                    double[] rectangleCoordinates = generateRectangleCoordinates();
                    double[] triangleCoordinates = generateTriangleCoordinates();

                    circleStatement.setDouble(1, xCircle);
                    circleStatement.setDouble(2, yCircle);
                    circleStatement.setDouble(3, radius);
                    circleStatement.executeUpdate();

                    rectangleStatement.setDouble(1, rectangleCoordinates[0]);
                    rectangleStatement.setDouble(2, rectangleCoordinates[1]);
                    rectangleStatement.setDouble(3, rectangleCoordinates[2]);
                    rectangleStatement.setDouble(4, rectangleCoordinates[3]);
                    rectangleStatement.setDouble(5, rectangleCoordinates[4]);
                    rectangleStatement.setDouble(6, rectangleCoordinates[5]);
                    rectangleStatement.setDouble(7, rectangleCoordinates[6]);
                    rectangleStatement.setDouble(8, rectangleCoordinates[7]);
                    rectangleStatement.setDouble(9, rectangleCoordinates[8]);
                    rectangleStatement.setDouble(10, rectangleCoordinates[9]);
                    rectangleStatement.executeUpdate();

                    triangleStatement.setDouble(1, triangleCoordinates[0]);
                    triangleStatement.setDouble(2, triangleCoordinates[1]);
                    triangleStatement.setDouble(3, triangleCoordinates[2]);
                    triangleStatement.setDouble(4, triangleCoordinates[3]);
                    triangleStatement.setDouble(5, triangleCoordinates[4]);
                    triangleStatement.setDouble(6, triangleCoordinates[5]);
                    triangleStatement.setDouble(7, triangleCoordinates[6]);
                    triangleStatement.setDouble(8, triangleCoordinates[7]);
                    triangleStatement.setDouble(9, triangleCoordinates[8]);
                    triangleStatement.executeUpdate();
                }

                System.out.println("Tables populated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Code for generating rectangle coordinates
     * @return the coordinates
     */
    private static double[] generateRectangleCoordinates() {
        double[] coordinates = new double[10];
        for (int i = 0; i < 8; i++) {
            coordinates[i] = random.nextInt(20) + 1; // Random x and y coordinates between 1 and 20
        }
        // Calculate width and height based on the coordinates
        coordinates[8] = Math.abs(coordinates[2] - coordinates[0]);
        coordinates[9] = Math.abs(coordinates[5] - coordinates[1]);
        return coordinates;
    }

    /**
     * Code for generating triangle coordinates
     * @return the coordinates
     */
    private static double[] generateTriangleCoordinates() {
        double[] coordinates = new double[9];
        for (int i = 0; i < 6; i++) {
            coordinates[i] = random.nextInt(20) + 1; // Random x and y coordinates between 1 and 20
        }
        // Calculate sides based on the coordinates
        coordinates[6] = Math.sqrt(Math.pow(coordinates[2] - coordinates[0], 2) + Math.pow(coordinates[3] - coordinates[1], 2));
        coordinates[7] = Math.sqrt(Math.pow(coordinates[4] - coordinates[2], 2) + Math.pow(coordinates[5] - coordinates[3], 2));
        coordinates[8] = Math.sqrt(Math.pow(coordinates[0] - coordinates[4], 2) + Math.pow(coordinates[1] - coordinates[5], 2));
        return coordinates;
    }

    /**
     * The main method of the ShapeCreator class. Calls the createTables() and populateTables() methods.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        createTables();
        populateTables();
    }
}
