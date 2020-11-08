import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private final String filePath;


    FileManager(String filePath) {
        this.filePath = filePath;
    }

    
    public String[][] readFile() {
        String line;
        int index = 0;
        String[][] lines = new String[32][]; //32 is the amount of items
        try {
            //parsing a CSV file into BufferedReader class constructor
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
            	lines[index++] = line.split(",");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
