import java.util.StringJoiner;

class StringJoinerEx
{
  public static void main(String[] args)
  {
    //StringJoiner sj=new StringJoiner(",") //separated the elements with a comma in between
    //StringJoiner sj=new StringJoiner(",", "@", "!") //separated the elements with a comma in between, prefix with @ and suffix(ending) with !
    StringJoiner sj = new StringJoiner(",", "(", ")");  //(Lalu, kumar, Yadav)
    sj.add("Lalu");
    sj.add("kumar");
    sj.add("Yadav");
    System.out.println(sj);
  }
}