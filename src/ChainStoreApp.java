import java.io.File;

public class ChainStoreApp {
    public static void main(String[] args){
        System.out.println("Welcome to Chain Store");

        FileManager fileManager = new FileManager("HW1_Transactions_Store1.csv");

        fileManager.readFile();
    }
}
