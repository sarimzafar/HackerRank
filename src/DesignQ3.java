import java.util.Scanner;

/**
 * Created by shassanzafar on 5/22/2015.
 */
public class DesignQ3 {
    public String a;
    public String b;

    boolean reverse(String val) {
        String w = "";
        for (int i = 0; i < val.length(); i++) w = val.charAt(i) + w;
        if (val.equals(w)) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        DesignQ3 dq3 = new DesignQ3();
        System.out.println("Enter string 1");
        System.out.println(dq3.reverse(dq3.a = obj.nextLine()));
        //System.out.println("Enter string 2");
        //System.out.println(dq3.reverse(dq3.b = obj.next()));

    }
}
