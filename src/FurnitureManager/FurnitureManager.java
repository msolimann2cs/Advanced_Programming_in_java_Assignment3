package FurnitureManager;

import Furniture.Chair;

public class FurnitureManager {

    Chair chair = new Chair();

    public FurnitureManager(){
        LoadFurniture();
        chair.setStock(100);
        chair.setPrice(589);
        chair.setTitle("Chair");
    }

    public void LoadFurniture(){
        System.out.println("Loading stock and prices from csv");
    }

    public void buyChair(){
        chair.decreaseStock();
    }
    public void displayStock(){
        chair.displayStock();
    }
}
