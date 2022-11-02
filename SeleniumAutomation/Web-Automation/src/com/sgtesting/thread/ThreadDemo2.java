package com.sgtesting.thread;

class MyThread1 implements Runnable
{
	public void run() 
	{
		displayEvenNumbers();
	}
	void displayEvenNumbers()
	{
		try
		{
			for(int i=20;i<=40;i++)
			{
				if(i%2==0)
				{
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName()+
							"Displays Even Number :"+i);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public class ThreadDemo2 {
	public static void main(String[] args) {
		MyThread1 job = new MyThread1();
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		t1.setName("Alpha");
		t2.setName("Omega");
		t1.start();
		t2.start();

}
}
