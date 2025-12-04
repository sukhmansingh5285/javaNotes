class Shared
{
	int flag=0;
	int data=0;
	synchronized public void submit()
	{
		flag=1;
		try
		{
			Thread.sleep(1000);
		}catch(Exception e){ }
		data=10;
		System.out.println("value submitted");
		notify(); //The JVM looks at the 'Wait Set' of object st, finds Thread1, and wakes it up.
		   // Catch: Thread1 doesn't run yet! It moves to the 'Entry Set'(Blocked State). It is waiting for the lock to be free.
	} // when Thread2 hits this brace, than Thread1 gets the lock

	synchronized int withdraw()
	{
		if(flag==0)
		{
			try
			{
				System.out.println("sending into wait block");
				wait(); // Thread1 releases the lock on st, and goes to sleep (Wait Set).
				// Thread1 wakes up here exactly where it left off
			}catch(Exception e){}
		}
		return data;
	}
}
