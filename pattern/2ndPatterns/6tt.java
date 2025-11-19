class Temp{
  public static void main(String... s){
    int i,j,n=4;
    //K pattern

    for(i=1; i<=n; i++){
      for(j=1; j<=n-i+1; j++){
        System.out.print("* ");
      }
      System.out.println();
    }

    for(i=1;i<=n;i++){
      if(i!=1){
        for(j=1; j<=i; ++j){
          System.out.print("* ");
        }
        System.out.println();
      }
    }
  }
}