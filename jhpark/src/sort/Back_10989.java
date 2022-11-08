package sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int[] intputArray = new int[a];
        int index = 0 ;
        int[] countArray = new int[10001];


        for(int i=0;i<intputArray.length;i++){
            int in = Integer.parseInt(br.readLine());

            countArray[in]++;
        }

        StringBuilder sb = new StringBuilder();


        for(int j=1; j<countArray.length;j++){
            int count = countArray[j];
            if(count !=0){
                for(int c=0;c<count;c++){
                    intputArray[index] = j;
                    index++;
                }
            }
        }
        //return intputArray;
        System.out.println(sb.toString());

    }
}
