import java.util.Scanner;

/**
 * Created by proshad on 1/18/17.
 */
public class MarsExploration {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String receivedMsg = in.next();
        int length = receivedMsg.length();
        String originalMsg = "SOS";
        int originalLength = originalMsg.length();
        int faultChar = 0;
        for(int i=0;i<length;i++){
            char a_char = receivedMsg.charAt(i);
            char b_char = originalMsg.charAt(i%originalLength);
            if (a_char!=b_char)
                faultChar ++;

        }
        System.out.println(faultChar);
    }
}
