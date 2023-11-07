package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class DequeTest {

   @Test
   public void test() {
      DirectAccessDeque d = new MyArrayDeque();
      d.addFirst("5");
      d.addLast("6");
      d.addFirst("4");
      d.addLast("7");
      d.addLast("8");
      d.addLast("9");
      d.addLast("10");
      d.addLast("11");
      d.addFirst("3");
      d.addFirst("2");
      d.addFirst("1");
      d.addFirst("0");
      d.addLast("12");
      for(int i = 0; i <= 12; i++)
         Assert.assertEquals("" + i,  d.get(i));
      
      Assert.assertEquals("0",d.removeFirst());
      Assert.assertEquals("1",d.removeFirst());
      Assert.assertEquals("12",d.removeLast());
      Assert.assertEquals("11",d.removeLast());
      Assert.assertEquals("10",d.removeLast());
      Assert.assertEquals(8,d.size());
      for(int i = 2; i <= 9; i++)
         Assert.assertEquals("" + i,  d.get(i-2));
      Assert.assertEquals("2",d.getFirst());
      Assert.assertEquals("9",d.getLast());

      
      
   }

}
