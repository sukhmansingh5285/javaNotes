class StartsWith
{ // welcome, tutorials, at 11 position is tutorial present
  public static void main(String[] args)
  {
    String str = new String("Welcome to Tutorials of String");

    System.out.println(str.startsWith("Tutorials")); // false
    System.out.println(str.startsWith("Welcome")); // true
    System.out.println(str.startsWith("Tutorials", 11)); // true, at index 11 the string starts with tutorials
  }
}