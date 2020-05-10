package DISPARP_Lab_Week13;

public class ParallelPi extends Thread 
{
	public static void main(String[] args) throws Exception 
	{
		long startTime = System.currentTimeMillis();	//System.nanoTime();
		ParallelPi thread1 = new ParallelPi();
		thread1.begin = 0 ;
		thread1.end = numSteps / 2;
		
		ParallelPi thread2 = new ParallelPi();
		thread2.begin = numSteps / 2 ;
		thread2.end = numSteps;
		
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		
		long endTime = System.currentTimeMillis();
		double pi = step * (thread1.sum + thread2.sum) ;
		System.out.println("Value of parallel pi: " + pi);
		System.out.println("Calculated in " + (endTime - startTime) + " milliseconds");
	}
	static int numSteps = 1_000_000_000;
	static double step = 1.0 / (double) numSteps;
	double sum ;
	int begin, end ;

	public void run() 
	{
		sum = 0.0 ;
		for(int i = begin ; i < end ; i++)
		{
			double x = (i + 0.5) * step ;
			sum += 4.0 / (1.0 + x * x);
		}
	}
}