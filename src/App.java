import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main application for the Data Analysis Mini‑Project.
 *
 * TODO:
 *  - Update the path to your dataset file
 *  - Read the CSV file using Scanner
 *  - Parse each row and extract the correct columns
 *  - Construct Data objects from each row
 *  - Store them in an array
 *  - Write methods to analyze the dataset (min, max, average, filters, etc.)
 *  - Print insights and answer your guiding question
 *  - Add Javadoc comments for any methods you create
 */
public class App {

    public static void main(String[] args) throws FileNotFoundException {

        // TODO: Update this with your CSV file path
        File file = new File("WorldIndicators2000.csv");

        // TODO: Create an array of Data objects to store data
            Data[] dataList = new Data[2704];

        // TODO: Read file using Scanner
        Scanner scan = new Scanner(file);
        // - Skip header if needed
        scan.nextLine(); // Skip header line
        // - Loop through rows
        
        int index = 0;
        while (scan.hasNextLine() && index < dataList.length) {
            String line = scan.nextLine();
            
            String[] parts = line.split(",");
            
            String country = parts[0];

            String year = parts[1];

            String carbonEmissions = parts[4];

            // - Create new Data objects
            dataList[index] = new Data(country, year, carbonEmissions);

            index++;
        }
        // - Add to your array
        scan.close();


        // TODO: Call your analysis methods
        // Example:
        // double maxValue = findMaxValue(dataList);
        // double average = computeAverageValue(dataList);
            Data highestEmissionsData = Data.findHighestEmissions(dataList);
            

        // TODO: Print insights
        // - Number of rows loaded
        // - Min, max, average, or any other findings
        // - Final answer to your guiding question
        System.out.println("Country with the highest carbon emissions: " + highestEmissionsData.getCountry());
        System.out.println("Year: " + highestEmissionsData.getYear());
        System.out.println("Carbon Emissions: " + highestEmissionsData.getCarbonEmissions());

        // OPTIONAL TODO:
        // Add user interaction:
        // Ask the user what kind of analysis they want to see
    }


}