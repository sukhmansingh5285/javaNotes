import java.io.*;

class MyFileWriter{
  public static void main(String s1[]) throws IOException{ 
    // FileOutputStream fw = new FileOutputStream("lalu.txt"); // Write Mode, uses string constructer
    // FileOutputStream fw = new FileOutputStream("lalu.txt", true); // append mode
    FileOutputStream fw = new FileOutputStream(new File("D:\\mJAVA\\javaProgram\\javaNotes\\20.Streams\\lalu.txt")); //Write Mode, uses file object constructer
    // FileOutputStream fw = new FileOutputStream(new File("D:\\mJAVA\\javaProgram\\javaNotes\\20.Streams\\lalu.txt"), true); //append mode

    String s = "Conventional treatment methods make even the most basic healthcare issues more complicated, " + 
    " which in turn increases the number of parties involved. Classical computing lacks the speed and accuracy needed for effective stakeholde" +
    " collaboration in COVID-19 healthcare solutions, such as patients, insurance agents, healthcare practitioners, pharmaceutical suppliers, etc" +
    " The research uses organizational information processing theory (OIPT) to examine how quantum computing which is applications of artificia" +
    " intelligence (AI) could transform the healthcare business, creating a more sustainable and less burdened system. The study of quantu" +
    " computing (QC) has the potential to bring about “quantum leaps,” which might have unforeseen consequences for healthcare.";

    // String s = "i am a goat";

    byte ch[] = s.getBytes();
    fw.write(ch);
    fw.close();
  }
}

class MyFileReader{
  public static void main(String s1[]) throws IOException{
    FileInputStream fr = new FileInputStream("lalu.txt");
    // FileInputStream fr = new FileInputStream("D://Local Disk E//mJAVA//demo//20.Streams//lalu.txt");
    int i=0;
    while((i=fr.read()) != -1) System.out.print((char) i);
    fr.close();
  }
}

class MyFileReader1{
  public static void main(String s2[]) throws IOException{
    FileInputStream fr = new FileInputStream("lalu.txt");
    byte b[] = new byte[fr.available()]; // fr.available()-> returns the no. of bytes that could be read from input stream, and creates a new byte array with the exact size
    fr.read(b); // This is a bulk-read operation that reads bytes from the file into the provided byte array
    String s = new String(b);
    System.out.print(s);
  }
}