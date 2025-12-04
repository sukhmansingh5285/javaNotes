import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

class SynchronizedArrayList {

    public static void main(String a[])
    {
        List<String> syncal =
          Collections.synchronizedList(new ArrayList<String>());
        //Adding elements to synchronized ArrayList
        syncal.add("Pen");
        syncal.add("NoteBook");
        syncal.add("Ink");
        System.out.println("Iterating synchronized ArrayList:");
        synchronized(syncal)
        {
            Iterator<String> iterator = syncal.iterator();
            while (iterator.hasNext())
                System.out.println(iterator.next());
        }
    }
}

/*
A synchronized ArrayList is a thread-safe version of an ArrayList. It ensures that only one thread can access or 
modify the list at a time, preventing data corruption or inconsistent results when multiple threads operate on 
the list concurrently.
*/