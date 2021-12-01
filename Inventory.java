package javaimplementation_2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Vector;

/*
THIS CLASS IS ON THE TOP OF THE HIERARCHIAL STRUCTURE-  THE CHILD CLASSES
ARE HARDWARE AND CONSUMABLES. THIS CLASS HOUSES THE COMMON ATTRIBUTES
BETWEEN THE TWO CLASSES.

THIS IS ALSO AN ABSTRACT CLASS AND IMPLEMENTS SERIALIZABLE
*/


public abstract class Inventory implements Serializable {

    //COMMON DATA TYPES AND VARIABLES
    int inventoryID;                //UNIQUE AND REQUIRED
    String itemDescription;         //REQUIRED
    double costOfPrice;             //NOT REQURIED AND CAN BE SET
    double recommendedSellingPrice; //NOT REQURIED AND CAN BE SET
    double stockAvailable;          //NOT REQURIED AND CAN BE SET
    char type;                      //C FOR CONSUMABLES, H FOR HARDWARE
    LocalDate dateOfItem;           //THE DATE THE ITEM WAS AQUIRED

    //CLASS CONSTRUCTOR
    public Inventory(int inventoryID, String itemDescription, LocalDate dateOfItem,
            double costOfPrice, double recommendedSellingPrice, double stockAvailable, char type) {

        this.inventoryID = inventoryID;
        this.itemDescription = itemDescription;
        this.dateOfItem = dateOfItem;
        this.costOfPrice = costOfPrice;
        this.recommendedSellingPrice = recommendedSellingPrice;
        this.stockAvailable = stockAvailable;
        this.type = type;

    }

    //THIS METHOD IS USED TO DISPLAY THE ITEMS IN THE SUB CLASSES
    public abstract void displayItems();
    
    //THIS METHOD IS USED TO MAKE SURE THE COMMON ITEMS BETWEEN HARDWARE AND CONSUMABLES ARE OK
    public abstract boolean setterValidationCommon(Vector<Inventory> hv, int id, String desc, double price, double rsp, double stock, LocalDate dateOfItem);
    
    //THIS METHOD IS USED TO MAKE SURE THE HARDWARE ITEMS ARE CORRECT
    public abstract boolean setterValidationHardware(double length, double height, double width, double weight);
    
    //THIS METHOD IS USED TO MAKE SURE THE HARDWARE ITEMS ARE CORRECT
    public abstract boolean setterValidationConsumables(double capacity, String units, LocalDate expireDate, LocalDate dateOfItem);
    
    //THIS METHOD IS USED TO MODIFY THE HARDWARE OR CONSUMABLE PRODUCTS
    public abstract boolean setterValidationModified(double price, double rsp, double stock);
    
    //THIS METHOD IS USED TO DISPLAY THE IMPORTANT ATTRIBUTES FOR THE FINANCIAL STATE
    public abstract void displayFinance();
    
    
}
