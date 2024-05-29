package Activities;
import java.util.Scanner;

public class CountUp {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        for(int i=0; i<=number; i++) {
            System.out.println(i);
        }
    }
}
