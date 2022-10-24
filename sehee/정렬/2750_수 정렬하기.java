import java.util.*;
import java.io.*;

// 처음: 메모리 18184 KB / 시간 236 ms / 코드길이 427 B
// 수정: 메모리 11868 KB / 시간 84 ms / 코드길이 830 B
class Main {
    public static void solution(int[] arr) {
    	Arrays.sort(arr);
    	
    	// for(int a : arr) {
    	// 	System.out.println(a);
    	// }
        // 시간 단축 방안 2 : StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a).append('\n');
        }
        System.out.println(sb);
    }
    
    public static void main(String[] args) throws IOException {
    	// Scanner in = new Scanner(System.in);
	    // int length = in.nextInt();
        // 시간 단축 방안 1 : BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

	    int[] arr = new int[length];

    	for(int i=0; i<length; i++) {
    		//arr[i] = in.nextInt();
            arr[i] = Integer.parseInt(br.readLine());
    	}

    	solution(arr);
	}
}
// https://st-lab.tistory.com/m/105
// https://yeon-kr.tistory.com/157