import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
병합정렬

메모리:124992KB   시간:692ms
 */
public class Backjoon_24060 {
    // 저장되는 횟수를 카운트하는 변수 선언
    int insertCount=0;
    // 찾고자하는 n번째로 저장되는 수를 저장하는 변수 선언
    int count;
    // 반환할 결과 값 저장 변수 선언
    // 찾고자하는 순서까지 안왔을 경우 -1을 반환해야하므로 기본값 -1로 선언
    int result = -1;

    public int solution(int total, int count, int[] arr) {
        // 찾고자하는 순서 저장
        this.count = count;
        // 병합정렬 시작 받아온 배열의 처음부터 끝까지 정렬 시작
        mergeSort(arr, 0, arr.length-1);

        return result;
    }

    //병합정렬 함수
    private void mergeSort(int[] arr, int start, int end) {
        // 시작값이 끝값과 같거나 크다면 더이상 나눠서 확인할 수 없으므로 리턴
        if(start >= end) {
            return;
        }

        // 현재 정렬하고자 하는 범위의 중앙값 저장
        int mid = (start+end) /2;

        // 중앙값을 기준으로 분할하여 정렬 실행
        // 중앙값을 기준으로 왼쪽(작은쪽) 정렬 (중앙값 포함)
        mergeSort(arr, start, mid);
        // 중앙값을 기준으로 오른쪽(큰쪽) 정렬 (중앙값 미포함)
        mergeSort(arr, mid+1, end);

        // 위에서 실행한 분할한 정렬을 다시 결합하여 정렬
        merge(arr, start, mid, end);
    }

    // 결합 메소드
    private void merge(int[] arr, int start, int mid, int end) {
        // 결합한 값을 저장할 임시 배열 생성 - 결합을 진행할 범위의 크기+1
        int[] tmp = new int[end-start+1];

        // 하나씩 증가할 왼쪽 포인트 선언 (중앙값의 왼쪽을 순회 - 중앙값 포함)
        int i = start;
        // 하나씩 증가할 오른쪽 포인트 선언 (중앙값의 오른쪽을 순회)
        int j = mid+1;
        // 위에서 생성한 임시 배열의 인덱스 위치를 지정할 값 선언
        int t = 0;

        // i가 mid보다 같거나 작아야 하며
        // j가 end보다 같거나 작아야 한다.
        // 즉, 중앙값 기준으로 분배하였던 리스트 2개 중 하나의 순회가 끝날때까지 반복
        while(i <= mid && j <= end) {
            // 하나씩 비교하며 보다 작은 값을 먼저 임시 배열에 추가
            if(arr[i] <= arr[j]) {
                // 기존 배열의 i번째 값이 j번째 값보다 작으므로
                // i값을 임시 배열에 추가하며
                // 인덱스를 표시하는 i값과 t값 증가
                // tmp[t] = arr[i];
                // t = t+1;
                // i = i+1;
                // 위와 같음
                tmp[t++] = arr[i++];
            } else {
                // 기존 배열의 j번째 값이 i번째 값보다 작으므로
                // j값을 임시 배열에 추가하며
                // 인덱스를 표시하는 j값과 t값 증가
                tmp[t++] = arr[j++];
            }
        }

        // 만약 중앙값을 기준하여 왼쪽 배열을 다 돌지 못했다면 (중앙값 포함)
        while(i <= mid) {
            // 남은 값들을 임시배열에 그대로 추가한다.
            tmp[t++] = arr[i++];
        }

         // 만약 중앙값을 기준하여 오른쪽 배열을 다 돌지 못했다면 (중앙값 미포함)
        while(j <= end) {
            // 남은 값들을 임시배열에 그대로 추가한다.
            tmp[t++] = arr[j++];
        }

        // 결합하여 정렬한 임시 배열을 
        // 결합하고자 한 범위 그대로 기존 배열에 추가
        int index = start;
        for(int k=0; k<tmp.length; k++) {
            // 기존배열 추가
            arr[index++] = tmp[k];
            // 저장되는 횟수 카운트 증가
            insertCount++;

            // 저장된 횟수가 찾고자하는 순서와 같다면
            if(insertCount == count) {
                // 결과에 현재 추가한 값 저장
                result = tmp[k];
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] first = br.readLine().split(" ");
        int total = Integer.parseInt(first[0]);
        int count = Integer.parseInt(first[1]);

        int[] numArray = new int[total];

        String[] numbers = br.readLine().split(" ");
        for(int i=0; i<numArray.length; i++) {
            numArray[i] = Integer.parseInt(numbers[i]);
        }

        Backjoon_24060 main = new Backjoon_24060();
        int result = main.solution(total, count, numArray);
        System.out.println(result);
    }
}
