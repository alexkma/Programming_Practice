/**
 * Created by Alex on 4/5/2015.
 */
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;

import javax.swing.*;
import java.util.EmptyStackException;
import java.util.Stack;
public class InfixToPostfix {

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) { super(message);}
    }

    private StringBuilder postfix;
    private Stack<Character> operatorStack;
    private static final String OPERATORS = "+-*/";
    private static final int[] PRECEDENCE = {1, 1, 2, 2};

    public String convert(String infix) throws SyntaxErrorException {
        postfix = new StringBuilder();
        operatorStack = new Stack<Character>();
        String[] tokens = infix.split("\\s+");
        boolean operand = false;

        try {
            for (String nextToken: tokens) {
                char firstChar = nextToken.charAt(0);

                // if current token is a digit or an identifier (operand) AND last token was not an operand
                // expect first token of an expression to be always a digit/identifier (initial operand is set to false)
                if ((Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)) && operand == false) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                    operand = true;
                }

                // if current token is an operator and last token was operand (not an operator)
                else if (isOperator(firstChar) && operand == true) {
                    processOperator(firstChar);
                    operand = false;
                }
                else {
                    throw new SyntaxErrorException("Invalid character encountered: " + firstChar);
                }

            }
            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                postfix.append(op);
                postfix.append(' ');
            }

            return postfix.toString();
        }
        catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }

    }

    private void processOperator(char op) {
        if (operatorStack.empty()) {
            operatorStack.push(op);
        }
        else {
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            }
            else {
                while (!operatorStack.empty() && op <= topOp) {
                    operatorStack.pop();
                    postfix.append(topOp);
                    postfix.append(' ');
                    if (!operatorStack.empty()) {
                        topOp = operatorStack.peek();
                    }
                }

                operatorStack.push(op);
            }
        }
    }

    private int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) > -1;
    }

    public static void main(String args[]) {
        InfixToPostfix inToPost = new InfixToPostfix();
        String infix = JOptionPane.showInputDialog("Enter an infix expression");

        try {
            String postfix = inToPost.convert(infix);
            JOptionPane.showMessageDialog(null, "Infix expression " + infix + "\nconverts to " + postfix);
        }
        catch (SyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }


}
