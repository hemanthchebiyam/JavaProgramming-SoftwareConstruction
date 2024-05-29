package Session;

import java.io.File;

public class Files {
    public static void main(String[] args) {
        createfile("XOX");
    }

    public static void createfile(String name) {
        File file = new File(name + ".txt");
        try {
            file.createNewFile();
        }
        catch (Exception e) {

        }
        //Print path
        System.out.println("File path: " + file.getAbsolutePath());

        //Message exists
        System.out.println("The file already existed: " + file.exists());

        //Print number of bytes
        System.out.println("Number of bytes in file: " + file.length());
    }
}
