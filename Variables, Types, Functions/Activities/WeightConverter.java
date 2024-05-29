package activities;

public class WeightConverter {
    public static double convertWeight(double weightInPounds){
        System.out.println("Weight in pounds = " + weightInPounds);
        double kilos = weightInPounds / 2.2;
        System.out.println("Kilos = " + kilos);
        return kilos;
    }

    public static void main(String[] args){
        double one = convertWeight(186.2);
        double two = convertWeight(207.0);
        System.out.println("Total: " + (one + two));
    }


}
