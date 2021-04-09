package com.makhabatusen;

import java.util.Scanner;

/* PSEUDOCODE:

input

Function scanWord
    call: userInput()
    call: scan()
EndFunction

Function userInput()
    PRINT 'Please type a word: '
    input <- USERINPUT
EndFunction


Function scan()
    IF (LEN('input') ≤ 2) THEN
        PRINT 'input'
    ELSEIF  (LEN('input') MOD 2) = 0 THEN
        PRINT SUBSTRING(0, LEN('input')-2, 'input')
        ELSE wordMiddle <- LEN('input') / 2
            PRINT SUBSTRING( wordMiddle-1, wordMiddle + 2,  'input')
    ENDIF
EndFunction

*/

public class Words {

    private static String input;

    public void scanWord() {
        userInput();
        scan();
    }

    private static void userInput() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please type a word: ");
        input = scan.nextLine();
    }

    private void scan() {
        if (input.length() <= 2)
            System.out.println(input);
        else if (input.length() % 2 == 0) {
            System.out.println(input.substring(0, input.length() - 2));
        } else {
            int wordMiddle = input.length() / 2;
            System.out.println(input.substring(wordMiddle - 1, wordMiddle + 2));
        }
    }
}
