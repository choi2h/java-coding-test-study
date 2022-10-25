import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    이분탐색[O(logN)]

    메모리:142588KB   시간:1636ms
 */
public class Backjoon_10816 {

    int[] haveCardArr;

    private int[] solution(int[] haveCard, int[] findCard) {
        haveCardArr = haveCard;
        // 카드개수를 저장하는 배열 선언
        int[] result = new int[findCard.length];
        // 가지고 있는 카드 오름차순 정렬
        Arrays.sort(haveCard);

        for(int i=0; i<findCard.length; i++) {
            // 찾고자 하는 카드 개수 탐색
            int count=find(0, haveCard.length-1, findCard[i]);
            // 반환받은 카드 개수 결과배열에 저장
            result[i] = count;
        }

        // 카드 개수를 저장한 배열 반환
        return result;
    }

    // 카드 개수 탐색
    private int find(int start, int end, int find) {
        // 범위 안의 중앙값
        int mid = (start + end) / 2;
        //카드 개수 초기화
        int count = 0;

        // 중앙값이 범위의 시작 혹은 끝 값과 같다면
        // 연속된 범위로 더이상 줄일 수 있는 범위가 없음
        // start 혹은 end 인덱스의 값 중 같은 찾는 카드값이 있는지 확인
        if(mid == start || mid == end) {
            // 같은 값이 있다면 해당 값의 좌우로 같은 값의 개수 찾기
            if(haveCardArr[start] == find) {
                count = findSameValue(start, find);
            } else if(haveCardArr[end] == find) {
                count = findSameValue(end, find);
            }

            return count;
        }

        // 중앙인덱스의 값 저장
        int midNum = haveCardArr[mid];
        // 중앙값이 찾고자 하는 카드 값과 같다면 좌우로 같은 값의 개수 찾기
        if(midNum == find) {
            count = findSameValue(mid, find);
        }
        // 중앙값이 찾고자하는 값보다 크다면 중앙인덱스를 기준으로 작은쪽(왼쪽) 범위로 재탐색
        else if(midNum > find){
            count = find(start, mid, find);
        }
        // 중앙값이 찾고자하는 값보다 작다면 중앙인덱스를 기준으로 큰쪽(오른쪽) 범위로 재탐색
        else {
            count = find(mid, end, find);
        }

        // 해당하는 카드의 개수 반환
        return count;
    }

    // 같은 값의 개수 구하기
    private int findSameValue(int index, int find) {
        // 현재 인덱스를 기준으로 작은쪽(왼쪽)에서 같은 값이 시작하는 부분 탐색
        int lower = lowerBound(0, index, find);

        // 현재 인덱스를 기준으로 큰쪽(오른쪽)에서 같은 값보다 하나 다음값이 있는 부분을 탐색
        int upper = upperBound(index+1, haveCardArr.length, find);

        // 찾고자하는 카드의 값보다 큰 값이 시작하는 인덱스 - 찾고자하는 카드의 값이 시작하는 인덱스 = 같은 값을 가진 카드의 개수
        return upper-lower;
    }

    // 작은쪽 범위에서 찾고자하는 값이 시작하는 인덱스 탐색
    public int lowerBound(int left, int right, int find){
        int mid;
        // 범위 = 왼쪽 ~ 오른쪽 -> 왼쪽인덱스가 오른쪽인덱스보다 작아야 한다.
        while(left<right){
            // 범위의 중앙인덱스 할당
            mid = (left+right)/2;

            // 중앙인덱스의 값이 찾고자 하는 카드값보다 작다면
            if(haveCardArr[mid]< find) {
                // 왼쪽인덱스를 중앙인덱스보다 1 크게 하여 범위 축소
                left = mid+1;
            } else {
                // 오른쪽인덱스를 중앙인덱스로 설정하여 범위 축소
                right = mid;
            }
        }

        // 왼쪽인덱스가 같거나 커지면 오른쪽 인덱스 반환
        return right;
    }

    // 큰쪽 범위에서 찾고자하는 값보다 큰 값이 시작하는 인덱스 탐색
    public int upperBound(int left, int right, int find){
        int mid;
        // 범위 = 왼쪽 ~ 오른쪽 -> 왼쪽인덱스가 오른쪽인덱스보다 작아야 한다.
        while(left<right){
            // 범위의 중앙인덱스 할당
            mid = (left+right)/2;
            // 중앙인덱스의 값이 찾고자 하는 카드값보다 크다면
            if(haveCardArr[mid]<=find) {
                // 왼쪽인덱스를 중앙인덱스 값보다 1 크게하여 범위 축소
                left=mid+1;
            } else {
                // 오른쪽인덱스를 중앙 인덱스와 같게하여 범위 축소
                right=mid;
            }
        }

        // 왼쪽인덱스가 같거나 커지면 오른쪽 인덱스 반환
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int haveLength = Integer.parseInt(br.readLine());
        int[] haveCards = new int[haveLength];

        String[] have = br.readLine().split(" ");
        for(int i=0; i<haveCards.length; i++) {
            haveCards[i] = Integer.parseInt(have[i]);
        }

        int findLength = Integer.parseInt(br.readLine());
        int[] findCards = new int[findLength];

        String[] find = br.readLine().split(" ");
        for(int i=0; i<findCards.length; i++) {
            findCards[i] = Integer.parseInt(find[i]);
        }

        Backjoon_10816 main = new Backjoon_10816();
        int[] result = main.solution(haveCards, findCards);

        StringBuilder sb = new StringBuilder();
        for(int value : result) {
            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }
}
