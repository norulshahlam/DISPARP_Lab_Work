package DISPARP_Lab_Week17;

import mpi.* ;
public class HelloWorld2 //np=2
{
	public static void main(String args[]) throws Exception 
	{
		long startTime = System.currentTimeMillis();
		MPI.Init(args) ;
		int me = MPI.COMM_WORLD.Rank() ;
		int size = MPI.COMM_WORLD.Size() ;
		System.out.println("Hi from <" + me + "> of " +size) ;
		MPI.Finalize();	//Terminates MPI execution environment. All processes must call this routine before exiting

		long endTime = System.currentTimeMillis();
		//System.out.println("time for process " +me+ ": " + (endTime - startTime) + " ms");
		int process = 25;

		for (int i = 1; i <= process; i++) {

			System.out.println("process " + i + ": size " + (size - 1));
			if (size != 0) {
				size--;
				if (size == 0) {
					size = 4;
				}
			}
		}
	}
} 

/*
 make sure mpj express debugger is copied in eclipse folder > plugins
 make sure run config > MPJ express application > MPJ parameters > under MPJ_HOME, browse & select mpj folder (mpj-v0_38).
 np refers to number of processors

 https://vimeo.com/86049819
 */