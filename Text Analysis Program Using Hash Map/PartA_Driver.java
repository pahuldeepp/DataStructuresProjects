import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartA_Driver{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("PartA.txt");
        Scanner kb = new Scanner(file);
        ProbeHashMap<String, Integer> wordsMap = new ProbeHashMap<>();
        ProbeHashMap<Character, Integer> charMap = new ProbeHashMap<>();
        
        // Define ArrayList to store words
        ArrayList<String> wordarray = new ArrayList<>();
        
        while (kb.hasNext()) {
            String input = kb.next();
            wordarray.add(input);
            char[] charr = input.toCharArray();
            ArrayList<Character> chararray = new ArrayList<>();
            for (char c : charr) {
                chararray.add(c);
            }
            int count = 0;
            for (int i = 0; i < wordarray.size(); i++) {
                for (int j = i + 1; j < wordarray.size(); j++) {
                    if (wordarray.get(i).equals(wordarray.get(j))) {
                        count++;
                    }
                }
                wordsMap.put(wordarray.get(i), count);
            }
            
            int charcount = 0;
            for (int i = 0; i < chararray.size(); i++) {
                for (int j = i + 1; j < chararray.size(); j++) {
                    if (chararray.get(i).equals(chararray.get(j))) {
                        charcount++;
                    }
                }
                charMap.put(chararray.get(i), charcount);
            }
        }
        
        // Close the Scanner
        kb.close();
        
    }
}