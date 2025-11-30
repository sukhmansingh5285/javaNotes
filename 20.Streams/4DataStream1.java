import java.io.*;

class DataStream1{
  public static void main(String s2[]) throws IOException{
    /*FileOutputStream fout = new FileOutputStream("codesquadz.txt");
    DataOutputStream dout = new DataOutputStream(fout);
    dout.writeInt(10);
    dout.writeLong(101);
    dout.writeDouble(10.9);
    dout.writeBoolean(true);
    dout.close(); */

    FileInputStream fis = new FileInputStream("codesquadz.txt");
    DataInputStream dis = new DataInputStream(fin);

  }
}

class Temp{
  public static void main(String[] args){
    //  Class c = java.lang.Thread  (thread class)
    // we just have to add '.class' at the end
    Class c = java.lang.Thread.class; // thread class will load in memory and than we will get the Class class object as discussed before, and than we can easily 
                               // get the detail of that class
    
  }
}