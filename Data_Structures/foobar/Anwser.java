import java.util.Scanner;

  public class Anwser {

    public static void main(String[] args) {
	  String str = "abcdefghijklmnopqrstuvwxyz!@#$";
      String output = "";
	  for (int i = 0; i < str.length(); i++) {
		  int charIndex = (int) str.charAt(i);
		  if (charIndex >= 110 && charIndex <= 122 ) {			  
			  output = output + (char) ((-1*(charIndex - 122)) + 97);
		  } else if (charIndex >= 97 && charIndex < 110){
			  output = output + (char) ((-1*(charIndex - 97)) + 122);
		  } else {
			  output = output + str.charAt(i);
		  }
		  System.out.println("output is " + output);
	  }
    }
  }
