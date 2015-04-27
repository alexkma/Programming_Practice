import javafx.beans.property.adapter.JavaBeanObjectProperty;

import javax.swing.*;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Alex on 4/3/2015.
 */
public class ParenChecker {
    // { (index 0); [ (index 1); ( (index 2)
    // } (index 0); ] (index 1); ) (index 2)
    private static final String OPEN = "{[(";
    private static final String CLOSE = "}])";
//(w * [x + y) / z - [p / {r - q}])
    public static boolean isBalanced(String expression) {

        boolean balanced = true;
        int index = 0;
        Stack<Character> charStack = new Stack<Character>();

        try {
            while (balanced == true && index < expression.length()) {
                char charNext = expression.charAt(index);
                if (isOpen(charNext)) {
                    charStack.push(charNext);
                } else if (isClose(charNext)) {
                    char poppedChar = charStack.pop();
                    /*
                    following is always true
                     */
                    //balanced = isClose(charNext) == isOpen(poppedChar);

                    //compares indexes to see if the the paren matches
                    balanced = OPEN.indexOf(poppedChar) == CLOSE.indexOf(charNext);
                }
                index++;
            }
        }

        catch (EmptyStackException ex) {
            balanced = false;
        }
        return (balanced && charStack.empty());
    }

    public static boolean isOpen(char ch) {
        //if indexOf exists (not negative)
        // e.g. 0 (index) > -1 returns TRUE
        return OPEN.indexOf(ch) >  -1;
    }

    public static boolean isClose(char ch) {
        return CLOSE.indexOf(ch) > -1;
    }

    public static void main(String args[]) {
        String expression = JOptionPane.showInputDialog("Enter an expression containing parenthesis");
        if (ParenChecker.isBalanced(expression)) {
            JOptionPane.showMessageDialog(null, expression + " is balanced");
        }
        else {
            JOptionPane.showMessageDialog(null, expression + " is not balanced");
        }
        System.exit(0);
    }
}

