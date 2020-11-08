import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private final String filePath;


    FileManager(String filePath) {
        this.filePath = filePath;
    }

    public String[][] readFile(int numberOfItems) {
    	// default parameter
    	return readFile(numberOfItems, 0);
    }
    
    public String[][] readFile(int numberOfItems, int categoryIndex) {
        String line;
        int index;
        String[][] lines = new String[numberOfItems][]; 
        
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
