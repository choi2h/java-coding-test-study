package sort;

import java.util.*;

public class Back_2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        List<Integer> numberList = new ArrayList<>();

        for(int i=0;i<a;i++){
            int num = sc.nextInt();
            numberList.add(num);
        }
        Collections.sort(numberList);
        StringBuffer sb = new StringBuffer();
        for(int temp : numberList){
            sb.append(temp + "\n");
        }
        System.out.println(sb.toString());

    }
}
