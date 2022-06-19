/**
 * 
 */
package roughWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author SAMEER KADGAYE
 *
 */
public class Parser {
	private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
	static {
		brackets.put('[', ']');
		brackets.put('{', '}');
		brackets.put('(', ')');
	}

	boolean checkParenthesesBalance(String str) {
		final Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			System.out.println("1 ==>> "+brackets.containsKey(str.charAt(i)));
			if (brackets.containsKey(str.charAt(i))) {
				System.out.println("CharAt str i = "+ i +" => "+str.charAt(i));
				stack.push(str.charAt(i));
				//Character pop = stack.pop();
				System.out.println("Last Condition ==> "+(str.charAt(i) != brackets.get(stack.pop())));
			} else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
				return false;
			}
			
		}
		return stack.empty();
	}
}
