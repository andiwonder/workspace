package gcd;
import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
	  if(b > a){
		  int tmp = a;
		  a = b;
		  b = tmp;
	  }
	  int remainder = 1;
	  while (remainder != 0) {
		  remainder = a %  b;
	  	  a = b;
	  	  b = remainder;
	  }
    return a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
