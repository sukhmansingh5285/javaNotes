import java.awt.*;
import javax.swing.*;

public class ShutdownHooks implements Runnable
{
    public void run()
    {
        System.out.println("*** Application Shutting down ***");
        ShutdownHooks1 hook = new ShutdownHooks1();
        Thread t1=new Thread(hook);
        t1.start();
        try{
            t1.join();
        }catch(Exception e){ }
        System.out.println("*** After Backup***");
    }
}

class ShutdownHooks1 implements Runnable
{
    public void run()
    {
        System.out.println("*** Taking backup and closing resources ***");
        try
        {
            Thread.sleep(1000*5);
        } catch(Exception e) { }
    }
}

class RunHookup
{
    public static void main(String[] arg)
    {
        Runtime runTime = Runtime.getRuntime();
        ShutdownHooks hook = new ShutdownHooks();

        //Registering the Shutdown Hook
        runTime.addShutdownHook(new Thread(hook));
        System.exit(0);
        //int x=10/0;
        
        JFrame testFrame = new JFrame(" Test Frame");
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setSize(400, 400);
        testFrame.setVisible(true);
        System.out.println("hello");

    }
}

/*Shutdown hook is an initialized but an unstarted thread, which is invoked when the Java
virtual-machine is shut down. Java virtual machine can shutdown in two ways, first is the
normal shutdown when the last non-daemon thread exits or when the VM is exited using
System.exit or Runtime.exit. Second way of VM termination is the user interruption, like by
pressing CTRL + C, or User Logs Off or System shutdown.

The shutdown hook can be registered to the java.lang.Runtime class by using the
addShutdownHook(Thread hook) method. This method is only available in JDK above 1.2.2. All
the registered shutdown hooks will be started in specified order and will run concurrently
when the virtual machine begins its shutdown sequence. Once the shutdown sequence is started
it is not possible to register new hooks or deregister a previously registered hook.
*/