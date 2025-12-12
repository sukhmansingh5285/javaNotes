import java.util.List;
import java.util.Vector;

class MyVectorSubRange 
{
    public static void main(String a[]){
        Vector<String> vct = new Vector<String>();
        //adding elements to the end
        vct.add("First");
        vct.add("Second");
        vct.add("Third");
        vct.add("Random");
        vct.add("Click");
        System.out.println("Actual vector:"+vct);

        // subList method just returns a view of the original list, kind of shallow copy, changes to sublist affect origiinal list, vice versa.
        List<String> list = vct.subList(1,4);
        System.out.println("Sub List: "+list);
    }
}