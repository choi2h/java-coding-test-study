import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 길이가 num인 계단. 자릿수
        int num = Integer.parseInt(br.readLine());
    
        // [자릿수][값의 범위] : [num+1][0~9] = 
        // 현재 값 기준으로 다음 자릿수 +1, -1
        // 맨앞자리에는 0이 못옴
        // 해당 자릿수의 값이 0인 경우 앞에가 없으므로 뒤에는 1만 가능, 9인 경우 8만 가능
        // 왼쪽에서 부터 자릿수 계산 할것임(원래는 오른쪽부터)
        
        long[][] memo = new long[num+1][10];
        
        for(int i=1; i<10; i++) {
        	memo[1][i] = 1; // 첫번째 자리수는 무조건 1~9의 수
        	//System.out.println("1. [1][" + i + "]=" + memo[1][i]);
        }
        
        for(int i=2; i<=num; i++) {
        	for(int j=0; j<10; j++) {
        		if(j == 0) { // j가 0이면.. 앞자리가 1인 값 밖에 못옴
        			memo[i][0] = memo[i-1][1] % 1000000000;
        			//System.out.println("2. [" + i + "][0]=" + memo[i][0] + " / [" + (i-1) + "][1]=" + memo[i-1][1] + " = " + 1 + 0);
        		} else if(j == 9) { // j가 9이면.. 앞자리가 8인 값 밖에 못옴
        			memo[i][9] = memo[i-1][8] % 1000000000;
        			//System.out.println("3. [" + i + "][9]=" + memo[i][9] + " / [" + (i-1) + "][8]=" + memo[i-1][8] + " = " + 8 + 9);
        		} else { // 이외에는 앞자리의 +1값과 -1값이 가능함
        			memo[i][j] = (memo[i-1][j-1] + memo[i-1][j+1]) % 1000000000;
        			//System.out.println("4. [" + i + "][" + j + "]=" + memo[i][j] 
        			//		+ " / [" + (i-1) + "][" + (j-1) + "]=" + memo[i-1][j-1] + " / [" + (i-1) + "][" + (j+1) + "]=" + memo[i-1][j+1]
        			//				+ " = " + (j-1) + (j) + ", " + (j+1) + (j));
        		}
        	}
        }
        
        long sum = 0;
        
        for(int i=0; i<10; i++) {
        	sum += memo[num][i];
        }
        
        System.out.print(sum % 1000000000);
	}
}