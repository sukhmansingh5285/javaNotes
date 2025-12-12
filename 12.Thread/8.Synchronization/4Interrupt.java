class Thread1 extends Thread
{
    Thread1(String s)
    {
        super(s);
    }

    public void run()
    {
        System.out.println(getName());
        try
        {
            Thread.sleep(60000 * 10); // i.e. sleep for 10 minutes (60000 ms * 10)
        }
        catch(Exception e)
        {
            System.out.println("interrupted forcely" + e);
        }
        System.out.println(getName() + "dead");
    }
}

class Thread2 extends Thread
{
    Thread1 t;
    Thread2(String s, Thread1 t)
    {
        super(s);
        this.t = t;
    }

    public void run()
    {
        System.out.println(getName());
        t.interrupt();
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e) { }
        System.out.println(getName() + " dead");
    }
}

class Interrupt
{
    public static void main(String s[])
    {
        Thread1 t1 = new Thread1("thread1");
        t1.setPriority(10);
        Thread2 t2 = new Thread2("thread2", t1);
        t1.start();
        t2.start();
    }
}

/*
t.interrupt() does not forcefully kill the target thread; it sets an interrupt signal that either (a) causes blocking calls like 
sleep()/wait()/join() to throw InterruptedException, or (b) sets the thread’s interrupted status which the thread can check and respond to.

Interrupt is a cooperative request, not a kill
Thread.interrupt() sets the interrupt flag and may cause certain blocking calls to throw InterruptedException.
The interrupted thread must check the interrupt status or rely on exceptions and then terminate itself (or do whatever is appropriate).

Behavior depends on what the thread is doing
If the thread is blocked on sleep(), wait(), or join(), the JVM will throw InterruptedException and clear the interrupted flag.
If the thread is running normally (not blocked), calling interrupt() simply sets the thread’s interrupted status to true. No exception 
is thrown — the thread must check Thread.interrupted() or thread.isInterrupted() to detect it.
*/