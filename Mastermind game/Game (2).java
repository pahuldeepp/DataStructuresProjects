// Student id 3153555
// Pahuldeep Singh

import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        simulation();
        //Dynamic array
        // ArrayList<String> list= new ArrayList<>();
        // list.add("john");
        // list.add("Seema");
        // list.add("Jeet");
        // list.add("Fatheh");
        // System.out.println(list);
        // list.add("john");
        // list.add("Seema");
        // list.add("Jeet");
        // list.add("Fatheh");
        // System.out.println(list);
        // list.add("john");
        // list.add("Seema");
        // list.add("Jeet");
        // list.add("Fatheh");
        // System.out.println(list);
        // list.add("john");
        // list.add("Seema");
        // list.add("Jeet");
        // list.add("Fatheh");
        // System.out.println(list);
        // list.add("john");
        // list.add("Seema");
        // list.add("Jeet");
        // list.add("Fatheh");
        // System.out.println(list);
        // list.add("john");
        // list.add("Seema");
        // list.add("Jeet");
        // list.add("Fatheh");
        // System.out.println(list);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // System.out.println(list);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // System.out.println(list);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // System.out.println(list);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // System.out.println(list);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // list.remove(0);
        // System.out.println(list);

    }

    public static void simulation() {
        Random gen = new Random();
        Colour[] colourar = Colour.values();
        ArrayList<Colour> code = new ArrayList<>(4);

        // Generate random code
        for (int i = 0; i < 4; i++) {
            code.add(colourar[gen.nextInt(6)]);
        }
        //  code for testing purposes
        // code.add(Colour.WHITE);
        // code.add(Colour.BLUE);
        // code.add(Colour.YELLOW);
        // code.add(Colour.GREEN);

        // Print the code using array iterator
        System.out.print("[Code: ");
        for (Colour color : code) {
            System.out.print(color + " ");
        }
        System.out.println("]");

        ArrayList<Colour> guess;
        Scanner kb = new Scanner(System.in);

        int maxCount = 1;
        boolean valid = false;
        int matchCount = 0; // Declare matchCount outside the loop
        StringBuilder smb = new StringBuilder();

        // Main game loop
        while (maxCount < 12 && !valid) {
            guess = new ArrayList<>(4);
            matchCount = 0; // Reset matchCount for each guess
            smb.setLength(0); // Reset StringBuilder for each guess

            // Prompt for guess
            System.out.println("System : Guess #" + maxCount);
            System.out.print("Player : ");

            try {
                // Get player's guess
                for (int i = 0; i < 4; i++) {
                    Colour inputCol = Colour.valueOf(kb.next().toUpperCase());
                    guess.add(inputCol);
                }
            } catch (Exception e) {
                // Handle invalid input
                System.out.println("System: The System has won, The input was invalid");
                return;
            }

            // Checking the guess against the code
            boolean[] tofind = new boolean[4];// Array to track matched positions
            boolean found = false;
            for (int i = 0; i < 4; i++) {
                // Check for exact matches ('x')
                if (guess.get(i) == code.get(i)) {
                    matchCount++;
                    smb.append("x");
                    tofind[i] = true; // Mark position as matched
                }
            }

            // Check for partial matches ('o')
            if (matchCount < 4) {
                for (int i = 0; i < 4; i++) {
                    if (!tofind[i]) { // If the position is not already matched
                        boolean checked = false;
                        for (int j = 0; j < 4; j++) {
                            if (!tofind[j] && guess.get(i) == code.get(j)) {
                                smb.append("o");
                                checked = true;// Mark position as matched for partial match
                                tofind[j] = true; // Mark position as matched
                                break;
                            }
                        }
                        if (!checked) {
                            smb.append("-");
                        }
                    }
                }
            }

            // Fill remaining slots with "-"
            while (smb.length() < 4) {
                smb.append("-");
            }

            // Check if the guess is correct
            if (matchCount == 4) {
                valid = true;
            }

            // Print result
            maxCount++;
            System.out.print("System : ");
            for (int i = 0; i < 2; i++) {
                System.out.print(smb.charAt(i) + " ");
            }
            System.out.println();
            System.out.print("\t");
            for (int i = 2; i < smb.length(); i++) {
                System.out.print(smb.charAt(i) + " ");
            }
            System.out.println();
        }

        // Print final result
        if (maxCount >= 12) {
            System.out.println("System: The System has won");
        } else {
            System.out.println("System: You cracked the code!");
        }
    }
}
