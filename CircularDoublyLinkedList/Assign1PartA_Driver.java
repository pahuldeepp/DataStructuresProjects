
public class Assign1PartA_Driver {
    public static void main(String[] args) {
        WaitlistedStudent[] newList = {
                new WaitlistedStudent("1111111", "Michael", Status.PERMITTED_TO_REGISTER, 2),
                new WaitlistedStudent("2222222", "Jessica", Status.WAITLISTED, 0),
                new WaitlistedStudent("3333333", "Alexander", Status.WAITLISTED, 0),
                new WaitlistedStudent("3180599", "Kuldeep Kaur", Status.WAITLISTED, 0)
        };
       CourseWaitlist list= new CourseWaitlist(newList);
    }
}
