
class Finally{
  static int show(){
    try{
      System.exit(0); //it doesn't terminate any process but the wholve JVM and skipps the whole remaining code
      int x = 10/0;
    }
    catch(NullPointerException e){ // it will be skipped for z (wrong exception type)
      System.out.println(e);
    }
    finally{
      return 4000;
    }
  }

  public static void main(String... s){
    // int z = show();
    // System.out.println(z);
    Finally f1 = null;
    f1.show();  /* It is allowed in java (calling static method from f1 which is null but is of type Class "Finally") */
  }
}

/* System.exit(0) stops everything immediately—no catch, no finally, no output.
   Review JVM lifecycle and exception handling for more details.   */


/* System.exit(1) works the same way as System.exit(0),= immediately terminates the JVM and skips all remaining code (including catch and finally blocks.)
   The argument (1) is the exit status code, 0 means normal termination, non-zero (like 1) means abnormal termination (error).
   It doesn't throw an exception, it just signals OS that the program ended with an error.
 */