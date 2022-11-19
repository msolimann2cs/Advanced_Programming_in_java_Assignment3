package Managers;

import Furniture.*;

import java.util.ArrayList;

public class FurnitureManager {

    Chair chair = new Chair();
    Table table = new Table();
    Couch couch = new Couch();
    Bed bed = new Bed();

    public ArrayList<Furniture> items = new ArrayList<>();

    public FurnitureManager(){
        LoadFurniture();
        chair.setStock(1);
        chair.setPrice(589);
        chair.setTitle("Chair");
        chair.setimgPath("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair2.png");
        table.setStock(3);
        table.setPrice(189);
        table.setTitle("Table");
        table.setimgPath("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\tables\\table2.jpg");
        couch.setStock(10);
        couch.setPrice(3750);
        couch.setTitle("Couch");
        couch.setimgPath("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\couches\\couch2.jpg");
        bed.setStock(5);
        bed.setPrice(226);
        bed.setTitle("Bed");
        bed.setimgPath("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\beds\\bed2.png");
    }


    public void LoadFurniture(){
        System.out.println("Loading stock and prices from csv");
        items.add(chair);
        items.add(table);
        items.add(couch);
        items.add(bed);
    }

    public void buyChairs(int amount){
        for(int i = 0; i < amount; i++){
            chair.decreaseStock();
        }
    }
    public void buyTables(int amount){
        for(int i = 0; i < amount; i++){
            table.decreaseStock();
        }
    }
    public void buyCouches(int amount){
        for(int i = 0; i < amount; i++){
            couch.decreaseStock();
        }
    }
    public void buyBeds(int amount){
        for(int i = 0; i < amount; i++){
            bed.decreaseStock();
        }
    }
    public void displayChairStock(){
        chair.displayStock();
    }

    public String getChairImg(){
        return chair.getImgPath();
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
