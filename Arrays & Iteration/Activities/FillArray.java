package Activities;
import java.util.Scanner;

public class FillArray {
    public static int[] getArray(int length) {
        int [] arr = new int[length];
        for (int i = 0; i < length; i++) 
            arr[i] = 10*i;
        return arr;
        
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int [] arr = getArray(number);

        for(int num : arr) {
            System.out.println(num);
        }
    }
}
