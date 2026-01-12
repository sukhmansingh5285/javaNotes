import java.io.BufferedInputStream;
import java.io.FileInputStream;

class Bufferedstream{
  public static void main(String s1[]){

    try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream("lalu.txt"))){
      // Read one byte at a time and display it
      byte byteData;
      while((byteData = (byte)bis.read()) != -1){
        System.out.print((char) byteData);
        }
      } catch(Exception e2){
      e2.printStackTree();
    }
  }
}