interface My{
  default void show(){
    System.out.println("my");
  }
}

interface My1{
  default void show(){
    System.out.println("my1");
  }
}

class MyRegister{
  void register(My b){
    b.show();
  }
}

/*--------------------------------------------------------------*/

class Child implements My, My1{
  // if you are implementing two interfaces at once, than you have to override the same function in them, otherwise you will get the error
  public void show(){
    System.out.println("Child");
  }

  public static void main(String... s){
    Child c = new Child();
    MyRegister mr = new MyRegister();
    /* The register method accepts any object that implements the My interface.
In Java, you can assign a subclass (or implementing class) object to a reference of its superclass (or interface). This is called polymorphism.
The compiler checks if Child implements My (it does), so this is valid.
register calls show() on the My reference.
At runtime, Java calls Child's show() due to dynamic dispatch.*/
    mr.register(c);
    My m = new Child();
    m.show();  //dynamic binding, m will run the inherited method
    My1 m1 = new Child();
    m1.show(); // //dynamic binding, m1 will run the inherited method
  }
}