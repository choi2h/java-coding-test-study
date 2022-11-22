package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dynamic_1463 {

    /**
     * 규칙을 찾아서 점화식을 세울 수 있는가?
     * 목표 : 1 로 만들어야 한다.
     * 입력값   연산을 사용한 횟수
     * 1    ->  0
     * 2    ->  1
     * 3    ->  1
     * 4    ->  2
     * 5    ->  3
     * 6    ->  2
     * 7    ->  3
     * 8    ->  3
     * .....
     * f(n) = 1 + min( f(n/2), f(n/3), f(n-1) )
     *
     */
    public static void main(String[] args) throws IOException {

        // x 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];

        // 변하지 않는 값이므로 초기화한다.
        dp[0] = dp[1] = 0;
        dp[2] = dp[3] = 1;

        for (int i = 4; i < X + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + Math.min(dp[i / 2], dp[i - 1]);
            } else if (i % 3 == 0) {
                dp[i] = 1 + Math.min(dp[i / 3], dp[i - 1]);
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }
        //System.out.println("dp:");


        StringBuilder sb = new StringBuilder();
        sb.append(dp[X]);
        System.out.println(sb.toString());
    }

    /*public static void main(String[] args) throws IOException {

        // x 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];

        // 변하지 않는 값이므로 초기화한다.
        dp[0] = dp[1] = 0;
        dp[2] = dp[3] = 1;

        for (int i = 4; i < X + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + Math.min(dp[i / 2], dp[i - 1]);
            } else if (i % 3 == 0) {
                dp[i] = 1 + Math.min(dp[i / 3], dp[i - 1]);
            } else {
                dp[i] = 1 + dp[i - 1];
            }

            // 6의 배수 처리!!

        }
        System.out.println("dp:");


        StringBuilder sb = new StringBuilder();
        sb.append(dp[X]);
        System.out.println(sb.toString());
    }*/
}
