// Java program to check if a given credit
// card is valid or not.
import java.util.Scanner;
 
public class CreditCheck {
    // Main Method
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        long number = scn.nextLong();
       
        System.out.println(number + " is " +
        (isValid(number) ? "valid" : "invalid"));

        if(prefixMatched(number, 4))
        {
            System.out.println("Visa Card");
        }
        if(prefixMatched(number, 5))
        {
            System.out.println("Master Card");
        }
        if(prefixMatched(number, 37))
        {
            System.out.println("American Express Card");
        }
        if(prefixMatched(number, 6))
        {
            System.out.println("Discover Card");
        }
    }    
    public static boolean isValid(long number)
    {
       return (getSize(number) >= 13 &&  getSize(number) <= 16) &&  prefixMatched(number, 4) ||
                prefixMatched(number, 5) || prefixMatched(number, 37) ||  prefixMatched(number, 6)) &&
              ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
    }
    public static int sumOfDoubleEvenPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
         
        return sum;
    }
    public static int getDigit(int number)
    {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }
    public static int sumOfOddPlace(long number)
    {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum = sum + Integer.parseInt(num.charAt(i) + "");       
        return sum;
    }
    public static boolean prefixMatched(long number, int d)
    {
        return getPrefix(number, getSize(d)) == d;
    }
    public static int getSize(long d)
    {
        String num = d + "";
        return num.length();
    }
    public static long getPrefix(long number, int k)
    {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }
}
