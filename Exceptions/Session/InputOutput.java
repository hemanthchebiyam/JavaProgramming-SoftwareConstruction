package Session;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutput {
    public static void main(String[] args) {
        String[] src = new String[]{"static", " ", "void main"};
        writeString(src, "XOX.txt");

        readString("XOX.txt");
    }

    public static void writeString(String[] src, String filename){
        try{
            FileWriter writer = new FileWriter(filename);
            for(int i = 0; i < src.length; i++) {
                writer.write(src[i]);
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static String[] readString(String filename){
        try{
            FileReader reader = new FileReader(filename);

            char[] c = new char[15];
            reader.read(c);
            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        finally{
            String [] st = new String[3];
            return st;
        }
    }
}
