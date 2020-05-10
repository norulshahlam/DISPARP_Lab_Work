package DISPARP_Lab_Week20;

public class test {

	public static void main(String[] args) {
		
		int size = 0;
		MatrixParallelMain parallel = new MatrixParallelMain();
		parallel.parallel(size); //starts from size 2 to (+5)
		MatrixSequentialMain sequential = new MatrixSequentialMain();
		sequential.sequential(size);
		
		
		System.out.println("\ntime taken for parallel "+parallel.timetaken+ " ms");
		System.out.println("time taken for sequential "+sequential.timetaken+ " ms");
		
	}

}
