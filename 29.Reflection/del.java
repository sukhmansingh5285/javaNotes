class Temp{
  void show(int... x){  // int x[] -> an array is passed actually in the form of variable length argument

  for(int i=0;i<x.length;i++){
    System.out.println(x[i]);
  }

  void show(int z){ // this will run when t.show(10); is called, first priority will be given to it.
    System.out.println(z);
  }

  void show(int x, int...z){}  // one argument in x, than rest of the arguments.

  }

  public static void main(String... s){
    Temp t=new Temp();
    t.show();   // new int[] {}

    t.show(10);    // new int[] {10}

    t.show(10, 20);    // new int[] {10, 20}

    t.show(10, 20, 30);   // new int[] {10, 20, 30}

    int z[] = {10, 20, 30};
    t.show(z);          // this will also be called
  }
}