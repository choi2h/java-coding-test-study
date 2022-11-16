package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 첫번째 생각
 */
//없앨수 있는 최소값 = 전체 개수 - 남길수 있는 최대값
//A기준으로 오름차순 정렬해서 B값이 증가하는 선 개수 찾기
//B기준으로 오름차순 정렬해서 A값이 증가하는 선 개수 찾기
//둘중에 더 큰값이 남길 수 있는 최대값

/**
 * 문제풀이방법 (LIS)
 * A를 오름 차순으로 정렬
 * B에서 증가하는 부분수열 찾기
 */

public class Baek_2565 {
    static int n;
    static int[][] A;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();

        n = Integer.parseInt(in);
        A = new int[n+1][2];
        dp = new int[n+1];

        for(int x=0;x<n;x++){
            String data = br.readLine();
            A[x][0] = Integer.parseInt( data.split(" ")[0]);
            A[x][1] = Integer.parseInt( data.split(" ")[1]);
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i =0;i<n+1;i++){
            for(int j=0;j<2;j++){
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
        int rs = allJoin();
        System.out.println(n - rs);

    }

    static int  allJoin(){
        int rs =1;
        for(int i=1;i<n+1;i++ ){
            dp[i]=1;
            for(int j=1;j<n+1;j++){
                if(A[i][1] > A[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            rs = Math.max(dp[i],rs);
        }
        return rs;
    }

    static int useLIS(){
        int rs =1;
        for(int i=1;i<n+1;i++ ){
            dp[i]=1;
            for(int j=1;j<i;j++){
                if(A[i][1] > A[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            rs = Math.max(dp[i],rs);
        }
        return rs;
    }

}
