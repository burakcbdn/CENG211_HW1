import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    String filePath;


    FileManager(String filePath) {
        this.filePath = filePath;
    }


    public void readFile() {
        String line;
        String[] lines;
        try {
            //parsing a CSV file into BufferedReader class constructor
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
