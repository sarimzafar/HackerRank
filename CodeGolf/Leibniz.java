import java.util.Scanner;

/**
 * Created by shassanzafar on 5/12/2015.
 */
public class Leibniz {public static void main(String [] args){Scanner o = new Scanner(System.in);int n=o.nextInt();int v=o.nextInt();while(n>0){double s=0;for(int i=0;i<v;i++){s+=Math.pow(-1,i)/(2*i +1);}System.out.println(Math.round(s));n--;}}}