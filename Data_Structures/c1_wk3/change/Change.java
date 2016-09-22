//package change;
import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int tens  = m / 10;
        int rem   = m - (10 * tens);
        int fives = rem  / 5;
        rem = rem - (5 * fives);
        int ones = rem;
        return tens + fives + ones;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

