import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tmp1 = br.readLine().split(" ");
        int items = Integer.parseInt(tmp1[0]);
        int max = Integer.parseInt(tmp1[1]);
        
        int[][] weightValue = new int[items+1][2]; // [아이템N번][0:무게,1:값]
        for(int i=1; i<=items; i++) {
        	String[] tmp2 = br.readLine().split(" ");
        	weightValue[i][0] = Integer.parseInt(tmp2[0]);
        	weightValue[i][1] = Integer.parseInt(tmp2[1]);
        }

        /*
         * [i] or (v), 현재최대무게-현재물건(v)=남은무게(v)
         * [max-현재물건무게]+[남은무게] or [현재무게최대값]
            물건 (6,13) (4,8), (3,6) (5,12)
         무게
          1    [1]=0  [1] or 0   0     0 => dp[1] 최대 0
          2    [2]=0      0      0     0 => dp[2] 최대 0
          3    [3]=0      0      6     0 => dp[3] 최대 6
          4    [4]=0      8   [3]or8   0 => dp[4] 최대 8
          5    [5]=0   [4]or8 [4]or[3][2] [4]or12 => dp[5] 최대 12
          6   [6]=13  [4]+[2]or13 [3]or[6] [5]or[6] =>13
          7   [6]or13   [4][3]or13 [3][4]or[7]
         */

        dp = new int[max+1];
        for(int i=1; i<=max; i++) {
        	for(int j=1; j<=items; j++) {
        		int weight = weightValue[j][0];
        		int value = weightValue[j][1];
        		if(weight < i) {
        			System.out.println("0-1. 시작 : weight=" + weight + " / value=" + value);
        			dp[i] = Math.max(Math.max(dp[i], dp[i-weight] + dp[weight]), value);
        			System.out.println("3. 확인 " + dp[i]);
        		} else if(weight == i) {
        			System.out.println("0-2. 시작 : weight=" + weight + " / value=" + value);
        			System.out.println("1-2. 비교 " + dp[i] + " 와 " + value);
        			dp[i] = Math.max(dp[i], value); 
        			System.out.println("3-2. 확인 " + dp[i]);
        		}
        	}
        	System.out.println("4. 무게 : " + i + " 의 최대 값 : " + dp[i]);
        }
        System.out.println(dp[max]);
    }
}