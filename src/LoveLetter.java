import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LoveLetter {

    public int difference(char a, char b) {
        return Math.abs((int) (a) - (int) (b));
    }

    public int palindrome(String word) {
        String part1 = word.substring(0, word.length() / 2);
        String part2 = "";
        if (word.length() % 2 == 0) part2 = word.substring(word.length() / 2, word.length());
        else part2 = word.substring(word.length() / 2 + 1, word.length());
        int sum = 0;
        for (int i = 0; i < word.length() / 2; i++) {
            sum += difference(part1.charAt(i), part2.charAt(part2.length() - i - 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        LoveLetter soln = new LoveLetter() ;
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(soln.palindrome(obj.next()));
        }
    }
}
