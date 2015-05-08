/**
 * Created by shassanzafar on 5/8/2015.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class UtopianTree {


    public int Height(int numberOfcycle) {
        int height = 1;
        for (int i = 1; i <= numberOfcycle; i++) {
            if (i <= 0)
                return height;
            else {
                if (i % 2 == 0) {
                    height++;
                } else {
                    height *= 2;
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int N = obj.nextInt();
        UtopianTree sample = new UtopianTree();
        for (int i = 0; i < N; i++)
            System.out.println(sample.Height(obj.nextInt()));
    }
}