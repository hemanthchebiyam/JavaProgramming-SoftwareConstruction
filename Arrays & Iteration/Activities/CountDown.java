package Activities;
import java.util.Scanner;

public class CountDown {
    
    public static void cDown(int number) {
        int count = number;
        while (count >= 0) {
            System.out.println(count);
            count -= 1;
        }
    } 

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        cDown(number);

    }
}
