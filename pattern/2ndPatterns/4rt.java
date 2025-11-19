class Temp{
  public static void main(String... s){
    int i,j,n=4; 
    int count =1;

    for(i=1;i<=n;++i){
      for(j=1;j<=i;++j){
        System.out.print(count+" ");
        count++;
      }
      System.out.println();
    }
  }
}