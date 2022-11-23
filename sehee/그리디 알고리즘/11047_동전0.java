import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int coins = Integer.parseInt(tmp[0]);
        int money = Integer.parseInt(tmp[1]);
        
        int[] value = new int[coins];
        for(int i=0; i<coins; i++) {
        	value[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int index = coins - 1;
        while(money > 0) {
        	if((money - value[index]) >= 0) {
        		money = (money- value[index]);
        		count++;
        	} else {
        		index--;
        	}
        }
        System.out.println(count);
    }
} 
