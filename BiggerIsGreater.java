package hacker.rank;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.*;

public class Main {

    public void permutations(String prefix, String str,ArrayList<String> arrayList)
    {
        if(str.length() == 0)
        {
            arrayList.add(prefix);
        }

        for(int i = 0 ; i<str.length();i++)
        {
            permutations(prefix + str.charAt(i),str.substring(0,i)+str.substring(i+1),arrayList);
        }
    }

    public String find(LinkedHashMap<String,ArrayList<String>> listLinkedHashMap,String word)
    {
        ArrayList<String> arrayList = listLinkedHashMap.get(word);
        int count = arrayList.indexOf(word);
        return arrayList.get(count+1);
    }

    public String sort(String word)
    {
        char[] Chars = word.toCharArray();
        Arrays.sort(Chars);
        return new String(Chars);
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int count = obj.nextInt();
        int n = count;
        Main main = new Main();

        LinkedHashMap<String,ArrayList<String>> listLinkedHashMap = new LinkedHashMap<String,ArrayList<String>>();

        while(count>0)
        {
            
            String s = obj.next();
            if(s.length() == 1)
            {
                System.out.println("no answer");
            }
            else
            {
                ArrayList<String> arrayList = new ArrayList<>();
                String str = main.sort(s);
                main.permutations("",str,arrayList);
                listLinkedHashMap.put(s, arrayList);

                String finalanswer  = main.find(listLinkedHashMap, s);

                if(finalanswer.equals(s))
                    System.out.println("no answer");
                else
                    System.out.println(finalanswer);

            }

            count--;
        }
    }
}
