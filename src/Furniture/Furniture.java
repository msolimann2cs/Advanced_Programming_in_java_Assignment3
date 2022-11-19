package Furniture;

import java.awt.image.BufferedImage;

public class Furniture {
    String title;
    int stock;
    int price;
    String img_path;
    int image_counter;
    static  int ID;
    public void setTitle(String title){
        this.title = title;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setimgPath(String img_path){
        this.img_path = img_path;
    }
    public void setImage_counter(int image_counter){
        this.image_counter = image_counter;
    }

    public String getTitle(){
        return title;
    }
    public int getStock(){
        return stock;
    }
    public int getPrice(){
        return price;
    }
    public String getImgPath(){
        return img_path;
    }
    public int getImage_counter(){
        return image_counter;
    }
    public void decreaseStock(){
        this.stock--;
    }
    public void displayStock(){
        System.out.println(stock);
    }
}


