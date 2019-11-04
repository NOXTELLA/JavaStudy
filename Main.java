/*시스템 부팅
Code written by J-Hoplin
Date of creation : 2019/10/05
 */
package BankSystem;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ps.printSentence("Enter Bank Name : ");
        String bankName = sc.nextLine();
        ps.printSentenceNextLine("Welcome to Bank System.");
        SystemBank N = new SystemBank(bankName);
    }
}