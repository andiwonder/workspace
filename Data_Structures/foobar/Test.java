import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> digits = new LinkedList<Integer>();
		int id = 999;
		while (id > 0) {
			
		    digits.add(0, id%10);
		    id = id/10;
		}
	}

}
