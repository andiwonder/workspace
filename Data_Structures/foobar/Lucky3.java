import java.util.*;

public class Lucky3 {

	public static void main(String [] args){
		int total = 0;
		int [] l = {1,10,20,40};
		Arrays.sort(l);
		List <Integer> triples = findTriple(l);
		List <Integer> uniquevals = removeDup(l);
		l = new int[uniquevals.size()];
		for(int i = 0;i < l.length; i++){
		  l[i] = uniquevals.get(i);
		}
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < l.length; i++) {
		    int currentDividor = l[i];
		    for (int j = i+1; j < l.length; j++){
		    	if (l[j] % currentDividor == 0 && currentDividor != l[j]){
		    		if ( map.get(currentDividor) == null){
		    			List<Integer> multiples = new ArrayList<Integer>();
		    			multiples.add(l[j]);
		    			map.put(currentDividor, multiples);
		    		} else {
		    			map.get(currentDividor).add(l[j]);
		    		}
		    	}
		    }
		}
		List<int []> tuples = new ArrayList<int []>();
		for (Integer name: map.keySet()) {
            for (int i=0; i < map.get(name).size(); i++) {
            	int otherval = map.get(name).get(i);
            	if (map.get(otherval) != null) {
            		for (int j = 0; j < map.get(otherval).size(); j++){
                		int [] temp = {name,otherval,map.get(otherval).get(j)};
                		tuples.add(temp);
            		}
            		total = map.get(otherval).size() + total;
            	}
            }
        }
		for (int i=0; i < tuples.size(); i++){
			System.out.println(Arrays.toString(tuples.get(i)));
		}
		total = total + triples.size();
		System.out.println("total is " + total);
	}
	
	public static List<Integer> removeDup(int[] ints){
	    Set<Integer> setString = new LinkedHashSet<Integer>();
	    for(int i=0;i<ints.length;i++){
	        setString.add(ints[i]);
	    }
	    List<Integer> uniquevals = new ArrayList<Integer>();
		uniquevals.addAll(setString);
		return uniquevals;
	}
	
	public static List<Integer> findTriple(int [] l){
		List<Integer> triple = new ArrayList<Integer>();
		List<Integer> alreadyfound = new ArrayList<Integer>();
		for (int i=0; i < l.length; i ++){
			int triplefinder = 0;
			for (int j = i+1; j < l.length; j++){
				if (l[i] == l[j] && alreadyfound.indexOf(l[i]) == -1){
					triplefinder++;
				}
				if (triplefinder == 2){
					triple.add(l[i]);
					triplefinder = 0;
					alreadyfound.add(l[i]);
				}
			}
		}
		return triple;
	}
}
