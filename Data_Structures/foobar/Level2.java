import java.util.*;
public class Level2 {

	public static void main(String[] args) {
		String n = "210111";
		int len = n.length();
		int base = 3;
		int counter = 1;
		boolean repeat = false;
		List<String> values = new ArrayList<String>();
		values.add(n);
		int diff = 0;
		while (repeat != true) {
			List<Integer> digits3 = digitToArray(values.get(counter-1),len);
			String val = Rem(digits3, len, base);
			values.add(val);
			int lastval = Integer.parseInt(values.get(values.size()-1));
			for (int i = 0; i < values.size()-1; i ++){
				int current = Integer.parseInt(values.get(i));
				if (current == lastval) {
					diff = (values.size()-1) - i;
					repeat = true;
				}
			}
			counter++;
		}
//		return diff;
	}
	
	public static String baseToDecimal(String num, int base){
		return Integer.toString(Integer.parseInt(num, base), 10);
	}
	
	public static String decimalToBase(String num, int base){
		return Integer.toString(Integer.parseInt(num, base));
	}
	
	public static List<Integer> digitToArray(String n, int len) {
		int id = Integer.parseInt(n); 
		List<Integer> digits = new LinkedList<Integer>(); 
		while (id > 0) {
		    digits.add(0,id%10);
		    id = id/10;
		}
		while (digits.size() < len){
			digits.add(0,0);
		}
		return digits;
	}

	
	public static String Rem(List<Integer> digits , int len , int base) {
		// make a clone of digits array
		List<Integer> digits2 = new ArrayList<Integer>();
		for (int item : digits) {
			digits2.add(item);
		}
		// sort in asc and desc order
		Collections.sort(digits);
		Collections.sort(digits2, Collections.reverseOrder());
		// concatanate string
		String xval = "";
		String yval = "";
		for (int i = 0;i < len; i++) {
			xval = xval + (digits.get(i));
			yval = yval + (digits2.get(i));
		}
		xval = baseToDecimal (xval, base);
		yval = baseToDecimal (yval, base);
		int answer = Integer.parseInt(yval) - Integer.parseInt(xval);
		String output = Integer.toString(answer, base);
		return output;
	}
	
}
