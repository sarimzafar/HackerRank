import java.util.Scanner;

/**
 * Created by shassanzafar on 5/26/2015.
 * Problem Statement
 * <p>
 * An English text needs to be encrypted using the following encryption scheme.
 * First, the spaces are removed from the text. Let L be the length of this text.
 * Then, characters are written into a grid, whose rows and columns have the following constraints:
 * <p>
 * ?L?????rows?column??L????, where ?x? is floor function and ?x? is ceil function
 * For example, the sentence if man was meant to stay on the ground god would have given us roots after removing spaces is 54 characters long, so it is written in the form of a grid with 7 rows and 8 columns.
 * <p>
 * ifmanwas
 * meanttos
 * tayonthe
 * groundgo
 * dwouldha
 * vegivenu
 * sroots
 * Ensure that rows×columns?L
 * If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. rows×columns.
 * The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:
 * <p>
 * imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau
 * <p>
 * You will be given a message in English with no spaces between the words. The maximum message length can be 81 characters. Print the encoded message.
 */

public class Encryption {

    int row, col;
    int count = 0;

    public String removeBlankSpace(String word) {
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ')
                newWord += word.charAt(i);
        }
        return newWord;
    }

    public void ensure(int length) {
        row = (int) Math.floor(Math.sqrt(length));
        col = (int) Math.ceil(Math.sqrt(length));
    }

    public int GetValue(int i, int j, int length) {
        if (count < length) {
            if (i == 0 && j == 0) {
                count++;
                return 0;
            } else if (j == 0) {
                count++;
                return col * i;
            } else if (i == 0) {
                count++;
                return j;
            } else {
                count++;
                return (i * col) + j;
            }
        }
        return 0;
    }

    public void prepare(String word, char arr[][]) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //if(GetValue(i,j,word.length())!= word.length())
                arr[i][j] = word.charAt(GetValue(i, j, word.length()));
            }
        }
    }

    public void extract(char arr[][], int size) {

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (((i * col) + j) < size)
                    System.out.print(arr[i][j]);
            }
            System.out.print(" ");
        }

    }


    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Scanner obj = new Scanner(System.in);
        String word = obj.nextLine();

        Encryption EP = new Encryption();
        String mainWord = EP.removeBlankSpace(word);

        int length = mainWord.length();
        EP.ensure(length);

        if (EP.row * EP.col < length) {
            EP.row++;
        }
        char base[][] = new char[EP.row][EP.col];
        EP.prepare(mainWord, base);
        EP.extract(base, length);

    }
}
