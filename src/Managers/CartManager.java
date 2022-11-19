package Managers;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class CartManager {
    public FurnitureManager furniture_manager = new FurnitureManager();
    //ArrayList<JPanel> cart_panel_item_panels;
    public ArrayList<JPanel> cart_panel_item_panels = new ArrayList<JPanel>();
    public ArrayList<Integer> cart_items_counter_two = new ArrayList<Integer>();
    int cart_items_counter = 0;
    int total = 0;

    public CartManager() throws IOException {
        for(int i = 0; i <4; i++){
            cart_items_counter_two.add(0);
        }
    }

    public void clearCart(){
        total = 0;
        cart_items_counter = 0;
        cart_panel_item_panels.clear();
        cart_items_counter_two.clear();
        for(int i = 0; i <4; i++){
            cart_items_counter_two.add(0);
        }
    }

    public int getTotal(){
        return total;
    }
    public void setTotal(int money){
        this.total = money;
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
    public int getTableCounter(){
        return cart_items_counter_two.get(1);
    }
    public int getCouchCounter(){
        return cart_items_counter_two.get(2);
    }
    public int getBedCounter(){
        return cart_items_counter_two.get(3);
    }

//    public void buyChairs(int ){
//        furniture_manager.buyChairs();
//    }
    public void increaseItemsCounter(){
        cart_items_counter++;
        //updateChair();
    }
    public void decreaseItemsCounter(){
        cart_items_counter--;
        //updateChair();
    }
    public void clearItemsCounter(){
        cart_items_counter = 0;
    }

    public void increaseChairCounter(){
        cart_items_counter_two.set(0, cart_items_counter_two.get(0) + 1);
        increaseItemsCounter();
        total += furniture_manager.getChairPrice();
        updateChair();
    }
    public void decreaseChairCounter(){
        cart_items_counter_two.set(0, cart_items_counter_two.get(0) - 1);
        decreaseItemsCounter();
        //int money = getChairCounter() > 0 ? furniture_manger.getChairPrice() * getChairCounter() : furniture_manger.getChairPrice();
        total -= furniture_manager.getChairPrice();
        updateChair();
    }
    public void increaseTableCounter(){
        cart_items_counter_two.set(1, cart_items_counter_two.get(1) + 1);
        increaseItemsCounter();
        total += furniture_manager.getTablePrice();
        updateTable();
    }
    public void decreaseTableCounter(){
        cart_items_counter_two.set(1, cart_items_counter_two.get(1) - 1);
        decreaseItemsCounter();
        total -= furniture_manager.getTablePrice();
        updateTable();
    }
    public void increaseCouchCounter(){
        cart_items_counter_two.set(2, cart_items_counter_two.get(2) + 1);
        increaseItemsCounter();
        total += furniture_manager.getCouchPrice();
        updateCouch();
    }
    public void decreaseCouchCounter(){
        cart_items_counter_two.set(2, cart_items_counter_two.get(2) - 1);
        decreaseItemsCounter();
        total -= furniture_manager.getCouchPrice();
        updateCouch();
    }
    public void increaseBedCounter(){
        cart_items_counter_two.set(3, cart_items_counter_two.get(3) + 1);
        increaseItemsCounter();
        total += furniture_manager.getBedPrice();
        updateBed();
    }
    public void decreaseBedCounter(){
        cart_items_counter_two.set(3, cart_items_counter_two.get(3) - 1);
        decreaseItemsCounter();
        total -= furniture_manager.getBedPrice();
        updateBed();
    }
//    public int getChairCounter(){}
    public ArrayList<JPanel> getCart(){
        return cart_panel_item_panels;
    }

    public void addToCart(JPanel pane){
        cart_panel_item_panels.add(pane);
    }

    public void removeFromCart(JPanel pane){
        cart_panel_item_panels.remove(pane);
    }
    public void addChair(){

    }


    public boolean itemExists(String item){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean chairExists(){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), "Chair")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean tableExists(){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), "Table")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean couchExists(){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), "Couch")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean bedExists(){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), "Bed")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void updateChair(){
            for (int i = 0; i < cart_panel_item_panels.size(); i++) {
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
                                if( b instanceof JLabel && b != c){
                                    if(((JLabel) b).getText().contains("$")){
                                        ((JLabel) b).setText("$" + String.valueOf(getChairCounter() > 0 ? furniture_manager.getChairPrice() * getChairCounter() : furniture_manager.getChairPrice() ));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    public void updateTable(){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), "Table")) {
                        for (Component b : cart_panel_item_panels.get(i).getComponents()) {
                            //if(((JLabel) b).getText() == "0")
                            if (b instanceof JLabel && b != c) {
                                if(!Objects.equals(((JLabel) b).getText(), "-") && !Objects.equals(((JLabel) b).getText(), "+") && !((JLabel) b).getText().contains("$")){
                                    ((JLabel) b).setText(cart_items_counter_two.get(1).toString());
                                }
                            }
                            if( b instanceof JLabel && b != c){
                                if(((JLabel) b).getText().contains("$")){
//                                    int money = getTableCounter() > 0 ? furniture_manger.getTablePrice() * getTableCounter() : furniture_manger.getTablePrice();
//                                    total += money;
                                    ((JLabel) b).setText("$" + String.valueOf(getTableCounter() > 0 ? furniture_manager.getTablePrice() * getTableCounter() : furniture_manager.getTablePrice() ));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void updateCouch(){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), "Couch")) {
                        for (Component b : cart_panel_item_panels.get(i).getComponents()) {
                            //if(((JLabel) b).getText() == "0")
                            if (b instanceof JLabel && b != c) {
                                if(!Objects.equals(((JLabel) b).getText(), "-") && !Objects.equals(((JLabel) b).getText(), "+") && !((JLabel) b).getText().contains("$")){
                                    ((JLabel) b).setText(cart_items_counter_two.get(2).toString());
                                }
                            }
                            if( b instanceof JLabel && b != c){
                                if(((JLabel) b).getText().contains("$")){
//                                    int money = getCouchCounter() > 0 ? furniture_manger.getCouchPrice() * getCouchCounter() : furniture_manger.getTablePrice();
//                                    total += money;
                                    ((JLabel) b).setText("$" + String.valueOf(getCouchCounter() > 0 ? furniture_manager.getCouchPrice() * getCouchCounter() : furniture_manager.getTablePrice() ));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void updateBed(){
        for (int i = 0; i < cart_panel_item_panels.size(); i++) {
            for (Component c : cart_panel_item_panels.get(i).getComponents()) {
                if (c instanceof JLabel) {
                    if (Objects.equals(((JLabel) c).getText(), "Bed")) {
                        for (Component b : cart_panel_item_panels.get(i).getComponents()) {
                            //if(((JLabel) b).getText() == "0")
                            if (b instanceof JLabel && b != c) {
                                if(!Objects.equals(((JLabel) b).getText(), "-") && !Objects.equals(((JLabel) b).getText(), "+") && !((JLabel) b).getText().contains("$")){
                                    ((JLabel) b).setText(cart_items_counter_two.get(3).toString());
                                }
                            }
                            if( b instanceof JLabel && b != c){
                                if(((JLabel) b).getText().contains("$")){
//                                    int money = getBedCounter() > 0 ? furniture_manger.getBedPrice() * getBedCounter() : furniture_manger.getBedPrice();
//                                    total += money;
                                    ((JLabel) b).setText("$" + String.valueOf(getBedCounter() > 0 ? furniture_manager.getBedPrice() * getBedCounter() : furniture_manager.getBedPrice() ));
                                }
                            }
                        }
                    }
                }
            }
        }
    }



//    public void createChairPanel() throws IOException {
//                if(cartEmpty()) {
//                    JPanel cart_panel_item = new JPanel();
//                    cart_panel_item.setBounds(0, 10, 400, 100);
//                    //cart_panel_item.setBackground(new Color(255,255,255,150));
//                    cart_panel_item.setBackground(Color.white);
//                    cart_panel_item.setLayout(null);
//
//                    BufferedImage chair_item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair2.png"));
//                    Components.BackgroundPanel chair_item_background1 = new Components.BackgroundPanel(chair_item_img, Components.BackgroundPanel.SCALED, 0f, 0f);
//                    chair_item_background1.setBounds(20, 10, 100, 80);
//                    cart_panel_item.add(chair_item_background1);
//
//                    JLabel test_label = new JLabel("Chair");
//                    //System.out.println("size: " + test_label.getUIClassID());
//                    test_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10, 10, 50, 20);
//                    test_label.setFont(new Font("Serif", Font.BOLD, 20));
//                    cart_panel_item.add(test_label);
//
//                    JLabel remove_item_label = new JLabel("-");
//                    //S//ystem.out.println("size: " + test_label.getUIClassID());
//                    remove_item_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10, 57, 50, 20);
//                    remove_item_label.setFont(new Font("Serif", Font.PLAIN, 30));
//                    cart_panel_item.add(remove_item_label);
//
//                    remove_item_label.addMouseListener(new MouseListener() {
//                        @Override
//                        public void mouseClicked(MouseEvent e) {
//                            //furniture_manger.buyChair();
//                            //furniture_manger.displayStock();
//                            decreaseChairCounter();
//                            //cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() +")");
//                            //cart_manager.updateChair();
//                            //cart_items_counter_two.set(0, cart_items_counter_two.get(0) - 1);
//                        }
//
//                        @Override
//                        public void mousePressed(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseReleased(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//                        }
//
//                        @Override
//                        public void mouseExited(MouseEvent e) {
//
//                        }
//                    });
//
//                    JLabel item_count_label = new JLabel(String.valueOf(getChairCounter()));
//                    //S//ystem.out.println("size: " + test_label.getUIClassID());
//                    item_count_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10 + 30, 60, 50, 20);
//                    item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
//                    cart_panel_item.add(item_count_label);
//
//                    JLabel add_item_label = new JLabel("+");
//                    //S//ystem.out.println("size: " + test_label.getUIClassID());
//                    add_item_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10 + 30 + 30, 60, 50, 20);
//                    add_item_label.setFont(new Font("Serif", Font.BOLD, 30));
//                    cart_panel_item.add(add_item_label);
//
//                    add_item_label.addMouseListener(new MouseListener() {
//                        @Override
//                        public void mouseClicked(MouseEvent e) {
//                            increaseChairCounter();
//                            //cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() +")");
//                        }
//
//                        @Override
//                        public void mousePressed(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseReleased(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseEntered(MouseEvent e) {
//
//                        }
//
//                        @Override
//                        public void mouseExited(MouseEvent e) {
//
//                        }
//                    });
//
//                    JLabel price_label = new JLabel("$100");
//                    //S//ystem.out.println("size: " + test_label.getUIClassID());
//                    price_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 180, 60, 130, 20);
//                    price_label.setFont(new Font("Serif", Font.BOLD, 20));
//                    cart_panel_item.add(price_label);
//
//                    addToCart(cart_panel_item);
//                    updateChair();
//                    //cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() +")");
//                }
//                else {
//                    updateChair();
//                    //cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() +")");
//                }
////                Chair chair = new Chair();
////                chair.setStock(100);
////                chair.setPrice(589);
////                chair.setTitle("Chair");
//                //cart_items_array.add(chair);
//                //cart_label.setLocation(1540 - 280, 15);
//                //System.out.println(cart_items_counter);
//            }

}
