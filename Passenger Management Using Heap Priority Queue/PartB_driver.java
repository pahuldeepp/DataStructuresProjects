import java.util.Scanner;
//Name Pahuldeep Singh
// Student id 3153555 

public class PartB_driver {
    public static void main(String[] args) {
        // Creating a heap priority queue to store Passenger objects
        HeapPriorityQueue<Passenger, String> list = new HeapPriorityQueue<>(new PassengerComparator<>());
        Scanner kb = new Scanner(System.in);

        // Prompt the user to enter passport numbers for new passengers
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter passport no of new passenger:");
            String passportNum = kb.next();
            Passenger p = new Passenger(passportNum);
            list.insert(p, passportNum);
            System.out.println("Adding Passenger: " + p);
            System.out.println("Standby list " + list);
        }

        // Removing and seating the first 5 passengers
        for (int i = 0; i < 5; i++) {
            Entry<Passenger, String> removed = list.removeMin();
            System.err.println("Passenger " + "( " + removed.getKey() + " ) gets seated .");
            System.out.println("Standby list: " + list);
        }

        // Prompting the user to enter passport numbers for additional passengers
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter passport no of new passenger:");
            String passportNum = kb.next();
            Passenger p = new Passenger(passportNum);
            list.insert(p, passportNum);
            System.out.println("Adding Passenger: " + p);
            System.out.println("Standby list " + list);
        }

        // Removing and seating passengers until the standby list is empty
        while (!list.isEmpty()) {
            Entry<Passenger, String> removed = list.removeMin();
            System.err.println("Passenger " + "( " + removed.getKey() + " ) gets seated .");
            System.out.println("Standby list: " + list);
        }
    }
}
