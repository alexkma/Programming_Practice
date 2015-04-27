/**
 * Created by Alex on 4/2/2015.
 */
import java.util.*;

//Listing 3.2 Data Structures (Koffman & Wolfgang)
public class PalindromeFinder {
    private String inputString;
    private Stack<Character> charStack = new Stack<Character>();

    public PalindromeFinder(String str){
        inputString = str;
        fillStack();
    }

    private void fillStack() {
        for (int i = 0; i < inputString.length(); i++) {
            charStack.push(inputString.charAt(i));
        }
    }

    private String buildReverse() {
        StringBuilder result = new StringBuilder();
        while (!charStack.empty()) {
            result.append(charStack.pop());
        }
        return result.toString();
    }

    public boolean isPalindrome() {
        return inputString.equalsIgnoreCase((buildReverse()));
    }

    public static void main(String[] args) {
        PalindromeFinder palFind = new PalindromeFinder("w");
        System.out.print(palFind.isPalindrome());
    }
}
