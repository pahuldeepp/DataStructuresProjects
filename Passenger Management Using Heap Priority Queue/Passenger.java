import java.sql.Timestamp;

/**
 * //Name Pahuldeep Singh
// Studentid 3153555
 * The Passenger class represents a passenger with a passport number, fare code,
 * flyer status, and timestamp.
 */
public class Passenger implements Comparable<Passenger> {
    private String passportNum;
    private FareCode fareCode;
    private FlyerStatus status;
    private Timestamp time;

    /**
     * Constructs a passenger with the specified passport number, fare code,
     * flyer status, and timestamp.
     * 
     * @param passportNum the passport number of the passenger
     * @param fareCode    the fare code of the passenger
     * @param status      the flyer status of the passenger
     * @param time        the timestamp of when the passenger was created
     */
    public Passenger(String passportNum, FareCode fareCode, FlyerStatus status, Timestamp time) {
        this.passportNum = passportNum;
        this.fareCode = fareCode;
        this.status = status;
        this.time = time;
    }

    /**
     * Constructs a passenger with the specified passport number, and assigns random
     * values to fare code, flyer status, and timestamp.
     * 
     * @param passportNum the passport number of the passenger
     */
    public Passenger(String passportNum) {
        this.passportNum = passportNum;
        this.fareCode = FareCode.randomValue();
        this.status = FlyerStatus.randomValue();
        this.time = new Timestamp(System.currentTimeMillis());
    }

    // Getters and setters for passport number, fare code, flyer status, and timestamp

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public FareCode getFareCode() {
        return fareCode;
    }

    public void setFareCode(FareCode fareCode) {
        this.fareCode = fareCode;
    }

    public FlyerStatus getStatus() {
        return status;
    }

    public void setStatus(FlyerStatus status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    // Comparable interface implementation to compare passengers based on passport number
    @Override
    public int compareTo(Passenger p) {
        return this.passportNum.compareTo(p.passportNum);
    }

    // toString method to represent the Passenger object as a string
    @Override
    public String toString() {
        return "Passport: " + passportNum + ", Fare: " + fareCode.getCode() + ", FlyerStatus: " + status + ", Time: " + time;
    }
}
