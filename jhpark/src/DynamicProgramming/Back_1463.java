package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_1463 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int in = Integer.parseInt(br.readLine());
        int count = 0;

        while (true){

            //제곱으로 가서 처리하는게 빠를 땐 어떻게 짜야하는가....??

            if(in % 3 == 0){
                in = in / 3;
                count++;
            }else if(in % 2 == 0){
                in = in / 2;
                count ++;
            }else{
                in = in - 1;
                count++;
            }



            if(in == 1){
                break;
            }
        }
        System.out.println(count);

    }
}
