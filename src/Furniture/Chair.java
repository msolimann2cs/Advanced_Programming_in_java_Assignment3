package Furniture;

public class Chair extends Furniture{
    public Chair(){
        super();
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void decreaseStock(){
        this.stock--;
    }
    public void displayStock(){
        System.out.println(stock);
    }
}
