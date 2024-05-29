package Activities;

public class MulTable {
    
    public static void main(String[] args) {
        int [][] mTable = new int[10][10];
        for (int row = 0; row < mTable.length; row ++){
            for (int col = 0; col < mTable[row].length; col++){
                mTable[row][col] = (row + 1) * (col + 1);
            }
        }
        for (int row = 0; row < mTable.length; row ++){
            for (int col = 0; col < mTable[row].length; col++){
                System.out.print(mTable[row][col] + " ");
                if ( mTable[col][row] < 10)
                    System.out.print(" ");
            }
            System.out.println("\n");
        }
        
    }   
}
