import java.util.Scanner;

/**
 * Created by proshad on 1/18/17.
 */
public class JumpingClouds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        int steps = 0;
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int i = 0;
        do {
            if ((i+2)<n && c[i + 2] == 0) {
                steps++;
                i = i + 2;
            } else if (c[i + 1] == 0) {
                steps++;
                i = i + 1;
            }else {
                i++;
            }

        } while (i < n-1);
        System.out.println(steps);
    }
}
