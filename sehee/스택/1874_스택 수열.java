import java.io.*;
import java.util.*;

// 메모리 28504 KB / 시간 352 ms / 코드길이 1591 B
// issue 1 : while을 돌고 남은 stack 처리
// issue 2 : No인 case 처리 방법
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
       
        int[] arr = new int[length];
        for(int i=0; i<length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int num = 1;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        while(num <= length) {
        	//System.out.println("num=" + num);
        	if(stack.isEmpty()) {
        		stack.push(num);
        		num++;
        		sb.append("+").append("\n");
        		continue;
        	}
        	
        	int a = arr[i];
        	int peek = stack.peek();
        	//System.out.println("i=" + i + " / a=" + a + " / peek=" + peek);
        	if(a == peek) {
        		stack.pop();
        		i++;
        		sb.append("-").append("\n");
        	} else {
        		stack.push(num);
        		num++;
        		sb.append("+").append("\n");
        	}
        	//System.out.println("stack=" + stack);
        }

        while(!stack.isEmpty()) {
        	int a = arr[i];
        	int peek = stack.peek();
        	if(a == peek) { 
        		stack.pop();
        		i++;
        		sb.append("-").append("\n");
        	} else {
        		sb = new StringBuilder("NO");
        		break;
        	}
        }
        System.out.print(sb);
	}
}