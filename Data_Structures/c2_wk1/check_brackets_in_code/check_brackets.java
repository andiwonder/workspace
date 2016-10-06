package check_brackets_in_code;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
  Bracket(char type, int position) {
    this.type = type;
    this.position = position;
  }
    
  public String toString(){
    return Character.toString(this.type);
  }

  boolean Match(char c) {
    if (this.type == '[' && c == ']')
      return true;
    if (this.type == '{' && c == '}')
      return true;
    if (this.type == '(' && c == ')')
      return true;
    return false;
  }
    
  char type(){
    return this.type;
  }

  char type;
  int position;
}

class check_brackets {
  public static void main(String[] args) throws IOException {
    InputStreamReader input_stream = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input_stream);
    String text = reader.readLine();
    if (text.length() == 1){
      System.out.println("1");
      return;
    }
    Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
    for (int position = 0; position < text.length(); ++position) {
      char next = text.charAt(position);
      if (next == '(' || next == '[' || next == '{') {
        opening_brackets_stack.push(new Bracket(next,position));
      }
      else if (next == ')' || next == ']' || next == '}') {
        if (opening_brackets_stack.empty()){
        	System.out.println(position+1);
        	return;
        }
        Bracket top = opening_brackets_stack.pop();
        if ((top.type == '(' && next == ']') || (top.type == '(' && next == '}')){
        	System.out.println(position+1);
        	return;
        } if ((top.type == '[' && next == ')') || (top.type == '[' && next == '}')){
        	System.out.println(position+1);
        	return;
        } if ((top.type == '{' && next == ')') || (top.type == '{' && next == ']')){
        	System.out.println(position+1);
        	return;
        }
      }
    }
    if (opening_brackets_stack.empty()){
    	System.out.println("Success");
    } else {
    	System.out.println(opening_brackets_stack.pop().position + 1);
    }
  }
}
