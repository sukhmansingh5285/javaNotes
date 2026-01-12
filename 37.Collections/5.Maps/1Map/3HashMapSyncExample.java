import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

class HashMapSyncExample
{
  public static void main(String args[])
  {
    Map map = Collections.synchronizedMap(new HashMap<Integer, String>());
  }
}