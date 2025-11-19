class Trim
{
  public static void main(String[] args)
  {
    String str = new String("    Welcome to Tutorials of String");
    System.out.println("Before trim: "+str+", The length of the string is - "+str.length());
    // str.trim(); // this might not work, as string immutable
    String z = str.trim();
    System.out.println("After trim: "+z+", The length of the string is - "+z.length());
  }
}