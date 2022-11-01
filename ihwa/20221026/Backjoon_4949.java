import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 메모리: 20072 KB   시간: 276 ms
 */
public class Backjoon_4949 {

    public String solution(String s) {
        // Character형 stack선언
        Stack<Character> stack = new Stack<>();

        // 인자로 받은 String 문자열을 문자리스트로 생성
        char[] charList = s.toCharArray();
        // 문자리스트를 돌면서 괄호 검사
        for(char c : charList) {
            // 시작하는 괄호 시 stack에 추가
            if(c == '[' || c == '(') {
                stack.push(c);
            }
            // 닫는 대괄호일 경우
            else if(c == ']') {
                // stack에 아무 값도 없으면 맞는 시작괄호가 없으므로 no 리턴
                // stack의 가장 최근에 들어간 값이 시작하는 대괄호가 아닐 경우 짝이 안맞으므로 no 리턴
                if(stack.isEmpty() || stack.pop() != '[') {
                    return "no";
                }
            }
            // 닫는 소괄호일 경우
            else if(c == ')') {
                // stack에 아무 값도 없으면 맞는 시작괄호가 없으므로 no 리턴
                // stack의 가장 최근에 들어간 값이 시작하는 소괄호가 아닐 경우 짝이 안맞으므로 no 리턴
                if(stack.isEmpty() || stack.pop() != '(') {
                    return "no";
                }
            }
        }

        // 문자열을 다 돌았으나 시작하는 괄호가 남아있다면 짝이 다 맞지 않았으므로 no 응답
        if(!stack.isEmpty()) {
            return "no";
        }

        // 짝이 다 맞는다면 yes 응답
        return "yes";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Backjoon_4949 main = new Backjoon_4949();

        String line;
        while((line = br.readLine()) != null) {
            if(!line.equals(".")) {
                System.out.println(main.solution(line));
            }
        }
    }
}
