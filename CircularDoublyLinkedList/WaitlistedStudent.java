
public class WaitlistedStudent extends Student {
    private Status myStatus;
    private int days;

    public WaitlistedStudent(String id, String name) {
        super(id, name);
        myStatus = Status.WAITLISTED;
        days = 0;
    }

    public WaitlistedStudent() {
        myStatus = Status.WAITLISTED;
        days = 0;
    }

    public WaitlistedStudent(int days) {
        super();
        myStatus = Status.WAITLISTED;
        this.days = days;
    }

    public WaitlistedStudent(String studentNumber, String studentName, Status status, int days) {
        super(studentNumber, studentName);
        myStatus = status;
        this.days = days;
    }

    public Status getStatus() {
        return myStatus;
    }

    public void setStatus(Status status) {
        this.myStatus = status;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String toString() {
        if (this.myStatus == Status.WAITLISTED) {
            return super.toString() + ", Status: " + myStatus + "\n";
        } else {
            return super.toString() + ", Status: " + myStatus + ", Days left: " + days + "\n";
        }
    }

}