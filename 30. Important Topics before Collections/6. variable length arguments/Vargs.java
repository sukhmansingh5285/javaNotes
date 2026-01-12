// whatever arguments you pass in a variable length arguments first they are converted into an annonymose array then 
// pass into the function as an arguments

class Vargs
{
  void show(int z, int... x)
  {
    System.out.println(z);
    for(int i=0; i<x.length; i++)
    {
      System.out.println(x[i]);
    }

    for(int i:x)
    {
      System.out.println(i);
    }
  }

  public static void main(String s[])
  {
    int z[] = {10, 10, 10, 10};
    new Vargs().show(100, 10, 10, 10, 10);
    new Vargs().show(100, z1);
  }
}