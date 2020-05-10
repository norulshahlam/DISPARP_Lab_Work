package DISPARP_Lab_Week20;


class MatrixSequential extends Thread {
	private int[][] A;
	private int[][] B;
	private int[][] C;
	private int rig,col;
	private int dim;

	public MatrixSequential(int[][] A,int[][] B,int[][] C,int rig, int col,int dim_com)
	{
		this.A=A;    
		this.B=B;
		this.C=C;
		this.rig=rig;    
		this.col=col; 
		this.dim=dim_com;     
	}
      
}