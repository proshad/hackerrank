import java.util.Scanner;

/**
 * Created by proshad on 1/19/17.
 */
public class ViralAdvertising {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        int totalLiked = 0;
        int intialReceived = 5;
        for (int i = 1; i <= day; i++) {
            int dayLike = intialReceived/2;
            totalLiked+= dayLike;
            intialReceived = dayLike*3;
        }
        System.out.println(totalLiked);
    }
}
