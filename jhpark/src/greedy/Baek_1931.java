package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_1931 {
    static int n;
    static int[] start,finish;
    static int[][] G;


    /**
     * 생각하기
     * 1. 수업이 짧은 강의 부터? X
     * 2. 빨리시작하는 강의 부터? X
     * 3. 가장 적게 겹치는 강의 부터? △
     * 4. 빨리 끝나는 강의 부터? O  -> 왜 이게 제일 빠른가?
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();

        n = Integer.parseInt(in);
//        start = new int[n];
//        finish = new int[n];

        G = new int[n][2];

        for(int x=0;x<n;x++){
            String data = br.readLine();
//            start[x] = Integer.parseInt( data.split(" ")[0]);
//            finish[x] = Integer.parseInt( data.split(" ")[1]);

            G[x][0] = Integer.parseInt( data.split(" ")[1]); //끝나는 시간
            G[x][1] = Integer.parseInt( data.split(" ")[0]); // 시작 시간
        }
        //끝나는 시간인 finish[] 의 오름차순 정렬 필요
        Arrays.sort(G, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int rs = 1; // 끝나는 시간을 오름 차순으로 넣었기 때문에 초기값 1
        int k=0; //인덱스 값
        for(int i=1;i<n;i++){
//            if(start[i]>=finish[k]){ //강의 i와 k가 겹치지 않음
//                rs++;
//                k = i;
//            }
            if(G[i][1]>=G[k][0]){ //강의 i와 k가 겹치지 않음
                rs++;
                k = i;
            }

        }
        System.out.println(rs);
    }

}
