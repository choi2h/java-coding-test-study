import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 메모리: 30336 KB    시간: 464 ms
 */

public class Backjoon_1874 {

    public String solution(int[] arr) {
        // PUSH(+), POP(-) 결과를 담는 List 생성
        List<Character> result = new ArrayList<>();

        // 입력받은 수들을 넣었다 뺄 스택 생성
        Stack<Integer> stack = new Stack<>();
        // 오름차순으로 쌓을 수 생성
        int n=1;

        // 입력받은 수를 하나씩 순회
        for(int k : arr) {
            // 스택이 비어있지 않으나
            // 스택의 가장 최근 값(stack.peek())이 현재 찾고자하는 값 k보다 작고
            // 오름차순으로 쌓을 수 있는 값 n이 현재 찾고자하는 값 k보다 크다면
            // 현재 찾고자 하는 값 k는 이미 스택에 들어갔다 나왔다고 판단
            // NO 반환
            if(!stack.isEmpty() && stack.peek()<k && n>k) {
                return "NO";
            }
            // 스택이 비어있고
            // 오름차순으로 쌓을 수 있는 값 n이 현재 찾고자하는 값 k보다 크다면
            // 현재 찾고자 하는 값 k는 이미 스택에 들어갔다 나왔다고 판단
            // NO 반환
            else if(stack.isEmpty() && n>k) {
                return "NO";
            }


            // 오름차순으로 쌓이는 n이 현재 찾고자 하는 값 K보다 작다면
            while(n <= k) {
                // 현재 찾고자하는 값 k까지 스택에 추가하여 준다.
                stack.push(n++);
                // PUSH 작업을 한번 진행할 때마다 결과List에 + 추가
                result.add('+');
            }

            // 스택이 비어있지 않고
            // 스택의 가장 최근 값이 현재 찾고자하는 값 k보다 크거나 같다면
            while(!stack.isEmpty() && stack.peek() >= k) {
                // 스택에서 가자 최근 값을 꺼낸다.
                int j = stack.pop();
                // POP 작업을 한번 진행할 때마다 결과List에 - 추가
                result.add('-');

                // 만약 스택에서 꺼낸 값 j가 현재 찾고자하는 값 k와 같다면
                if(j==k) {
                    // 이 반복문을 멈춘다.
                    break;
                }

                // 꺼낸 값 j가 찾고자하는 값 k보다 크다면 k를 찾기위해 이 반복문을 계속 돈다.
            }
        }

        // 이 스택을 사용하여 수열을 만들지 못했다면 이미 NO로 반환되었을 것
        // 결과 리스트에 담아놓은 값들을 StringBuilder에 담아서 반환한다.
        StringBuilder sb = new StringBuilder();
        for(char s : result) {
            sb.append(s).append('\n');
        }

        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] arr = new int[total];

        for(int i=0; i<total; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Backjoon_1874 main = new Backjoon_1874();
        System.out.println(main.solution(arr));
    }
}