package Screens;

import Components.BackgroundPanel;
import Furniture.Furniture;
import Managers.CartManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class main_screen extends JFrame implements ActionListener, MouseListener {
    //    cache current_cache = new cache();
//    BufferedImage img = current_cache.img;
    BufferedImage cart_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\cart2.png"));
    BufferedImage cart_img_no_stock = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\cart2_red.png"));


    // index 0 = chair , 1 = table, 2 = couch, 3 = bed

    ArrayList<Furniture> cart_items_array = new ArrayList<Furniture>();

    CartManager cart_manager = new CartManager();
    JList main_list;
    JPanel main_panel;
    JLabel cart_label;
    JPanel cart_items;
    JLabel total_money_label_actual;
    JPanel purchase_panel;
    JPanel cart_menu;

//    JPanel cart_items;

//    public void temp_cart_panel(){
//        JPanel cart_panel_item = new JPanel();
//        cart_panel_item.setBounds(50,50, 200,200);
//        cart_panel_item.setBackground(Color.green);
//        cart_panel_item.setLayout(null);
//        JLabel test_label = new JLabel("Char");
//        test_label.setBounds(30, 30, 50, 50);
//        cart_panel_item.add(test_label);
//        cart_item_panel.add(cart_panel_item);
////        return cart_item_panel;
//    }

    main_screen(BufferedImage bg_img) throws IOException {

//        for(int i = 0; i < 10; i++){
//            temp_cart_panel();
//        }


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1540, 800);
        this.setLayout(null);

        //BufferedImage img = ImageIO.read(new File("C:\\D Drive\\img1.jpg"));
        BackgroundPanel background_panel = new BackgroundPanel(bg_img, BackgroundPanel.SCALED, 0f, 0f);
//        JPanel background_panel = new JPanel();
//        background_panel.setBackground(new Color(211, 211, 211, 230));
//        background_panel.setBounds(0,0,1540, 800);
//        background_panel.setLayout(null);
        this.setContentPane(background_panel);
        this.setVisible(true);

        //-------------------------------------------------------------------------------
        main_panel = new JPanel();
        main_panel.setLayout(null);
        main_panel.setSize(1540, 800);
        main_panel.setLocation(0, 0);
        main_panel.setBackground(Color.white);
        main_panel.setOpaque(true);
        //this.add(main_panel);
        background_panel.add(main_panel);
        //-------------------------------------------------------------------------------
        cart_menu = new JPanel();
        cart_menu.setLayout(null);
        //cart_menu.setSize(1540-400, 800);
        cart_menu.setSize(1540, 800);
        cart_menu.setBackground(new Color(0, 0, 0, 0));

        cart_menu.setVisible(false);

        cart_items = new JPanel();
        //cart_items.setSize(400,800);
        cart_items.setLayout(null);
        cart_items.setBounds(1540 - 450, 100, 400, 630);
        //cart_items.setLocation(1540-800, 0);
        cart_items.setBackground(new Color(246, 246, 246, 248));
        cart_items.setBorder(new LineBorder(new Color(230, 230, 230, 150), 3));
        cart_items.setVisible(false);

        total_money_label_actual = BuyPanel();

        main_panel.add(cart_items);

//        JLabel logo_label2 = new JLabel("iFurnex");
//        logo_label2.setBounds(30, 15, 200,45);
//        logo_label2.setFont(new Font("Serif", Font.BOLD, 40));
//        cart_items.add(logo_label2);
        main_panel.add(cart_menu);


//        FastPanelList panelList = new FastPanelList(FastPanelList.FPLOrientation.VERTICAL,
//                Screens.main_screen::supplyPanel,
//                0.1,
//                0.95,
//                false,
//                80,
//                Integer.MAX_VALUE);
//        Container cart_panel_container = panelList.container;
//        cart_panel_container.setPreferredSize(new Dimension(400, 630));
//        cart_items.add(cart_panel_container);
        //ShowItemList(cart_item_panel, cart_items);
        //cart_panel_container.setBackground(Color.GRAY);
        //-------------------------------------------------------------------------------
        JPanel nav_bar = new JPanel();
        nav_bar.setLayout(null);
        nav_bar.setBounds(50, 20, 1540 - 100, 80);
        nav_bar.setOpaque(false);
        //nav_bar.setBackground(Color.red);
        main_panel.add(nav_bar);

        JLabel logo_label = new JLabel("iFurnex");
        logo_label.setBounds(30, 15, 200, 45);
        logo_label.setFont(new Font("Serif", Font.BOLD, 40));
        nav_bar.add(logo_label);

        JLabel shop_label = new JLabel("Shop  |");
        shop_label.setBounds((1540 / 2) - 150, 15, 60, 45);
        shop_label.setFont(new Font("Serif", Font.BOLD, 20));
        nav_bar.add(shop_label);

        JLabel about_label = new JLabel("About  |");
        about_label.setBounds((1540 / 2) - 150 + 70, 15, 70, 45);
        about_label.setFont(new Font("Serif", Font.BOLD, 20));
        nav_bar.add(about_label);

        JLabel contact_us_label = new JLabel("Contact Us");
        contact_us_label.setBounds((1540 / 2) - 150 + 60 + 85, 15, 100, 45);
        contact_us_label.setFont(new Font("Serif", Font.BOLD, 20));
        nav_bar.add(contact_us_label);

        //JLabel cart_label = new JLabel("Cart (" + cart_items +")");
        cart_label = new JLabel("Cart (" + cart_manager.getCartItemsCounter() + ")");
        cart_label.setBounds(1540 - 280, 15, 200, 45);
        cart_label.setFont(new Font("Serif", Font.BOLD, 40));
//        cart_label.setOpaque(false);
//        cart_label.setContentAreaFilled(false);
//        cart_label.setBorderPainted(false);
        nav_bar.add(cart_label);

        //cart_label.addActionListener(e -> hide_page_for_cart.setVisible(true));

        cart_label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


                for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                    JPanel temp_panel = new JPanel();
                    temp_panel = cart_manager.cart_panel_item_panels.get(i);
                    temp_panel.setBounds(10, margin, 380, 100);
                    for(Component c : temp_panel.getComponents()){
                        if(c instanceof JLabel){
                            if (Objects.equals(((JLabel) c).getText(), "Chair") ) {
                                for(Component b : temp_panel.getComponents()){
                                    if(b instanceof JLabel){
                                        if (Objects.equals(((JLabel) b).getText(), "+") ) {
                                            if(cart_manager.getChairCounter() == cart_manager.furniture_manager.items.get(0).getStock()){
                                                b.setForeground(Color.red);
//                                    cart_icon1.setImage(cart_img_no_stock);
//                                    Card.repaint();
//                                    add_item = false;
                                            }
                                        }
                                    }
                                }
                            }
                            else if (Objects.equals(((JLabel) c).getText(), "Table") ) {
                                for(Component b : temp_panel.getComponents()){
                                    if(b instanceof JLabel){
                                        if (Objects.equals(((JLabel) b).getText(), "+") ) {
                                            if(cart_manager.getTableCounter() == cart_manager.furniture_manager.items.get(1).getStock()){
                                                b.setForeground(Color.red);
//                                    cart_icon1.setImage(cart_img_no_stock);
//                                    Card.repaint();
//                                    add_item = false;
                                            }
                                        }
                                    }
                                }
                            }
                            else if (Objects.equals(((JLabel) c).getText(), "Couch") ) {
                                for(Component b : temp_panel.getComponents()){
                                    if(b instanceof JLabel){
                                        if (Objects.equals(((JLabel) b).getText(), "+") ) {
                                            if(cart_manager.getCouchCounter() == cart_manager.furniture_manager.items.get(2).getStock()){
                                                b.setForeground(Color.red);
//                                    cart_icon1.setImage(cart_img_no_stock);
//                                    Card.repaint();
//                                    add_item = false;
                                            }
                                        }
                                    }
                                }
                            }
                            else if (Objects.equals(((JLabel) c).getText(), "Bed") ) {
                                for(Component b : temp_panel.getComponents()){
                                    if(b instanceof JLabel){
                                        if (Objects.equals(((JLabel) b).getText(), "+") ) {
                                            if(cart_manager.getBedCounter() == cart_manager.furniture_manager.items.get(3).getStock()){
                                                b.setForeground(Color.red);
//                                    cart_icon1.setImage(cart_img_no_stock);
//                                    Card.repaint();
//                                    add_item = false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    //temp_panel.setBackground(Color.black);
                    //cart_items.add( cart_manager.getCart().get(i));
                    cart_items.add(temp_panel);
                }

//                cart_items.setBounds(1540 - 450, 100, 400, 631);
//                cart_items.setBounds(1540 - 450, 100, 400, 630);
//                cart_items.repaint();
//                cart_items.revalidate();
//                cart_items.validate();
                cart_label.setLocation(1540 - 280 - 90, 15);
                cart_menu.setVisible(true);
                cart_items.setVisible(true);
                //ShowItemList(cart_item_panel, cart_items);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        cart_items.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cart_menu.setVisible(true);
                cart_items.setVisible(true);
                cart_label.setLocation(1540 - 280 - 90, 15);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        cart_menu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cart_menu.setVisible(false);
                cart_items.setVisible(false);
                cart_label.setLocation(1540 - 280, 15);
                if(purchase_panel != null){
                    purchase_panel.setVisible(false);
                }

                //cart_items.removeAll();
//                JFrame parent = (JFrame) cart_items.getTopLevelAncestor();
//                parent.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        //-------------------------------------------------------------------------------
        JLabel catch_phrase_label = new JLabel("MODERN FURNITURE");
        catch_phrase_label.setBounds(120, 110, 1400, 200);
        catch_phrase_label.setFont(new Font("Serif", Font.BOLD, 120));
        main_panel.add(catch_phrase_label);
        //-------------------------------------------------------------------------------
        JPanel chair_card = ItemCard("Chair");
        chair_card.setLocation(50, 350);
        //-------------------------------------------------------------------------------
        JPanel table_card = ItemCard("Table");
        table_card.setLocation(410, 350);
        //-------------------------------------------------------------------------------
        JPanel couch_card = ItemCard("Couch");
        couch_card.setLocation(770, 350);
        //-------------------------------------------------------------------------------
        JPanel bed_card = ItemCard("Bed");
        bed_card.setLocation(1180 - 50, 350);
    }


    public JPanel ItemCard(String item_name) throws IOException {
        JPanel Card = new JPanel();
        Card.setLayout(null);
        //Card.setBorder(new LineBorder(Color.lightGray, 3));
        Card.setSize(350, 350);
        Card.setLocation(50, 350);
        //Card.setOpaque(false);
        Card.setBackground(Color.white);
        //p2.setOpaque(true);
        main_panel.add(Card);
        Furniture item = new Furniture();
        for (int i = 0; i < cart_manager.furniture_manager.items.size(); i++) {
            if (Objects.equals(item_name, cart_manager.furniture_manager.items.get(i).getTitle())) {
                item = cart_manager.furniture_manager.items.get(i);
            }
        }
        BufferedImage item_img = ImageIO.read(new File(item.getImgPath()));
        BackgroundPanel item_background = new BackgroundPanel(item_img, BackgroundPanel.SCALED, 0f, 0f);
        item_background.setBounds(0, 0, Card.getWidth(), Card.getHeight() - 50);
        Card.add(item_background);
        JLabel test = new JLabel(">");
        test.setBounds(320, item_background.getHeight() /2 - 31  , 60, 60);
        test.setForeground(Color.black);
        test.setFont(new Font("Serif", Font.BOLD, 60));
        item_background.add(test);
        JLabel test2 = new JLabel("<");
        test2.setBounds(item_background.getWidth() + 800, item_background.getHeight() /2 , 30, 30);
        test2.setForeground(Color.black);
        test2.setFont(new Font("Serif", Font.BOLD, 60));
        item_background.add(test2);
        //
        Furniture finalItem1 = item;
        test.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Objects.equals(finalItem1.getTitle(), "Chair") && cart_manager.furniture_manager.items.get(0).getImage_counter() > 0 && cart_manager.furniture_manager.items.get(0).getImage_counter() < 3) {
                    cart_manager.furniture_manager.items.get(0).setImage_counter(cart_manager.furniture_manager.items.get(0).getImage_counter() + 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair" + cart_manager.furniture_manager.items.get(0).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (Objects.equals(finalItem1.getTitle(), "Table") && cart_manager.furniture_manager.items.get(1).getImage_counter() > 0 && cart_manager.furniture_manager.items.get(1).getImage_counter() < 3) {
                    cart_manager.furniture_manager.items.get(1).setImage_counter(cart_manager.furniture_manager.items.get(1).getImage_counter() + 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\tables\\table" + cart_manager.furniture_manager.items.get(1).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (Objects.equals(finalItem1.getTitle(), "Couch") && cart_manager.furniture_manager.items.get(2).getImage_counter() > 0 && cart_manager.furniture_manager.items.get(2).getImage_counter() < 3) {
                    cart_manager.furniture_manager.items.get(2).setImage_counter(cart_manager.furniture_manager.items.get(2).getImage_counter() + 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\couches\\couch" + cart_manager.furniture_manager.items.get(2).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (Objects.equals(finalItem1.getTitle(), "Bed") && cart_manager.furniture_manager.items.get(3).getImage_counter() > 0 && cart_manager.furniture_manager.items.get(3).getImage_counter() < 3) {
                    cart_manager.furniture_manager.items.get(3).setImage_counter(cart_manager.furniture_manager.items.get(3).getImage_counter() + 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\beds\\bed" + cart_manager.furniture_manager.items.get(3).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        test2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Objects.equals(finalItem1.getTitle(), "Chair") && cart_manager.furniture_manager.items.get(0).getImage_counter() > 1 && cart_manager.furniture_manager.items.get(0).getImage_counter() <= 3) {
                    cart_manager.furniture_manager.items.get(0).setImage_counter(cart_manager.furniture_manager.items.get(0).getImage_counter() - 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair" + cart_manager.furniture_manager.items.get(0).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (Objects.equals(finalItem1.getTitle(), "Table") && cart_manager.furniture_manager.items.get(1).getImage_counter() > 1 && cart_manager.furniture_manager.items.get(1).getImage_counter() <= 3) {
                    cart_manager.furniture_manager.items.get(1).setImage_counter(cart_manager.furniture_manager.items.get(1).getImage_counter() - 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\tables\\table" + cart_manager.furniture_manager.items.get(1).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (Objects.equals(finalItem1.getTitle(), "Couch") && cart_manager.furniture_manager.items.get(2).getImage_counter() > 1 && cart_manager.furniture_manager.items.get(2).getImage_counter() <= 3) {
                    cart_manager.furniture_manager.items.get(2).setImage_counter(cart_manager.furniture_manager.items.get(2).getImage_counter() - 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\couches\\couch" + cart_manager.furniture_manager.items.get(2).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else if (Objects.equals(finalItem1.getTitle(), "Bed") && cart_manager.furniture_manager.items.get(3).getImage_counter() > 1 && cart_manager.furniture_manager.items.get(3).getImage_counter() <= 3) {
                    cart_manager.furniture_manager.items.get(3).setImage_counter(cart_manager.furniture_manager.items.get(3).getImage_counter() - 1);
                    String temp_path1 = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\beds\\bed" + cart_manager.furniture_manager.items.get(3).getImage_counter() + ".png";
                    try {
                        BufferedImage item_img = ImageIO.read(new File(temp_path1));
                        item_background.setImage(item_img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //
        JLabel item_label = new JLabel(item.getTitle());
        item_label.setBounds(30, Card.getHeight() - 39, 80, 25);
        item_label.setFont(new Font("Serif", Font.BOLD, 20));
        Card.add(item_label);

        JLabel chair_price_label = new JLabel("$" + String.valueOf(item.getPrice()));
        chair_price_label.setBounds(250, Card.getHeight() - 39, 80, 25);
        chair_price_label.setFont(new Font("Serif", Font.BOLD, 20));
        Card.add(chair_price_label);

        BackgroundPanel cart_icon1 = new BackgroundPanel(cart_img, BackgroundPanel.SCALED, 0f, 0f);
        cart_icon1.setBackground(Color.white);
        cart_icon1.setBounds(310, Card.getHeight() - 39, 27, 27);
        Card.add(cart_icon1);

        final Furniture finalItem = item;
        cart_icon1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                boolean add_item = true;
                if (Objects.equals(finalItem.getTitle(), "Chair") && cart_manager.getChairCounter() < finalItem.getStock()) {
                    add_item = true;
                    cart_manager.increaseChairCounter();
                } else if (Objects.equals(finalItem.getTitle(), "Table")&& cart_manager.getTableCounter() < finalItem.getStock()) {
                    add_item = true;
                    cart_manager.increaseTableCounter();
                } else if (Objects.equals(finalItem.getTitle(), "Couch")&& cart_manager.getCouchCounter() < finalItem.getStock()) {
                    add_item = true;
                    cart_manager.increaseCouchCounter();
                } else if (Objects.equals(finalItem.getTitle(), "Bed")&& cart_manager.getBedCounter() < finalItem.getStock()) {
                    add_item = true;
                    cart_manager.increaseBedCounter();
                }
                else{
                    cart_icon1.setImage(cart_img_no_stock);
                    Card.repaint();
                    add_item = false;
                }
                if(cart_manager.getChairCounter() == finalItem.getStock()||cart_manager.getTableCounter() == finalItem.getStock()||cart_manager.getCouchCounter() == finalItem.getStock()||cart_manager.getBedCounter() == finalItem.getStock()){
                    cart_icon1.setImage(cart_img_no_stock);
                    Card.repaint();
                    //add_item = false;
                }
                total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                if (cart_manager.cartEmpty() && add_item) {
                    JPanel cart_panel_item = new JPanel();
                    cart_panel_item.setBounds(0, 10, 390, 100);
                    //cart_panel_item.setBackground(new Color(255,255,255,150));
                    cart_panel_item.setBackground(Color.white);
                    cart_panel_item.setLayout(null);

                    //BufferedImage item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair2.png"));
                    BackgroundPanel item_background1 = new BackgroundPanel(item_img, BackgroundPanel.SCALED, 0f, 0f);
                    item_background1.setBounds(20, 10, 100, 80);
                    cart_panel_item.add(item_background1);

                    JLabel test_label = new JLabel(finalItem.getTitle());
                    //System.out.println("size: " + test_label.getUIClassID());
                    test_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10, 10, 100, 20);
                    test_label.setFont(new Font("Serif", Font.BOLD, 20));
                    cart_panel_item.add(test_label);

                    JLabel remove_item_label = new JLabel("-");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    remove_item_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10, 57, 50, 20);
                    remove_item_label.setFont(new Font("Serif", Font.PLAIN, 30));
                    cart_panel_item.add(remove_item_label);



                    if (Objects.equals(finalItem.getTitle(), "Chair")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getChairCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    } else if (Objects.equals(finalItem.getTitle(), "Table")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getTableCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    } else if (Objects.equals(finalItem.getTitle(), "Couch")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getCouchCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    } else if (Objects.equals(finalItem.getTitle(), "Bed")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getBedCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    }


                    JLabel add_item_label = new JLabel("+");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    add_item_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30 + 30, 60, 50, 20);
                    add_item_label.setFont(new Font("Serif", Font.BOLD, 30));
                    cart_panel_item.add(add_item_label);



                    //boolean add_item2 = true;
                    remove_item_label.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            //furniture_manger.buyChair();
                            //furniture_manger.displayStock();
                            cart_icon1.setImage(cart_img);
                            add_item_label.setForeground(Color.black);
                            main_panel.repaint();
                            //Card.repaint();
                            //BuyPanel();
                            //cart_items.repaint();
                            //wcart_panel_item.repaint();
                            //add_item = true;
                            if (Objects.equals(finalItem.getTitle(), "Chair")) {
                                if (cart_manager.getChairCounter() > 0) {
                                    cart_manager.decreaseChairCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getChairCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            } else if (Objects.equals(finalItem.getTitle(), "Table")) {
                                if (cart_manager.getTableCounter() > 0) {
                                    cart_manager.decreaseTableCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getTableCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            } else if (Objects.equals(finalItem.getTitle(), "Couch")) {
                                if (cart_manager.getCouchCounter() > 0) {
                                    cart_manager.decreaseCouchCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getCouchCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            } else if (Objects.equals(finalItem.getTitle(), "Bed")) {
                                if (cart_manager.getBedCounter() > 0) {
                                    cart_manager.decreaseBedCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getBedCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            }

                            //cart_manager.updateChair();
                            //cart_items_counter_two.set(0, cart_items_counter_two.get(0) - 1);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    add_item_label.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (Objects.equals(finalItem.getTitle(), "Chair") && cart_manager.getChairCounter() < finalItem.getStock()) {
                                cart_manager.increaseChairCounter();
                            } else if (Objects.equals(finalItem.getTitle(), "Table") && cart_manager.getTableCounter() < finalItem.getStock()) {
                                cart_manager.increaseTableCounter();
                            } else if (Objects.equals(finalItem.getTitle(), "Couch") && cart_manager.getCouchCounter() < finalItem.getStock()) {
                                cart_manager.increaseCouchCounter();
                            } else if (Objects.equals(finalItem.getTitle(), "Bed") && cart_manager.getBedCounter() < finalItem.getStock()) {
                                cart_manager.increaseBedCounter();
                            }
                            else{
                                add_item_label.setForeground(Color.red);
                                cart_icon1.setImage(cart_img_no_stock);
                                main_panel.repaint();
                            }
                            if(cart_manager.getChairCounter() == finalItem.getStock()||cart_manager.getTableCounter() == finalItem.getStock()||cart_manager.getCouchCounter() == finalItem.getStock()||cart_manager.getBedCounter() == finalItem.getStock()){
                                add_item_label.setForeground(Color.red);
                                cart_icon1.setImage(cart_img_no_stock);
                                main_panel.repaint();
                            }
                            total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                            cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                    JLabel price_label = new JLabel("$");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    price_label.setBounds(item_background1.getWidth() + item_background1.getX() + 180, 60, 130, 20);
                    price_label.setFont(new Font("Serif", Font.BOLD, 20));
                    cart_panel_item.add(price_label);

                    cart_manager.addToCart(cart_panel_item);
                    if (Objects.equals(finalItem.getTitle(), "Chair")) {
                        cart_manager.updateChair();
                    } else if (Objects.equals(finalItem.getTitle(), "Table")) {
                        cart_manager.updateTable();
                    } else if (Objects.equals(finalItem.getTitle(), "Couch")) {
                        cart_manager.updateCouch();
                    } else if (Objects.equals(finalItem.getTitle(), "Bed")) {
                        cart_manager.updateBed();
                    }
                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                }
                if (!cart_manager.itemExists(finalItem.getTitle()) && !cart_manager.cartEmpty() && add_item) {
                    JPanel cart_panel_item = new JPanel();
                    int margin = cart_manager.cart_panel_item_panels.get(cart_manager.cart_panel_item_panels.size() - 1).getHeight() + getY() + 15;
                    cart_panel_item.setBounds(0, margin, 390, 100);
                    //cart_panel_item.setBackground(new Color(255,255,255,150));
                    cart_panel_item.setBackground(Color.white);
                    cart_panel_item.setLayout(null);

                    //BufferedImage item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair2.png"));
                    BackgroundPanel item_background1 = new BackgroundPanel(item_img, BackgroundPanel.SCALED, 0f, 0f);
                    item_background1.setBounds(20, 10, 100, 80);
                    cart_panel_item.add(item_background1);

                    JLabel test_label = new JLabel(finalItem.getTitle());
                    //System.out.println("size: " + test_label.getUIClassID());
                    test_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10, 10, 100, 20);
                    test_label.setFont(new Font("Serif", Font.BOLD, 20));
                    cart_panel_item.add(test_label);

                    JLabel remove_item_label = new JLabel("-");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    remove_item_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10, 57, 50, 20);
                    remove_item_label.setFont(new Font("Serif", Font.PLAIN, 30));
                    cart_panel_item.add(remove_item_label);


                    if (Objects.equals(finalItem.getTitle(), "Chair")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getChairCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    } else if (Objects.equals(finalItem.getTitle(), "Table")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getTableCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    } else if (Objects.equals(finalItem.getTitle(), "Couch")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getCouchCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    } else if (Objects.equals(finalItem.getTitle(), "Bed")) {
                        JLabel item_count_label = new JLabel(String.valueOf(cart_manager.getBedCounter()));
                        //S//ystem.out.println("size: " + test_label.getUIClassID());
                        item_count_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30, 60, 50, 20);
                        item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                        cart_panel_item.add(item_count_label);
                    }


                    JLabel add_item_label = new JLabel("+");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    add_item_label.setBounds(item_background1.getWidth() + item_background1.getX() + 10 + 30 + 30, 60, 50, 20);
                    add_item_label.setFont(new Font("Serif", Font.BOLD, 30));
                    cart_panel_item.add(add_item_label);

                    remove_item_label.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            //furniture_manger.buyChair();
                            //furniture_manger.displayStock();
                            cart_icon1.setImage(cart_img);
                            add_item_label.setForeground(Color.black);
                            main_panel.repaint();
                            //Card.repaint();
                            //BuyPanel();
                            //cart_items.repaint();
                            //wcart_panel_item.repaint();
                            //add_item = true;
                            if (Objects.equals(finalItem.getTitle(), "Chair")) {
                                if (cart_manager.getChairCounter() > 0) {
                                    cart_manager.decreaseChairCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getChairCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            } else if (Objects.equals(finalItem.getTitle(), "Table")) {
                                if (cart_manager.getTableCounter() > 0) {
                                    cart_manager.decreaseTableCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getTableCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            } else if (Objects.equals(finalItem.getTitle(), "Couch")) {
                                if (cart_manager.getCouchCounter() > 0) {
                                    cart_manager.decreaseCouchCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getCouchCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            } else if (Objects.equals(finalItem.getTitle(), "Bed")) {
                                if (cart_manager.getBedCounter() > 0) {
                                    cart_manager.decreaseBedCounter();
                                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                                }
                                if (cart_manager.getBedCounter() == 0) {
                                    cart_manager.removeFromCart(cart_panel_item);
                                    //cart_items.remove(cart_panel_item);
                                    cart_items.removeAll();
                                    BuyPanel();
                                    for (int i = 0, margin = 10; i < cart_manager.getCart().size(); i++, margin += 110) {
                                        JPanel temp_panel = new JPanel();
                                        temp_panel = cart_manager.cart_panel_item_panels.get(i);
                                        temp_panel.setBounds(10, margin, 380, 100);
                                        //temp_panel.setBackground(Color.black);
                                        //cart_items.add( cart_manager.getCart().get(i));
                                        cart_items.add(temp_panel);
                                    }
                                    cart_items.repaint();
                                }
                            }

                            //cart_manager.updateChair();
                            //cart_items_counter_two.set(0, cart_items_counter_two.get(0) - 1);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                    add_item_label.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (Objects.equals(finalItem.getTitle(), "Chair") && cart_manager.getChairCounter() < finalItem.getStock()) {
                                cart_manager.increaseChairCounter();
                            } else if (Objects.equals(finalItem.getTitle(), "Table") && cart_manager.getTableCounter() < finalItem.getStock()) {
                                cart_manager.increaseTableCounter();
                            } else if (Objects.equals(finalItem.getTitle(), "Couch") && cart_manager.getCouchCounter() < finalItem.getStock()) {
                                cart_manager.increaseCouchCounter();
                            } else if (Objects.equals(finalItem.getTitle(), "Bed") && cart_manager.getBedCounter() < finalItem.getStock()) {
                                cart_manager.increaseBedCounter();
                            }
                            else{
                                add_item_label.setForeground(Color.red);
                                cart_icon1.setImage(cart_img_no_stock);
                                main_panel.repaint();
                            }
                            if(cart_manager.getChairCounter() == finalItem.getStock()||cart_manager.getTableCounter() == finalItem.getStock()||cart_manager.getCouchCounter() == finalItem.getStock()||cart_manager.getBedCounter() == finalItem.getStock()){
                                add_item_label.setForeground(Color.red);
                                cart_icon1.setImage(cart_img_no_stock);
                                main_panel.repaint();
                            }
                            total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                            cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });

                    JLabel price_label = new JLabel("$100");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    price_label.setBounds(item_background1.getWidth() + item_background1.getX() + 180, 60, 130, 20);
                    price_label.setFont(new Font("Serif", Font.BOLD, 20));
                    cart_panel_item.add(price_label);

                    cart_manager.addToCart(cart_panel_item);
                    if (Objects.equals(finalItem.getTitle(), "Chair")) {
                        cart_manager.updateChair();
                    } else if (Objects.equals(finalItem.getTitle(), "Table")) {
                        cart_manager.updateTable();
                    } else if (Objects.equals(finalItem.getTitle(), "Couch")) {
                        cart_manager.updateCouch();
                    } else if (Objects.equals(finalItem.getTitle(), "Bed")) {
                        cart_manager.updateBed();
                    }
                    //  1cart_manager.updateChair();
                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                }
                else {
                    if (Objects.equals(finalItem.getTitle(), "Chair")) {
                        cart_manager.updateChair();
                    } else if (Objects.equals(finalItem.getTitle(), "Table")) {
                        cart_manager.updateTable();
                    } else if (Objects.equals(finalItem.getTitle(), "Couch")) {
                        cart_manager.updateCouch();
                    } else if (Objects.equals(finalItem.getTitle(), "Bed")) {
                        cart_manager.updateBed();
                    }

                    total_money_label_actual.setText("$" + String.valueOf(cart_manager.getTotal()));
                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                }


//                Chair chair = new Chair();
//                chair.setStock(100);
//                chair.setPrice(589);
//                chair.setTitle("Chair");
                //cart_items_array.add(chair);
                //cart_label.setLocation(1540 - 280, 15);
                //System.out.println(cart_items_counter);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        return Card;
    }


    public JLabel BuyPanel() {
        JPanel cart_buy_panel = new JPanel();
        cart_buy_panel.setLayout(null);
        cart_buy_panel.setBounds(10, 500, 380, 120);
        cart_buy_panel.setBackground(Color.white);
        cart_items.add(cart_buy_panel);

        JLabel total_money_label = new JLabel("Total");
        total_money_label.setBounds(20, 10, 50, 45);
        total_money_label.setFont(new Font("Serif", Font.BOLD, 20));
        cart_buy_panel.add(total_money_label);

        total_money_label_actual = new JLabel("$" + String.valueOf(cart_manager.getTotal()));
        total_money_label_actual.setBounds(300, 10, 120, 45);
        total_money_label_actual.setFont(new Font("Serif", Font.BOLD, 20));
        cart_buy_panel.add(total_money_label_actual);

        JButton pay_button = new JButton("Place order");
        pay_button.setBounds(20, 65, 350, 40);
        pay_button.setFont(new Font("Serif", Font.BOLD, 20));
        pay_button.setBackground(Color.black);
        pay_button.setForeground(Color.white);
        cart_buy_panel.add(pay_button);

        pay_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!cart_manager.cartEmpty()){
                    for (int i = 0; i < cart_manager.cart_items_counter_two.size(); i++) {
                        int deductAmount = cart_manager.cart_items_counter_two.get(i);
                        if(i == 0){
                            try {
                                cart_manager.furniture_manager.buyChairs(deductAmount);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        else if(i == 1){
                            try {
                                cart_manager.furniture_manager.buyTables(deductAmount);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        else if(i == 2){
                            try {
                                cart_manager.furniture_manager.buyCouches(deductAmount);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        else if(i == 3){
                            try {
                                cart_manager.furniture_manager.buyBeds(deductAmount);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                    cart_manager.clearCart();
                    cart_label.setText("Cart (" + cart_manager.getCartItemsCounter() + ")");
                    //main_panel.repaint();
                    cart_items.removeAll();
                    BuyPanel();
                    cart_items.setVisible(false);
                    purchaseSuccessfulPanel();
                }
            }
        });

        return total_money_label_actual;
    }

    public void purchaseSuccessfulPanel(){
        //JPanel purchase_successfully_panel = new JPanel()
        purchase_panel = new JPanel();
        purchase_panel.setLayout(null);
        purchase_panel.setBounds(0, 0, 1540, 800);
        purchase_panel.setBackground(new Color(0,0,0,200));
        purchase_panel.setVisible(true);

        cart_menu.add(purchase_panel);

        JPanel purchase_panel_two = new JPanel();
        purchase_panel_two.setLayout(null);
        purchase_panel_two.setBounds((1540/2) - (650/2) , (800/2) - (330/2), 650, 330);
        purchase_panel_two.setBackground(new Color(255,255,255,255));
        //purchase_panel_two.setBorder(new LineBorder(new Color(233,233,233,233), 4));
        purchase_panel_two.setBorder(new LineBorder(new Color(0, 203, 0,255), 3));
        purchase_panel.add(purchase_panel_two);

        JLabel purchase_label = new JLabel("Payment Successful!");
        purchase_label.setBounds(85,50,500 ,70);
        //contact_us_label.setBounds((1540 / 2) - 150 + 60 + 85, 15, 100, 45);
        purchase_label.setFont(new Font("Serif", Font.BOLD, 55));
        purchase_label.setForeground(new Color(0,203,0,255));
        purchase_panel_two.add(purchase_label);

        JLabel purchase_label_two = new JLabel("<HTML>" + "Congratulations on your <br> purchase from iFurnex" + "</HTML>");
        purchase_label_two.setBounds(165,160,600,80);
        //contact_us_label.setBounds((1540 / 2) - 150 + 60 + 85, 15, 100, 45);
        purchase_label_two.setFont(new Font("Serif", Font.BOLD, 30));
        purchase_label_two.setForeground(Color.black);
        purchase_panel_two.add(purchase_label_two);

        main_panel.repaint();

//        JLabel total_money_label = new JLabel("Total");
//        total_money_label.setBounds(20, 10, 50, 45);
//        total_money_label.setFont(new Font("Serif", Font.BOLD, 20));
//        cart_buy_panel.add(total_money_label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
