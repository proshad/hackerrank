import java.util.Scanner;

/**
 * Created by proshad on 1/18/17.
 */
public class RepeatedString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int length = s.length();
        long total = 0;
        long repeat = n / length;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == 'a')
                total++;
        }
        total = repeat * total;
        long due = n - (repeat * length);
        for (int i = 0; i < due; i++) {
            char c = s.charAt(i);
            if (c == 'a')
                total++;
        }
        System.out.println(total);
    }
}
