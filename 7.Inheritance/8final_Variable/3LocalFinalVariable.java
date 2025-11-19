class LocalFinalVariable{
  public static void main(String[] args){
    final int x = 10;
    // x=x+10;,    this will not work
    System.out.println(x);
    final LocalFinalVariable t1 = new LocalFinalVariable();
          // t1 = new LocalFinalVariable(); , this will not work
  }
}