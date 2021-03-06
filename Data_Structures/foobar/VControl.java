import java.util.*;

public class VControl {
	public static void main(String []args){
		String[] l = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "2", "2.0"};
		Arrays.sort(l, new Comparator<String>() {		
			public int compare(String o1, String o2) {
		        String[] thisParts = o1.split("\\.");
		        String[] thatParts = o2.split("\\.");
		        int length = Math.max(thisParts.length, thatParts.length);
		        for(int i = 0; i < length; i++) {
		            int thisPart = i < thisParts.length ?
		                Integer.parseInt(thisParts[i]) : -2;
		            int thatPart = i < thatParts.length ?
		                Integer.parseInt(thatParts[i]) : -2;
		            if(thisPart < thatPart)
		                return -1;
		            if(thisPart > thatPart)
		                return 1;
		        }
		        return 0;
		    }
		});
		System.out.println(Arrays.toString(l));		
		
//	[0.1, 1.11, 1.2, 1.2.1, 1.1.1, 2.0.0, 2, 2.0] on -1
//  [0.1, 1.1.1, 1.2, 1.2.1, 1.11, 2.0.0, 2, 2.0] on 0
		
		
		
		

		HashMap<String, ArrayList<String>> hMap = new HashMap<String, ArrayList<String>>();
		String firstMajor = l[0].split("\\.")[0];
		ArrayList<String> firstTemp = new ArrayList<String>();
		firstTemp.add(l[0]);
		hMap.put(firstMajor,firstTemp); 
		for (int i=1; i < l.length; i++){
			int counter = Integer.parseInt(firstMajor);
			int num1 = Integer.parseInt(l[i].split("\\.")[0]);
	    	int num2 = Integer.parseInt(l[i-1].split("\\.")[0]);
			if (num1 != num2){
				ArrayList<String> newtemp = new ArrayList<String>();
				newtemp.add(l[i]);
				hMap.put(l[i].split("\\.")[0],newtemp);
				counter ++;
			} else {
				ArrayList<String> temp = hMap.get(Integer.toString(counter));
				temp.add(l[i]);
				hMap.put(Integer.toString(counter),temp);
			}
		}
		for (Map.Entry<String, ArrayList<String>> entry : hMap.entrySet()) {
//		    System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		
	}
}
