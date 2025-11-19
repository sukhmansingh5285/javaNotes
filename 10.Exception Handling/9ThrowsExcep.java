// 'throws' in a method declaration indicates the method may propagate one or more checked exceptions to its caller.
// The caller must either handle them (try-catch) or declare them with 'throws' as well; unchecked (runtime) exceptions need not be declared.

import java.io.*;

class ThrowsException
{
  static void show() throws IOException
  {
    throw new IOException("throws example");
  }

  public static void main(String...s)
  {
    try
    {
      show();
    } catch(IOException e){
      System.out.println(e+" main method");
    }
    System.out.println("After show");
  }
}