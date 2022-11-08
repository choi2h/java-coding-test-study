package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Back_1912 {

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int in = Integer.parseInt(br.readLine());
        int[] numArray =  new int[in];

        String[] inArray = br.readLine().split(" ");

        int start=0;

        for(int i=0;i<numArray.length;i++){
            numArray[i] = Integer.parseInt(inArray[i]);
        }

        int result=numArray[0];
        //10 -4 3 1 5 6 -35 12 21 -1
        //10 -4 3 1 5 6 -35 12 21 -1
        while(start<numArray.length){
            for(int i=start ;i<numArray.length;i++){

                int tempSum = 0;

                //합을 구하는 부분
                for(int j=start ; j<=i;j++){
                    if(j==start){
                        tempSum = numArray[j];
                    }else{
                        tempSum += numArray[j];
                        if(tempSum<0){
                            continue;
                        }
                    }
                }

                if(tempSum > result){
                    result=tempSum;
                }
            }
            start++;
        }

        System.out.println(result);
    }
}
