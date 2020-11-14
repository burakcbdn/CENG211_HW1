import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private final String filePath;
    private int numberOfItems;


    FileManager(String filePath) {
        this.filePath = filePath;
        this.numberOfItems = getFileLineCount();
    }

    // This is not efficient (Reading file 2 times) but since we have to use array, this is required
    public int getFileLineCount() {
        int count = 0;
        
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((bufferedReader.readLine()) != null) {
                count += 1;
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public String[][] readFile() {
        // default parameter
        return readFile(0);
    }

    public String[][] readFile(int categoryIndex) {
    	String line;
        int index;
        
        String[][] lines = new String[numberOfItems + 1][];

        try {
            //parsing a CSV file into BufferedReader class constructor
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                //Getting the category of the item
                index = Integer.parseInt(String.valueOf(line.split(",")[categoryIndex]));
                //Placing according to its category
                lines[index] = line.split(",");

            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    


}
