package p2;
// If your class is inside a package (like package p1; in your image_50f5ec.jpg), your manifest must reflect 
// that: Main-Class: p1.Temp1. You must also package the folder structure, not just the file.

import p1.Temp1;

class Temp2
{
  public static void main(String... s)
  {
    new Temp1().show();
  }
}


/* 
What’s happening: java p2.Temp2 means “load class Temp2 inside package p2”, 
i.e., it expects a file like p2/Temp2.class on the classpath.
*/