import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

/**
 * Created by shassanzafar on 5/15/2015.
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 */
public class DesignQ2 {


    public static void main(String[] a) throws StringIndexOutOfBoundsException {
        Scanner obj = new Scanner(System.in);

        ArrayList<String> arrayList = new ArrayList<>();
        String word = obj.next();
        for (int count = 0; count < word.length(); count++) {
            arrayList.add(Character.toString(word.charAt(count)));
        }

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j)) && i != j) {
                    arrayList.remove(j);
                }
            }
        }
        for (String s : arrayList)
            System.out.print(s);


    }
}
