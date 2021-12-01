package javaimplementation_2;

import java.util.Vector;

/*
THIS CLASS HAS THREE METHODS AND ARE ALL SET TO GET THE IMPORTANT
INFORMATION FROM THE SAVED CLASSES IN THE VECTOR.

IN ORDER TO VIEW HARDWARE STOCK, THE LOOP CHECKS IF THE TYPE CHAR IS'h'
IN ORDER TO VIEW CONSUMABLE STOCK, THE LOOP CHECKS IF THE TYPE CHAR IS 'c'
 */
public class ViewStockLevels {

    public static void stockLevelsHardware(Vector<Inventory> vh) {

        //DISPLAY THE TOP OF THE MENU AS GOOD AS POSSIBLE USING TABS
        System.out.println("HARDWARE STOCK");
        System.out.println("Inventory ID \t" + "Item Desc \t\t" + "Date \t\t"
                + "Cost \t" + "RSP \t" + "Stock Levels \t"
                + "Width \t" + "Length \t" + "Height \t" + "Weight \t");

        //FOR LOOP TO ITERATE TRHOUGHT THE WHOLE INVENTORY VECTOR
        for (Inventory h : vh) {

            //ONLY DISPLAY ITME IF THE TYPE IS 'h'
            if (h.type == 'h') {
                h.displayItems();
            }
        }

    }

    public static void stockLevelsConsumables(Vector<Inventory> vc) {
        //DISPLAY THE TOP OF THE MENU AS GOOD AS POSSIBLE USING TABS
        System.out.println("CONSUMABLES STOCK");
        System.out.println("Inventory ID \t" + "Item Desc \t\t" + "Date \t\t"
                + "Cost \t" + "RSP \t" + "Stock Levels \t"
                + "Expiry Date \t\t" + "Capacity \t" + "Units \t");

        //FOR LOOP TO ITERATE TRHOUGHT THE WHOLE INVENTORY VECTOR
        for (Inventory c : vc) {

            //ONLY DISPLAY ITME IF THE TYPE IS 'c'
            if (c.type == 'c') {
                c.displayItems();
            }
        }
    }

    public static void financialStatment(Vector<Inventory> vi) {

        //DATA TYPES AND VARIABLES FOR THIS METHOD
        double totalCost = 0;       //THIS VARIABLE IS USED TO STORE THE TOTAL COST IN STOCK
        double totalRsp = 0;        //THIS VARIABLE IS USED TO STORE THE TOTAL RSP IN STOCK

        //DISPLAY THE TOP OF THE MENU AS GOOD AS POSSIBLE USING TABS
        System.out.println("FINANCIAL SUMMARY");
        System.out.println("Inventory ID \t" + "Item Desc \t\t" + "Cost \t" + "RSP \t" + "Stock Levels \t");

        //FOR LOOP TO ITERATE TRHOUGHT THE WHOLE INVENTORY VECTOR
        for (Inventory i : vi) {
            i.displayFinance();

            //ADD THE TOTAL COST AND RSP FOR EACH ITERATION
            totalCost = i.costOfPrice + totalCost;
            totalRsp = i.recommendedSellingPrice + totalRsp;

        }

        //DISPLAY THE TOTAL COST AND TOTAL RSP
        System.out.println("");
        //round up to two decimal places
        totalCost = Math.round(totalCost*100.0)/100.0;
        totalRsp = Math.round(totalRsp*100.0)/100.0;
        //show costs
        System.out.println("TOTAL COST: " + totalCost);
        System.out.println("TOTAL RSP: " + totalRsp);

    }

}
