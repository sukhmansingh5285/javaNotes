import java.util.*;

public class ArrayToArrayList
{
  /* Array Declarationa and Initialization*/
  String citynames[] = {"Agra", "Mysore", "Chandigarh", "Bhopal"};
  List<String> l = Arrays.asList(citynames);  //asList method takes an array and return a fixed sized list
  System.out.prinln(l.getClass().getName());
  //l.add("Meerut"); // (not supported)
  ArrayList<String> citylist = new ArrayList<String>(l);

  citylist.add("New City2");
  citylist.add("New City3");

  for(String str: citylist)
  {
    System.out.prinln(str);
  }
}