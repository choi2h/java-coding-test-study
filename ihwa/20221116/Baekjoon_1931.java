import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * 메모리: 53316KB / 시간: 676ms
 */
public class Baekjoon_1931 {

    private int solution(List<Meeting> arr, int count) {
        Collections.sort(arr);

        int result=0;
        int now=0;

        for(Meeting m : arr) {
            if(m.start>=now) {
                now = m.end;
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Baekjoon_1931 main = new Baekjoon_1931();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<Meeting> arr = new ArrayList<>();

        for(int i=0; i<count; i++) {
            String[] sarr = br.readLine().split(" ");
            Meeting meeting = new Meeting(Integer.parseInt(sarr[0]), Integer.parseInt(sarr[1]));
            arr.add(meeting);
        }

        int result = main.solution(arr, count);
        System.out.println(result);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end > o.end) {
                return 1;
            } else if(this.end == o.end) {
                if(this.start>o.start) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
}