package javaimplementation_2;

import java.io.*;
import java.util.Vector;

public class SaveAndLoad {

    /*SAVE/LOAD BOTH THE HARDWARE AND CONSUMABLES CHILD OBJECTS IN/FROM THE ROOT FILE (USING THE 
    INVENTORY SUPER CLASS.  THE FILE'S NAME IS inventory.data
    THIS METHOD WILL THROW THE EXPECTION BACK TO THE MAIN METHOD WHERE IT IS HANDELED
     */
    public static Vector loadAll() throws FileNotFoundException, IOException, ClassNotFoundException {

        //USE SERIALIZATION TO LOAD FROM THE FILE
        ObjectInputStream isc = new ObjectInputStream(new FileInputStream("inventory.data"));
        Vector<Inventory> vc = (Vector<Inventory>) isc.readObject();
        isc.close();

        return vc;

    }

    public static void saveAll(Vector<Inventory> vc) throws FileNotFoundException, IOException {

        //USER SERIALIZATION TO SAVE TO THE FILE
        ObjectOutputStream osc = new ObjectOutputStream(new FileOutputStream("inventory.data"));
        osc.writeObject(vc);
        osc.close();

    }
}
