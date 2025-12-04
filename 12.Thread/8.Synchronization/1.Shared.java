/*
Notes on Synchronization in Java:

1. The 'synchronized' keyword is used to control access of multiple threads to shared resources.
2. Synchronized methods (e.g., 'synchronized void show(...)') ensure that only one thread can execute the method at a time for the same object.
3. Synchronized blocks (e.g., 'synchronized(this) { ... }') allow finer control, synchronizing only specific sections of code.
4. You can synchronize on any object, not just 'this'. For example, 'synchronized(t)' synchronizes on object 't'.
5. The 'add' method demonstrates a synchronized method returning a value.
6. The 'show1', 'show2', 'show3', and 'show4' methods show different ways to use synchronization:
    - 'show1': synchronized method
    - 'show2': synchronized block on 'this'
    - 'show3': synchronized block on another object ('t')
    - 'show4': synchronized method with thread suspend/resume (not recommended in modern Java)
7. The 'Temp' class is used to demonstrate synchronization on a different object.
8. Thread.sleep(2000) is used to simulate a delay and show thread locking behavior.
9. Always handle exceptions when using thread operations.
10. Synchronization is essential for thread safety when multiple threads modify shared data.
*/

class Shared {
    int x, y;

    synchronized void show(String s, int a) {
        x = a;
        System.out.println("starting in method " + s + " " + x);
        try {
            Thread.sleep(2000);
        } catch (Exception e) { }
        System.out.println("exit from method " + s + " " + x);
    }

    synchronized int add(int a, int b) {
        System.out.println("inside add method " + Thread.currentThread().getName());
        x = a;
        y = b;
        try {
            Thread.sleep(2000);
        } catch (Exception e) { }
        return x + y;
    }

    synchronized void show1(String s, int a) {
        System.out.println("starting show1" + s);
        try {
            Thread.sleep(2000);
        } catch (Exception e) { }
        System.out.println("ending show1" + s);
    }

/* 
Concept: The object you pass inside synchronized(obj) specifies whose lock the thread must acquire.
Why use a dummy object? If you don't want to lock the whole this object (which would block all synchronized methods), you can pass a specific dummy object.
Does the block get locked? No. The block is just a Critical Section (a guarded area).
*/
    void show2(String s, int a) {
        System.out.println("starting in method " + s);
        synchronized (this) { // when this block executes, it's blocks rest of the object completely for other threads
            x = a;
            System.out.println("starting in block " + s + " " + x);
            try {
                Thread.sleep(2000);
            } catch (Exception e) { }
            System.out.println("exit from block " + s + " " + x);
        }
    }

    Temp t = new Temp();
    void show3(String s, int a) {
        System.out.println("starting in method " + s);
        synchronized (t) { // When a thread enters this block, it grabs t's lock.
            t.dilTohPagalHai(s);
        }
    }

    synchronized void show4(String s, int a) {
        x = a;
        System.out.println("starting in method " + s + " " + x);
        // Thread.currentThread().suspend();
        // Thread.currentThread().resume();  // these 2 methods got removed java24, run them in old versions of java
        System.out.println("exit from method " + s + " " + x);
    }
}

class Temp {
    void dilTohPagalHai(String s) { //this method is not synchronized, but still work as one becuase in show(3) this class object
                                    // is locked in synchronized block.
        System.out.println("starting haa mai hooooooooooooooo in dilTohPagalHai" + " " + s);
        try {
            Thread.sleep(2000);
        } catch (Exception e) { }
        System.out.println("ending from dilTohPagalHai" + " " + s);
    }
}