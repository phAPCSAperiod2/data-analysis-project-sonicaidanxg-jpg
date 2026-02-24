/**
 * Represents one row from the dataset containing a country, year, and
 * carbon emissions value. Instances of this class hold the raw CSV fields
 * and provide simple accessors and utility methods for analysis.
 *
 * @author Aidan Manzanares
 */
public class Data {

    // TODO: Add at least 3 private attributes
    // Example:
    private String country;
    private String year;
    private String carbonEmissions;
    


    // TODO: Create a constructor that takes all attributes as parameters
    /**
     * Constructs a new Data record.
     *
     * @param country the country name for this record
     * @param year the year for this record (as a string)
     * @param carbonEmissions the carbon emissions value for this record (as a string)
     */
    public Data(String country, String year, String carbonEmissions) {
        this.country = country;
        this.year = year;
        this.carbonEmissions = carbonEmissions;
    }

    // TODO: Add getters for attributes you need
    /**
     * Returns the country name for this record.
     *
     * @return the country name, or null if not set
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the year for this record.
     *
     * @return the year as a string, or null if not set
     */
    public String getYear() {
        return year;
    }

    /**
     * Returns the carbon emissions value for this record.
     * The value is stored as a string; callers should parse it as a number
     * when numeric operations are required.
     *
     * @return the carbon emissions value as a string, or null if not set
     */
    public String getCarbonEmissions() {
        return carbonEmissions;
    }

    // TODO: Add other data analysis methods

    /**
     * Finds the {@code Data} record with the highest carbon emissions from an array
     * of records. Non-numeric or empty emission values are ignored. If multiple
     * records share the same highest numeric value, the first encountered is
     * returned.
     *
     * @param dataArray an array of {@code Data} objects containing country and emission information
     * @return the {@code Data} object with the highest carbon emissions, or {@code null} if the array is null or empty
     * @author Aidan Manzanares
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

    /**
     * Returns a readable string representation of this {@code Data} object.
     *
     * @return a string containing the country, year, and carbon emissions values
     */
    @Override
    public String toString() {
        return "Data{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", carbonEmissions=" + carbonEmissions +
                '}';
    }

}