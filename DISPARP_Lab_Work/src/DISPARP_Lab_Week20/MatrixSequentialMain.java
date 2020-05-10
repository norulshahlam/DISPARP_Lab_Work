package DISPARP_Lab_Week20;
import java.util.Random;

public class MatrixSequentialMain {
	
	long timetaken;
	public void sequential(int size)
	{   		
		//Random ran = new Random();
		int rA,cA,rB,cB;
		long startTime = System.currentTimeMillis();

		for(int k=2; k<size+3; k++)	//start with array 2x2
		{
			rA =k; cA=k; rB=k; cB=k;

			//System.out.println("\nMatrix size: "+rA+" x "+cB+ "\n");
			int[][] A=new int[rA][cA];
			int[][] B=new int[rB][cB];
			int[][] C=new int[rA][cB];
			System.out.print("Matrix A\n");
			for(int i=0;i<rA;i++)	//matrix A
			{
				for(int j=0;j<cA;j++)	
				{	
					A[i][j]=MatrixParallelMain.getValueMAtA().get(i).intValue();	//random 50-100
					System.out.print(i+","+j+" = ");
					System.out.println(A[i][j]);
				}
			} 
			System.out.print("Matrix B\n");
			for(int i=0;i<rB;i++)	//input val matrix B
			{
				
				for(int j=0;j<cB;j++)	
				{
					B[i][j]=MatrixParallelMain.getValueMAtB().get(i).intValue();	//random 50-100
					System.out.print(i+","+j+" = ");
					System.out.println(B[i][j]);					
				}        
			}
			for(int i=0;i<rA;i++)	//start thread
			{
				for(int j=0;j<cB;j++)
				{
					for(int m=0;m<cA;m++){
						C[i][j]+=A[i][i]*B[i][j];        
					}      
				}
			}
			System.out.println("\nResult for "+rA+" x "+cB+ " SEQUENTIAL\n");
			for(int i=0;i<rA;i++)
			{
				for(int j=0;j<cB;j++)
				{
					System.out.print(C[i][j]+" ");
				}    
				System.out.println();            
			}       
		} 
		long endTime = System.currentTimeMillis();
		timetaken = endTime-startTime;
		//System.out.println("\nCalculated in " + (endTime - startTime) + " ms");
	}
}

