package Activities;

import java.util.Scanner;

public class StringTester {
    public static void main(String[] args) {
        String a = "buttercup";
        String b = "buttercup";
        String c = "butter";

        String x = new String("buttercup");
        String y = new String("buttercup");


        System.out.println("a==b: " + (a==b));
        System.out.println("a==c: " + (a==c));
        System.out.println("x==y: " + (x==y));
        System.out.println("a==x: " + (a==x));


        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter String 1: ");
            String str1 = scanner.next();
            System.out.println("Enter String 2: ");
            String str2 = scanner.next();
            System.out.println(str1 + " == " + str2 + " : " + (str2 == str1));
        }

    }
}
