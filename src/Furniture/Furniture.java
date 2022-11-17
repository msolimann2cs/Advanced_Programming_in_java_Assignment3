package Furniture;

public class Furniture {
    String title;
    int stock;
    int price;
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

    public int getPrice(){
        return price;
    }
    public void decreaseStock(){
        this.stock--;
    }
    public void displayStock(){
        System.out.println(stock);
    }
}


