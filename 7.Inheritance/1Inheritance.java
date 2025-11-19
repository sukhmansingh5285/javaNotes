// rule 2 of method overriding.
/*
Rule for function overriding by changing only the return type of functions: 
1) Parent Class function and a Child class function both must be having a return type as reference that means both functions must
 be returning the objects of some classes. Primitive data types are not allowed.     
 2) The Classes whose objects are returned by the Parent class function and by Child class function must be having a parent 
 to child relationship.       
 3) Parent class function must return the other Parent class object and Child class function must return the other Child class object.
*/

class Base{
  A show(){
    System.out.println("Base");
    return new A();
  }
}

class Child extends Base{
  B show(){
    System.out.println("Child");
    return new B();
  }

  public static void main (String... s){
    Child c=new Child();
    c.show();
  }
}

class A{}
class B extends A{}