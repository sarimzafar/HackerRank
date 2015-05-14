import java.io.IOException;
import java.util.Scanner;

/**
 * Created by shassanzafar on 5/14/2015.
 */
public class CStyle {
    public static void main(String[] args) throws IOException {
        Scanner obj = new Scanner(System.in);
        String word = obj.next();
        String reverse = "";
        for (int i = 0; i < word.length(); i++)
            reverse = word.charAt(i) + reverse;
        System.out.println(reverse);

    }
}
