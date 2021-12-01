package javaimplementation_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
THIS CLASS IS USED TO DISPLAY THE MAIN MENU TO THE USER.  THE RETURNED VALUE
IS USED IN THE MAIN METHOD TO BRANCH TO THE APPRORIATE CLASSES AND METHODS
ACCORDINGLY.  THIS METHOD ALSO HAS A TRY-CATCH METHOD IN CLASS USER INPUTS
INAPPROPRIATE VALUES.
 */
public class MainMenu {

    public static int Menu() {

        //DATA TYPES AND VARIABLES
        int MenuSelection;
        boolean isLoopMenu = true;
        Scanner sc = new Scanner(System.in);

        //LOOP UNTIL ISLOOPMENU VARIBALE IS FALSE
        do {

            System.out.println("---*** MAIN MENU ***---");
            System.out.println("SELECT A NUMBER TO CONTINUE");
            System.out.println("1. ADD NEW ITEMS IN INVENTORY");
            System.out.println("2. MODIFY ITEMS IN INVENTORY");
            System.out.println("3. VIEW ALL STOCK IN THE INVENTORY (HARDWARE)");
            System.out.println("4. VIEW ALL STOCK IN THE INVENTORY (CONSUMABLES)");
            System.out.println("5. FINANCIAL SUMMARY");
            System.out.println("6. SAVE ALL CHANGES");
            System.out.println("7. LOAD ALL CHANGES");
            System.out.println("8. EXIT DATABASE PROGRAM");
            try {
                MenuSelection = sc.nextInt();

                //FROM 1 TO 9, RETURN THE NUMBERED OPTION AND BREAK THE DO-WHILE LOOP
                switch (MenuSelection) {
                    case 1: {
                        isLoopMenu = false;
                        return 1;
                    }
                    case 2: {
                        isLoopMenu = false;
                        return 2;
                    }
                    case 3: {
                        isLoopMenu = false;
                        return 3;
                    }
                    case 4: {
                        isLoopMenu = false;
                        return 4;
                    }
                    case 5: {
                        isLoopMenu = false;
                        return 5;
                    }
                    case 6: {
                        isLoopMenu = false;
                        return 6;
                    }
                    case 7: {
                        isLoopMenu = false;
                        return 7;
                    }
                    case 8: {
                        isLoopMenu = false;
                        return 8;
                    }
                    default: {
                        Warnings.incorrectNumberedOption();
                        isLoopMenu = true;
                    }
                }
            } catch (InputMismatchException e) {
                Warnings.incorrectScannerInput();
                isLoopMenu = false;

            }
        } while (isLoopMenu == true);

        //THIS RETURN STATEMENT IS DONE IN CASE SOMETHING WRONG HAPPENS IN THE MENU
        //THE RETURNED 0 WILL DO NOTHING IN THE MAIN METHOD.
        return 0;
    }
}
