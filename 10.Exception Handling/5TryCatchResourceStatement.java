// this isn't a code but notes
// the other object inside the try-catch block won't be closed automatically
// it's only the resource declared in the try-resources satement (basically the parameters/arguments in try-catch block

static String readFirstLineFromFile (String path) throws IOException
{
  try (BufferedReader br = new BufferedReader(new FileReader(path)))
  {
    int x = 10/0;
    return br.readLine();
  }
} 

/*
In this example, the resource declared in the try-with-resources statement is a BufferedReader. The declaration statement appears within
paranthesis immediately after the try keyword. The class BufferedReader, in Java SE 7 and later, implements the interface 
java.lang.AutoCloseable. Because the BufferedReader instance is declared in a try-with-resource statement, it will be closed regardless 
of wether the try statement completes normally or abruptly.
*/


// Using Mutliple Resources
// You can use multiple resources inside a try-with-resources block and have them all automatically closed. Here is an example:-

private static void printFileJava7() throws IOException
{
  try(FileInputStream input = new FileInputStream("file.txt"); BufferedInputStream bufferedInput = new BufferedInputStream(input))
  {

  }
}

// This example creates two resources inside the paranthesis after the try keyword. A FileInputStream and a BufferedInputStream. 
// Both of these resources will be closed automatically when the execution leaves the try block.

// The resources will be closed in reverse order of the order in which they are created/listed inside the paranthesis.
// First the BufferedInputStream will be closed, then the FileInputStream.