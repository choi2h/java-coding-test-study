import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Backjoon_10816{

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 개수

            // 키 : 밸류 = 숫자 : 개수
            Map<Integer, Integer> map = new HashMap<>();

            // n개의 수만큼 카드 입력
            for (int i = 0; i < n; i++) {
                int inputNum = Integer.parseInt(String.valueOf(br.read()));

                if (map.containsKey(inputNum)) {
                    map.put(inputNum, map.get(inputNum) + 1);
                } else {
                    map.put(inputNum, 1);
                }
            }

            StringBuffer sb = new StringBuffer();
            int m = Integer.parseInt(br.readLine()) ; // 찾을 숫자 개수
            for (int i = 0; i < m; i++) {
                int inputNum2 = Integer.parseInt(String.valueOf(br.read()));

                if (map.containsKey(inputNum2)) {
                    sb.append(inputNum2).append(" ");
                } else {
                    sb.append("0");
                }

                System.out.println(sb.toString());
            }
        }
}
