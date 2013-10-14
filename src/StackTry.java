import java.util.Stack;

public class StackTry {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("first");
		stack.push("second");
		stack.push("third");
		stack.push("forth");
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		System.out.println(stack.search("second"));
		System.out.println(stack.search("forth"));
	}

}
