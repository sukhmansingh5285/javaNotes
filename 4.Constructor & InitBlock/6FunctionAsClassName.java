class FunctionAsClassName{

  FunctionAsClassName(){
    System.out.println("default");
  }

  void FunctionAsClassName(){
    System.out.println("hello");
  }

  public static void main (String... s){
    new FunctionAsClassName().FunctionAsClassName();
  }
}

// it is possible to have same name as className of a function, but not two functions can share the same name (other than constructor or a function with different parameters)