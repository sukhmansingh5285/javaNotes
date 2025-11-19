class Thread1 extends Thread
{
    Thread1(String s)
    {
        super(s);
        //start();
    }
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(Thread.currentThread().getName());
            //System.out.println("hello");
            try{
                Thread.sleep(1000);
            }catch(Exception e){ }
        }
        System.out.println(getName()+" dead");
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
        for(int i=1;i<=10;i++)
        {
            System.out.println(Thread.currentThread().getName());
            //System.out.println("hay");
            try{
                Thread.sleep(1000);
            }catch(Exception e){ }
        }
        System.out.println(getName()+" dead");
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
        for(int i=1;i<=15;i++)
        {
            System.out.println(Thread.currentThread().getName());
            //System.out.println("bye");
            try{
                Thread.sleep(1000);
            }catch(Exception e){ }
        }
        System.out.println(getName()+" dead");
    }
}

class SetPriority
{
    public static void main(String s[])
    {
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());
        Thread1 t1=new Thread1("thread1");
        Thread2 t2=new Thread2("thread2");
        Thread3 t3=new Thread3("thread3");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        t1.setPriority(5);
        t2.setPriority(5);
        t3.setPriority(5);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        System.out.println(Thread.currentThread().getPriority());
    }
}

// Priority inheritance: New threads inherit the priority of the thread that creates them. In your code Thread.currentThread().setPriority(10) 
// sets main thread to 10, so threads created afterward will initially show priority 10 until you change them with setPriority(5). 
// The code demonstrates this by printing priorities before and after changing them.

// Priority is advisory: Thread priority is only a hint to the OS/JVM scheduler. It does not guarantee order of execution or timing. 
// Behavior varies by JVM and OS; you can't rely on priorities for correctness.