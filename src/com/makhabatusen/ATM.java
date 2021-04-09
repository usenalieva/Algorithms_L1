package com.makhabatusen;

import java.util.Scanner;

/*   PSEUDOCODE:
 banknotes <- [1, 3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000]
 quantities <- [10, 5, 5, 3, 2, 1, 2, 3, 3, 2, 0, 2]
 withdrawNotesCount <- [LEN(quantities)]
 totalAvailable
 withdrawAmount
 availableForWithdraw
 canOnlyWithdraw <- 'You can only withdraw: '

 Function withdraw()
    call: totalAvailable()
    call: userInput()
    call: withdraw(withdrawAmount)
 EndFunction


 Function totalAvailable()
    FOR i <- 0 TO LEN(banknotes)
    totalAvailable <- totalAvailable + banknotes[i] * quantities[i]
    ENDFOR
 EndFunction

 Function userInput()
    PRINT 'Please enter the amount to withdraw: '
    withdrawAmount <-  USERINPUT
 EndFunction


 Function withdraw(withdrawAmount)
    IF (withdrawAmount ≤ totalAvailable ) THEN
        FOR i <- LEN(banknotes) TO 0
            IF (quantities[i] > 0) AND (banknotes[i] ≤ withdrawAmount) THEN
                withdrawNotesCount[i] <- MIN(withdrawAmount / banknotes[i], quantities[i])
                availableForWithdraw <- availableForWithdraw + banknotes[i] * withdrawNotesCount[i]
                totalAvailable <- totalAvailable - withdrawNotesCount[i] * banknotes[i]
                withdrawAmount <- withdrawAmount - withdrawNotesCount[i] * banknotes[i]
                quantities[i] <-  quantities[i] - withdrawNotesCount[i]
                ENDIF
        ENDFOR
    call: dispenseCash()
    ELSE PRINT canOnlyWithdraw + totalAvailable
    ENDIF
 EndFunction

 Function dispenseCash()
    IF (availableForWithdraw MOD withdrawAmount) = 0 THEN
        PRINT 'You received: '
        FOR i <- LEN(banknotes) TO 0
            IF (withdrawNotesCount[i] > 0) THEN
            PRINT banknotes[i] + ' x ' + withdrawNotesCount[i]
            ENDIF
        ENDFOR
        PRINT 'Total = ' + withdrawAmount
    ELSE PRINT canOnlyWithdraw + availableForWithdraw
    ENDIF
 EndFunction

 */

public class ATM {

    private static final int[] banknotes = {1, 3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
    private static final int[] quantities = {10, 5, 5, 3, 2, 1, 2, 3, 3, 2, 0, 2};
    private static final int[] withdrawNotesCount = new int[quantities.length];
    private static int totalAvailable;
    private static int withdrawAmount;
    private static int availableForWithdraw;
    private static final String canOnlyWithdraw = "You can only withdraw: ";

    public void withdraw() {
        totalAvailable();
        userInput();
        withdraw(withdrawAmount);
    }

    private static void totalAvailable() {
        for (int i = 0; i < quantities.length; i++) {
            totalAvailable += quantities[i] * banknotes[i];
        }
    }

    private static void userInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the amount to withdraw: ");
        withdrawAmount = scan.nextInt();
    }

    private static void withdraw(int withdrawAmount) {
        if (withdrawAmount <= totalAvailable) {
            for (int i = banknotes.length - 1; i >= 0; i--) {
                if (quantities[i] > 0 && banknotes[i] <= withdrawAmount) {
                    withdrawNotesCount[i] = Math.min( withdrawAmount / banknotes[i], quantities[i]);
                    availableForWithdraw += banknotes[i] * withdrawNotesCount[i];
                    totalAvailable -= withdrawNotesCount[i] * banknotes[i];
                    withdrawAmount -= withdrawNotesCount[i] * banknotes[i];
                    quantities[i] -= withdrawNotesCount[i];
                }
            }
            dispenseCash();
        } else {
            System.out.println(canOnlyWithdraw + totalAvailable);
        }
    }


    private static void dispenseCash() {
        if (availableForWithdraw % withdrawAmount == 0) {
            System.out.print("You received: ");
            for (int i = quantities.length - 1; i >= 0; i--) {
                if (withdrawNotesCount[i] > 0)
                    System.out.format(" %d x %d ", banknotes[i], withdrawNotesCount[i]);
            }
            System.out.format("\nTotal = %d\n", withdrawAmount);
        } else
            System.out.println(canOnlyWithdraw + availableForWithdraw);
    }

}
