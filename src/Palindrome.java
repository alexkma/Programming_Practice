/**
 * Created by Alex on 3/11/2015.
 */
public class Palindrome {

    public static boolean isPalindrome(String word) {
        // index starting at tail of list
        int index = word.length() - 1;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(index)) {
                return false;
            }
            index--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "alex";
        String str2 = "1DooD1";
        String str3 = "zpdTTTTT TTTdpz";
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(str3));
    }
}
