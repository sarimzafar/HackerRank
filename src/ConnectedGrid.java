import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 *Problem Statement

You are given a matrix with m rows and n columns of cells, each of which contains either 1 or 0. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. The connected and filled (i.e. cells that contain a 1) cells form a region. There may be several regions in the matrix. Find the number of cells in the largest region in the matrix.

Input Format
There will be three parts of t input:
The first line will contain m, the number of rows in the matrix.
The second line will contain n, the number of columns in the matrix.
This will be followed by the matrix grid: the list of numbers that make up the matrix.

Output Format
Print the length of the largest region in the given matrix.

Constraints
0<m<10
0<n<10

Sample Input:

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output:

5
Task: 
Write the complete program to find the number of cells in the largest region.

Explanation

X X 0 0
0 X X 0
0 0 X 0
1 0 0 0  
The X characters indicate the largest connected component, as per the given definition. There are five cells in this component.
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
