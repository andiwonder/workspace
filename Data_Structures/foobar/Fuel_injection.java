import java.math.BigInteger;

public class Fuel_injection {
	public static void main(String[] args){
        String n = "3121238123917239812371233";
		BigInteger num = new BigInteger(n);
		int counter = 0;
		BigInteger num2 = new BigInteger("2");
		BigInteger num1 = new BigInteger("1");
		BigInteger negnum1 = new BigInteger("-1");
		while (num.compareTo(num1) == 1){
			if (num.mod(num2).equals(BigInteger.ZERO)){
				counter = counter + 1;
				num = num.divide(num2);
			} else if (num.add(num1).divide(num2).mod(num2).equals(BigInteger.ZERO)){
				counter = counter + 2;
				num = num.add(num1).divide(num2);
			} else {
				System.out.println("num for else is " + num);
				System.out.println("so uhmm else was hit");
				counter = counter + 2;
				num = num.add(negnum1).divide(num2);
			}
//			System.out.println("num is " + num);
//			System.out.println("counter is " + counter);
		}
		System.out.println(counter);
//		return counter;
	}
}
