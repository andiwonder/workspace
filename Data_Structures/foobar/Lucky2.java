import java.util.*;

public class Lucky2 {

	public static void main(String [] args){
		int [] l = {1,1,1,2,2,2,3,4,5,6};
		Arrays.sort(l);
		List <Integer> triples = findTriple(l);
//		System.out.println("Triples is " + Arrays.toString(triples.toArray()));
		List <Integer> uniquevals = removeDup(l);
//		System.out.println("Unique vals is " + Arrays.toString(uniquevals.toArray()));
		l = new int[uniquevals.size()];
		for(int i = 0;i < l.length; i++){
		  l[i] = uniquevals.get(i);
		}
//		List<Integer> originalList = new ArrayList<Integer>();
//		for (int index = 0; index < l.length; index++) {
//		    originalList.add(l[index]);
//		}
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < l.length; i++) {
		    int currentDividor = l[i];
//		    System.out.println("first loop l i is " + currentDividor);
//		    System.out.println(currentDividor);
		    for (int j = i+1; j < l.length; j++){
//		    	System.out.print(l[j] + " ");
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
//		    System.out.println(" ");
//		    System.out.println("outerloop started again");
		}
		int total = 0;
		for (Integer name: map.keySet()){
//			System.out.println("----------------");
//			System.out.println(name);
//            System.out.println(map.get(name).size());
            for (int i=0; i < map.get(name).size(); i++){
//            	System.out.print(map.get(name).get(i) + " ");
            	int otherval = map.get(name).get(i);
            	if (map.get(otherval) != null){
//            		System.out.println("the otherval is " + otherval );
            		total = map.get(otherval).size() + total;
            	}
            }
//            System.out.println(" ");
//            System.out.println(Arrays.toString(map.get(name).toArray()));
//            System.out.println("----------------");
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


//		hs.addAll(triple);
//		triple.clear();
//		triple.addAll(hs);
////		System.out.println(Arrays.toString(triple.toArray()));
//		total = total + triple.size();
//		System.out.println("total is " + total);
//	}
//}
