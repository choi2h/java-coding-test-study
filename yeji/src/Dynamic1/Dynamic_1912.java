package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dynamic_1912 {

    /**
     *
     */
    /*public static void main(String[] args) throws IOException {

        // n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // input 값 배열에 저장
        int[] inputArr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // 연속된 수들의 합을 저장할 배열 생성 (동일하게 n개의 배열)
        int[] resultArr = new int[n];
        for (int i = 0; i < n; i++) {

            // 각원소의 연속 합을 저장할 배열을 생성
            // 예) n = 5 일 때,
            // i = 0  5개 저장
            // i = 1  4개 저장
            // i = 2  3개 저장
            // i = 3  2개 저장
            // i = 4  1개 저장
            int[] sumArr = new int[n - i];
            sumArr[0] = inputArr[i]; // 첫번째값 세팅

            // 연속된 합들을 저장..
            if (sumArr.length > 1) {
                for (int k = 0; k < sumArr.length - 1; k++) { // 첫번째값은 세팅해줬으므로 하나 빼고 진행
                    sumArr[k + 1] += sumArr[k] + inputArr[k + i + 1];
                }
            }
            // 정렬 후 장 큰 값을 저장한다.
            Arrays.sort(sumArr);
            resultArr[i] = sumArr[sumArr.length - 1];
        }

        Arrays.sort(resultArr);
        int max = resultArr[resultArr.length - 1];
        StringBuffer sb = new StringBuffer();
        sb.append(max);
        System.out.println(sb.toString());
    }*/

    // 메모리 : 22484KB
    // 시간 : 236ms
    public static void main(String[] args) throws IOException {

        /**
         * 다이나믹 프로그래밍 -> 점화식 알고리즘 필요
         * 메모이제이션 : 이전에 계산한 값을 메모리에 저장
         */
        // n 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // input 값 배열에 저장
        int[] inputArr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // n번째에서의 연속합 중 최대값
        int[] dp = new int[n];
        dp[0] = inputArr[0]; // 첫번째는 입력 첫번째값
        int max = 0;
        for (int i = 1; i < n; i++) {
            // 연속되는 합과 연속하지 않는 경우(자기자신) 을 비교하여 큰 값을 저장한다.
            /**
             * dp 배열 : 마지막이 i번째 일때 최대값을 저장
             * dp[0] = inputArr[0] 즉 연속할 합이 없으므로 자기자신
             * dp[1] = dp[0] + inputArr[1] (연속합 - 이전 dp값과 자기자신 합) , inputArr[1] (연속되지 않는 값 - 자기자신)
             * dp[2] = dp[1] + inputArr[2] (연속합 - 이전 dp값과 자기자신 합) , inputArr[2] (연속되지 않는 값 - 자기자신)
             * dp[3] = dp[2] + inputArr[3] (연속합 - 이전 dp값과 자기자신 합) , inputArr[3] (연속되지 않는 값 - 자기자신)
             * .
             * .
             * .
             */
            dp[i] = Math.max(dp[i - 1] + inputArr[i], inputArr[i]);
        }
        Arrays.sort(dp);
        max = dp[n - 1];
        System.out.println(max);
    }
}