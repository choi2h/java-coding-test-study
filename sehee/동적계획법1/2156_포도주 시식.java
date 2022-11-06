import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[] arr = new int[length+1];
        
        for(int i=1; i<length+1; i++) {
        	arr[i] =  Integer.parseInt(br.readLine());
        }
        
        // 계단 오르기 베이스??
        // 전 합계랑 비교 필요???
                	
        int[] memo = new int[length+1]; // 각 단계마다의 값의 합
    		
        memo[1] = arr[1];
        
        // 주어진 길이가 1 인 경우가 있음...
        if(length > 1) {
        	memo[2] = arr[1] + arr[2];
        }
        
 		for (int i = 3; i <= length; i++) {
 			memo[i] = Math.max(memo[i - 2] , memo[i - 3] + arr[i - 1]);
            memo[i] += arr[i];
            memo[i] = Math.max(memo[i-1], memo[i]);
 		}
  
 		System.out.println(memo[length]);
	}
}