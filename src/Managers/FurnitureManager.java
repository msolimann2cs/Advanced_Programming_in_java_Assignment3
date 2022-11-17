package Managers;

import Furniture.Bed;
import Furniture.Chair;
import Furniture.Couch;
import Furniture.Table;

public class FurnitureManager {

    Chair chair = new Chair();
    Table table = new Table();
    Couch couch = new Couch();
    Bed bed = new Bed();

    public FurnitureManager(){
        LoadFurniture();
        chair.setStock(100);
        chair.setPrice(589);
        chair.setTitle("Chair");
        table.setStock(100);
        table.setPrice(189);
        table.setTitle("Table");
        couch.setStock(100);
        couch.setPrice(3750);
        couch.setTitle("Couch");
        bed.setStock(100);
        bed.setPrice(226);
        bed.setTitle("Bed");
    }

    public void LoadFurniture(){
        System.out.println("Loading stock and prices from csv");
    }

    public void buyChair(){
        chair.decreaseStock();
    }
    public void displayChairStock(){
        chair.displayStock();
    }

    public int getChairPrice(){
        return chair.getPrice();
    }
    public int getTablePrice(){
        return table.getPrice();
    }
    public int getCouchPrice(){
        return couch.getPrice();
    }
    public int getBedPrice(){
        return bed.getPrice();
    }

}
