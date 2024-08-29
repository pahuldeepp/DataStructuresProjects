import java.util.Random;

/**
 * //Name Pahuldeep Singh
// Studentid 3153555
 * Enumeration representing fare codes.
 */
public enum FareCode {
    Full("Full"), // Full fare code
    DISC("Disc"), // Discount fare code
    BUDDY("Buddy"); // Buddy fare code

    private String code; // String representation of the fare code

    /**
     * Constructs a FareCode enum with the specified code.
     * @param code the code representing the fare
     */
    FareCode(String code){
       this.code= code;
    }

    /**
     * Gets the code representing the fare.
     * @return the code representing the fare
     */
    public String getCode(){
        return code;
    }

    /**
     * Generates a random FareCode.
     * @return a random FareCode
     */
    public static FareCode randomValue(){
        FareCode[] myarray= FareCode.values(); // Get all possible FareCode values
        Random gen= new Random(); // Create a Random object
        return myarray[ gen.nextInt(myarray.length)]; // Return a random FareCode
    }
}
