import java.util.*;

class VectorDemo 
{
    public static void main(String s1[])
    {
        Vector<String> al=new Vector<>(3,2);

        System.out.println("ini"+al.capacity());
        System.out.println(al.size());
        al.addElement("a");
        al.addElement("b");
        al.addElement("a");
        al.addElement("b");
        System.out.println("cap"+al.capacity());
        System.out.println(al.size());
        al.removeElementAt(2);
        Enumeration<String> el=al.elements();
        System.out.println(el.getClass().getName());
        while(el.hasMoreElements())
        {
            String s=el.nextElement();
            System.out.print(s);
        }
        System.out.println("   ");
        Iterator<String> e=al.iterator();
        while(e.hasNext())
        {
            String s=e.next();
            System.out.print(s);
        }
        al.trimToSize();
        System.out.println("\ncap"+al.capacity());
    }
}