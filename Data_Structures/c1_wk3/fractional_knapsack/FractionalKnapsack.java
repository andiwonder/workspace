package fractional_knapsack;
//import java.util.Scanner;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.TreeMap;
//import java.util.Set;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
import java.util.*;


public class FractionalKnapsack {
	
//	static class Pair implements Comparable<Pair> {
//	    public final int index;
//	    public final double value;
//
//	    public Pair(int index, double value) {
//	        this.index = index;
//	        this.value = value;
//	    }
//
//	    @Override
//	    public int compareTo(Pair other) {
//	        //multiplied to -1 as the author need descending sort order
//	        return -1 * Double.valueOf(this.value).compareTo(other.value);
//	    }
//	}
	
	 public static Map<Integer, Double> sortByValue(Map<Integer, Double> map) {
	        List list = new LinkedList(map.entrySet());
	        Collections.sort(list, new Comparator() {

	            @Override
	            public int compare(Object o1, Object o2) {
	                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
	            }
	        });

	        Map result = new LinkedHashMap();
	        for (Iterator it = list.iterator(); it.hasNext();) {
	            Map.Entry entry = (Map.Entry) it.next();
	            result.put(entry.getKey(), entry.getValue());
	        }
	        return result;
	    }
	
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		double value = 0;
//        TreeMap<Double, Integer> tmap = new TreeMap<Double, Integer>(Collections.reverseOrder());
//        Pair[] yourArray = new Pair[values.length];
		 HashMap<Integer, Double> mapa = new HashMap<Integer, Double>();
		 
        //write your code here
        for (int i = 0; i < values.length; i++) {
        		double ratio =  values[i] / weights[i];  
        		mapa.put(values[i], ratio);
//        		tmap.put(ratio, i);
//        		yourArray[i] = new Pair(5, ratio); 
        }
        for (HashMap.Entry<Integer, Double> map : mapa.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        };
//        Set set = tmap.entrySet();
//        Arrays.sort(yourArray);
//        System.out.println(yourArray[0]);
//        System.out.println(yourArray[1]);
//        Iterator iterator = set.iterator();
//        Boolean full = false;
//        while(full == false) {
//           Map.Entry mentry = (Map.Entry)iterator.next();
//           System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
//           System.out.println(mentry.getValue());
//           capacity = capacity - weights[(int) mentry.getValue()];
//           value += values[(int) mentry.getValue()]; 
//           System.out.println("Capacity is now " + capacity);
//           System.out.println("Value is now " + value);
//           if (capacity <= 0){
//        	     full = true;
//           }
//         
//        }
        return value;
    }
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));        
    }
} 
