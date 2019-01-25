import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {

    static void printMatrix(int[][] matr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);

        int[][] matr = new int[n][n];
        int[] arr = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matr[i][j] = new Random().nextInt(n);
            }
        }

        printMatrix(matr,n);

        //limits
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;

        int i = 0;
        int j = 0;
        int fixI = i;
        int fixJ = j;
        int way = j; // fix str
        int quantity = 1;
        int elOfArr = 1;

        arr[0] = matr[j][i];

        while (quantity != n * n) {
            if (way == j && fixI == left && i != right)//way right
                i++;
            else if (way == i && fixJ == top && j != bottom)//way bottom
                j++;
            else if (way == j && fixI == right && i != left && fixJ == way)//way left
                i--;
            else if (way == i && fixJ == bottom && j != top + 1)//way top
                j--;
            else {
                if (way == i && fixJ == bottom && j == top + 1) {//переход на следующий виток
                    top++;
                    left++;
                    bottom--;
                    right--;
                    fixI++;
                } else { //изменение начальной точки
                    fixI = i;
                    fixJ = j;
                }

                //изм fix point в зависимости от пройденного ребра
                if (way == j) way = i;
                else way = j;

                continue;
            }

            arr[elOfArr] = matr[j][i];
            elOfArr++;
            quantity++;


        }

        System.out.println("\n"+ Arrays.toString(arr));
    }
}
