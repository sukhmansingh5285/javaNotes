import java.util.ArrayList;
import java.util.List;

public class MyArrayListSubRange {
	public static void main(String a[]){
		ArrayList<String> arr1 = new ArrayList<String>();
		//adding elements to the end
		arr1.add("First");
		arr1.add("Second");
		arr1.add("Third");
		arr1.add("Random");
		arr1.add("Click");
		System.out.println("Actual ArrayList:"+arr1);
		List<String> list = arr1.subList(2, 4);
		System.out.println("Sub List:"+list);
	}
}

/*
subList(inclusive, exclusive) method returns a view of the portion of the origina list
The returned sublist is backed by the original list (arr1), so changes to the sublist affect 
the original list and vice versa.
To create a new ArrayList -> new ArrayList<>(arr1.subList(2, 4));
*/