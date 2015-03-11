import java.util.ArrayList;

/**
 * Created by Alex on 3/10/2015.
 */
public class ReverseList {
    public static ArrayList reverseList(ArrayList arrayList) {
        // index starting at tail of list
        int index = arrayList.size() - 1;
        for (int i = 0; i < arrayList.size() / 2; i++) {
            System.out.println("i " + i);
            System.out.println("else ");
            Object temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(index));
            arrayList.set(index, temp);
            System.out.println("at i: " + arrayList.get(i));
            System.out.println("at index: " + arrayList.get(index));
            index--;

        }
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<String> list_one = new ArrayList<String>();
        list_one.add("Joe");
        list_one.add("Gucci");
        list_one.add("Tommy");
        list_one.add("Alex");
        list_one.add("Blah");
        list_one.add("Bling");
        list_one.add("Zoo");
        list_one.add("Booty");

        for (String names : list_one) {
            System.out.println(names);
        }

        System.out.println("Reverse order: ");

        ArrayList<String> reversedList_one = new ArrayList<String>();
        reversedList_one = reverseList(list_one);

        for (String names : reversedList_one) {
            System.out.println(names);
        }
    }
}
