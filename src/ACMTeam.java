import java.util.Scanner;

/**
 * Created by proshad on 1/18/17.
 */
public class ACMTeam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int people = in.nextInt();
        int topics = in.nextInt();

        int[][] a = new int[people][topics];
        for(int i=0; i < people; i++){
            String visitTopics = in.next();
            int[] currentTopics = new int[topics];
            for(int j=0; j<visitTopics.length();j++){
                currentTopics[j]=Integer.parseInt(visitTopics.charAt(j)+"");
            }
            a[i] = currentTopics;
        }

        int totalTeam =0;
        int totalSolve = 0;
    }
}
