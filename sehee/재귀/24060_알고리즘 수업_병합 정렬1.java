import java.io.*;

class Main {
	private static int[] sorted; // 합치는 과정에서 값을 담을 배열
	private static int count = 0;
	private static boolean isFound = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp1 = br.readLine().split(" ");
        int length = Integer.parseInt(tmp1[0]);
        int k = Integer.parseInt(tmp1[1]);

        int[] arr = new int[length];
        String[] tmp2 = br.readLine().split(" ");
        for(int i=0; i<length; i++) {
        	int tmpStr = Integer.parseInt(tmp2[i]);
            arr[i] = tmpStr;
        }

        merge(arr, k);
        if(!isFound) {
        	System.out.println(-1); 
        }
	}
    
    public static void merge(int[] arr, int k) {
    	sorted = new int[arr.length];
    	merge_sort(arr, 0, arr.length - 1, k);
    	sorted = null;
    }
    
    // Top-Down 방식 구현
    public static void merge_sort(int[] arr, int left, int right, int k) {
    	// left == right : 부분리스트가 1개의 원소만 갖고 있을 경우 쪼갤수 없으므로 return
    	if(left == right) {
    		return;
    	}
    	
    	int mid = (left + right) / 2; // 배열의 중간 위치값
    	//System.out.println("mid=" + mid + " / left=" + left + " / right=" + right + " / k=" + k);
    	merge_sort(arr, left, mid, k); // 절반 중 왼쪽 부분 리스트 (left ~ mid)
    	merge_sort(arr, mid+1, right, k); // 절반 중 오른쪽 부분리스트 (mid+1 ~ right)
    	
    	int answer = merge(arr, left, mid, right, k); // 병합 작업
    	if(answer != -1) {
    		System.out.println(answer);
    		return;
    	}
    	//System.out.println("count=" + count + " / answer=" + answer + " / arr.length=" + arr.length + " / sorted.length=" + sorted.length);
    }
    
    // arr의 left ~ right의 배열을 합친다.
    private static int merge(int[] arr, int left, int mid, int right, int k) {
    	int l = left; // 왼쪽 부분리스트 시작점
    	int r = mid + 1; // 오른쪽 부분리스트 시작점
    	int idx = left; // 채워 넣을 배열의 인덱스
    	
    	while(l <= mid && r <= right) { // 왼쪽의 위치가 mid까지 오기전, 오른쪽의 위치가 배열의 맨 끝까지 가기 전
    		if(arr[l] <= arr[r]) { // 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
    			sorted[idx] = arr[l]; // 왼쪽값을 정답배열에 넣고
    			l++; // l, idx 증가시킨다.
    		} else { // 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작을 경우 (arr[l] > arr[r])
    			sorted[idx] = arr[r]; // 오른쪽값을 정답배열에 넣고
    			r++; // r, idx 증가시킨다.
    		}
    		idx++;
    		count++;
    		if(count == k) {
    			isFound = true;
    			return sorted[idx-1];
    		}
    	}
    	
    	if(l > mid) { // 뢴쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우
    		while(r <= right) { // r이 오른쪽 끝에 닿을 때까지
    			sorted[idx] = arr[r]; // 오른쪽 배열에 있는 값을 정답 배열에 다 넣기
    			idx++;
    			r++;
    			count++;
    			if(count == k) {
    				isFound = true;
        			return sorted[idx-1];
        		}
    		}
    	} else { // 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
    		while(l <= mid) { // l이 중간에 닿을때까지
    			sorted[idx] = arr[l]; // 왼쪽 배열에 있는 값을 정답 배열에 다 넣기
    			idx++;
    			l++;
    			count++;
    			if(count == k) {
    				isFound = true;
        			return sorted[idx-1];
        		}
    		}
    	}
    	
    	// 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
    	for(int i=left; i <= right; i++) {
    		arr[i] = sorted[i];
    	}
		return -1;
    }
}