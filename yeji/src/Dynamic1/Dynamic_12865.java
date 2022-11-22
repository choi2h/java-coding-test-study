package Dynamic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Dynamic_12865 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken()); // 물건개수
        int k = Integer.parseInt(tokenizer.nextToken()); // 최대무게

        // 무게와 가치를 저장할 맵
        Map<Integer, Integer> map = new HashMap<>();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }

        // Iterator 사용 1 - keySet()
        Iterator<Integer> keys = map.keySet().iterator();
        int u = 0;
        while (keys.hasNext()){
            w[u] = keys.next();
            u++;
        }

        // 가치의 합
        int max = 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if(i == n) break;
            if ((w[i-1] + w[i]) <= k) {
                dp[i] =  map.get(w[i-1]) + map.get(w[i]);
                max = Math.max(dp[i-1], dp[i]);
            }
        }
        System.out.println(max);
    }
}
