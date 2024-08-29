//Student Name: Pahuldeep Singh
// Student number:3153555
import java.util.Random;
import java.util.Scanner;

public class CourseWaitlist {
    private CircularDoublyLinkedList<WaitlistedStudent> list;
    private static final int MAX_OPERATIONS = 20;

    public CourseWaitlist(WaitlistedStudent[] students) {
        list = new CircularDoublyLinkedList<>();
        for (WaitlistedStudent student : students) {
            list.addLast(student);
        }
        grantPermission();

        simulation();

    }

    public void grantPermission() {
        WaitlistedStudent s = list.first();
        s.setStatus(Status.PERMITTED_TO_REGISTER);
        s.setDays(2);
    }

    public void simulation() {
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);
        System.out.println("ACS-2947 Waitlist");
        int round = 0;
        System.out.println(list);
        while (round < MAX_OPERATIONS && !list.isEmpty()) {
            operation(rand, kb);
            round++;
        }
        if (round == MAX_OPERATIONS) {
            System.out.println("Reached 20 days/operations! \n");
            System.out.println("Final waitlist:");
            System.out.println(list);
        } 
        try {
            if (list.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("list is empty");
        }
        kb.close();
    }
    
    public void reducedays() {
        WaitlistedStudent firstStudent = list.first();
        int days = firstStudent.getDays();
        if (days >0) {
            days = days - 1;
            firstStudent.setDays(days); 
        }
    }
    

    public void operation(Random rand, Scanner kb) {
        int value = rand.nextInt(4)+1;
        
        switch (value) {
            case 1:
           
                System.out.println("System chose option 1: No addition to waitlist (status/days left may change)");
                
                if (list.first().getStatus() == Status.PERMITTED_TO_REGISTER) {
                    reducedays();
                    // System.out.println(list.first().getDays());
                    if (list.first().getDays() ==0) {
                        list.first().setStatus(Status.WAITLISTED);
                        list.rotate();
                        list.first().setDays(2);
                    }
                }

                if (!list.isEmpty() && list.first().getStatus() != Status.PERMITTED_TO_REGISTER)
                    list.first().setStatus(Status.PERMITTED_TO_REGISTER);
                    System.out.println(list);
                break;
            case 2:
            
                System.out.println("System chose option 2: A new student joins the waitlist");
                System.out.println("Enter the Student id and name");
                WaitlistedStudent s = new WaitlistedStudent(kb.next(), kb.nextLine());
                list.addLast(s);
                if (list.first().getStatus() == Status.PERMITTED_TO_REGISTER) {
                    reducedays();
                    // System.out.println(list.first().getDays());
                    if (list.first().getDays() ==0) {
                        list.first().setStatus(Status.WAITLISTED);
                        list.rotate();
                        list.first().setDays(2);
                    }
                }
                if (!list.isEmpty() && list.first().getStatus() == Status.WAITLISTED) {
                    list.first().setStatus(Status.PERMITTED_TO_REGISTER);
                }
                System.out.println(list);
                
                break;

            case 3:
            
                if (!list.isEmpty() && list.first().getStatus() != Status.WAITLISTED) {
                    System.out.println("System chose option 3:" + list.first().getStudentName() + " Registers");
                     
                    WaitlistedStudent p = list.removeFirst();
                    if (list.first().getStatus() == Status.WAITLISTED) {
                        grantPermission();
                    }
                    
                    }
                    System.out.println(list);

                
                break;

            case 4:
                System.out.println("System chose option 4: Check if a student is on the waitlist");
                System.out.println("Enter student number and name:");
                String searchName = kb.next();
                String searchNumber = kb.next();
                WaitlistedStudent studentToCheck = new WaitlistedStudent(searchName, searchNumber);
                boolean containsStudent = list.contains(studentToCheck);
                if (containsStudent) {
                    System.out.println("Student is on the waitlist");
                } else {
                    System.out.println("Student is not on the waitlist");
                }
                if (list.first().getStatus() == Status.PERMITTED_TO_REGISTER) {
                    reducedays();
                    // System.out.println(list.first().getDays());
                    if (list.first().getDays() ==0) {
                        list.first().setStatus(Status.WAITLISTED);
                        list.rotate();
                        list.first().setDays(2);
                    }
                }
                if (!containsStudent && list.first().getStatus() != Status.PERMITTED_TO_REGISTER) {
                    grantPermission();
                }
             
                System.out.println(list);
                break;

        }
    }

}