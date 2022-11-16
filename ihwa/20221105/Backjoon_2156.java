import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Backjoon_2156 {

    int[] wines;
    int[] dp;


    public int solution(int[] arr) {
        // 와인 전역변수에 할당
        wines = arr;
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
        if(i == 0) {
            // 처음 와인양 저장
            max = wines[i];
        } else if(i == 1){
            // 현재 와인양과 와인 합한 값 중 큰 값 저장
            max = Math.max(wines[i], wines[i] + wines[i-1]);
        } else if(i == 2) {
            // OXO
            // XOO
            // 위 둘 중 큰 값 저장
            max = Math.max(wines[i] + wines[i-1], wines[i]+ wines[i-2]);
            max = Math.max(max, dp[i-1]);
        } else {
            // XOO 
            // OXO
            max = Math.max(dp[i-3] + wines[i-1] + wines[i], dp[i-2] + wines[i]);
            // OOX
            max = Math.max(max, dp[i-1]);
            
            // 위 세가지 경우 다 비교하여 큰 값 저장
        }

        // 최대값 저장 배열에 저장
        dp[i] = max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Backjoon_2156 main = new Backjoon_2156();

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        for(int i=0; i<count; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.solution(arr));
    }
}
