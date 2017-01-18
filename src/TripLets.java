import java.util.Scanner;

/**
 * Created by proshad on 1/17/17.
 */
public class TripLets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int alicePoints =0, bobPoints = 0;
        if(a0>b0)
            alicePoints ++;
        if(a1>b1)
            alicePoints ++;
        if(a2>b2)
            alicePoints ++;

        if(a0<b0)
            bobPoints ++;
        if(a1<b1)
            bobPoints ++;
        if(a2<b2)
            bobPoints ++;
        System.out.println(alicePoints + " "+bobPoints);
    }


}
