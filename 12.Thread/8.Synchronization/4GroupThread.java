class Thread1 implements Runnable
{
  public void run()
  {
    for(int i=1; i<=15; i++)
    {
      System.out.println(Thread.currentThread().getName());
      try
      {
        Thread.sleep(1000);
      } catch (Exception e){ }
    }
  }
}

class GroupThread
{
  public static void main(String s[])
  {
    ThreadGroup tg = new ThreadGroup("rr");
    Thread1 t1= new Thread1();
    // Thread(ThreadGroup group, Runnable target, String name), this constructor is being used here.
    // The target is the Runnable whose run() method will execute in the new thread.
    Thread t3 = new Thread(tg, t1, "thread1");
    Thread t4 = new Thread(tg, t1, "thread2");
    Thread t5 = new Thread(tg, t1, "thread3");
    t3.start();
    t4.start();
    t5.start();

    try{

    } catch(Exception e) {   }
    System.out.println(Thread.currentThread().getName());
    tg.stop();
  }
}

/* 
-> Thread1 implements Runnable so it provides a run() method that a Thread can execute.
-> t3, t4, t5 are three distinct Thread objects. Each is constructed with the same Runnable instance t1, so all 
      three threads execute the same run() code concurrently.
-> tg is a ThreadGroup named "rr"; passing tg into the Thread constructor places each thread into that group so you can manage them as a unit.
*/

// why use ThreadGroup
/* 
-> When you create a Thread with that ThreadGroup, the thread becomes a member of the group.
-> You can perform some group operations (historically): tg.interrupt() (interrupts all threads in the group), tg.activeCount(), 
     tg.enumerate(...), tg.list(), tg.setMaxPriority(...).