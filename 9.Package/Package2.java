package p2;

import p1.Temp1;

class Package2{
  public static void main(String... args){
    new Package1.show();
  }
}

/*
So, you need to import Package1, but from where, so on the command prompt you need to set the path ->
  set classpath=c:\f1; (for example)
Then you can compile it->
  javac -d . Package2.java
  java Package2
*/