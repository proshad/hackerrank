import java.math.BigInteger;
import java.util.Scanner;
import java.math.*;


/**
 * Created with IntelliJ IDEA.
 * User: Proshad
 * Date: 1/21/17
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class BigFactorial {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
        }
        System.out.println(fact.toString());
    }
}
