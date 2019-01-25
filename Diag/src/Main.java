import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    static void printMatrix(int[][] matr, int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
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
        int[] arr = new int[n*n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                matr[i][j] = new Random().nextInt(n);
            }
        }

        printMatrix(matr,n);

        int i = 0;
        int j = 0;
        int lim = 0;
        int border = 0;
        int elOfArr = 1;
        boolean way;

        //arrIndex = 0
        arr[0] = matr[0][0];

        //итерируемость по диагонали
        while (i != n-1 || j != n-1){
            if (j == lim) i++; //переход с одной диагонали на другую
            else j++;

            //определение стороны, верх или низ
            if (lim == 0) border = i;
            else border = j;

            //определяем направление
            way = border == lim;

            //сам обход диагонали
            while ( lim == 0 ? j != border : i != border ){
                arr[elOfArr] = matr[j][i];
                elOfArr++;

                if (way) {
                    i++;
                    j--;
                }else {
                    i--;
                    j++;
                }

            }

            //внешний while
            arr[elOfArr] = matr[j][i];
            elOfArr++;

            //изменение lim для над или под диагональю
            if ((i == n-1 && j == 0) || (i == 0 && j == n-1))
                lim = n-1;
        }

        System.out.println("\n"+Arrays.toString(arr));

    }
}
