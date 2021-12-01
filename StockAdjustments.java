package javaimplementation_2;

import java.util.*;

/*
THIS CLASS IS USED TO LET THE USER MODIFY THE AVAILABLE STOCK 
THE ATTRIBUTES THEY CAN MODIFY ARE: COST, RSP , STOCK+ AND STOCK -
 */
public class StockAdjustments {

    public static void inventoryCheck(Vector<Inventory> vi) throws InputMismatchException {

        Scanner sc = new Scanner(System.in);
        int whichId;
        boolean itemExists = false;
        int elementOfVector = -1;

        //USER ENTERS THE ID
        System.out.println("ENTER ID OR STOCK CODE: ");
        whichId = sc.nextInt();
        sc.nextLine();

        //CYCLE THROUGH ALL THE INSTANCES OF HARDWARE AND DISPLAY TO THE USER
        //THE ONE ITEM THEY WANT TO EDIT.
        for (Inventory i : vi) {

            if (whichId == i.inventoryID) {
                elementOfVector = vi.indexOf(i);
                System.out.println("THE ITEM YOU WOULD LIKE TO ADJUST IS: ");

                //DISPLAY THE MENU UI FOR THE TYPE OF INVENTORY
                if (i.type == 'h') {
                    System.out.println("Inventory ID \t" + "Item Desc \t\t" + "Date \t\t"
                            + "Cost \t" + "RSP \t" + "Stock Levels \t"
                            + "Width \t" + "Length \t" + "Height \t" + "Weight \t");
                } else if (i.type == 'c') {
                    System.out.println("Inventory ID \t" + "Item Desc \t\t" + "Date \t\t"
                            + "Cost \t" + "RSP \t" + "Stock Levels \t"
                            + "Expiry Date \t\t" + "Capacity \t" + "Units \t");
                }
                vi.elementAt(elementOfVector).displayItems();
                itemExists = true;

            }

        }
        //IF ID IS NOT FOUND, ADVICE USER ACCORDINGLY
        if (itemExists == false) {
            Warnings.noItemWithIdFound();
        } else if (itemExists == true) {
            adjustStock(elementOfVector, vi, whichId);
        }

    }

    //GET THE ITEM THE USER WOULD LIKE TO MODIFY
    public static void adjustStock(int elementOfVector, Vector<Inventory> vi, int whichId) throws InputMismatchException {

        //PUT IN A CLASS OF INVENTORY THE ELEMENTS FOUND IN THE INVENTORY VECTOR AT THE ELEMENT SET BY THE ID NUMBER
        Inventory i = vi.elementAt(elementOfVector);
        boolean isNotOk;

        //DATA TYPES AND VARIABLES
        double newCost = adjustCost(vi.elementAt(elementOfVector).costOfPrice);
        double newRsp = adjustRsp(vi.elementAt(elementOfVector).recommendedSellingPrice);
        double currentStock = vi.elementAt(elementOfVector).stockAvailable;
        double newStock = adjustStockUp(currentStock);
        newStock = adjustStockDown(newStock);

        //CHECK IF EVERYTHING IS OK USING THE SETTERS IN THE CLASS
        isNotOk = i.setterValidationModified(newCost, newRsp, newStock);
        if (isNotOk == false) {

            vi.elementAt(elementOfVector).costOfPrice = newCost;
            vi.elementAt(elementOfVector).recommendedSellingPrice = newRsp;
            vi.elementAt(elementOfVector).stockAvailable = newStock;
            Warnings.itemAddedSuccess();
        }

    }

    //ADJUST THE NEW COST
    public static double adjustCost(double oldCost) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double newCost = oldCost;
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("Would you like to edit the cost price of the item?");
            System.out.println("1. YES, 2. NO");
            int innerChoice = sc.nextInt();

            switch (innerChoice) {

                case 1:
                    System.out.println("Enter new cost (cannot be 0): ");
                    newCost = sc.nextDouble();
                    newCost = Math.round(newCost*100.0)/100.0;  //ROUND UP TO 2 DECIMAL PLACES
                    Warnings.itemChangeNoted();
                    isTrue = false;
                    break;
                case 2:
                    isTrue = false;
                    return newCost;
                default:
                    Warnings.incorrectNumberedOption();
                    isTrue = true;
                    break;

            }
        }
        return newCost;
    }

    //ADJUST THE NEW RSP
    public static double adjustRsp(double oldRsp) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double newRsp = oldRsp;
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("Would you like to edit the RSP of the item?");
            System.out.println("1. YES, 2. NO");
            int innerChoice = sc.nextInt();

            switch (innerChoice) {

                case 1:
                    System.out.println("Enter new RSP (cannot be 0): ");
                    newRsp = sc.nextDouble();
                    newRsp = Math.round(newRsp*100.0)/100.0;  //ROUND UP TO 2 DECIMAL PLACES
                    Warnings.itemChangeNoted();
                    isTrue = false;
                    break;
                case 2:
                    isTrue = false;
                    return newRsp;
                default:
                    Warnings.incorrectNumberedOption();
                    isTrue = true;
                    break;

            }
        }
        return newRsp;

    }

    //ADJUST THE STOCK UP
    public static double adjustStockUp(double oldStock) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double newStock = oldStock;
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("Would you like to increase the amount of stock?");
            System.out.println("1. YES, 2. NO");
            int innerChoice = sc.nextInt();

            switch (innerChoice) {

                case 1:
                    System.out.println("Enter the amount of stock you would like to add: ");
                    double additionalStock = sc.nextDouble();
                    additionalStock = Math.abs(additionalStock);    //makes sure that number is always positive

                    //MAKE SURE NUMBER ENTERED IS NOT LESS THAN 0
                    if (additionalStock < 0) {
                        Warnings.stockIsZero();
                        isTrue = true;
                    } else {
                        newStock = additionalStock + oldStock;
                        Warnings.itemChangeNoted();
                        isTrue = false;
                    }
                    break;
                case 2:
                    isTrue = false;
                    return newStock;
                default:
                    isTrue = true;
                    Warnings.incorrectNumberedOption();
                    break;

            }
        }

        return newStock;

    }

    //ADJUST THE STOCK DOWN
    public static double adjustStockDown(double oldStock) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double newStock = oldStock;
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("Would you like to decrease the amount of stock?");
            System.out.println("1. YES, 2. NO");
            int innerChoice = sc.nextInt();

            switch (innerChoice) {

                case 1:
                    System.out.println("Enter the amount of stock you would like to decrease: ");
                    double subtractableStock = sc.nextDouble();
                    subtractableStock = Math.abs(subtractableStock);    //makes sure that number is always positive

                    if (subtractableStock < 0) {
                        Warnings.stockIsZero();
                        isTrue = true;
                    } else {
                        newStock = oldStock - subtractableStock;
                        Warnings.itemChangeNoted();
                        isTrue = false;
                    }
                        break;
                case 2:
                    isTrue = false;
                    return newStock;
                default:
                    Warnings.incorrectNumberedOption();
                    isTrue = true;
                    break;

            }
        }
        return newStock;

    }

}
