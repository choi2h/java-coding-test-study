import java.io.*;

// 메모리 451020 KB / 시간 1844 ms / 코드길이 947 B
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        int[] arr = new int[length];
        for(int i=0; i<length; i++) {
        	arr[i] = Integer.parseInt(br.readLine());	
        }
        
        int[] counts = new int[10001];
        for(int i=0; i<length; i++) {
        	counts[arr[i]]++;	
        }
        
        for(int i=1; i<counts.length; i++) {
        	counts[i] += counts[i-1];
        }
        
        int[] results = new int[length];
        for(int i=length-1; i>=0; i--) {
        	int val = arr[i];
        	counts[val]--;
        	results[counts[val]] = val;
        }

        StringBuilder sb = new StringBuilder();
        for(int a : results) {
            sb.append(a).append('\n');
        }
        System.out.println(sb);
	}
}