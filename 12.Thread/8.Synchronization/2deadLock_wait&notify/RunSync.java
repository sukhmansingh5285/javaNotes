class RunSync
{
  public static void main (String[] args)
  {
    Shared st = new Shared();
    Thread1 t1 = new Thread1(st, "one");
    Thread2 t2 = new Thread2(st, "two");
  }
}

/*
This code example would have gone in a deadlock if we had used suspend instead of wait.

wait(): Politely gives up the lock before going to sleep. "I'm pausing, so someone else can use the room."
suspend(): Goes to sleep while holding the lock. "I'm pausing right here, and I'm keeping the door locked."

notify vs notifyAll
notify() vs. notifyAll() and the "Lost Signal" Risk When threads wait on a shared lock, notify() wakes only one random 
thread. In scenarios where different types of threads (e.g., Producers vs. Consumers) share the same lock, notify() is 
dangerous because it might wake the "wrong" thread (e.g., waking a Producer when the buffer is already full). That thread 
will check its condition, realize it cannot work, and go back to sleep, causing the signal to die before it reaches the correct 
thread. This results in a Deadlock (the "Lost Wakeup Problem"). notifyAll() solves this by waking every waiting thread. Although 
slightly less efficient because it momentarily wakes threads that aren't ready, it guarantees that the correct thread also receives 
the signal and the program proceeds safely.*/