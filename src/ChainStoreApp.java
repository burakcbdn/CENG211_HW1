import java.io.File;

public class ChainStoreApp {
    public static void main(String[] args){
        System.out.println("Welcome to Chain Store");
        int numberOfItems = 32;

        FileManager fileManager = new FileManager("HW1_Items.csv");
        
        System.out.println(fileManager.readFile(numberOfItems)[1][0]);
    }
}
