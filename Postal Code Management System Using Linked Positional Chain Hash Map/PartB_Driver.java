import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PartB_Driver {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("PartB.txt");
        Scanner sc = new Scanner(f);
        LinkedPositionalChainHashMap<String, PostalCode> map = new LinkedPositionalChainHashMap<>();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] inputarr = input.split(",");
            map.put(inputarr[0], new PostalCode(inputarr[0], inputarr[1], inputarr[2], Double.parseDouble(inputarr[3]),
                    Double.parseDouble(inputarr[4])));
        }

        System.out.println("Number of elements in the map: " + map.size());
        System.out.println("Number of collisions: " + map.getCollisions());

        Scanner kb = new Scanner(System.in);
        System.out.println("Display by code (C) or Longitude (L) (any other key to quit)");
        String userInput = kb.next();

        List<Entry<String, PostalCode>> list = new ArrayList<>();
        for (Entry<String, PostalCode> E : map.entrySet()) {
            list.add(E);
        }
        if (userInput.equalsIgnoreCase("C")) {
            // Sort by postal code (using natural ordering)
            Collections.sort(list, new OrderbyCode());
        } else if (userInput.equalsIgnoreCase("L")) {
            // Sort by longitude
            Collections.sort(list, new OrderbyLongitude());
        } else {
            return;
        }

        for (Entry<String, PostalCode> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
