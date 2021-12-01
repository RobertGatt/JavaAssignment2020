package javaimplementation_2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Vector;

/*
THIS CLASS IS A CHILD OF THE CLASS INVENTORY.  APART FROM THE ITEMS INHERITED 
FROM THE INVENTORY CLASS, THIS CLASS ALSO HAS EXPIRY DATE, CAPACITY AND UNITS

THIS CLASS IS ALSO SERIALIZABLE - USED TO SAVE AND LOAD THE CLASS
 */
public class Consumables extends Inventory implements Serializable {

    //ADDITIONAL VARIABLES
    LocalDate expireDate;
    double capacity;
    String units;

    //CLASS CONSTRUCTOR
    public Consumables(int inventoryID, String itemDescription, LocalDate dateOfItem,
            double costOfPrice, double recommendedSellingPrice, double stockAvailable,
            LocalDate expireDate, double capacity, String units, char type) {

        //THE SUPER IS THE IMPORTATION OF ATTRIBUTES FROM THE SUPER CLASS (INVENTORY)
        super(inventoryID, itemDescription, dateOfItem, costOfPrice, recommendedSellingPrice, stockAvailable, type);
        this.expireDate = expireDate;
        this.capacity = capacity;
        this.units = units;

    }

    //METHOD OVERRIDEN FROM SUPER CLASS TO DISPLAY ALL THE ATTRIBUTES (GETTER)
    @Override
    public void displayItems() {

        System.out.println(inventoryID + "\t\t" + itemDescription + "\t\t\t" + dateOfItem + "\t" + costOfPrice + "\t"
                + recommendedSellingPrice + "\t" + stockAvailable + "\t\t" + expireDate + "\t\t"
                + capacity + "\t\t" + units);

    }

    //METHOD OVERRIDEN FROM THE SUPER CLASS TO SET ATTRIBUTES TO THE CORRECT STATES (THIS IS COMMON
    //IN BOTH HARDWARE AND CONSUMABLES CLASS) (SETTER)
    @Override
    public boolean setterValidationCommon(Vector<Inventory> cv, int id, String desc, double price,
            double rsp, double stock, LocalDate dateOfItem) {

        boolean checkIfAnyIsTrue = false;
        for (Inventory h : cv) {

            //SEARCH IN ALL THE INVENTORY ITEMS.  IF THE SAME ID IS FOUND RETURN TRUE
            if (h.inventoryID == id) {
                //SELECT THE ERROR THAT ID ALREADY EXISTS - ID IS UNIQUE FOR ALL INSTANCES
                Warnings.idAlreadyExist();
                checkIfAnyIsTrue = true;
            }
        }

        //CHECK IF ID IS SET TO LESS THAN 0 - DISPLAY A WARNING
        if (id < 0) {
            Warnings.idIsZero();
            checkIfAnyIsTrue = true;
        }
        //IF THE DESCRIPTION IS LEFT BLANK - MARK IT AN AN ERROR
        if (desc.isBlank()) {
            Warnings.descriptionIsBlank();
            checkIfAnyIsTrue = true;
        }
        //IF THE PRICE IS LESS THAN 0 (YOU CAN SET IT TO 0) - MARK IT AS AN ERROR
        if (price < 0) {
            Warnings.costPriceIsZero();
            checkIfAnyIsTrue = true;
        }
        //IF THE RSP IS LESS THAN 0 (YOU CAN SET IT TO 0) - MARK IT AS AN ERROR
        if (rsp < 0) {
            Warnings.sellingPriceIsZero();
            checkIfAnyIsTrue = true;
        }

        //IF THE STOCK IS SET LESS THAN 0 - MARK IT AS AN ERROR
        if (stock < 0) {
            Warnings.stockIsZero();
            checkIfAnyIsTrue = true;
        }

        //IF THE DATE OF ITEM IS AFTER TODAY'S DATE, DISPLAY AN ERROR
        if (dateOfItem.isAfter(LocalDate.now())) {
            Warnings.dateOfAcquisitionFuture();
            checkIfAnyIsTrue = true;
        }

        //RETURN THE APPROPRIATE BOOLEAN VALUE
        if (checkIfAnyIsTrue == true) {
            return true;
        } else {
            return false;
        }
    }

    //THIS METHOD DOES NOTHING IN THE CONSUMABLES CLASS
    @Override
    public boolean setterValidationHardware(double length, double height, double width, double weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //METHOD OVERRIDEN FROM THE SUPER CLASS TO SET ATTRIBUTES TO THE CORRECT STATES (THIS IS ONLY APPLICABLE
    //IN THE CONSUMABLES CLASS) (SETTER)
    @Override
    public boolean setterValidationConsumables(double capacity, String units, LocalDate expireDate, LocalDate dateOfItem) {
        boolean checkIfAnyIsTrue = false;

        //IF CAPACITY IS LESS THAN 0 - DISPLAY A WARNING
        if (capacity < 0) {
            Warnings.capacityIsZero();
            checkIfAnyIsTrue = true;
        }
        //IF UNITS IS LEFT BLANK - DISPLAY A WARNING
        if (units.isBlank()) {
            Warnings.unitsIsBlank();
            checkIfAnyIsTrue = true;

        }

        //IF THE EXPIRY DATE IS BEFORE THE DATE OF ACQUISITION - DISPLAY A WARNING
        if (expireDate.isBefore(dateOfItem)) {
            Warnings.dateOfExpiryPast();
            checkIfAnyIsTrue = true;
        }

        //RETURN THE APPROPRIATE BOOLEAN VALUE
        if (checkIfAnyIsTrue == true) {
            return true;
        } else {
            return false;
        }
    }

    //METHOD OVERRIDEN FROM SUPER CLASS TO DISPLAY ALL THE IMPORTANT VALUES FOR THE FINANCIAL STATE (GETTER)
    @Override
    public void displayFinance() {
        System.out.println(inventoryID + "\t\t" + itemDescription + "\t\t\t" + costOfPrice + "\t"
                + recommendedSellingPrice + "\t" + stockAvailable);
    }

    //THIS METHOD IS THE SETTER VALIDATION FOR THE MODIFIED ITEMS THE USER CAN ADJUST
    @Override
    public boolean setterValidationModified(double price, double rsp, double stock) {
        boolean checkIfAnyIsTrue = false;

        //IF THE PRICE IS LESS THAN 0 (YOU CAN SET IT TO 0) - MARK IT AS AN ERROR
        if (price < 0) {
            Warnings.costPriceIsZero();
            checkIfAnyIsTrue = true;
        }
        //IF THE RSP IS LESS THAN 0 (YOU CAN SET IT TO 0) - MARK IT AS AN ERROR
        if (rsp < 0) {
            Warnings.sellingPriceIsZero();
            checkIfAnyIsTrue = true;
        }

        //IF THE STOCK IS SET LESS THAN 0 - MARK IT AS AN ERROR
        if (stock < 0) {
            Warnings.stockIsZero();
            checkIfAnyIsTrue = true;
        }

        //RETURN THE APPROPRIATE BOOLEAN VALUE
        if (checkIfAnyIsTrue == true) {
            return true;
        } else {
            return false;
        }

    }

}
