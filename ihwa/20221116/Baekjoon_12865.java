
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 */
public class Backjoon_12865 {

    // index 숫자가 나누어지는데 가장 최적의 횟수
    int[] dp;
    int k;
    int[][] arr;

    /*
    2중배열 - [물건][무게] [물건][값어치]
    [0] [0][0]6 [0][1]13
    [1] 1[0]4 1[1]8
    [2] 2[0]2 2[1]6
    [3] [3][0]5 [3][1]12
     */

    public int solution(int k, int[][] list) {
        this.k = k;
        arr = list;
        dp = new int[k+1];

        Arrays.sort(arr, Comparator.comparing(arr -> arr[0]));
        find(0, 0, 0);

        int max=0;
        for(int i : dp) {
            if(i!=0) {
                max = Math.max(max, i);
            }
        }

        return max;
    }

    private void find(int wSum, int vSum, int i) {
        if(wSum!=0 && dp[wSum] < vSum){
            dp[wSum] = vSum;
        }

        if(i >= arr.length || wSum == k || dp[wSum] > vSum) {
            return;
        }

        if(wSum + arr[i][0] <= k) {
            find(wSum + arr[i][0], vSum+arr[i][1], i+1);
            find(wSum, vSum, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Backjoon_12865 main = new Backjoon_12865();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        int[][] list = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            list[i][0] = Integer.parseInt(s[0]);
            list[i][1] = Integer.parseInt(s[1]);
        }

        System.out.println(main.solution(k, list));
    }
}
