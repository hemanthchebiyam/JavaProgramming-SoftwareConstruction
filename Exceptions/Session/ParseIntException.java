package Session;

public class ParseIntException {
    public static void main(String[] args) {
        String str = "abcd";
        int number;

        try {
            number = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            System.out.println("Conversion error: " + e.getMessage());
            System.out.println("Conversion error: " + e.getCause());
        }
        catch (IllegalArgumentException e1) {
            System.out.println("Bad number format");
        }
        catch (Exception e2) {
            System.out.println("Bad number format!");
        }
    }
}
