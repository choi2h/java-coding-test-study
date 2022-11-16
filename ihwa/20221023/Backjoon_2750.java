
import java.util.Scanner;

/*
 *  선택 정렬
 *  메모리:22204KB   시간:352ms
 */
public class Backjoon_2750 {

    public int[] solution(int[] nums) {

        for(int i=0; i<nums.length-1; i++) {
            for(int j=nums.length-1; j>i; j--) {
                if(nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = new int[s.nextInt()];

        for(int i=0; i<nums.length; i++) {
            nums[i] = s.nextInt();
        }

        Backjoon_2750 main = new Backjoon_2750();
        int[] result = main.solution(nums);
        for(int i=0; i<nums.length; i++) {
            System.out.println(result[i]);
        }

    }
}
