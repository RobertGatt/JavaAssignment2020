package javaimplementation_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
THIS CLASS TAKES CARE OF THE USERS CHOICE BETWEEN HARDWARE OR CONSUMABLE
PRODUCTS.  AFTER THE CHOICE FROM THE CLIENTS SIDE, THE VALUE IS RETURNED
BACK TO THE MAIN METHOD.
*/


public class HardwareOrConsumables {

    public static int hardwareOrConsumablesSelection() {
        
        //DATA TYPES AND VARIABLES
        Scanner sc = new Scanner(System.in);
        boolean isLooping = true;
        int typeOfInventory = 0;

        //LOOP UNTIL USER CHOOSES CORRECT NUMBER
        while (isLooping) {
            
            //ASK THE USER WHICH TYPE OF INVENTORY CHILD CLASSES
            System.out.println("SELECT WHICH TYPE OF INVENTORY: ");
            System.out.println("1.HARDWARE, 2.CONSUMABLES, 3.EXIT");
            
            //TRY AND CATCH ANY ERROR INPUTS FROM THE USER (DOUBLE OR STRING)
            //DISPLAY A WARNING AND LOOP AGAIN
            try {
                typeOfInventory = sc.nextInt();
            } catch (InputMismatchException e) {
                Warnings.incorrectScannerInput();
                sc.nextLine();
                isLooping = true;
            }
            //IF IT IS AN INTEGER BUT >3 OR <1, DISPLAY WARNING AND LOOP AGAIN
            if (typeOfInventory > 3 || typeOfInventory < 1) {
                Warnings.incorrectNumberedOption();
                isLooping = true;
            } else {
                isLooping = false;
            }

        }
        //RETURN 1 FOR HARDWARE, 2 FOR CONSUMABLES AND 3 FOR NOTHING
        return typeOfInventory;
    }

}
