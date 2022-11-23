import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
	static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        
        for(int i=0; i<count; i++) {
        	int curr = Integer.parseInt(br.readLine());
        	if(curr > 0) { 
        		pos.add(curr);
        	} else {
        		neg.add(curr);
        	}
        }
       
        Collections.sort(pos);
        Collections.sort(neg, Collections.reverseOrder());
        
        int sum = 0;
        sum += solution(pos);
        sum += solution(neg);
        
        System.out.println(sum);
    }
    
    public static int solution(List<Integer> arr) {
    	int sum = 0;
        int index = arr.size() - 1;

        while(index > 0) {
        	int posNow = arr.get(index);
        	int posPre = arr.get(index-1);
        	//System.out.println("0. sum=" + sum + " / index=" + index);
        	//System.out.println("1. arr[index-1]=" + posPre + " ( ) arr[index]="+posNow);
        	int math = Math.max((posNow * posPre), (posNow + posPre));
        	if(math > posNow) {
        		sum += math;
        		index -= 2;
        	} else {
        		sum += posNow;
        		index -= 1;
        	}
        	/* 시간 초과
        	if(posPre > 0 && posNow == 0) {
        		//System.out.println("2-1. +");
        		sum += (posNow+ posPre);
        		index -= 2;
        	} else if(posPre < 0 && posNow == 0) {
        		//System.out.println("2-2. *");
        		sum += (posNow * posPre);
        		index -= 2;
        	} else if(posPre == 0 && posNow > 0) {
        		//System.out.println("2-3. next");
        		sum += posNow; // 줄일수 있으나 패턴을 보기위해
        		index -= 1;
        	} else if(posPre == 0 && posNow < 0) {
        		//System.out.println("2-4. *");
        		sum += (posNow * posPre); // 줄일수 있으나 패턴을 보기위해
        		index -= 2;
        	} else if(posPre > 0 && posNow > 0) {
        		//System.out.println("2-5. * or +");
        		sum += Math.max((posNow * posPre), (posNow + posPre));
        		index -= 2;
        	} else if(posPre < 0 && posNow > 0) {
        		//System.out.println("2-6. * or +");
        		sum += Math.max((posNow * posPre), (posNow + posPre));
        		index -= 2;
        	} else if(posPre < 0 && posNow < 0) {
        		//System.out.println("2-6. * or +");
        		sum += Math.max((posNow * posPre), (posNow + posPre));
        		index -= 2;
        	}
        	*/
        	//System.out.println("3. sum=" + sum + " / index=" + index);
        }
        
        if(index == 0) {
        	sum += arr.get(index);
        	//System.out.println("4. sum=" + sum + " / index=" + index + " / arr[index]="+arr.get(index));
        }
    	return sum;
    }
} 


/* 둘 다 음수일때 반례 고침: 원래는 +만 했는데 * or + 변경
7
-2
-5
-3
0
1
2
3
*/

/* TODO : 음수는 낮은 순에서 부터 정렬해서 위의 작업해야됨. 음수 양수 따로 나누기
5
-3
-2
-1
1
2
답:8?
https://www.acmicpc.net/board/view/33174

0. sum=0 / index=4
1. arr[index-1]=1 ( ) arr[index]=2
2-5. * or +
3. sum=3 / index=2

0. sum=3 / index=2
1. arr[index-1]=-2 ( ) arr[index]=-1
2-6. * or +
3. sum=5 / index=0

4. sum=2 / index=0 / arr[index]=-3

2
*/