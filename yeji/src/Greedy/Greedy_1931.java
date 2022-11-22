package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_1931 {
    /**
     * 가능한 한 많은 구간을 선택하는 문제
     * 3
     * 1 3
     * 8 8
     * 3 8
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //회의 수
        int time[][] = new int[N + 1][2]; //[][1] : 시작시간, [][2] : 끝나는시간

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 끝시간
        }

        //회의가 끝나는 시간 기준으로 오름차순 정렬
        Arrays.sort(time, (o1, o2) -> {
            // 종료 시간이 같을 경우 시작 시간이 빠른순으로 정렬
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else{
                return o1[1] - o2[1];
            }
        });

        int count = 0; //하루 최대 회의 수
        int endTime = 0; // 종료시간
        for (int i = 1; i <= N; i++) {
            // 시작시간이 종료시간보다 크거나 같으면
            if (endTime <= time[i][0]) {
                // 종료시간을 해당 회의의 종료시간으로 갱신한다.
                endTime = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
