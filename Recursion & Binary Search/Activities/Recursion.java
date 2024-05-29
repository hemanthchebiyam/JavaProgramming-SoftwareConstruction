package Activities;

public class Recursion {
    //Main Method
    public static void main(String[] args) {
        //countDown(10);
        //countDownRec(10);
        //countUpRec(10);
        countUpRec(20000);
        int [] test = new int[]{2,10,12,9,36,28,93,45,6};
        System.out.println(searchArr(test, 9, 0));
    }

    //Methods
    public static void countDown(int n) {
        for ( int i = n; i >= 0; i--)
            System.out.println(i);
    }

    public static void countDownRec(int n) {
        System.out.println(n);
        if (n>0)
            countDownRec(n-1);
    }

    public static void countUpRec(int n) {
        if (n>0) 
            countUpRec(n-1);
        System.out.println(n);
        
    }

    public static boolean searchArr(int [] arr, int target, int index) {
        if (arr[index] == target) {
            return true;
        }else{
            if (index+1 == arr.length)
                return false;
            return searchArr(arr, target, index + 1);
        }
    }
}
