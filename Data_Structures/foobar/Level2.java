import java.util.*;
public class Level2 {

	public static void main(String[] args) {
		String n = "210022";
		int b = 3;
		int start = Integer.parseInt(n);
		System.out.println(Integer.parseInt("210022", 3));
		int len = n.length();
		int base = b;
		int output = 0;
		List<Integer> values = new LinkedList<Integer>();
		values.add(0, start);
		boolean repeat = false;
		int counter = 1;
		while (repeat != true) {
			values.add(counter, Rem(values.get(counter-1),len));
			counter++;
			int lastval = values.get(values.size() -1);
			if (counter > 1) {
				for (int i = 0; i < values.size() -1;i++){
					if (values.get(i) == lastval){
						output = values.size() - 1 - i;
						repeat = true;
					}
				}
			}
		}
//	System.out.println(output);
		output = (int) (Math.ceil((double)output / base));
		System.out.println(Arrays.toString(values.toArray()));
		System.out.println(output);
	}
	
	public static int Rem(int id, int len){
		List<Integer> digits = new LinkedList<Integer>();
		while (id > 0) {
		    digits.add(0, id%10);
		    id = id/10;
		}
		if (digits.size() < len){
			for (int i= digits.size(); i <= len -1; i++){
				digits.add(i, 0);
			}
		}
		int length = digits.size();
		List<Integer> xArr = digits;
	    Comparator<Integer> comparator = new Comparator<Integer>() {
	      @Override
	      public int compare(Integer o1, Integer o2) {
	        return o2.compareTo(o1);
	      }
	    };
	    Collections.sort(digits);
		Collections.sort(xArr, comparator);
		int xval = 0;
		int yval = 0;
		for (int i = 0;i < length; i++) {
			xval = xval + (digits.get(i) * (int) Math.pow(10,i));
			yval = yval + (xArr.get(length - i - 1) * (int) Math.pow(10,i));
		}
		int newval = yval - xval;
		System.out.println("yval is " + yval + " xval is " + xval);
		System.out.println("newval is " + newval);
		return newval;
	}
	
}
