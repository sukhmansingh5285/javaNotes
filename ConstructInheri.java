class A{
  A(){
    System.out.println("A");
  }
}

class B extends A{
  B(){
    System.out.println("B");
  }
}

class C extends B{
  C(){
    System.out.println("C");
  }

  C(int x){
    System.out.println(x);
  }

  public static void main(String... s){
    new C();
    new C(20);
  }
}