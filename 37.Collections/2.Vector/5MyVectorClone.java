import java.util.Vector;

class MyVectorClone {
    public static void main(String a[]){
        Vector<String> vct = new Vector<String>();
        // add -> First, Second, Third, Random. than print it -> Actual vector: vct. 
        // clone the vector here with name copy. than print it again -> Cloned vector: copy.
        vct.add("First");
        vct.add("Second");
        vct.add("Third");
        vct.add("Random");
        System.out.println("Actual vector: " + vct);

        Vector<String> copy = (Vector<String>)vct.clone();
        System.out.println("Cloned version: " + copy);
    }
}