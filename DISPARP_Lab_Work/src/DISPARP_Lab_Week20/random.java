package DISPARP_Lab_Week20;

import java.util.Random;



public class random {

	public static void main(String[] args) {

		Random ran = new Random();

		for(int i =0; i<33; i++)
		{
			int x = ran.nextInt(900) + 100;	//50-100
			System.out.println(x);
		}
	}

}
