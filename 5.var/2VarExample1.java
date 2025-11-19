// var can only be used with local variables

class VarExample1{
  var x;           // this won't work

  static void show(var z){   // (var z) neither this will work
    System.out.println(z);
  }

  public static void main (String[] args){
    show(10);
  }
}