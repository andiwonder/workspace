import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProductFast(int[] numbers) {
        long result = 0;
        int n = numbers.length;
        int max_index1 = -1;
        
        for (int i = 0; i < n; ++i){
        	if ((max_index1 == -1) || (numbers[i] > numbers[max_index1])){
        		max_index1 = i;
        	}
        }
        
        int max_index2 = -1;
        for (int j = 0; j < n; ++j) {
          if ((j != max_index1) && ((max_index2 == -1) 
            || (numbers[j] > numbers[max_index2]))) {
        	max_index2 = j;
          }
        }
        
        result = ((long)numbers[max_index1]) * ((long)numbers[max_index2]);
        return result;
    }

    static int getMaxPairwiseProduct(int[] numbers) {
        int result = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (numbers[i] * numbers[j] > result) {
                    result = numbers[i] * numbers[j];
                }
            }
        }
        return result;
    }

    
    
    public static void main(String[] args) {
//    	test();
    	FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
    
    public static void test () {
    	Random rand = new Random();
    	while (true){
    		int  n = rand.nextInt(10) + 2;
    		int [] numbers = new int[n];
    		System.out.println(n);
    		for (int i =0; i < n; i++){
    			numbers[i] = ((rand.nextInt(10) + 5));
    		}
    		System.out.println(Arrays.toString(numbers));
    		long result1 = getMaxPairwiseProduct(numbers);
    		long result2 = getMaxPairwiseProductFast(numbers);
    		System.out.println("MPP: " + result1 + " " + "MPPF:" + result2);
    		if (result1 != result2){
    			break;
    		} else {
    			System.out.println("OK OK OK OK");
    		}
    	  }
    	}
    }