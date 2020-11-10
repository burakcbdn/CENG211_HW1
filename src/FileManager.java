import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private final String filePath;
    private int numberOfItems;


    FileManager(String filePath) {
        this.numberOfItems = getFileLineCount();
        this.filePath = filePath;
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

    public AnnualSale parseFile(String[][] transactions, String[][] items, int numberOfMonths){

        AnnualSale annualSale = new AnnualSale(numberOfItems);      

        for(int categoryIndex = 1; categoryIndex < numberOfItems; categoryIndex++) {

            int itemId = Integer.parseInt(items[categoryIndex][1]); //itemId index is 1
            String itemName = items[categoryIndex][0]; //itemName index is 0
            String itemCategory = items[categoryIndex][2]; // itemCategory index in

            Item item = new Item(itemId, itemName, itemCategory);

            ItemTransaction itemTransaction = new ItemTransaction(item, 4, numberOfMonths);

            double purchasePrice;
            double salePrice;
            int numberOfSales;
            int monthCounter = 1;

            for(int columnNumber = 1; columnNumber < (numberOfMonths * 3) +1 ;) {   // 37 column in transaction.csv
                purchasePrice = Double.parseDouble(transactions[categoryIndex][columnNumber++]); //i'th category
                salePrice = Double.parseDouble(transactions[categoryIndex][columnNumber++]);
                numberOfSales = Integer.parseInt(transactions[categoryIndex][columnNumber++]);
                itemTransaction.addTransactionItem( new Transaction(purchasePrice, salePrice, numberOfSales), 1, monthCounter);

                columnNumber -= 3;
            }
            annualSale.addAnnualSale(itemTransaction, itemId);

        }
        return annualSale;
    }
    


}
