import java.util.Scanner;

/**
 * Created by proshad on 1/19/17.
 */
public class Kangaroo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        boolean bmeet = false;
        for(int i=1;i<10000;i++){
            if((x1+i*v1)==(x2+i*v2)){
                bmeet = true;
                break;
            }
        }
        if(bmeet)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
