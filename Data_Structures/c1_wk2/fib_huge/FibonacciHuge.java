package fib_huge;
import java.util.*;

public class FibonacciHuge {
    private static int getFibonacciHugeNaive(int n) {
        if (n <= 1)
            return(int) n;
        int previous= 0;
        int current= 1;
        
        for (int i = 2; i <= n; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            if (current > 10)
            		current = current % 10;
            else if (current==10)
            		current = 0;
        }
        
        return current;        
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int anwser = getFibonacciHugeNaive(n);
        System.out.println(anwser);
    }
}

