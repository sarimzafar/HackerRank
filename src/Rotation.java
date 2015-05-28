import java.util.Scanner;

/**
 * Created by shassanzafar on 5/25/2015.
 */
public class Rotation {

    int baseArray[][];

    public void NinetyRotation(int array[][]) {
        int size = array.length;
        baseArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                baseArray[j][size - i - 1] = array[i][j];
            }
        }
    }

    void swap(int arr[][], int a, int b, int c) {

        if (arr[a][b] > arr[c][a]) {
            arr[a][b] = arr[a][b] - arr[c][a];
            arr[c][a] = arr[a][b] + arr[c][a];
            arr[a][b] = arr[c][a] - arr[a][b];
        } else {
            arr[c][a] = arr[c][a] - arr[a][b];
            arr[a][b] = arr[c][a] + arr[a][b];
            arr[c][a] = arr[a][b] - arr[c][a];
        }
    }

    public void RotationAtPlace(int array[][]) {
        int size = array.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j != array.length - 1) {
                    swap(array, j, size - 1 - i, i);
                } else {
                    //swap();
                }

            }
        }
    }


    void printBase(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(baseArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    void print(int array[][]) throws NullPointerException {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int N = obj.nextInt();
        int array[][] = new int[N][N];
        System.out.println("Enter the array now");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = obj.nextInt();
            }
        }

        Rotation rt = new Rotation();
        rt.RotationAtPlace(array);
        rt.print(array);
    }
}
