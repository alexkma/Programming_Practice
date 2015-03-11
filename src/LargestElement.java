/**
 * Created by Alex on 3/10/2015.
 */
public class LargestElement {

    public static int getLargest(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] anArray = {4, 55, 4, 601, 5};
        System.out.println(getLargest(anArray));
    }
}
