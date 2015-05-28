import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by shassanzafar on 5/20/2015.
 */
public class ConnectedGrid {
    public int row;
    public int col;
    public int count = 0;
    public int array[][];
    static int[][] coordinates = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int visited[][];

    public void checkMax(int number) {
        count = number > count ? number : count;
    }

    public void CountData(int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col) return;
        if (visited[i][j] == 1 || array[i][j] == 0) return;

        count++;
        visited[i][j] = 1;
        for (int x = 0; x < 8; x++) {
            CountData(i + coordinates[x][0], j + coordinates[x][1]);
        }
    }


    public void update() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                CountData(i, j);
                checkMax(count);
            }
        }

    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Scanner obj = new Scanner(System.in);
        ConnectedGrid CG = new ConnectedGrid();

        CG.row = obj.nextInt();
        CG.col = obj.nextInt();

        CG.visited = new int[CG.row][CG.col];
        CG.array = new int[CG.row][CG.col];

        for (int i = 0; i < CG.row; i++) {
            for (int j = 0; j < CG.col; j++) {
                CG.array[i][j] = obj.nextInt();
            }
        }
        // CG.print();
        CG.update();
        System.out.println(CG.count);
    }
}
