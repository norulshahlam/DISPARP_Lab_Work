package DISPARP_Lab_Week15;

import java.awt.Color; import java.awt.image.BufferedImage ;
import javax.imageio.ImageIO; import java.io.File ;

public class ParallelMandelbrot3 extends Thread {
	final static int P = 2;	// no of threads
	final static int N = 4096, CUTOFF = 100 ;
	static int [] [] set = new int [N] [N] ;
	public static void main(String [] args) throws Exception 	{

		long startTime = System.currentTimeMillis();
		
		ParallelMandelbrot3 [] threads = new ParallelMandelbrot3 [P] ;
		
		for(int me = 0 ; me < P ; me++) {
			threads [me] = new ParallelMandelbrot3(me) ;
			threads [me].start() ;
			}
		for(int me = 0 ; me < P ; me++) {
			threads [me].join() ;
			}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Calculation completed in " + (endTime - startTime) + " milliseconds");
		// Plot image
		BufferedImage img = new BufferedImage(N, N,
				BufferedImage.TYPE_INT_ARGB) ;
		// Draw pixels
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				int k = set [i] [j] ;
				float level ;
				if(k < CUTOFF) {
					level = (float) k / CUTOFF ;
				}
				else {
					level = 0 ;
				}
				Color c = new Color(0, level, 0) ; // Green
				img.setRGB(i, j, c.getRGB()) ;
			}
		}
		// Print file
		ImageIO.write(img, "PNG", new File("ParellelMandelbrotWK15.png"));
	}
	int me ;
	public ParallelMandelbrot3(int me) {
		this.me = me ;
	}
	public void run() {
		int begin, end;
		int b = N/P ; // block size
		begin = me * b ;
		end = begin + b ;
		
		for(int i = begin ; i < end ; i++) {
			for(int j = 0 ; j < N ; j++) {
				double cr = (4.0 * i - 2 * N) / N ;
				double ci = (4.0 * j - 2 * N) / N ;
				double zr = cr, zi = ci ;
				int k = 0 ;
				while (k < CUTOFF && zr * zr + zi * zi < 4.0) {
					// z = c + z * z
					double newr = cr + zr * zr - zi * zi ;
					double newi = ci + 2 * zr * zi ;
					zr = newr ;
					zi = newi ;
					k++ ;
				}
				set [i] [j] = k ;
			}
		}		
	}
}