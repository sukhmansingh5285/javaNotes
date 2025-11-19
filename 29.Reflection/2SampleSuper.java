/* Frame object, passed in another function (printSuperClass), create reflectin class (subClass), 
 and gets it superclass (superclass), and it's super class on and on until you get the parent
 class null (which is the case when you apply getSuperClass() method to object class)  */

import java.lang.reflect.*;
import java.awt.*;

class SampleSuper{
  public static void printSuperClass()

  public static void main(String s[]){
    Frame f = new Frame();
    printSuperClass(f);
  }
}