import java.util.*;
import java.io.*;

// 메모리 160032 KB / 시간 1244 ms / 코드길이 607 B
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int a : list) {
            sb.append(a).append('\n');
        }
        System.out.println(sb);
	}
}
// String, StringBuffer, StringBuilder의 차이 : https://ifuwanna.tistory.com/221