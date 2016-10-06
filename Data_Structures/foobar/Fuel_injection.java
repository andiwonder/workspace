import java.math.BigInteger;

public class Fuel_injection {
	public static void main(String[] args){
        String n = "13";
		BigInteger num = new BigInteger(n);
		// setting counter to 0, takes care of input 1 , as the while loop never gets used
		// need values of -1, 1, 2, 3 for comparisions  
		int counter = 0;
		BigInteger negnum1 = new BigInteger("-1");
		BigInteger num1 = new BigInteger("1");
		BigInteger num2 = new BigInteger("2");
		BigInteger num3 = new BigInteger("3");
		while (num.compareTo(num1) == 1){
//			num % 2 == 0
			if (num.mod(num2).equals(BigInteger.ZERO)){
				counter = counter + 1;
				num = num.divide(num2);
			} 
//			num == 3
// 			3 -> 2 -> 1  vs 3 -> 4 -> 2 -> 1  
			else if (num.equals(num3)) {
				num = BigInteger.ZERO;
				counter = counter + 2;
			}
//			((num + 1) / 2) % 2 == 0
//			not checking if n + 1 is odd or even, checking if (n + 1) / 2 is odd or even
			else if (num.add(num1).divide(num2).mod(num2).equals(BigInteger.ZERO)){
				counter = counter + 2;
				num = num.add(num1).divide(num2);
			} else {
				counter = counter + 2;
				num = num.add(negnum1).divide(num2);
			}
			System.out.println(num);
		}
		System.out.println(counter);
//		return counter;
	}
}
