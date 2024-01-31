import java.util.Scanner;
import java.util.Stack;
public class ParenthesisCheck {
}

class BalancedParentheses {
    public static boolean areParenthesesBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            // If an opening parenthesis is encountered, push it onto the stack
            if (ch == '('||ch == '{'||ch == '[') {
                stack.push(ch);
            }
            // If a closing parenthesis is encountered
            else if (ch == ')'|| ch == '}'|| ch == ']') {
                // If the stack is empty, there's no matching opening parenthesis
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack and check if it matches the closing parenthesis
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{')||  (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // After processing the entire string, if the stack is empty, all parentheses are balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Enter expression:");
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        if (areParenthesesBalanced(str)) {
            System.out.println("Parentheses Balanced");
        } else {
            System.out.println("Parentheses Not Balanced");
        }
    }
}