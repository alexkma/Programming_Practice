import java.util.Comparator;

/**
 * Created by Alex on 4/21/2015.
 */
public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] table) {

        if (table.length > 1) {
            int halfSize = table.length / 2;
            T[] leftTable = (T[]) new Comparable[halfSize];
            T[] rightTable = (T[]) new Comparable[table.length - halfSize];
            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);

            // Sort the halves.
            sort(leftTable);
            sort(rightTable);

            merge(table, leftTable, rightTable);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] outputSequence, T[] leftSequence, T[] rightSequence) {
        System.out.println("leftSequence[0]: " + leftSequence[0]);
        System.out.println("rightSequence[0]: " + rightSequence[0]);
        String s = "";
        for (int i = 0; i < outputSequence.length; i++) {
            s += outputSequence[i] + " ";
        }

        System.out.println("outputSequence: " + s);
        //System.out.println("outputSequence.length: " + outputSequence.length);
        System.out.println("leftSequence.length: " + leftSequence.length);
        System.out.println("merge");

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSequence.length && j < rightSequence.length) {
            if (leftSequence[i].compareTo(rightSequence[j]) < 0) {
                outputSequence[k++] = leftSequence[i++];
            } else {
                outputSequence[k++] = rightSequence[j++];
            }
        }

        while (i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
        }

        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {50, 60, 45, 30, 90, 20, 80, 15};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
