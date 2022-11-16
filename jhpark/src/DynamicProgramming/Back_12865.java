package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_12865 {

    static int n,k;
    static int[] W,V;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();

        n = Integer.parseInt( in.split(" ")[0]);
        k = Integer.parseInt( in.split(" ")[1]);
        W = new int[n];
        V = new int[n];
        dp = new int[n+1][k+1];

        for(int x=0;x<n;x++){
            String data = br.readLine();
            W[x] = Integer.parseInt( data.split(" ")[0]);
            V[x] = Integer.parseInt( data.split(" ")[1]);
        }


        System.out.println(excuteDP(0,0));
    }

    /**
     * 2의 n승인 모든 경우의 수를 확인하게 되므로 시간초과 발생
     */
    public static int excute(int i, int w){ //현재까지 인덱스, 현재 무게
        if (i == n){
            return 0;
        }

        //포함 시키는 경우
        int n1= 0;
        if(w+W[i]<=k){//현재무게와 더하려는 무게가 가방에 넣을 수 있을 경우에만 포함시킨다
            n1 = V[i] + excute(i+1,w + W[i]); //인덱스의 가치를 더하고, 인덱스 하나 증가, 무게도 증가
        }

        //미포함하는 경우
        int n2 = excute(i+1, w); // 인덱스의 가치를 더하지않고, 인덱스만 증가하고, 무게도 증가하지 않음.

        return Math.max(n1,n2);
    }

    /**
     * 캐시를 이용한 방법DP를 이용한
     * @param i
     * @param w
     * @return
     */
    public static int excuteDP(int i, int w){ //현재까지 인덱스, 현재 무게
        if(dp[i][w]>0){
            return dp[i][w]; // 저장되어 있는 값이 있다면 리턴해라
        }
        if (i == n){
            return 0;
        }

        //포함 시키는 경우
        int n1= 0;
        if(w+W[i]<=k){//현재무게와 더하려는 무게가 가방에 넣을 수 있을 경우에만 포함시킨다
            n1 = V[i] + excuteDP(i+1,w + W[i]); //인덱스의 가치를 더하고, 인덱스 하나 증가, 무게도 증가
        }

        //미포함하는 경우
        int n2 = excuteDP(i+1, w); // 인덱스의 가치를 더하지않고, 인덱스만 증가하고, 무게도 증가하지 않음.
        dp[i][w] = Math.max(n1,n2); // 리턴하기전에 기억해 놓는다.
        return dp[i][w];
    }


}
