import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        str = br.readLine();
        int m= Integer.parseInt(str);

        int[] arr1 = IntStream.generate(() -> new Random().nextInt(n)).limit(n).toArray();
        int[] arr2 = IntStream.generate(() -> new Random().nextInt(m)).limit(m).toArray();
        int[] result = new int[m+n];

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String arrStr1 = Arrays.toString(arr1);
        System.out.println(arrStr1);
        String arrStr2 = Arrays.toString(arr2);
        System.out.println(arrStr2);

        int i = 0;
        int j = 0;
        int[] subArr;

        for (int h=0; h<n+m; h++){
            if(i==n || j==m){
                if (i == n){
                    subArr = Arrays.copyOfRange(arr2, j, m);
                    result = IntStream.concat(Arrays.stream(result), Arrays.stream(subArr)).toArray();
                    break;
                }

                if (j == m){
                    subArr = Arrays.copyOfRange(arr1,i,n);
                    result = IntStream.concat(Arrays.stream(result), Arrays.stream(subArr)).toArray();
                    break;
                }
            }

            if (arr1[i] <= arr2[j]){
                result[h] = arr1[i];
                i++;
            } else {
                if (arr1[i] > arr2[j]){
                    result[h] = arr2[j];
                    j++;
                }
            }
        }

        String rez = Arrays.toString(result);
        System.out.println(rez);

    }
}
