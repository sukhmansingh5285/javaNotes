import java.util.ArrayList;

class MyArrayListClone
{
  public static void main(String a[])
  {
    ArrayList<String> arr1 = new ArrayList<String>();
    arr1.add("First");
    arr1.add("Second");
    arr1.add("Third");
    arr1.add("Random");
    System.out.println("Actual ArrayList: "+arr1);
    ArrayList<String> copy = (ArrayList<String>) arr1.clone();
    System.out.println("Cloned ArrayList: "+copy);

    // checks if the first element in both ArrayList refer to exact same String object in memory (as in shallow copy)
    if(arr1.get(0) == copy.get(0))
    {
      System.out.println("shallow");
    }

    // check if the two ArrayList objectes themselves are differnt objects in memory
    if(arr1!=copy)
    {
      System.out.println("clone");
    }
  }
}