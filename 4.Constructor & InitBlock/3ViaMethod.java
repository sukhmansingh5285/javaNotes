class ViaMethod{
  int x = this.getX();

  int getX(){
    return 20;
  }

  ViaMethod(){
    // x=0, this line is inserted by the compiler
    // x=this.getX(), after compilation
    System.out.println(x);
  }

  public static void main(String... s){
    new ViaMethod();
  }
}