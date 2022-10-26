import java.util.*;

public class Backjoon_2750 {

    /**
     * 문제
     * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
     *
     * 출력
     * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
     */
    public static void main(String[] args) {
        // n 개수 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (1 > n || 1000 < n) {
            return;
        }

        // 배열에 담기
        ArrayList<Integer> arrList = new ArrayList<>(n);

        // n 개수만큼 입력받기
        for (int i = 0; i < n; i++) {
            arrList.add(sc.nextInt());
        }

        // 중복 제거
        Set<Integer> set = new LinkedHashSet<>(arrList);
        ArrayList<Integer> sortlist = new ArrayList<>(set);

        // 정렬시키기
        Collections.sort(sortlist);

        // 출력
        for (Integer out : sortlist) {
            System.out.println(out);
        }
    }
}
