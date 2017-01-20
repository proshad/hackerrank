import java.util.Scanner;

/**
 * Created by proshad on 1/20/17.
 */
public class ReducedString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String regex = "(.)(\\1)"; // matches one character followed by the same one(s)

        do{
            int previousLength = input.length();
            input = input.replaceAll(regex, "");
            int currentLength = input.length();
            if(currentLength==previousLength)
                break;
        }while (true);

        if (input.trim().length()<1)
            System.out.println("Empty String");
        else
            System.out.println(input);
    }
}
