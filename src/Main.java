import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by proshad on 1/17/17.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        HashSet<Integer> hashSet = new HashSet();
        int max_occarence =0;
        for(int a_i=0; a_i < n; a_i++){
            int number = in.nextInt();
            a[a_i] = number;
            hashSet.add(number);
        }
        for(int number: hashSet) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(a[j]==number)
                    sum++;
            }
            if(max_occarence<sum)
                max_occarence = sum;
        }
        System.out.println((n-max_occarence));
    }

}
