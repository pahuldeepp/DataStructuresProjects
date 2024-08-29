import java.util.Comparator;

public class OrderLettersByFrequency implements Comparator<Entry<Character,Integer>> {

    @Override
    public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
      int frequency=  Integer.compare(o1.getValue(),o2.getValue());
      if(frequency!=0){
        return frequency;
      }else{
        return o1.getKey().compareTo(o2.getKey());
      }
    }
    
}
