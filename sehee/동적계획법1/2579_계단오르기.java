import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[] arr = new int[length+1];
        
        for(int i=1; i<length+1; i++) {
        	arr[i] =  Integer.parseInt(br.readLine());
        }
        
        // 1. 한번에 한 계단, 두 계단만 가능. 연속 3개 밟기 불가능
        // 2. 마지막 계단은 무조건 밟아야 한다.
        // 2-1.  마지막-3 (마지막-2) 마지막-1  (마지막) : (n-2) + (n)
        // 2-2. (마지막-3) 마지막-2 (마지막-1) (마지막) : (n-3) + (n-1) + (n)
        
        	
        int[] memo = new int[length+1]; // 각 단계마다의 값의 합
    		
        memo[1] = arr[1];
        
        // 주어진 길이가 1 인 경우가 있음...
        if(length > 1) {
        	memo[2] = arr[1] + arr[2];
        }
        
 		for (int i = 3; i <= length; i++) {
 			memo[i] = Math.max(memo[i - 2] , memo[i - 3] + arr[i - 1]);
            memo[i] += arr[i]; // 마지막 더하기
 		}
  
 		System.out.println(memo[length]);
	}
}