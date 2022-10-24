import java.io.*;
import java.util.*;

// 메모리 253624 KB / 시간 1248 ms / 코드길이 882 B
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardCnt = Integer.parseInt(br.readLine());
        String[] cardArr = br.readLine().split(" ");

        Map<Integer, Integer> cardMap = new HashMap<>();
        for(int i=0; i<cardCnt; i++) {
        	int key = Integer.parseInt(cardArr[i]);
        	cardMap.put(key, cardMap.getOrDefault(key, 0) + 1);
        }
        
        int cnt = Integer.parseInt(br.readLine());
        String[] cntArr = br.readLine().split(" ");
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<cnt; i++) {
        	int key = Integer.parseInt(cntArr[i]);
        	sb.append(cardMap.getOrDefault(key, 0)).append(' ');
        }
        
        System.out.println(sb);
	}
}