abstract class Base {
  int x;
  int y;
  void show(){
    System.out.println(x);
    System.out.println(y);
  }

  abstract void display();
}

/* ------------------------------------- */
class MyRegister {
  void register(Base b){
    b.display();
  }
}
/*-------------------------------------- */

class Child extends Base{
  void get (int x, int y){
    this.x = x;
    this.y = y;
  }

  void display(){
    System.out.println("display");
  }

  public static void main(String... s){
    Child c = new Child();
    MyRegister mr = new MyRegister();
    mr.register(c);  // we pass the c, because Child is subclass of Base
    /* This works because Java allows you to use a subclass object (Child) wherever a superclass (Base) is expected. 
    The method can then call overridden methods (like display()) on the actual object, which is the power of polymorphism. */
  }
}

/* A question -> If abstract class can't make an object, than how will it run the overridden methods from the child class? 
so it will need the object of the child class. so child class will have to register itself with the base class and developer 
through giving it's reference to it. (Same thing will be applied to the interface). So there always would be a abstract method 
and registration method (which will come from other class). And to catch that reference variable using the 'upcasting'. */