package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        //입력값 저장할 배열
        int[] inputArr = new int[n];
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(br.readLine()); // 입력값 저장
        }

        Stack<Integer> stack = new Stack<>();
        /**
         * 스택에 push 하는 순서는 반드시 오름차순
         */
        // 스택에 저장될 값
        int value = 1;

        for (int i = 0; i < n; i++) {

            /* 입력값과 스택에 저장된 값의 비교 */
            // 입력 값이 value 값보다 크거나 같으면
            if (inputArr[i] >= value) {
                while (inputArr[i] >= value) {
                    stack.push(value++);
                    sb.append("+").append("\n");
                }
            } else if (inputArr[i] <= stack.peek()) {
                while (inputArr[i] <= stack.peek()) { // 입력값이 top 값과 같아질 때까지 제거
                   stack.pop();
                    sb.append("-").append("\n");
                    if (stack.isEmpty()) {
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
