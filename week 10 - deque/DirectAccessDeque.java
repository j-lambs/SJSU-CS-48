/**
 * A simple Deque (Double Ended Queue) that provides
 * direct access.  All methods should run in average
 * O(1) time.  For your purposes:  the Deque will
 * only hold Strings.  It should resize to grow if
 * needed, but I will not force you to shrink the
 * underlying data structure as it empties.  I also
 * won't force you to worry about what exceptions to
 * throw when something goes wrong, for instance when
 * you try to remove from an empty Deque.
 * @author dtaylor
 */
public interface DirectAccessDeque {
   /**
    * Adds elt to the front of the Deque.
    * @param elt
    */
   public void addFirst(String elt);

   /**
    * Adds elt to the back of the Deque.
    * @param elt
    */
   public void addLast(String elt);

   /**
    * Removes and returns elt from the front of the Deque.
    * @param elt
    */
   public String removeFirst();
   /**
    * Removes and returns elt from the back of the Deque.
    * @param elt
    */
   public String removeLast();
   /**
    * Returns elt at the front of the Deque.
    * @param elt
    */ 
   public String getFirst();
   /**
    * Returns elt at the back of the Deque.
    * @param elt
    */ 
   public String getLast();
   /**
    * Returns elt at index of the Deque, assuming that the front element is indexed at 0.
    * @param elt
    */ 
   public String get(int index);
   
   /**
    * Returns the number of elements in the Deque.
    * @return
    */
   public int size();
   
}
