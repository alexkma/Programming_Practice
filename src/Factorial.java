/**
 * Created by Alex on 4/8/2015.
 */
public class Factorial {
    public static int getFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n * getFactorial(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(5));
    }
}
