import java.util.Scanner;

/**
 * Created by proshad on 1/17/17.
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int length = s.length();
        int word_count = 1;
        for(int i=0; i<length; i++){
            char a_char = s.charAt(i);
            boolean isUpperCase = Character.isUpperCase(a_char);
            if (isUpperCase)
                word_count ++;

        }
        System.out.println(word_count);
    }
}
