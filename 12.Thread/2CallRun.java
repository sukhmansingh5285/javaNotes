// Thread.currentThread().getName() returns the name of the thread that is currently executing, regardless of which object or class you call it from.
// getName() (when used inside a class that extends Thread) returns the name of the thread object (this)—but only if called from within a Thread subclass.
// So, in a Thread subclass's run() method, both usually return the same value, but outside a Thread context, only Thread.currentThread().getName() works.


class Thread1 extends Thread
{
  Thread1(String s)
  {
    super(s);
    //start();
  }

  public void run()
  {
    for(int i=0;i<5;i++)
    {
      System.out.println("getName(): "+getName()+" ,and Thread.currentThread.getName(): "+Thread.currentThread().getName());
      try{
        Thread.sleep(1000);
      } catch(Exception e) {    }
    }

    System.out.println("Thread1 class run completed");
  }
}

class Thread2 extends Thread
{
  Thread2(String s)
  {
    super(s);
    //start();
  }

  public void run()
  {
    for(int i=0;i<10;i++)
    {
      System.out.println("getName(): "+getName()+" ,and Thread.currentThread.getName(): "+Thread.currentThread().getName());
      try{
        Thread.sleep(1000);
      } catch(Exception e) {    }
    }

    System.out.println("Thread2 class run completed");
  }
}

class Thread3 extends Thread
{
  Thread3(String s)
  {
    super(s);
    //start();
  }

  public void run()
  {
    for(int i=0;i<15;i++)
    {
      System.out.println("getName(): "+getName()+" ,and Thread.currentThread.getName(): "+Thread.currentThread().getName());
      try{
        Thread.sleep(1000);
      } catch(Exception e) {    }
    }

    System.out.println("Thread3 class run completed");
  }
}

// print it's name 5 tiems, and sleep it for 5 mili seconds,

class CallRun
{
  public static void main(String[] args)
  {
    Thread1 t1 = new Thread1("thread1");
    Thread2 t2 = new Thread2("thread2");
    Thread3 t3 = new Thread3("thread3");
    t1.start();   t2.start();   t3.start();

    for(int i=0;i<20;i++)
    {
      System.out.println("Thread.currentThread.getName():" +Thread.currentThread().getName());
      try{
        Thread.sleep(1000);
      }catch(Exception e) {    }
    }

    System.out.println(Thread.currentThread().getName()+" dead");
  }
}