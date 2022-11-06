import java.io.*;

class Main {
	static Integer[] memo; // 인덱스의 값은 최단 경로를 의미
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        // X가 3으로 나누어 떨어지면 3으로, 2로 나누어 떨어지면 2로. 1을 뺀다. -> 1로 만들기
        // X - 1의 값과 X의 경로 값을 비교
        // [0], [1] 의 경우 미리 설정 했으므로 나눠지는 값이 없는 경우 재귀 종료.
        
        memo = new Integer[num+1];
        
        memo[0] = 0; // X가 0일 때 
        memo[1] = 0; // X가 1일 때
        // ALERT) 이거 안하면 런타임 에러 발생
        
        System.out.print(resolution(num));
	}
    
    public static int resolution(int num) {
    	//System.out.println("num= " + num);
    	
    	if(memo[num] == null) { // ALERT) 이거 안하면 메모리 초과 발생 
    		if(num % 6 == 0) {
        		//System.out.println("0. 1= " + (num / 3) + " / 2=" + ((num) / 2));
        		memo[num] = Math.min(resolution(num -1), Math.min(resolution(num / 3), resolution(num / 2))) + 1;
        		// memo[num] = resolution(Math.min((num / 3), ((num) / 2))) + 1; // WRONG
        	} else if(num % 3 == 0) {
        		//System.out.println("1. 1= " + (num / 3) + " / 2=" + (num -1));
        		memo[num] = Math.min(resolution(num / 3), resolution(num - 1)) + 1;
        		//memo[num] = resolution(Math.min((num / 3), ((num -1) / 2))) + 1; // WRONG
        	} else if (num % 2 == 0) {
        		//System.out.println("2. 1= " + (num - 1) + " / 2=" + (num / 2));
        		memo[num] = Math.min(resolution(num - 1), resolution(num / 2)) + 1;
        		//memo[num] = resolution(Math.min(((num - 1) / 3), (num / 2))) + 1; // WRONG
        	} else {
        		//System.out.println("3. 1= " + (num - 1));
        		memo[num] = resolution(num - 1) + 1;
        	}
    	}
    	
    	//System.out.println("num = " + num + " / memo[num]= " + memo[num]);
    	return memo[num];
    }
}