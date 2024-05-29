import java.util.Random;

public class SortUtilities {
    
    private static Random RNG = new Random();
    
    public static boolean sorted(int[] arr) {
        for(int i=0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

    public static int[] swap(int [] input, int a, int b) {
        
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
        
        return input;
    }

    public static int[] makeArray(int length) {
        int [] output = new int[length];
        for(int i = 0; i < length; i++){
            output[i]=RNG.nextInt(length+1);
        }
        return output;
    }
}
