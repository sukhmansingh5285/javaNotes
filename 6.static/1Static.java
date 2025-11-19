class Temp{
   static int x;

   static{
    x=new java.util.Scanner(System.in).nextInt();
   }

   public static void main(String... s){
    System.out.println("main");
   }
}

class Temp1{
  public static void main (String... s){
    System.out.println(Temp.x);
    System.out.println(Temp.x);
    Temp.x=40;
  }
}

class Temp2{
  public static void main(String... s){
    System.out.println(Temp.x);
  }
}

// When you run java Temp1, the JVM loads the Temp class for the first time in that process. 
// The static block executes, asks for input, and sets Temp.x.

// When you run java Temp2, you are starting a new JVM process. 
// The Temp class is loaded again, so the static block runs again, and you are asked for input again.