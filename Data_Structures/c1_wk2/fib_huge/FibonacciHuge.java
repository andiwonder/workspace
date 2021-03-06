package fib_huge;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class FibonacciHuge {
    
    private static long getFibonacciHugeNaive(int n, int m) {
        if (n <= 1)
            return n % m;

        List<Integer> modList = new ArrayList<Integer>();
        long previous = 0;
        long current  = 1;
        int periodLen = 0;
        int prevMod = 0;
        int thisMod = 1;
        
        boolean found = false;
        
        System.out.println("At the start current is " + current);

        while(found == false){
          for (int i = 2; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
//            System.out.println("Fib is " + current);
            System.out.println("Fib " + current + " mod is % " + m + " and val:" + current % m );
            if(i > 2 && current % m == 1 && tmp_previous % m == 0){
            	System.out.println("Hey look here ----------------------");
            }
          }
          found = true;
        }
        return current;
    };
    
    private static int getFibModulo(int n, int m) {
        if (n <= 1)
            return n % m;

        int previous = 0;
        int current  = 1;
        int periodLen = 0;
        int prevMod;
        int thisMod;
        int [] mods = new int [5000];
        boolean found = false;

        while(found == false)
          for (int i = 2; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            prevMod = tmp_previous % m;
            thisMod = current % m;
            mods[i-2] = thisMod;
            
            if (i > 2 && thisMod == 1 && prevMod == 0) {
//            System.out.println("this Mod is " + thisMod + "found it at position " + (i-2));
//            System.out.println(Arrays.toString(mods));
              found = true;
              periodLen = i -2;
            }
          }

        return mods[n % periodLen];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

