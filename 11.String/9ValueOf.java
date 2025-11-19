// valueOf method in java is a static method found in many classes like String, Integer, Double, etc. 
// It converts different types of values(int, double, char, boolean, objects) into their String representation or corresponding wrapper object.

class ValueOf
{
  public static void main(String... args)
  {
    double d = 104857345.426;
    boolean b = false;
    long l = 1234567;
    char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    System.out.println("Return Value: " + String.valueOf(d));
    System.out.println("Return Value: " + String.valueOf(b));
    System.out.println("Return Value: " + String.valueOf(l));
    System.out.println("Return Value: " + String.valueOf(arr));
  }
}