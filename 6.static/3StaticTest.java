class Tem{
  static Demo d;
  static{
    System.out.println("static block from Temp");
    d=new Demo();
  }
}

class Demo{
  void show(int x){
    System.out.println(x);
  }
}

class Tem1{
  public static void main(String[] args){
    System.out.println("main from Tem1");
    Tem.d.show(10);
  }
}