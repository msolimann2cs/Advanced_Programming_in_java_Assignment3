package Managers;

import Furniture.*;
import Users.Account;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FurnitureManager {

    Chair chair = new Chair();
    Table table = new Table();
    Couch couch = new Couch();
    Bed bed = new Bed();

    String furniture_csv_path = "src/LocalDatabase/furniture.csv";

    public ArrayList<Furniture> items = new ArrayList<>();

    public FurnitureManager() throws IOException {
        chair.setTitle("Chair");
        chair.setimgPath("src/images/products/chairs/chair2.png");
        chair.setImage_counter(1);
        table.setTitle("Table");
        table.setimgPath("src/images/products/tables/table2.png");
        table.setImage_counter(1);
        couch.setTitle("Couch");
        couch.setimgPath("src/images/products/couches/couch2.png");
        couch.setImage_counter(1);
        bed.setTitle("Bed");
        bed.setimgPath("src/images/products/beds/bed2.png");
        bed.setImage_counter(1);
        LoadFurniture();
    }


    public void LoadFurniture() throws IOException {
        System.out.println("Loading stock and prices from csv");
        items.add(chair);
        items.add(table);
        items.add(couch);
        items.add(bed);

        BufferedReader br = new BufferedReader(new FileReader(furniture_csv_path));
        String line = "";

        boolean first_line = true;
        while((line = br.readLine()) != null){
            String [] furniture = line.split(",");
            if(first_line == false){
                Furniture item2 = new Furniture();
                if (Objects.equals(chair.getTitle(), furniture[0])){
                    chair.setPrice(Integer.parseInt(furniture[1]));
                    chair.setStock(Integer.parseInt(furniture[2]));
                }
                else if (Objects.equals(table.getTitle(), furniture[0])){
                    table.setPrice(Integer.parseInt(furniture[1]));
                    table.setStock(Integer.parseInt(furniture[2]));
                }
                else if (Objects.equals(couch.getTitle(), furniture[0])){
                    couch.setPrice(Integer.parseInt(furniture[1]));
                    couch.setStock(Integer.parseInt(furniture[2]));
                }
                else if (Objects.equals(bed.getTitle(), furniture[0])){
                    bed.setPrice(Integer.parseInt(furniture[1]));
                    bed.setStock(Integer.parseInt(furniture[2]));
                }
            }

            first_line = false;
        }

        br.close();
    }

    public void buyChairs(int amount) throws IOException {
        for(int i = 0; i < amount; i++){
            chair.decreaseStock();
        }
        updateDatabase(chair.getTitle(), String.valueOf(chair.getPrice()), String.valueOf(chair.getStock()));
    }
    public void buyTables(int amount) throws IOException {
        for(int i = 0; i < amount; i++){
            table.decreaseStock();
        }
        updateDatabase(table.getTitle(), String.valueOf(table.getPrice()), String.valueOf(table.getStock()));
    }
    public void buyCouches(int amount) throws IOException {
        for(int i = 0; i < amount; i++){
            couch.decreaseStock();
        }
        updateDatabase(couch.getTitle(), String.valueOf(couch.getPrice()), String.valueOf(couch.getStock()));
    }
    public void buyBeds(int amount) throws IOException {
        for(int i = 0; i < amount; i++){
            bed.decreaseStock();
        }
        updateDatabase(bed.getTitle(), String.valueOf(bed.getPrice()), String.valueOf(bed.getStock()));
    }
    public void updateDatabase(String item_name, String item_price, String item_stock) throws IOException {
        if(items.isEmpty()){
            LoadFurniture();
        }
        FileWriter outputfile = new FileWriter(furniture_csv_path);
        CSVWriter writer = new CSVWriter(outputfile, ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String[] account = { item_name, item_price, item_stock };
        ArrayList<String[]> csv_data = new ArrayList<String[]>();
        csv_data.add(new String[]{"Name", "Price", "Stock"});
        for(int i = 0; i < items.size(); i++){
            csv_data.add(new String[] {items.get(i).getTitle(), String.valueOf(items.get(i).getPrice()), String.valueOf(items.get(i).getStock())});
        }
        //csv_data.add(account);
        writer.writeAll(csv_data);
        writer.close();
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
