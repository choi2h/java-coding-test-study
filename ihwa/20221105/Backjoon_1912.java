import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
동적계획법1

메모리:31968 KB   시간:276ms
 */
public class Backjoon_1912 {
    // 최대 연속합을 저장할 변수 선언
    private int max = Integer.MIN_VALUE;
    // 전역변수로 사용할 배열 선언
    private int[] numbers;

   public int solution(int[] arr) {
       // 전달받은 int배열을 전역변수에 할당
        numbers = arr;
        // 최대 연속합 구하기
        find(0, 0);

        return max;
   }

   private void find(int sum, int index) {
       // sum이 기본값으로 넣는 0이 아니고 max보다 클 경우
       if(sum != 0 && max < sum) {
           // max값은 sum으로 변경
           max  = sum;
       }

       // 배열의 마지막 인덱스 초과 시 그냥 return;
       if(index >= numbers.length) {
           return;
       }

       // max값이 현재 인덱스의 수보다 작을 경우
       if(max < numbers[index]) {
           // max값은 현재 인덱스의 수로 변경
           max = numbers[index];
       }


       // 인자로 받은 sum에다 현재 인덱스의 값을 더했을 때 음수가 아닌 경우
       if(sum+numbers[index] >= 0) {
           // 합한값과 다음 인덱스 값을 넘기며 이어서 탐색
           find(sum+numbers[index], index+1);
       }
       // 위 조건이 아닐 경우 (합한 값이 음수인 경우 아무것도 합하지 않은 어느 값이 더 클 것)
       else {
           // sum값을 0으로 초기화하여 다음 인덱스부터 다시 합하도록 탐색
           find(0, index+1);
       }
   }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Backjoon_1912 main = new Backjoon_1912();

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<count; i++) {
           arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(main.solution(arr));
    }
}
