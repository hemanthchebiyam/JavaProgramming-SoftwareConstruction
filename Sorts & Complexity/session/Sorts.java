import java.util.Arrays;

public class Sorts {
    
    public static void main(String[] args) {
        int[] arr = SortUtilities.makeArray(10);
        SelectionSort(arr);
    }
    
    //in place and ascending
    public static int[] SelectionSort(int [] array){
        int currIndex = 0;
        while (!SortUtilities.sorted(array)){
            System.out.println("Selection Step: " + Arrays.toString(array));
            int minIndex = currIndex;
            for(int j = currIndex; j < array.length; j++){
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            SortUtilities.swap(array, currIndex, minIndex);
            currIndex++;
        }
        return array;
    }
}
