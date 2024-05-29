package Activities;
import java.util.Scanner;

public class Register {

    public static String changeAmount(float charge, float payment) {

        float change = payment - charge;
        if (change == 0)
            return "You have no change.";
        boolean owes;
        owes = (change < 0);
        if (owes)
            change = -1 * change;
        int dollars = (int) change;
        float remaining = change - dollars;
        int cents = (int) (remaining * 100);
        return (owes ? "You still owe " : "Your change is ") + dollars + " dollar" + (dollars == 1 ? "" : "s") + " and " + cents + " cent" + (cents == 1 ? "" : "s");
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the charge: ");
        float charge = scanner.nextFloat();

        System.out.print("Enter the payment: ");
        float payment = scanner.nextFloat();

        System.out.println(changeAmount(charge, payment));
    }
    
}
