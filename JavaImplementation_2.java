package javaimplementation_2;

import java.io.*;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Vector;

public class JavaImplementation_2 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        //DATATYPES AND VARIABLES FOR THE MAIN METHOD
        Vector<Inventory> inventoryVector = new Vector<Inventory>();        //A VECTOR TO HOLD ALL THE INVENTORY ITEMS CREATED

        int menuSelection;      //A VARIABLE TO STORE USER'S MENU SELECTION
        int typeOfInventory;    //A VARIABLE TO STORE USER'S INVENTORY CHOICE(HARDWARE/CONSUMABLES)
        boolean isLooping = true;       //LOOPS IN THE MENU UNTIL THIS IS SET TO FALSE
        boolean isSaved = true;         //THIS IS SET TO FALSE UPON USER ADDS/MODIFIES STOCK.  DONE TO ADVICE USER TO SAVE


        /*BEFORE STARTING THE MAIN MENU LOOP, LOAD AUTOMATICALLY FROM PREVIOUS STATES
        THIS WILL MAKE SURE THAT THE USER DOES NOT SAVE ANY CHANGES WITHOUT LOADING.
        THE LOAD IS ENCLOSED IN A TRY-CATCH STATEMENT IN ORDER TO AVOID PROGRAMMING
        CRASHING IN CASE THE FILE IS NOT FOUND, OR THERE WAS A CHANGE IN THE HIERARCHICAL
        STRUCTURE
         */
        try {
            inventoryVector = SaveAndLoad.loadAll();
            Warnings.LoadSuccess();
        } catch (FileNotFoundException | InvalidClassException e) {
            Warnings.LoadFail();
        }

        //START THE WHILE LOOP FOR THE MAIN MENU
        while (isLooping) {
            menuSelection = MainMenu.Menu();        //CALL THE MAIN MENU METHOD

            //CHECK INPUT FROM USER'S MAIN MENU CHOICE AND BRANCH ACCORDINGLY
            switch (menuSelection) {

                //1. ADD ITEMS IN INVENTORY
                case 1:
                    isSaved = false;        //THE VARIABLE IS SET TO FALSE, THE CLIENT WILL BE ADVICED TO SAVE
                    typeOfInventory = HardwareOrConsumables.hardwareOrConsumablesSelection();       //CALL THE CHECK WHAT KIND OF INVENTORY

                    //CHECK WHAT WAS THE CLIENTS OPTION AND GO TO THE APPROPRIATE METHOD & CLASS
                    //1- ADD HARDWARE
                    //IF ANY ILLEGAL INPUTS ARE THROWN FROM THE METHOD, DISPLAY WARNING TO THE USER
                    if (typeOfInventory == 1) {
                        try {
                            inventoryVector = ItemsManagament.addItemsHardware(inventoryVector);
                        } catch (InputMismatchException e) {
                            Warnings.miscScannerErrors();
                        } catch (DateTimeException e) {
                            Warnings.dateOfAcquisitionFormat();
                        }
                        break;

                        //2 - ADD CONSUMABLES
                        //IF ANY ILLEGAL INPUTS ARE THROWN FROM THE METHOD, DISPLAY WARNING TO THE USER
                    } else if (typeOfInventory == 2) {
                        try {
                            inventoryVector = ItemsManagament.addItemsConsumables(inventoryVector);
                        } catch (InputMismatchException e) {
                            Warnings.miscScannerErrors();
                        } catch (DateTimeException e) {
                            Warnings.dateOfAcquisitionFormat();
                        }
                        break;
                    } //3 - BREAK THE LOOP AND RETURN TO MAIN MENU
                    else {
                        break;
                    }

                //2. MODIFY A STOCK ITEM
                //IF ANY ILLEGAL INPUTS ARE THROWN FROM THE METHOD, DISPLAY WARNING TO THE USER
                case 2:
                    isSaved = false;        //THE VARIABLE IS SET TO FALSE, THE CLIENT WILL BE ADVICED TO SAVE
                    try {
                        StockAdjustments.inventoryCheck(inventoryVector);
                    } catch (InputMismatchException e) {
                        Warnings.miscScannerErrors();
                    }
                    break;

                //3. VIEW ALL STOCK IN INVENTORY (HARDWARE)
                //CALL THE METHOD & CLASS TO SHOW ONLY HARDWARE
                case 3:
                    ViewStockLevels.stockLevelsHardware(inventoryVector);
                    break;

                //4. VIEW ALL STOCK IN INVENTORY (CONSUMABLES)
                //CALL THE METHOD & CLASS TO SHOW ONLY CONSUMABLES
                case 4:
                    ViewStockLevels.stockLevelsConsumables(inventoryVector);
                    break;

                //FINANCIAL SUMMARY
                //VIEW ONLY ID, DESC, COST, RSP AND STOCK AVAILABLE FOR ITEMS
                //DISPLAY THE TOTAL COST AND TOTAL RSP IN ALL THE STOCK(CONSUMABLES AND HARDWARE)
                case 5:
                    ViewStockLevels.financialStatment(inventoryVector);
                    break;

                //SAVE FILE WITH A TRY - CATCH INCASE FILE CANNOT BE SAVED IN THE ROOT LOCATION
                //DISPLAY A WARNING
                case 6:
                    try {

                    SaveAndLoad.saveAll(inventoryVector);
                    Warnings.SavedSuccess();
                    isSaved = true;     //THIS VARIABLE IS TRUE SINCE USER SAVED
                } catch (FileNotFoundException | InvalidClassException e) {
                    Warnings.SavedFail();
                }
                break;

                //LOAD FILE WITH A TRY - CATCH INCASE FILE IS NOT FOUND
                //DISPLAY A WARNING
                case 7:
                    try {
                    inventoryVector = SaveAndLoad.loadAll();
                    Warnings.LoadSuccess();
                    isSaved = true;     //THIS VARIABLE IS TRUE SINCE USER LOADED
                } catch (FileNotFoundException | InvalidClassException e) {
                    Warnings.LoadFail();
                }
                break;

                //EXIT PROGRAM BUT BEFORE MAKE SURE THE CLIENT SAVED THE UPDATES
                case 8:
                    if (isSaved == false) {
                        isLooping = Warnings.userDidNotSave();
                    } else {
                        isLooping = false;
                    }
                    break;

                default:
                    break;
            }

        }

        
        //EXIT MESSAGE
        System.out.println("************************************");
        System.out.println("**THANK YOU FOR USING THIS PRODUCT**");
        System.out.println("**BUILT AND TESTED BY ROBERT GATT **");
        System.out.println("************************************");
        
    }

}
