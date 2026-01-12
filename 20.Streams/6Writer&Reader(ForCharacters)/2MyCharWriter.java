import java.io.*;

class MyCharWriter
{
  public static void main(String s1[]) throws IOException
  {
    CharArrayWriter fw = new CharArrayWriter();
    String s = "india is a good country";
    for(int i=0;i<s.length;i++)  
        fw.write(ch[i]);  //fw.write(ch);
    fw.writeTo(new FileWriter("temp.txt"));
    System.out.println(fw.toString());
    char z[] = fw.toCharArray();
    CharArrayReader fr = new CharArrayReader(z);
    int i=0;
    while((i=fr.read())!=-1)
       System.out.print((char)i);
  }
}







// write: Adds data to the CharArrayWriter.
// writeTo: Transfers all accumulated data from the CharArrayWriter to another Writer.