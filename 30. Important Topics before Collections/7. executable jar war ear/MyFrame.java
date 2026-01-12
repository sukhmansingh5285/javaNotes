import java.awt.*;
import javax.swing.*;

class MyFrame
{
  MyFrame()
  {
    JFrame f = new JFrame("dd");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(400, 400);
    f.setVisible(true);
  }

  public static void main(String s[])
  {
    new MyFrame();
    System.out.println("aaa");
  }
}

// jar   cvfm   t1.jar   my.mf  *.class
// Any Java Program with a valid public static void main(String[] args) can be executable JAR.


/* A JAR is basically a ZIP that packages .class files (and resources). If it contains a Main-Class entry in its manifest, it becomes an 
executable JAR (meaning java -jar ... knows what main() to run).
*/