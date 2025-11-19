/*
  create 1 class, using try catch block, handle some exceptions (ArithmeticException, ArrayIndexOutOfBoundException)
  also write the general Exception hadnling
  also add the Error, and Throwable handling, it's highly discouraged, use this only for logging
  very specific recovery scenario
*/

class NewExcep{
  public static void main(String... s){
    try{
      int x=10/s.length; // only this will be handled, rest of the code will be skipped
      System.out.println(x);
      int z[] = new int[s.length]; // if above exception gone, this would be handled
      z[10] = 100;
    } 
    catch(ArithmeticException | ArrayIndexOutOfBoundsException e){ //Multi catch uses single '|' and only one variable name is allowed
      System.out.println(e+"jajajajajaj");
    }
    catch(Error e){   // highly discouraged, as errors are unchecked. but you can handle them like this too
      System.out.println(e);
    }
    catch(Exception e){
      System.out.println(e);
    }
    catch(Throwable e){ //Error, Exception are both subclass of Throwable. so if you catch Throwable you catch them both
      System.out.println(e);
    }
  }
}