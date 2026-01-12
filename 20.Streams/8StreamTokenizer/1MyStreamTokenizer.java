import java.io.*;

class MyStreamTokenizer
{
  public static void main (String s[]) throws IOException
  {
    FileInputStream fin = new FileInputStream("abc11.txt");
    InputStreamReader ir = new InputStreamReader(fin);
    StreamTokenizer st = new StreamTokenizer(ir);
    st.eolIsSignificant(true);
    st.wordsChars(33, 255);
    st.whitespaceChars(0, 32);
    int token = 0;   //stores the type of current token
    int count = 0;   // counts total tokens processed
    int count1 = 0;  // counts the number of lines (EOL tokens)

    while(true)
    {
      token = st.nextToken();
      if(token == StreamTokenizer.TT_EOF)
        break;
      if(token == StreamTokenizer.TT_NUMBER)
        System.out.println(st.nval+"number");
      if(token == StreamTokenizer.TT_WORD)
        System.out.println(st.sval+"word");
      if(token == StreamTokenizer.TT_EOL)
        count1++;
      count++;
    }
    System.out.println("no. of words in file = "+((--count)-(--count1)));
    System.out.println("no. of lines in file = "+(count1));
  }
}