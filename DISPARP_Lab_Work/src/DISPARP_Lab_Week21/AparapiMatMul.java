package DISPARP_Lab_Week21;


import com.amd.aparapi.Kernel;
import com.amd.aparapi.ProfileInfo;
import com.amd.aparapi.Range;

public class AparapiMatMul {

    //public static int N = 10 ;  // Aparapi doesn't like this

    public static void main(String [] args) {

        int N = 4096 ;

        float [] a = new float [N * N], b = new float [N * N] ;
        float [] c = new float [N * N] ;

        for (int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                a [N * i + j] = i + j ;
                b [N * i + j] = i - j ;
            }
        }

        //long startTime = System.currentTimeMillis() ;

        Kernel kernel = new Kernel() {
            public void run() {
                //int N = getGlobalSize(0) ;

                int tx = getGlobalId(0) ;
                int ty = getGlobalId(1) ;

                float sum = 0 ;
                for(int k = 0 ; k < N ; k++) {
                    sum += a [N * ty + k] * b [N * k + tx] ;
                }
                c [N * ty + tx] = sum ;
            }
        } ;

        long startTime = System.currentTimeMillis() ;

        Range range = Range.create2D(N, N) ;
        kernel.execute(range) ;

        long endTime = System.currentTimeMillis() ;

        System.out.println("Execution mode = " + 
                           kernel.getExecutionMode());

        long timeMs = endTime - startTime ;
        System.out.println("Matrix multiplication completed in "
                + timeMs + " milliseconds") ;
        System.out.println("Performance = " +
                ((2L * N * N * N) / (1E6 * timeMs)) + " GFLOPS") ; 
/*
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                System.out.print(c [N * i + j] + " ") ;
            }
            System.out.println("");
        } 
*/
    }
}