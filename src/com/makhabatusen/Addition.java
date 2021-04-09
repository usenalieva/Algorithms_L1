package com.makhabatusen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* PSEUDOCODE:

n

Function add
    call: userInput()
    call: addNumbers()
EndFunction

Function userInput
    PRINT 'Please type a number of elements: '
    n <- USERINPUT
EndFunction

Function addNumbers()
one <- '1'
result <- 0
numbers <- ArrayList

    IF (n < 20) THEN
        FOR i <- 1 TO n
            numbers.add(n)
        ENDFOR

        PRINT 'Result: '

        FOREACH num IN numbers
            result <- result + STRING_TO_LONG(num)
            IF  (numbers.INDEX_OF(num) = LEN(numbers)-1 )
                PRINT num
            ELSE PRINT num + ' + '
            ENDIF
        ENDFOREACH

        PRINT 'Sum: ' + result

    ELSE PRINT 'Please type a number less than 20'
        call: add()
    END IF
EndFunction

*/

public class Addition {
    private static int n;


    public void add() {
        userInput();
        addNumbers();
    }

    private static void userInput() {
        Scanner scan = new Scanner(System.in);
        System.out.format("Please type number of elements: ");
        n = scan.nextInt();
    }

    private void addNumbers() {
        String one = "1";
        long result = 0;
        List<String> numbers = new ArrayList<>();
        if (n < 20) {
            for (int i = 1; i <= n; i++) {
                numbers.add(one.repeat(i));
            }

            System.out.println("Result:");

            for (String num : numbers) {
                result += Long.parseLong(num);
                if (numbers.indexOf(num) == numbers.size() - 1)
                    System.out.print(num);
                else
                    System.out.printf("%s + ", num);
            }
            System.out.printf("\nSum: %d%n", result);
        } else {
            System.out.println("Please type a number less than 20");
            add();
        }
    }
}
