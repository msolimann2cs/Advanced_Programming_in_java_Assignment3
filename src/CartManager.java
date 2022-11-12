import FurnitureManager.FurnitureManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class CartManager {
    FurnitureManager furniture_manger = new FurnitureManager();
    //ArrayList<JPanel> cart_panel_item_panels;
    ArrayList<JPanel> cart_panel_item_panels = new ArrayList<JPanel>();
    ArrayList<Integer> cart_items_counter_two = new ArrayList<Integer>();
    int cart_items_counter = 0;

    public CartManager(){
        for(int i = 0; i <4; i++){
            cart_items_counter_two.add(0);
        }
    }

    public boolean cartEmpty(){
        if(cart_panel_item_panels.size() == 0){
            return true;
        }
        return false;
    }

    public int getCartItemsCounter(){
        return cart_items_counter;
    }

    public int getChairCounter(){
        return cart_items_counter_two.get(0);
    }

    public void increaseItemsCounter(){
        cart_items_counter++;
    }
    public void decreaseItemsCounter(){
        cart_items_counter--;
    }

    public void increaseChairCounter(){
        cart_items_counter_two.set(0, cart_items_counter_two.get(0) + 1);
    }
    public void decreaseChairCounter(){
        cart_items_counter_two.set(0, cart_items_counter_two.get(0) - 1);
    }

    public ArrayList<JPanel> getCart(){
        return cart_panel_item_panels;
    }

    public void addToCart(JPanel pane){
        cart_panel_item_panels.add(pane);
    }
    public void addChair(){

    }
    public void updateChair(){
        cart_items_counter++;
        //cart_label.setText("Cart (" + cart_items_counter +")");
        furniture_manger.buyChair();
        furniture_manger.displayStock();
        cart_items_counter_two.set(0, cart_items_counter_two.get(0) + 1);
        if(cart_panel_item_panels.size() > 0) {
            for (int i = 0; i < cart_panel_item_panels.size(); i++) {
//                    ArrayList<Object> temp_array = new ArrayList<Object>();
//                    temp_array = cart_item_panel.get(i).getComponents();
//                    for(int j = 0; j < temp_array.length; j++){
//                        if(temp_array.)
//                    }
                for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                    if (c instanceof JLabel) {
                        if (Objects.equals(((JLabel) c).getText(), "Chair")) {
                            for (Component b : cart_panel_item_panels.get(i).getComponents()) {
                                //if(((JLabel) b).getText() == "0")
                                if (b instanceof JLabel && b != c) {
                                    if(!Objects.equals(((JLabel) b).getText(), "-") && !Objects.equals(((JLabel) b).getText(), "+") && !((JLabel) b).getText().contains("$")){
                                        ((JLabel) b).setText(cart_items_counter_two.get(0).toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }



}
