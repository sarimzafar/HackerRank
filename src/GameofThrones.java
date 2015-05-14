import java.io.IOException;
import java.util.Scanner;

/**
 * Created by shassanzafar on 5/13/2015.
 */

//https://www.hackerrank.com/challenges/game-of-thrones

public class GameofThrones {
    public char[] alphabets;
    public char[] characters;
    public char[] rearranged;
    public int[] frequency;

    public void prepareAlpha() {
        int count = (int) ('a');
        for (int i = 0; i < 26; i++)
            alphabets[i] = (char) (count + i);
    }

    public void prepareChar(String word) {
        for (int i = 0; i < word.length(); i++)
            characters[i] = word.charAt(i);

    }

    public void findFrequency() {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < characters.length; j++) {
                if (alphabets[i] == characters[j])
                    frequency[i]++;
            }
        }
    }

    public boolean palindromeornot() {
        int total = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] % 2 != 0)
                total++;
        }

        if (total > 3 && total % 2 != 0) //NEED TO FIX THIS LOGIC
            return false;

        else
            return true;

    }

    public void rearrange() {
        int k = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; i < characters.length; j++) {
                if (alphabets[i] == characters[j]) {
                    rearranged[k] = characters[j];
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner obj = new Scanner(System.in);
        GameofThrones GoT = new GameofThrones();
        GoT.alphabets = new char[26];
        String word = obj.next();
        GoT.characters = new char[word.length()];
        GoT.frequency = new int[26];
        GoT.rearranged = new char[word.length()];

        GoT.prepareAlpha();
        GoT.prepareChar(word);
        GoT.findFrequency();
        GoT.rearrange();

        /*boolean answer = GoT.palindromeornot();
        if(answer)
        System.out.println("YES");
        else
            System.out.println("NO");*/

        for (int i = 0; i < GoT.rearranged.length; i++)
            System.out.print(GoT.rearranged[i]);

    }
}
