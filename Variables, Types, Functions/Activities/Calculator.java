package activities;
import java.util.Scanner;

public class Calculator {
    public static void Compute(double x, double y){
        System.out.println("The value of x = " + x);
        System.out.println("The value of y = " + y);
        System.out.println("x + y = " + (x+y));
        System.out.println("x * y = " + (x*y));
        System.out.println("x - y = " + (x-y));
        System.out.println("x / y = " + (x/y));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter one number: ");
        double x = scanner.nextDouble();
        
        System.out.print("Enter another number: ");
        double y = scanner.nextDouble();

        Compute(x, y);
        
        //Compute(6,3);
        //Compute(10,5);
        //Compute(25,4);

    }
    
}
