import java.io.*;
import java.util.*;

// 메모리 11896 KB / 시간 84 ms / 코드길이 655 B
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int length = Integer.parseInt(first[0]);
        int winners = Integer.parseInt(first[1]);
        
        String[] second = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<length; i++) {
            list.add(Integer.parseInt(second[i]));
        }
        
        Collections.sort(list);
        System.out.println(list.get(length-winners));
	}
}