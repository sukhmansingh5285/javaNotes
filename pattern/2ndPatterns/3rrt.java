class Temp{
  public static void main(String... s){
    int i,j,n=4;

    //Number increasing Reverse Pyramid

    for(i=0; i<n; ++i){
      for(j=1; j<=n-i; ++j){
        System.out.print(j+" ");
      }
      System.out.println();
    }
  }
}