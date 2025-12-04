import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyItrRemoveElement
{
  public static void main(String a[])
  {
    String removeElem = "Perl";
    List<String> myList = new ArrayList<String>();
    myList.add("Java");
    myList.add("Unix");
    myList.add("Oracle");
    myList.add("C++");
    myList.add("Perl");
    myList.add("Perl");
    myList.add("Perl");

    System.out.println("Before remove:");
    System.out.println(myList);

    //When an iterator is created, it is positioned before the first element of the list.
    Iterator<String> itr = myList.iterator();
    while(itr.hasNext())
    {
      if(removeElem.equals(itr.next())) // itr.next() returns the next elemetn in string and moves the iterator to next element,
      {
        itr.remove();
      }
    }
    System.out.println("After remove: ");
    System.out.println(myList);
  }
}