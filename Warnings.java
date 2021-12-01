package javaimplementation_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
THIS CLASS HAS A LOT OF METHODS WHICH ARE ASSOCIATED WITH WARNINGS
AND SUCCESSES THAT WILL BE DISPLAYED TO THE USER IN A DIFFERENT COLOUR
IN ORDER TO MAKE IT STAND OUT FROM THE REST OF THE MENUS.

EACH METHOD NAME IS APPROPRIATE TO THE TYPE OF WARNING
 */
public class Warnings {

    final static String blackColour = "\u001B[30m";
    final static String redColour = "\u001B[31m";
    final static String greenColour = "\u001B[32m";
    static Scanner sc = new Scanner(System.in);

    //VALIDATION
    public static void idAlreadyExist() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- ID ALREADY EXISTS --");
        System.out.println("" + blackColour);

    }
    public static void idIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- ID CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);

    }

    public static void descriptionIsBlank() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- DESCRIPTION CANNOT BE BLANK --");
        System.out.println("" + blackColour);

    }

    public static void dateOfAcquisitionFuture() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- DATE OF ACQUISITION CANNOT BE IN THE FUTURE --");
        System.out.println("" + blackColour);
    }

    public static void dateOfAcquisitionFormat() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- DATE FORMAT IS INCORRECT --");
        System.out.println("" + blackColour);
    }

    public static void dateOfExpiryPast() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- DATE OF EXPIRY CANNOT BE BEFORE DATE OF ACQUISITION --");
        System.out.println("" + blackColour);
    }

    public static void costPriceIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- COST PRICE CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void sellingPriceIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- SELLING PRICE CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void stockIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- STOCK ITEMS CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void weightIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- WEIGHT CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void heightIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- HEIGHT CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void lengthIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- LENGTH CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void widthIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- WIDTH CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void capacityIsZero() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- CAPACITY CANNOT BE LESS THAN 0 --");
        System.out.println("" + blackColour);
    }

    public static void unitsIsBlank() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- UNITY CANNOT BE LEFT BLANK --");
        System.out.println("" + blackColour);
    }

    public static void miscScannerErrors() {

        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- ILLEGAL INPUT DETECTED - PLEASE TRY AGAIN --");
        System.out.println("" + blackColour);
    }

    public static void itemAddedSuccess() {
        System.out.println(greenColour + "--SUCCESS--");
        System.out.println(greenColour + "-- ITEM HAS BEEN ADDED SUCESSFULLY --");
        System.out.println("" + blackColour);

    }

    //SAVE AND LOAD ERRORS / SUCCESS
    public static void SavedSuccess() {
        System.out.println(greenColour + "--SUCCESS--");
        System.out.println(greenColour + "-- ALL ITEMS HAVE BEEN SAVED SUCESSFULLY--");
        System.out.println("" + blackColour);
    }

    public static void LoadSuccess() {
        System.out.println(greenColour + "--SUCCESS--");
        System.out.println(greenColour + "-- ALL ITEMS HAVE BEEN LOADED SUCESSFULLY--");
        System.out.println("" + blackColour);
    }

    public static void SavedFail() {
        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "-- ITEMS WERE NOT SAVED - MAKE SURE ROOT LOCATION SET IS CORRECT --");
        System.out.println("" + blackColour);
    }

    public static void LoadFail() {
        System.out.println(redColour + "--WARNING --");
        System.out.println(redColour + "-- ITEMS WERE NOT LOADED - MAKE SURE YOU HAVE inventory.data IN ROOT FOLDER--");
        System.out.println("" + blackColour);
    }

    //EXIT ERRORS
    public static boolean userDidNotSave() {
        //IN CASE THERE IS A PROBLEM FROM THE USER, AUTOMATICALLY CHOOSE NO
        int choice = 2;
        System.out.println(redColour + "DATA HAS NOT BEEN SAVED - ARE YOU SURE YOU WANT TO QUIT?" + blackColour);
        System.out.println("1. YES, 2.NO");
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            Warnings.incorrectScannerInput();
            //CLEAR SCANNER BUFFER!
            sc.nextLine();
        }
        if (choice == 1) {
            return false;
        } else if (choice == 2) {
            return true;
        } else {
            Warnings.incorrectNumberedOption();
            return true;
        }

    }

    //MISC ERRORS AND SUCCESSES
    public static void noItemWithIdFound() {
        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "NO ITEMS WITH THAT ID WAS FOUND");
        System.out.println("" + blackColour);
    }

    public static void incorrectNumberedOption() {
        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "INCORRECT NUMBERED OPTION");
        System.out.println("" + blackColour);
    }

    public static void incorrectScannerInput() {
        System.out.println(redColour + "--WARNING--");
        System.out.println(redColour + "YOUR INPUT MUST BE AN INTEGER");
        System.out.println("" + blackColour);
    }

    public static void userAdvicedWhatIsRequired() {
        System.out.println(greenColour + "--ATTENTION--");
        System.out.println(greenColour + "ALL ITEMS MARKED WITH A * ARE REQUIRED AND CANNOT BE LEFT BLANK");
        System.out.println("" + blackColour);
    }

    public static void itemModified() {
        System.out.println(greenColour + "--SUCCESS--");
        System.out.println(greenColour + "ITEM HAS BEEN MODIFIED SUCESSFULLY");
        System.out.println("" + blackColour);
    }
    public static void itemChangeNoted() {
        System.out.println(greenColour + "--SUCCESS--");
        System.out.println(greenColour + "ITEM'S CHANGE HAS BEEN NOTED.  CHANGE WILL NOT TAKE PLACE UNTIL ALL OPTIONS HAVE BEEN CLEARED");
        System.out.println("" + blackColour);
    }
}
