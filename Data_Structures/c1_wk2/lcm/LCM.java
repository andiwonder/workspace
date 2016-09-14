package lcm;
import java.util.*;

public class LCM {
  private static int gcd(int a, int b) {
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
	  
  private static long lcm_naive(int a, int b) {
    int dem = gcd(a,b);
    long num = (long)a * (long)b;
    long lcm = num/dem;
    return lcm;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
