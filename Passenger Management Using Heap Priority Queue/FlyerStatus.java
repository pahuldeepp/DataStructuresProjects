import java.util.Random;

/**
 * //Name Pahuldeep Singh
// Studentid 3153555
 * Enumeration representing flyer status.
 */
public enum FlyerStatus {
    Gold ("Gold"), // Gold flyer status
    Silver("Silver"), // Silver flyer status
    Bronze("Bronze"), // Bronze flyer status
    None("None"); // No flyer status

    private String status; // String representation of the flyer status

    /**
     * Constructs a FlyerStatus enum with the specified status.
     * @param status the status representing the flyer status
     */
    private FlyerStatus(String status){
        this.status=status;
    }

    /**
     * Gets the status representing the flyer status.
     * @return the status representing the flyer status
     */
    public String getFlyerStatus(){
        return status;
    }

    /**
     * Generates a random FlyerStatus.
     * @return a random FlyerStatus
     */
    public static FlyerStatus randomValue() {
        FlyerStatus[] mystatus = FlyerStatus.values(); // Get all possible FlyerStatus values
        Random gen = new Random(); // Create a Random object
        return mystatus[gen.nextInt(mystatus.length)]; // Return a random FlyerStatus
    }
}
