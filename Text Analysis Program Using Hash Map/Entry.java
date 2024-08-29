/*
 * From Data Structures and Algorithms in Java, Sixth Edition, Goodrich et al.
 */

/**
 * /**
 * Student id 3153555
 * Pahuldeep Singh
 * Interface for a key-value pair.
 */

public interface Entry<K,V> {
    
  /**
   * Returns the key stored in this entry.
   * @return the entry's key
   */
  K getKey();

  /**
   * Returns the value stored in this entry.
   * @return the entry's value
   */
  V getValue();
}
