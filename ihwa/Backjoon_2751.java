import java.util.*;


/*
 * String vs StringBuffer vs StringBuilder
 *  - 속도 : String > StringBuilder > StringBuffer
 *  - 동기화지원 O : String, StringBuffer
 *  - 동기화지원 X : Stringbuilder
 *  - 설명 참고 : https://ifuwanna.tistory.com/221
 *  
 * 메모리: 320768 KB    시간: 2656ms
 */
public class Backjoon_2751 {

    private void solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr) {
            list.add(i);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int value : list) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = new int[s.nextInt()];

        for(int i=0; i<nums.length; i++) {
            nums[i] = s.nextInt();
        }

        Backjoon_2751 main = new Backjoon_2751();
        main.solution(nums);
    }
}
