package javaimplementation_2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class ItemsManagament {

    /*
    THIS CLASS IS USED TO CREATE OBJECTS OR HARDWARE AND CONSUMABLES USING THE 
    SUPER CLASS INVENTORY.  THIS IS DONE USING POLYMORPHISIM.  
    
    ONE OF THE METHODS IS USED TO CREATE A HARDWARE ITEM
    ONE OF THE METHODS IS USED TO CREATE A CONSUMABLE ITEMS
     */
    
    public static Vector addItemsHardware(Vector<Inventory> hardwareVector) throws InputMismatchException, DateTimeException {

        //DATATYPES AND VARIABLES FOR THIS METHOD
        Scanner sc = new Scanner(System.in);
        boolean isHardware = true;
        boolean isThereErrorsCommon;
        boolean isThereErrorsHardware;
        int addMore;
        LocalDate dateOfItem = null;

        //THIS WILL LOOP UNTIL THE CLIENT CHOOSE TO STOP ADDING ITEMS
        while (isHardware) {
            System.out.println("--ADDING OF NEW HARDWARE INVENTORY--");
            Warnings.userAdvicedWhatIsRequired();
            System.out.println("ENTER DESCRIPTION*: ");
            String desc = sc.nextLine();
            System.out.println("ENTER ID OR STOCK CODE*: ");
            int id = sc.nextInt();
            System.out.println("ENTER DAY OF ACQUISITION (1-31)*: ");
            int day = sc.nextInt();
            System.out.println("ENTER MONTH OF ACQUISITION (1-12)*: ");
            int month = sc.nextInt();
            System.out.println("ENTER YEAR OF ACQUISITION (XXXX)*: ");
            int year = sc.nextInt();
            System.out.println("ENTER COST: ");
            double price = sc.nextDouble();
            price = Math.round(price*100.0)/100.0;  //ROUND UP TO 2 DECIMAL PLACES
            System.out.println("ENTER RSP: ");
            double rsp = sc.nextDouble();
            rsp = Math.round(rsp*100.0)/100.0;      //ROUND UP TO 2 DECIMAL PLACES
            System.out.println("ENTER QUANTITY: ");
            double addStock = sc.nextDouble();
            System.out.println("ENTER WIDTH (M): ");
            double width = sc.nextDouble();
            System.out.println("ENTER LENGTH (M): ");
            double length = sc.nextDouble();
            System.out.println("ENTER HEIGHT (M): ");
            double height = sc.nextDouble();
            System.out.println("ENTER WEIGHT (KG)");
            double weight = sc.nextDouble();

            //USING LOCALDATE CLASS TO STORE THE CLIENTS INPUT
            dateOfItem = dateOfItem.of(year, month, day);
            //INSERT ALL THE ATTRIBUTES SET BY THE CLIENT IN THE OBJECT
            Inventory h = new Hardware(id, desc, dateOfItem, price, rsp, addStock, width, length, height, weight, 'h');

            //VALIDATE ALL INPUTED ITEMS
            isThereErrorsCommon = h.setterValidationCommon(hardwareVector, id, desc, price, rsp, addStock, dateOfItem);
            isThereErrorsHardware = h.setterValidationHardware(length, height, width, weight);

            //IF STATEMENT TO CHECK IF ANY OF THE ITEMS RETURNED A PROBLEM BACK
            if (isThereErrorsCommon == false && isThereErrorsHardware == false) {
                //ADVICE USER THAT ITEM HAS BEEN ADDED
                Warnings.itemAddedSuccess();
                hardwareVector.add(h);      //ONLY ADDED IF THERE WERE NO ISSUES
                System.out.println("WOULD YOU LIKE TO ADD ANOTHER ITEM?");
                System.out.println("1. YES, 2. NO/EXIT");
                addMore = sc.nextInt();
                sc.nextLine();
            } else {
                //AUTOMATICALLY RESTART THE MENU WITHOUT ADDING AND ALL WARNINGS SHOULD HAVE BEEN 
                //DISPLAYED BY THE HARDWARE CLASS
                addMore = 2;
                sc.nextLine();      //THIS IS USED TO CLEAR THE BUFFER AS IT WAS CREATING A BUG IN THE PROGRAM
            }
            
            //THIS SWITCH STATEMENT IS DONE TO SEE IF THE CLIENT WOULD LIKE TO LOOP BACK AND ADD MORE
            //OR EXIT TO THE MAIN MENU (SAVED OR NOT)
            switch (addMore) {

                case 1:
                    isHardware = true;
                    break;
                case 2:
                    isHardware = false;
                    break;
                default:
                    Warnings.incorrectNumberedOption();
                    isHardware = false;
                    break;

            }

        }//END WHILE LOOP (WHEN ISHARDWARE IS FALSE)
        return hardwareVector;      //RETURN BACK THE SAVED VECTOR
    }

    public static Vector addItemsConsumables(Vector<Inventory> consumablesVector) throws InputMismatchException, DateTimeException {

        //DATATYPES AND VARIABLES FOR THIS METHOD
        Scanner sc = new Scanner(System.in);
        boolean isConsumables = true;
        boolean isThereErrorsCommon;
        boolean isThereErrorsConsumables;
        int addMore;
        LocalDate dateOfItem = null;
        LocalDate expireDate = null;

        //THIS WILL LOOP UNTIL THE CLIENT CHOOSE TO STOP ADDING ITEMS
        while (isConsumables) {
            System.out.println("--ADDING OF NEW CONSUMABLES INVENTORY--");
            Warnings.userAdvicedWhatIsRequired();
            System.out.println("ENTER DESCRIPTION*: ");
            String desc = sc.nextLine();
            System.out.println("ENTER ID OR STOCK CODE*: ");
            int id = sc.nextInt();
            System.out.println("ENTER DAY OF ACQUSITION (1-31)*: ");
            int day = sc.nextInt();
            System.out.println("ENTER MONTH OF ACQUSITION (1-12)*: ");
            int month = sc.nextInt();
            System.out.println("ENTER YEAR OF ACQUSITION (XXXX)*: ");
            int year = sc.nextInt();
            System.out.println("ENTER COST: ");
            double price = sc.nextDouble();
            price = Math.round(price*100.0)/100.0;
            System.out.println("ENTER RSP: ");
            double rsp = sc.nextDouble();
            rsp = Math.round(rsp*100.0)/100.0;
            System.out.println("ENTER QUANTITY: ");
            double addStock = sc.nextDouble();
            System.out.println("ENTER DAY OF EXPIRY (1-31)*: ");
            int expireDay = sc.nextInt();
            System.out.println("ENTER MONTH OF EXPIRY (1-12)*: ");
            int expireMonth = sc.nextInt();
            System.out.println("ENTER YEAR OF EXPIRY (XXXX)*: ");
            int expireYear = sc.nextInt();
            System.out.println("ENTER CAPACITY: ");
            double capacity = sc.nextDouble();
            sc.nextLine();
            System.out.println("ENTER UNITS*(KG, mL, GB): ");
            String units = sc.nextLine();

            //USING LOCALDATE CLASS TO STORE USERS INPUT
            dateOfItem = dateOfItem.of(year, month, day);
            expireDate = expireDate.of(expireYear, expireMonth, expireDay);
            //INSERT ALL THE ATTRIBUTES SET BY THE CLIENT IN THE OBJECT
            Inventory c = new Consumables(id, desc, dateOfItem, price, rsp, addStock, expireDate, capacity, units, 'c');

            //VALIDATE ALL INPUTED ITEMS
            isThereErrorsCommon = c.setterValidationCommon(consumablesVector, id, desc, price, rsp, addStock, dateOfItem);
            isThereErrorsConsumables = c.setterValidationConsumables(capacity, units, expireDate, dateOfItem);

            //IF STATMENT TO CHECK IF ANY PROBLEMS WERE FOUND AND ADD ONLY IF NOT
            if (isThereErrorsCommon == false && isThereErrorsConsumables == false) {
                //ADVICE USER THAT ITEM HAS BEEN ADDED SUCESSFULLY
                Warnings.itemAddedSuccess();
                consumablesVector.add(c);
                System.out.println("WOULD YOU LIKE TO ADD ANOTHER ITEM?");
                System.out.println("1. YES, 2.NO/EXIT");
                addMore = sc.nextInt();
                sc.nextLine();
            } else {
                //AUTOMATICALLY RESTART THE MENU IF THERE WERE ERRORS
                addMore = 2;
                sc.nextLine();
            }
            switch (addMore) {

                case 1:
                    isConsumables = true;
                    break;
                case 2:
                    isConsumables = false;
                    break;
                default:
                    Warnings.incorrectNumberedOption();
                    isConsumables = false;
                    break;

            }

        }//END WHILE LOOP (WHEN ISHARDWARE IS FALSE)
        return consumablesVector;       //RETURN BACK THE SAVED VECTOR
    }

}
