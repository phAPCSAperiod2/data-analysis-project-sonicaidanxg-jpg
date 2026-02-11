/**
 * Represents one row from your dataset.
 *
 * TODO:
 *  - Rename the class to match your dataset (e.g., Pokemon, StateData, CountryStat)
 *  - Add at least 3 private attributes based on your CSV columns
 *  - Write a constructor that initializes all attributes
 *  - Add getter methods for the attributes you need in your analysis
 *  - Override toString() to display the object's data
 *  - Add Javadoc comments for the class and all methods
 */
public class Data {

    // TODO: Add at least 3 private attributes
    // Example:
    private String country;
    private String year;
    private String carbonEmissions;
    


    // TODO: Create a constructor that takes all attributes as parameters
    public Data(String country, String year, String carbonEmissions) {
        this.country = country;
        this.year = year;
        this.carbonEmissions = carbonEmissions;
    }

    // TODO: Add getters for attributes you need
    public String getCountry() {
        return country;
    }

    public String getYear() {
        return year;
    }

    public String getCarbonEmissions() {
        return carbonEmissions;
    }

    // TODO: Add other data analysis methods

    /**
     * Finds the Data record with the highest carbon emissions from a list of data records.
     *
     * @param dataArray an array of Data objects containing country and emission information
     * @return the Data object with the highest carbon emissions, or null if array is empty
     */
    public static Data findHighestEmissions(Data[] dataArray) {
        if (dataArray == null || dataArray.length == 0) {
            return null;
        }
        
        Data highestEmissionData = dataArray[0];
        long highestEmissions = 0;
        
        // Find first non-empty emissions value to start with
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i].getCarbonEmissions() != null && !dataArray[i].getCarbonEmissions().isEmpty()) {
                try {
                    highestEmissions = Long.parseLong(dataArray[i].getCarbonEmissions());
                    highestEmissionData = dataArray[i];
                    break;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i].getCarbonEmissions() != null && !dataArray[i].getCarbonEmissions().isEmpty()) {
                try {
                    long emissions = Long.parseLong(dataArray[i].getCarbonEmissions());
                    if (emissions > highestEmissions) {
                        highestEmissions = emissions;
                        highestEmissionData = dataArray[i];
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        
        return highestEmissionData;
    }

    // TODO: Override toString() to return a readable representation of your object
    @Override
    public String toString() {
        
    
        return "Data{" +
    
        "country='" + country + '\'' +
    
        ", year=" + year +
    
        ", carbonEmissions=" + carbonEmissions +
    
        '}';
    }

}