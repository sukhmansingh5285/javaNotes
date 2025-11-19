// Create custom exceptions by extending Exception (checked) or RuntimeException (unchecked).
// Pass message/data to the superclass via super(message); provide constructors and optional fields; 
// throw with `throw new MyException("msg")` and declare with `throws` for checked exceptions.


class Emp
{
  int age;
  void get(int age) throws AgeException
  {
    if(age<18) throw new AgeException("invalid age");
    else this.age = age;
  }

  public static void main(String... s)
  {
    Emp e1 = new Emp();
    try
    {
      e1.get(14);
    } catch(AgeException e){
      System.out.println(e);
    }
  }
}
/* you can put the message of error in Exception class super by calling it's constructor too 
  This would be the official error message, accessible by getMessage(), if you don't update the official error message, getMessage() returns null'*/
//   class AgeException extends Exception
//   {
//     AgeException(String s)
//     {
//       super(s);  /* when i call the System.out.println(e), it uses default Exception.toString() method, which prints: 'AgeException: invalid age'
//     }
//   }

/* in this version you are not updating the error message from the Exception class
  but storint and returning the custom string.  */
class AgeException extends Exception
{
  String s;
  AgeException(String s)
  {
    this.s = s;
  }

  public String toString()
  {
    return s;  // i override the toString(), so whenever i call the System.out.println(e), e.toString() will be called automatically, 
                    //  and hence you will see "invalid age"
  }
}


/* for reference -> useString() method in manishSirCore2 */