package fib;
import java.util.Scanner;

public class Fibonacci {
	
	private static long calc_fib(int n) {
	  long solution = 0;
	  if (n==0){
		  solution = 0;
	  } else if (n==1) {
		  solution = 1;
	  } else { 
		long [] numbers = new long[n+1];
	    numbers[0] = 0;
	    numbers[1] = 1;
	    for (int i = 2; i <= n; i++){
		  numbers[i] = numbers[i-1] + numbers[i-2];
	    }
	    solution = numbers[n];
	  }
	  return solution;
  }
	
	private static long calc_fib_2(int n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current;
		
	}

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib_2(n));
  }
}
