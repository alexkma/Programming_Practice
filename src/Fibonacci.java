/**
 * Created by Alex on 4/25/2015.
 */
public class Fibonacci {
    //@param n - number in sequence
    // F_0 = 1; F_1 = 1; F_2 = 1; F_3 = 2..etc
    public static int getFib(int n) {
        int f1 = 1;
        int f2 = 1;
        int sum = 0;

        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            //assuming 3 or larger
            for (int i = 2; i < n; i++) {
                sum = f1 + f2;
                f1 = f2;
                f2 = sum;
            }
        }
        return sum;
    }


    // By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms
    // In other words, add all even-valued terms that are less than four million in the Fibonacci sequence
    // the largest term added is less than num
    // 2 + 8 + 34 + 144 + ... + 3524578  (3524578 is the larget even-valued term that is less than four million.)
    // @num - the number you want your largest even-valued term in Fibonacci sequence to be less than.
    public static int getEvenFib(int num) {

        // this is what I'm returning. the sum of all even-valued terms up to less than num (4,000,000)
        int evenSum = 0;
        // first value
        int f1 = 1;
        // second value
        int f2 = 1;
        // starts with f_3 because it is the first even-valued term in the Fibonacci Sequence
        int fibSeq = f1 + f2;

        //if you want to get the sum of all even Fibonnaci sequence that is less than num, then (f1+f2+evenSum) < num would be more appropriate

        if (num <= 2) {
            System.out.println("num must be greater than 2.");
        }
        //if current number in Fibonacci sequence is less than num
        // starts off with f1 + f2 ---> f_3 (2)
        while (fibSeq < num) {
            System.out.println("fibSeq " + fibSeq);
            // if the current number in the Fibonacci Sequence is even, add to evenSum
            if (fibSeq % 2 == 0) {
                System.out.println("f1 " + f1 + " f2 " + f2);
                evenSum += fibSeq;
                System.out.println("evenSum " + evenSum);
            }
            // calculate fibonacci sequence
            f1 = f2;
            f2 = fibSeq;
            fibSeq = f1 + f2;
        }

        return evenSum;

    }
    public static int getFibRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return getFibRec(n - 1) + getFibRec(n - 2);
        }
    }

    public static void main(String[] args) {
            System.out.println(getEvenFib(2));
            //System.out.println(getFib(12));
            //System.out.println(getFibRec(12));

    }
}
