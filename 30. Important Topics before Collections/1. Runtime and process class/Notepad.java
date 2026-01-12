class Notepad
{
  public static void main(String s[])
  {
    Runtime rt = Runtime.getRuntime();
    try{
      rt.exec("notepad.exe");
      //rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
      rt.exec("C:\\Windows\\explorer.exe");
      rt.exec("control.exe");
      rt.exec("calc.exe");
      //t.exec("C:\\Program Files (x86)\\Microsoft Office\\Office16\\winword.exe");
    } catch (Exception e) {
      System.out.println(e);
    }

    System.out.println("hello");
  }
}

/* This code demonstrates, how a Java application can interact with operating system to launch 
   other applications (processes).

   -> Runtime class follows the Singleton Design Pattern, which means you can't create an object of it using new Runtime().
   -> Instead, you use the static method -> Runtime.getRuntime().
   -> exec() -> exec method is the star here, it tell the operating system to find the program and start it up.
   -> try-catch block -> Launcing external programs is "risky" for Java (like what if file do not exists, or OS denies the 
                        permission). So these things might go wrong, Java forces you to wrap this code in a try-catch block.

  Work-Flow:
  1. Java executes, rt.exec()  -> JVM sends a request to the OS kernel.
  2. OS looks for the executable -> windows finds calc.exe or explorer.exe in its system paths.
  3. New process created -> A separate process is born. This is why "hello" prints in your console immediately even if the Notepad 
                            is still open.
  4. Independence -> The java program and the Notepad program are now running independently. Closing Java won't close Notepad.

*/