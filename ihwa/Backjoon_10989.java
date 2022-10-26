import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 계수정렬(Couning sort)
 *  - 알고리즘 참고 : https://jeonyeohun.tistory.com/103
 * 
 * 
 * 메모리: 320768 KB   시간: 2656 ms
 */
public class Backjoon_10989 {

    int[] count = new int[10001];

    private void solution(int[] arr) {
        for(int i : arr) {
            count[i]++;
        }

        for(int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }

        int[] result = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int num = arr[i];
            count[num]--;
            result[count[num]] = num;
        }

        StringBuilder sb = new StringBuilder();
        for(int value : result) {
            sb.append(value).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] nums = new int[length];

        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Backjoon_10989 main = new Backjoon_10989();
        main.solution(nums);
    }
}