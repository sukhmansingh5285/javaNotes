class Temp{
  public static void main (String... s){
    int rows = 5;
    for(int i=1; i<=5; i++){
      for(int j=i; j<rows; j++){
        System.out.print(" ");
      }
      for(int j=1; j<=i; j++){
        if(i==1 || i==rows || j==1 || j==i){
          System.out.print("* ");
        }
        else{
          System.out.print("  ");
        }
      }

      System.out.println();
    }
  }
}


/* 

    * 
   * *
  *   *
 *     *
* * * * *

*/