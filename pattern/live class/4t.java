class Temp{
  public static void main(String[] args){
    int rows = 9;

    for(int i=0; i<=rows/2; i++){
      for(int j=0; j<rows/2 - i; j++){
        System.out.print(" ");
      }
      for(int j=0; j<=i; j++){
        System.out.print("* ");
      }
      System.out.println();
    }

    for(int i=rows/2 - 1; i>=0; i--){
      for(int j=i; j<rows/2; j++){
        System.out.print(" ");
      }

      for(int j=0; j<=i; j++){
        System.out.print("* ");
      }

      System.out.println();
    }
  }
}

/*

    * 
   * * 
  * * * 
 * * * * 
* * * * * 
 * * * * 
  * * * 
   * * 
    * 

*/