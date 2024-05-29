package Activities;
import java.util.Scanner;

public class Calendar {

    public static String getSuffix(int day) {
        if (day < 1 || day > 31)
            return null;
        switch (day) {
            case 11:
            case 12:
            case 13:
                return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the day of the month: ");
        int day = scanner.nextInt();
        
        String suffix = getSuffix(day);
        
        if (suffix == null)
            System.out.println("That is an invalid day");
        else
            System.out.println("It is the " + day + suffix + ".");
    }
}
