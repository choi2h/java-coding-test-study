import java.io.*;
import java.util.*;

// 메모리 24356 KB / 시간 388 ms / 코드길이 1745 B
// issue 1 : 입력의 종료 조건으로 점 하나!!!! 여러 줄에 걸쳐서 하나의 문장이 올 수 있음.
//          한줄마다 입력을 받아서 검증하는것이 아니라, 문자열을 다 합친 뒤 '.'으로 나눠서 검증하는 방법으로 변경
// 반례 1 : (((((( : 검증 끝나고 stack이 비어있지 않은 경우 no 리턴
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = "";
        StringBuilder sb = new StringBuilder();
        while(true) {
        	str = br.readLine();
        	if(str.equals(".")) {
        		break;
        	}
        	sb.append(str);
        }
        
        String[] arr = sb.toString().split("[.]");
        for(String a : arr) {
        	System.out.println(isBalance(a));
        }
	}
    
    public static String isBalance(String str) {
    	String answer = "yes";
    	
    	Stack<String> stack = new Stack<>();
    	for(char c : str.toCharArray()) {
    		if(Character.isAlphabetic(c) || Character.isWhitespace(c)) {
    			continue;
    		}

    		if(stack.isEmpty()) {
    			if(c == ')' || c == ']') {
    				answer = "no";
    				break;
    			} else if(c == '(' || c == '[') {
    				stack.add(String.valueOf(c));
    			}
    		} else {
    			char peek = stack.peek().charAt(0);
    			if((peek == '(' && c == ']') || (peek == '[' && c == ')')) {
    				answer = "no";
    				break;
    			} else if((peek == '(' && c == ')') || (peek == '[' && c == ']')) {
    				stack.pop();
    			} else if(c == '(' || c == '[') {
    				stack.add(String.valueOf(c));
    			}
    		}
    	}
    	
    	if(!stack.isEmpty()) {
    		return "no";
    	}
    	return answer;
    }
}