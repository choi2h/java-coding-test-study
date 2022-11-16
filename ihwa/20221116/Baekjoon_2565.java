import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 * 메모리: 14224KB / 시간: 128ms
 */
public class Baekjoon_2565 {
    int[] dp;
    List<UtilityPole> list;
    int totalMax;


    public int solution(int n, List<UtilityPole> poleList) {
        dp = new int[n];
        Collections.sort(poleList);
        list = poleList;
        dp[0] = 1;

        for(int i=1; i<poleList.size(); i++) {
            int max = find(i);
            dp[i] = max;

            totalMax = Math.max(totalMax, max);
        }

        return n-totalMax;
    }

    private int find(int i) {
        int arrive = list.get(i).arrive;
        int max =1;

        for(int j=0; j<i; j++){
            if(list.get(j).arrive < arrive) {
                max = Math.max(dp[j]+1, max);
            }
        }

        return max;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Baekjoon_2565 main = new Baekjoon_2565();
        int n = Integer.parseInt(br.readLine());

        List<UtilityPole> poleList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String[] s = br.readLine().split(" ");
            UtilityPole pole = new UtilityPole(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            poleList.add(pole);
        }

        System.out.println(main.solution(n, poleList));
    }

    static class UtilityPole implements Comparable<UtilityPole> {
        int num;
        int arrive;

        public UtilityPole(int num, int arrive) {
            this.num = num;
            this.arrive = arrive;
        }

        @Override
        public int compareTo(UtilityPole o) {
            if(this.num > o.num) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}