import java.util.*;

public class MyListIterator {
    public static void main(String a[])
    {
        List<Integer> li = new ArrayList<Integer>();
        ListIterator<Integer> litr = null;
        li.add(23);
        li.add(98);
        li.add(29);
        li.add(71);
        li.add(5);
        litr=li.listIterator();
        System.out.println("Elements in forward direction");
        while(litr.hasNext())
        {
            System.out.println(litr.next());
        }
        System.out.println("Elements in backward direction");
        while(litr.hasPrevious()){
            System.out.println(litr.previous());
        }
    }
}