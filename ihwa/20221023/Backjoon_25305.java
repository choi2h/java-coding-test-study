import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 정렬함수
 * - 기본 : 오름차순
 * - 반대 : 내림차순 -> Collections.reverseOrder()
 * 
 * 정렬
 * - 시간 : Array.sort() < Collections.sort()
 * - Array.sort() : 평균 [O(nlog(n))] / 최악 [O(n^2)]
 * - Collections.sort() : 평균,최악 [O(nlog(n))]
 * - 참고 : https://da-nyee.github.io/posts/java-arrays-sort-vs-collections-sort/
 * 
 * 메모리: 320768 KB   시간: 2656 ms
 */
public class Backjoon_25305 {

    private int solution(Integer[] arr, int rank) {
        Arrays.sort(arr, Collections.reverseOrder());

        return arr[rank-1];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer[] nums = new Integer[s.nextInt()];
        int rank = s.nextInt();

        for(int i=0; i<nums.length; i++) {
            nums[i] = s.nextInt();
        }

        Backjoon_25305 main = new Backjoon_25305();
        System.out.println(main.solution(nums, rank));
    }
}