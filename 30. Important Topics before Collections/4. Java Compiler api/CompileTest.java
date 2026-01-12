import javax.tools.*;    // Imports the classes needed to talk to the compiler

class CompileTest
{
  public static void main(String[] args)
  {
    JavaCompiler comp = ToolProvider.getSystemJavaCompiler();   //This line asks your system (your JDK) to give the program a reference to the compiler.
    int i = comp.run(System.in, System.out, System.err, "A.java");
    System.out.println(i);
  }
}


/*
The Java Compiler API (found in the javax.tools package) allows you to call the compiler from inside a running Java program.

The .run() method is where the magic happens. It takes four main arguments:
InputStream (System.in): Where the compiler gets input (rarely used here).
OutputStream (System.out): Where the compiler sends normal messages (like "Compilation successful").
OutputStream (System.err): Where the compiler sends error messages (like syntax errors).
Arguments ("A.java"): This is the file name you want to compile. It's exactly like typing javac A.java.
*/