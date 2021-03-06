//package fib_modulo;
// heyyyyyyyyyyyyy
import java.util.Arrays;
import java.util.Scanner;

public class FibModulo {
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
        int c = getFibModulo(n, m);
        System.out.println(c);
    }
}

