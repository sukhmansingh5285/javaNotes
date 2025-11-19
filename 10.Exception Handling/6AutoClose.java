/* create a try block and two Demo class object as resource in try-with resource statement, exit the system, have an Arithmetic error, call show and show1 method from both
  objects,  
*/

// To use custom objects as resources in a try-with-resources statement, the objects must implement the AutoCloseable interface. The objects are 
// declared as resources inside the try-with-resources statement, and they will be automatically closed when the block exits.
class Myauto{
  public static void main(String... s)
  {
    try(Demo d = new Demo();  Demo1 d1 = new Demo1())
    {
      // System.exit(0);
      int x = 10/0;
      d.show();
      d1.show1();
    }
    catch(ArrayIndexOutOfBoundsException e){ // exception isn't handled as it was an Arithmatic Exception
      System.out.println(e);
    }
  }
}


class Demo implements AutoCloseable
{
  void show()
  {
    System.out.println("show");
  }

  public void close()  // you will have to override the close() method
  {
    System.out.println("close from Demo");
  }
}


class Demo1 implements AutoCloseable
{
  void show1()
  {
    System.out.println("show1");
  }

  public void close()
  {
    System.out.println("close from Demo1");
  }
}
