
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon_2579 {

    int[] scores;
    int[] dp;


    public int solution(int[] arr) {
        // 와인 전역변수에 할당
        scores = arr;
        // 각 자리당 최대값을 계산해서 넣을 배열 선언
        dp = new int[arr.length];

        // 최대값 찾기
        for(int i=0; i<arr.length; i++) {
            find(i);
        }


        // 마지막 최대값 반환
        return dp[arr.length-1];
    }

    private void find(int i) {
        int max = 0;
        if(i==0) {
            max = scores[i];
        } else if(i==1){
            max = Math.max(scores[i], scores[i-1]+scores[i]);
        } else if(i==2) {
            max = Math.max(scores[i-2]+scores[i], scores[i-1]+scores[i]);
        } else {
            max = Math.max(dp[i-2] + scores[i], dp[i-3] + scores[i-1] + scores[i]);
        }


        dp[i] = max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Backjoon_2579 main = new Backjoon_2579();

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        for(int i=0; i<count; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.solution(arr));
    }
}
