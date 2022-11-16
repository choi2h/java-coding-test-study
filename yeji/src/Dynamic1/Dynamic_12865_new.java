package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dynamic_12865_new {

    /**
     * 참고 강의 : https://youtu.be/rhda6lR5kyQ
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken()); // 물건개수
        int k = Integer.parseInt(tokenizer.nextToken()); // 최대무게

        // 가치를 저장할 배열
        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for (int i = 1; i <= n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(tokenizer.nextToken()); // weight
            v[i] = Integer.parseInt(tokenizer.nextToken()); // value
        }

        // 변수가 n , k 두개 이므로 2차원 배열을 만들어야 한다는 걸 생각해야 한다.
        int[][] ns = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // 디폴트값으로 이전 물건의 가치를 저장한다.
                // 이걸 선언하지 않으면 틀린다..
                // 기본적으로 선택하지 않는 경우를 디폴트로 삼는 것 같다...
                ns[i][j] = ns[i-1][j];

                if (j - w[i] >= 0) { //무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
                    // i 번째 물건을 선택한 경우와 선택하지 않은 경우 총 2 가지의 케이스로 나뉜다.
                    // 이전 물건에서 구한 가치와 // 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                    ns[i][j] = Math.max(ns[i-1][j], ns[i-1][j-w[i]]+v[i]);
                }

                //정답
               /* ns[i][j] = ns[i-1][j]; // 기본적으로 이전 물건의 가치를 저장한다.
                if(j - w[i]>=0) { // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
                 // 이전 물건에서 구한 가치와 // 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                    ns[i][j] = Math.max(ns[i-1][j], ns[i-1][j-w[i]]+v[i]);
                }*/
            }
        }
        System.out.println(ns[n][k]);
    }
}
