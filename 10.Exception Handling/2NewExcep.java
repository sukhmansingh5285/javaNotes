// in first code we used - catch(ArithmeticException | ArrayIndexOutOfBoundsException e){... }
// but what if you want something else to happen each time for the different exceptions
// so for that we can use 'instanceOf'


class NewExcep{
  public static void main(String... s){
    try{
      int x = 10/s.length;
      System.out.println(x);
      int z[] = new int[s.length];
      z[10] = 100;
    }
    catch(Exception e){
      if(e instanceof ArithmeticException){
        System.out.println(e+" AE");
      }
      if(e instanceof ArrayIndexOutOfBoundsException){
        System.out.println(e+" AIOBE");
      }
    }
  }
}