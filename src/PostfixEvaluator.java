import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Alex on 4/4/2015.
 */
public class PostfixEvaluator {

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/";
    private static Stack<Integer> operandStack;

    public static int evalOp(char op) {
        int rhs = operandStack.pop();
        int lhs = operandStack.pop();
        int result = 0;

        switch(op) {
            case '+':
                result = lhs + rhs;
                break;
            case '-':
                result = lhs - rhs;
                break;
            case '*':
                result = lhs * rhs;
                break;
            case '/':
                result = lhs / rhs;
                break;
        }
        return result;

    }
    public static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) > -1;
    }

    public int eval(String expression) throws SyntaxErrorException {
        operandStack = new Stack<Integer>();
        // one ore more occurrences of a whitespace character (space, tab, newline, formfeed, or return)
        String[] tokens = expression.split("\\s+");
        try {
            for (String nextToken : tokens) {
                char firstChar = nextToken.charAt(0);

                if (Character.isDigit(firstChar)) {
                    int value = Integer.parseInt(nextToken);
                    operandStack.push(value);
                } else if (isOperator(firstChar)) {
                    int result = evalOp(firstChar);
                    operandStack.push(result);
                } else {
                    throw new SyntaxErrorException("Invalid character encountered: " + firstChar);
                }
            }


            int answer = operandStack.pop();

            if (operandStack.empty()) {
                return answer;
            } else {
                throw new SyntaxErrorException("Syntax Error: Stack should be empty");
            }
        }
        catch (EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }


    }

    public static void main(String[] args) throws SyntaxErrorException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Type 'q/Q' to quit.");
        System.out.print("Postfix Expression: ");
        String expression = sc.nextLine();
        while (!expression.equalsIgnoreCase("q")) {

            PostfixEvaluator pfe = new PostfixEvaluator();
            int result = pfe.eval(expression);
            System.out.println("Answer to "  + " is " + result);
            System.out.print("Postfix Expression: ");
            expression = sc.nextLine();
        }

        System.out.print("Good bye!");
    }
}
