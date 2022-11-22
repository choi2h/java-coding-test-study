package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Dynamic_2565 {

    static Integer[] dp;
    static int[][] wire;

    /**
     * LIS 문제( 최대 증가 수열문제 )
     * 업애야 하는 전깃줄의 최소 개수를 구하시오.
     * 즉, 반대로 남길 수 있는 전깃줄의 최대 개수 구하면 전체에서 빼주면 되니까
     *
     * ** 전깃줄이 교차하지 않는 다는 것은 -> 왼쪽 번호 증가대로 순서대로 오른쪽 번호도 증가함
     * 입력으로 들어오는 왼쪽 번호를 정렬해주면
     * 교차하지 않는 대응되는 전선의 오른쪽 번호도 증가한다.
     * https://youtu.be/sYh62pujaH8
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] num = new int[N + 1][2]; //[][1] : A 전깃줄 번호, [][2] : B 전깃줄 번호
        int[] dp = new int[N+1]; // 최장 증가(=최대 설치할 수 있는) 전기줄 개수 (구하고자하는 해)
        int maxInstall = 1; // 가장 많이 설치할 수 있는 개수

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num[i][0] = Integer.parseInt(st.nextToken()); // A 전깃줄 번호
            num[i][1] = Integer.parseInt(st.nextToken()); // B 전깃줄 번호
        }

        //[][0] 정렬 (A 전봇대 기준으로 오름차순 정렬)
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i <= N; i++) {
            System.out.println(num[i][0] + " " + num[i][1]);
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = 1; // 초기값은 최소 한개는 이어져야 하니까 1...
            for (int j = 1; j < i; j++) {
                if (num[j][1] < num[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxInstall = Math.max(maxInstall, dp[i]); // 최대 이어진 전깃줄 개수 세팅
            }
        }
        System.out.println(N-maxInstall); // 없애야 하는 전깃줄 개수 = 전체개수 - 가장 많이 설치할 수 있는 개수
    }
}
