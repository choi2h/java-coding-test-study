import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        List<ClassTime> classList = new ArrayList<>();
        for(int i=0; i<length; i++) {
        	String[] tmp = br.readLine().split(" ");
        	ClassTime cTime = new ClassTime(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        	classList.add(cTime);
        }
        
        /*
         * 반례 
           3
		   1 3
		   8 8
		   4 8
		   = 3
		   정렬 방식을 endTime 우선 정렬 후 같은 값인 경우 startTime 기준으로 재정렬함
         */

        classList.sort(Comparator.comparing(ClassTime::getEndTime).thenComparing(ClassTime::getStartTime));
        
        int tmp = 0; // 최소 끝나는 시간
        int cnt = 0;
        for(ClassTime list : classList) {
        	if(tmp <= list.getStartTime()) {
        		//System.out.println("tmp=" + tmp + " / startTime=" + list.getStartTime() + " / endTime=" + list.getEndTime());
        		tmp = list.getEndTime();
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
    }
} 

class ClassTime {
	private int startTime;
	private int endTime;
	
	public ClassTime(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
	
	public int getStartTime() {
		return this.startTime;
	}
	
	public int getEndTime() {
		return this.endTime;
	}
	
	@Override
    public String toString() {
        return String.valueOf(this.startTime) + " " + String.valueOf(this.endTime);
    }
}