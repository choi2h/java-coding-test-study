import java.io.*;

// 풀이 실패.. 찾아봄
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[] arr = new int[length+1];
	    int[] dp = new int[length+1];

        String line[] = br.readLine().split(" ");
        
        // 기저 상태 지정
        dp[0] = Integer.parseInt(line[0]);
        
        // 최대 연속값 미리 지정
        int max_val = dp[0];
        
        for(int i=1; i < length; i++){
            arr[i] = Integer.parseInt(line[i]);
            //System.out.println("1. 현재값 : " + arr[i]);

            //System.out.println("2. 이전까지의 합 : " + (dp[i-1] + arr[i]) + " vs 현재 값 : " + arr[i]);
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            //System.out.println("3. 현재 최대값 : " + max_val + " / 2의 결과 : " + dp[i]);

            max_val = Math.max(max_val, dp[i]);
            //System.out.println("4. max_val : " + max_val);
        }
        
        System.out.println(max_val);
	}
}