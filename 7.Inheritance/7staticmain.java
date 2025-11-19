interface MyInterface {
    public static void main(String[] args) {
        System.out.println("Main in interface!");
    }
}

/* 
Since java 8, interfaces can have static methods, and main method is a static
method in java.

 Normally, to call a static method in Java, you use the class or interface name
 However, the main method is special in Java.
 When you run java MyInterface from the command line, the Java Virtual Machine (JVM) looks for a public static 
 void main(String[] args) method in the specified class or interface and calls it automatically as the program entry point.
*/

// main