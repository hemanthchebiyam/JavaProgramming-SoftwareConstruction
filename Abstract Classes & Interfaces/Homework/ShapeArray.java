package Homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShapeArray {
    
    /**
     * Sorts an array of shapes based on their area values.
     *
     * @param shapes The array of shapes to be sorted.
     * @return The sorted array of shapes.
     */
    public static Figure[] sortShape(Figure[] shapes) {
        // Sort shapes based on their area values using a custom comparator
        Arrays.sort(shapes, Comparator.comparingDouble(Figure::area));

        return shapes;
    }

    /**
     * Checks if the given array of shapes contains a similar shape (same type and state) as the given shape.
     *
     * @param shapes The array of shapes to search in.
     * @param targetShape The target shape to find in the array.
     * @return true if a similar shape is found, false otherwise.
     */
    public static boolean findShape(Figure[] shapes, Figure targetShape) {
        for (Figure shape : shapes) {
            if (shape.getClass() == targetShape.getClass() && shape.equals(targetShape)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for array size between 2 and 20
        int arraySize;
        do {
            System.out.print("Enter the array size (between 2 and 20): ");
            arraySize = scanner.nextInt();
        } while (arraySize < 2 || arraySize > 20);

        // Create an array of Figures
        Figure[] shapesArray = new Figure[arraySize];

        // Populate the array with random objects of Triangle, Circle, and Rectangle
        for (int i = 0; i < arraySize; i++) {
            // Randomly choose the type of shape to create (0 for Triangle, 1 for Circle, 2 for Rectangle)
            int shapeType = i % 3; // Cycles through 0, 1, 2 for Triangle, Circle, Rectangle respectively

            // Generate random position, fill color, and line color
            Position position = new Position((int) (Math.random() * 100), (int) (Math.random() * 100));
            String fillColor = "Color" + i;
            String lineColor = "Outline" + i;

            // Generate random dimensions or radius based on shape type
            Figure shape;
            if (shapeType == 0) {
                // For Triangle, generate random side length
                int sideLength = (int) (Math.random() * 50) + 1;
                shape = new Triangle(position, fillColor, lineColor, sideLength);
            } else if (shapeType == 1) {
                // For Circle, generate random radius
                int radius = (int) (Math.random() * 50) + 1;
                shape = new Circle(position, fillColor, lineColor, radius);
            } else {
                // For Rectangle, generate random width and height
                int width = (int) (Math.random() * 50) + 1;
                int height = (int) (Math.random() * 50) + 1;
                shape = new Rectangle(position, fillColor, lineColor, width, height);
            }

            // Add the generated shape to the array
            shapesArray[i] = shape;
        }

        // Print details of each shape in the unsorted array
        System.out.println("Shapes before sorting:");
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            ShapeMover.printFigure(shapesArray[i]);
        }

        // Sort the shapes based on their area values
        shapesArray = sortShape(shapesArray);

        // Print details of each shape in the sorted array
        System.out.println("\nShapes after sorting based on Area:");
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            ShapeMover.printFigure(shapesArray[i]);
        }

        /* // Randomly select a shape type (0 for Triangle, 1 for Circle, 2 for Rectangle)
        int randomShapeType = (int) (Math.random() * 3);

        Figure randomShape;

        // Create a random shape based on the randomly selected shape type
        if (randomShapeType == 0) {
            // For Triangle, generate random side length
            int sideLength = (int) (Math.random() * 50) + 1;
            randomShape = new Triangle(new Position(5, 5), "Green", "Yellow", sideLength);
        } else if (randomShapeType == 1) {
        // For Circle, generate random radius
        int radius = (int) (Math.random() * 50) + 1;
        randomShape = new Circle(new Position(5, 5), "Green", "Yellow", radius);
        } else {
        // For Rectangle, generate random width and height
        int width = (int) (Math.random() * 50) + 1;
        int height = (int) (Math.random() * 50) + 1;
        randomShape = new Rectangle(new Position(5, 5), "Green", "Yellow", width, height);
        } */

        // Randomly select a shape from the existing shapesArray
        int randomIndex = (int) (Math.random() * arraySize);
        Figure randomShape = shapesArray[randomIndex];

        // Call findShape method with the random object and the array
        boolean foundRandomShape = findShape(shapesArray, randomShape);
        System.out.println("Result of findShape (Random Object): " + foundRandomShape);

        // Call findShape method with the first object of the array and the array itself
        Figure firstShape = shapesArray[0];
        boolean foundFirstShape = findShape(shapesArray, firstShape);
        System.out.println("\nResult of findShape (First Cell Object): " + foundFirstShape);
    }
}
