class Replace
{
  public static void main(String[] args)
  {
    String str = new String("Welcome to Tutorials of String");

    System.out.println("Return value: ");
    System.out.println(str.replace('o', 'T'));

    System.out.println("Return value");
    System.out.println(str.replace('1', 'D')); //string are immutable, and the return value will be the same
                               // as there is no 1 in the string
  }
}