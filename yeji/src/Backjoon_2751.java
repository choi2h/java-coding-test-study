import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Backjoon_2751 {

    public static void main(String[] args) throws IOException {

        // n 개수 입력받기 ( Scanner 를 사용하면 성능이 느림 )
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (1 > n || 1000000 < n) {
            return;
        }

        // 배열에 담기
        ArrayList<Integer> arrList = new ArrayList<>(n);

        // n 개수만큼 입력받기
        for (int i = 0; i < n; i++) {
            arrList.add(Integer.parseInt(br.readLine()));
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
