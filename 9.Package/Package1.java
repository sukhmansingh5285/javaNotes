package p1;   //to create a package

public class Package1{
  public void show(){
    System.out.println("pkg p1");
  }

  public static void main(String[] args){
    new Package1().show();
  }
}

/*
Now you can't compile it just with->'javac p1.java'. You have to use here ->
  javac -d path Package1.java
and then,
  java Package1 (simple)
*/