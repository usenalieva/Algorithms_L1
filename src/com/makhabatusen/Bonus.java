package com.makhabatusen;

import java.util.Scanner;


/*   PSEUDOCODE:

annualWage
bonus <- 0

Function calcBonus
    call: userInput()
    call: calculateBonus(annualWage)
EndFunction


Function calcBonus()
    PRINT 'Please enter your annual wage: '
    annualWage <- USERINPUT
EndFunction

Function calculateBonus(annualWage)
   bonus <- bonus + (annualWage * 0.5 * 0.05) + (annualWage * 0.3 * 0.08) + (annualWage * 0.2 * 0.1)
   PRINT 'Your annual bonus is: ' + bonus
EndFunction

*/

public class Bonus {

    private static int annualWage;
    private static int bonus = 0;

    public void calcBonus() {
        userInput();
        calculateBonus(annualWage);
    }

    private static void userInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your annual wage: ");
        annualWage = scan.nextInt();
    }

    private void calculateBonus(int annualWage) {
        bonus += (annualWage * 0.5 * 0.05) + (annualWage * 0.3 * 0.08) + (annualWage * 0.2 * 0.1);
        System.out.printf("Your annual bonus is %d%n", bonus);
    }


}
