/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */
package Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The ShapeArray class generates an array of random shapes, saves them to a file,
 * and then loads the shapes from the file and prints their details.
 */
public class ShapeArray {

    /**
     * The main method that drives the program.
     * 
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Prompt user for array size between 2 and 20
        int arraySize;
        do {
            System.out.println("Enter array size (between 2 and 20): ");
            arraySize = scanner.nextInt();
        } while (arraySize < 2 || arraySize > 20);

        // Create an array of shapes with the given size
        Shape[] shapes = new Shape[arraySize];
        Random random = new Random();

        // Populate the array with random shapes
        for (int i = 0; i < arraySize; i++) {
            int shapeType = random.nextInt(3); // 0: Circle, 1: Rectangle, 2: Triangle

            // Randomly generate properties for the shapes
            Position position = new Position(random.nextInt(200) - 100, random.nextInt(200) - 100);
            String[] colors = {"Red", "Green", "Blue", "Yellow", "Orange", "Purple", "Pink", "Brown", "Black", "Transparent"};
            String fillColor = colors[random.nextInt(colors.length)];
            String lineColor = colors[random.nextInt(colors.length)];

            switch (shapeType) {
                case 0:
                    double radius = random.nextDouble() * 100; // Random radius between 0 and 100
                    shapes[i] = new Circle(position, fillColor, lineColor, radius);
                    break;
                case 1:
                    double width = random.nextDouble() * 100; // Random width between 0 and 100
                    double height = random.nextDouble() * 100; // Random height between 0 and 100
                    shapes[i] = new Rectangle(position, fillColor, lineColor, width, height);
                    break;
                case 2:
                    double side = random.nextDouble() * 100; // Random side length between 0 and 100
                    shapes[i] = new Triangle(position, fillColor, lineColor, side);
                    break;
            }
        }
        
        // Save shapes to a file
        saveShapesToFile(shapes, "shapes.txt");

        // Create an array to store loaded shapes (assuming arraySize is the desired size)
        Shape[] loadedShapes = new Shape[arraySize];

        // Load shapes from the file into the loadedShapes array
        loadShapesToFile("shapes.txt", loadedShapes);

        //System.out.println(loadedShapes.length);
        // Print details of the shapes in the array
        System.out.println("Loaded Shapes:");
        for (Shape shape : shapes) {
            ShapeMover.printShape(shape);
        }
    }

    /**
     * Saves an array of shapes to a file.
     * 
     * @param shapes   Array of Shape objects to be saved.
     * @param fileName Name of the file to save the shapes to.
     */
    public static void saveShapesToFile(Shape[] shapes, String filename) {
        try {
            // Create a PrintWriter to write to the file
            PrintWriter writer = new PrintWriter(new FileWriter(filename));

            // Loop through the array of shapes
            for (Shape shape : shapes) {
                // Use the printShape method to format the information
                printShapeToWriter(shape, writer);
            }

            // Close the PrintWriter to save data to the file
            System.out.println("Saved shapes to File");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Prints the details of a Shape object to a PrintWriter.
    * This method prints the class type, position, area, perimeter, fill color,
    * and outline color of the given Shape object, followed by an empty line.
    *
    * @param shape  The Shape object to print details of.
    * @param writer The PrintWriter to which the shape details will be printed.
    */
    public static void printShapeToWriter(Shape shape, PrintWriter writer) {
        writer.println("Shape: " + shape.getClass());
        writer.println("  position: " + shape.getPos());
        writer.println("  area: " + shape.area());
        writer.println("  perimeter: " + shape.perimeter());
        writer.println("  fill color: " + shape.getFillColor());
        writer.println("  outline: " + shape.getLineColor());
        writer.println(); // Empty line to separate shapes
    }

    /**
     * Loads shapes from a file and saves them into an array of Shape objects.
     * 
     * @param fileName Name of the file to load shapes from.
     * @return An array of Shape objects loaded from the file.
     */
    public static int loadShapesToFile(String fileName, Shape[] shapes) {
        List<Shape> shapeList = new ArrayList<>();
        int loadedShapesCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming shapes are stored as comma-separated values
                if (parts.length >= 4) {
                    String shapeType = parts[0].trim();
                    Position position = new Position(Double.parseDouble(parts[1].trim()),
                            Double.parseDouble(parts[2].trim()));
                    String fillColor = parts[3].trim();
                    String lineColor = parts[4].trim();

                    switch (shapeType) {
                        case "Circle":
                            double radius = Double.parseDouble(parts[5].trim());
                            shapes[loadedShapesCount] = new Circle(position, fillColor, lineColor, radius);
                            loadedShapesCount++;
                            break;
                        case "Rectangle":
                            double width = Double.parseDouble(parts[5].trim());
                            double height = Double.parseDouble(parts[6].trim());
                            shapes[loadedShapesCount] = new Rectangle(position, fillColor, lineColor, width, height);
                            loadedShapesCount++;
                            break;
                        case "Triangle":
                            double side = Double.parseDouble(parts[5].trim());
                            shapes[loadedShapesCount] = new Triangle(position, fillColor, lineColor, side);
                            loadedShapesCount++;
                            break;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Handle IOException (input/output error) or NumberFormatException (parsing error) that might occur.
            System.out.println("Error occurred while reading shapes from file: " + e.getMessage());
        }

        // Convert the list of shapes to an array and return
        //return shapeList.toArray(new Shape[0]);

        // Return the number of shapes loaded from the file
        return loadedShapesCount;
    }
} 
