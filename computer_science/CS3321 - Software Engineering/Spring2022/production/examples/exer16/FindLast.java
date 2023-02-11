// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 1; page 13

import java.io.*;

public class FindLast
{
  /**
    * Find last index of element
    *
    *  @param x array to search
    *  @param y value to look for
    *  @return last index of y in x; -1 if absent
    *  @throws NullPointerException if x is null
    */
   public static int findLast (int[] x, int y)
   {
      // As the example in the book points out, this loop should end at 0.
      for (int i=x.length-1; i > 0; i--)
      {
         if (x[i] == y)
         {
            return i;
         }
      }
      return -1;
   }
}
test: x = [0, 1, 0]; expected = 2
