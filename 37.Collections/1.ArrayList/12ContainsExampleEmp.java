import java.util.ArrayList;
import java.util.Collections;

public class ContainsExampleEmp
{
	public static void main(String a[])
	{
		ArrayList<Emp> list = new ArrayList<Emp>();
		Emp e2 = new Emp(1001);
		// list.add(new Emp(1001));
		list.add(new Emp(1002));
		list.add(new Emp(1003));
		list.add(new Emp(1004));
		list.add(new Emp(1005));
		list.add(new Emp(1001));
		//list.add(new Emp(1001));

		System.out.println("Actual List:");
		for(Emp e : list){
			System.out.println(e.id);
		}
		System.out.println("ArrayList contains the id  1001 " + list.contains(e2));
	}
}

class Emp
{
	int id;
	Emp(int id)
	{
		this.id = id;
	}
//When you call list.contains(e2), Java uses the equals method to check if any element in the list is "equal" to e2
	public boolean equals(Object o) //you ovverrided this method, and now cotains will check only id to determine its result, otherwise it would have checked for the reference.
	{
		System.out.println("check");
		Emp e = (Emp)o;
		if(this.id == e.id)
			return true;
		else
			return false;
	}
}
