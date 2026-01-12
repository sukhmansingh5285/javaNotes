// it is used for unit testing in java. keep putting the assert statement until you won't get any error, 
// assert statements are disabled in java

class MyAssertion {
public static void main (String... s){
  assert s[0].equals("india") : "error tu pagal hai";
  System.out.println("ok");
 }
}

// use 'java -ea' switch to enable assertion  =  java -ea MyAssertion india
// use java -da switch to diable assertion


/*
This topic is all about Java Assertions. Think of an assertion as a "sanity check" for your code. It's a way for a developer to 
say: "I am 100% sure this condition is true at this point in the program. If it isn't, something is seriously wrong, so stop 
the program immediately."

Logic: If the boolean condition in the assert statement is true, the program continues normally.
Failure: If the condition is false, JVM throws an AssertionError, and the program crashes.

*/