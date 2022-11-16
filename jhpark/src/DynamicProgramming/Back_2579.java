package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_2579 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int in = Integer.parseInt(br.readLine());
        int[] arr = new int[in];

        for(int i =0;i<in;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[in];
        dp[0] = arr[0];
        dp[1] = dp[0] + arr[1];

        for(int test=2;test<in;test++){
            dp[test] = Math.max(dp[test-2],dp[test-3]+arr[test]);
        }


        System.out.println(dp[in]);

    }
}
