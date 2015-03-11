/**
 * Created by Alex on 3/11/2015.
 */
public class ListTotal {
    public static int getTotal(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] thisArray = {3, 4, 77, 2, 0, 5};
        int tot = getTotal(thisArray);
        System.out.println(tot);
    }
}
