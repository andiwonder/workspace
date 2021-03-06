//package fractional_knapsack;
import java.util.*;


public class FractionalKnapsack {
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
		HashMap<Integer, Double> mapa = new HashMap<Integer, Double>();
        for (int i = 0; i < values.length; i++) {
        		double ratio = (double)  values[i] / weights[i];
        		mapa.put(i, ratio);
        }
        Map<Integer, Double> sortedMap = FractionalKnapsack.sortByValue(mapa);
        Iterator it = sortedMap.entrySet().iterator();
        boolean empty = false;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (capacity - weights[(int) pair.getKey()] <= 0){
            	double remWeightRatio = (double) capacity / weights[(int) pair.getKey()];
            	value = value + (remWeightRatio * values[(int) pair.getKey()]);
            	break;
            } else {
            	capacity = capacity - weights[(int) pair.getKey()];
                value = value + values[(int) pair.getKey()];
            }
            it.remove(); // avoids a ConcurrentModificationException
        }
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
