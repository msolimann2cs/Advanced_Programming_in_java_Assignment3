import Furniture.Chair;
import Furniture.Furniture;
import FurnitureManager.FurnitureManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class main_screen extends JFrame implements ActionListener, MouseListener {
//    cache current_cache = new cache();
//    BufferedImage img = current_cache.img;
    BufferedImage cart_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\cart2.png"));
    int cart_items_counter = 0;
    ArrayList<Integer> cart_items_counter_two = new ArrayList<Integer>();

    // index 0 = chair , 1 = table, 2 = couch, 3 = bed
    FurnitureManager furniture_manger = new FurnitureManager();
    ArrayList<Furniture> cart_items_array = new ArrayList<Furniture>();
    ArrayList<JPanel> cart_item_panel = new ArrayList<JPanel>();
    JList main_list;
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

        for(int i = 0; i <4; i++){
            cart_items_counter_two.add(0);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1540,800);
        this.setLayout (null);

        //BufferedImage img = ImageIO.read(new File("C:\\D Drive\\img1.jpg"));
        BackgroundPanel background_panel = new BackgroundPanel(bg_img, BackgroundPanel.SCALED, 0f, 0f);
        background_panel.setLayout(null);
        this.setContentPane(background_panel);
        this.setVisible(true);

        //-------------------------------------------------------------------------------
        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        //main_panel.setBorder(new LineBorder(Color.black, 3));
        main_panel.setSize(1540,800);
        main_panel.setLocation(0, 0);
        main_panel.setBackground(Color.white);
        main_panel.setOpaque(true);
        //this.add(main_panel);
        background_panel.add(main_panel);
        //-------------------------------------------------------------------------------
        JPanel cart_menu = new JPanel();
        cart_menu.setLayout(null);
        //cart_menu.setSize(1540-400, 800);
        cart_menu.setSize(1540, 800);
        cart_menu.setBackground(new Color(0,0,0,0));

        cart_menu.setVisible(false);

        JPanel cart_items = new JPanel();
        //cart_items.setSize(400,800);
        cart_items.setLayout(null);
        cart_items.setBounds(1540 - 450, 100, 400, 630);
        //cart_items.setLocation(1540-800, 0);
        cart_items.setBackground(new Color(255, 255, 255, 248));
        cart_items.setBorder(new LineBorder(new Color(230, 230, 230, 150), 3));
        cart_items.setVisible(false);


        main_panel.add(cart_items);

//        JLabel logo_label2 = new JLabel("iFurnex");
//        logo_label2.setBounds(30, 15, 200,45);
//        logo_label2.setFont(new Font("Serif", Font.BOLD, 40));
//        cart_items.add(logo_label2);
        main_panel.add(cart_menu);


//        FastPanelList panelList = new FastPanelList(FastPanelList.FPLOrientation.VERTICAL,
//                main_screen::supplyPanel,
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
        nav_bar.setBounds(50,20, 1540 - 100, 80);
        nav_bar.setOpaque(false);
        //nav_bar.setBackground(Color.red);
        main_panel.add(nav_bar);

        JLabel logo_label = new JLabel("iFurnex");
        logo_label.setBounds(30, 15, 200,45);
        logo_label.setFont(new Font("Serif", Font.BOLD, 40));
        nav_bar.add(logo_label);

        JLabel shop_label = new JLabel("Shop  |");
        shop_label.setBounds((1540/2) - 150, 15, 60,45);
        shop_label.setFont(new Font("Serif", Font.BOLD, 20));
        nav_bar.add(shop_label);

        JLabel about_label = new JLabel("About  |");
        about_label.setBounds((1540/2) - 150 + 70, 15, 70,45);
        about_label.setFont(new Font("Serif", Font.BOLD, 20));
        nav_bar.add(about_label);

        JLabel contact_us_label = new JLabel("Contact Us");
        contact_us_label.setBounds((1540/2) - 150 + 60 + 85 , 15, 100,45);
        contact_us_label.setFont(new Font("Serif", Font.BOLD, 20));
        nav_bar.add(contact_us_label);

        //JLabel cart_label = new JLabel("Cart (" + cart_items +")");
        JLabel cart_label = new JLabel("Cart (" + cart_items_counter +")");
        cart_label.setBounds(1540 - 280, 15, 200,45);
        cart_label.setFont(new Font("Serif", Font.BOLD, 40));
//        cart_label.setOpaque(false);
//        cart_label.setContentAreaFilled(false);
//        cart_label.setBorderPainted(false);
        nav_bar.add(cart_label);

        //cart_label.addActionListener(e -> hide_page_for_cart.setVisible(true));

        cart_label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {



                for(int i = 0; i < cart_item_panel.size(); i++){
                    JPanel temp_panel = new JPanel();
                    //temp_panel = cart_item_panel.get(i);
                    //temp_panel.setBounds(50,50,400,100);
                    //temp_panel.setBackground(Color.black);

                    cart_items.add( cart_item_panel.get(i));
                    //cart_items.add(temp_panel);
                }
                for(int i = 0; i < cart_item_panel.size(); i++){
                    System.out.println(cart_item_panel.get(i));
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

        cart_menu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cart_menu.setVisible(false);
                cart_items.setVisible(false);
                //System.out.println("test");
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
        catch_phrase_label.setBounds(120, 110, 1400,200);
        catch_phrase_label.setFont(new Font("Serif", Font.BOLD, 120));
        main_panel.add(catch_phrase_label);
        //-------------------------------------------------------------------------------
        JPanel ItemCard = new JPanel();
        ItemCard.setLayout(null);
        //ItemCard.setBorder(new LineBorder(Color.lightGray, 3));
        ItemCard.setSize(350,350);
        ItemCard.setLocation(50, 350);
        //ItemCard.setOpaque(false);
        ItemCard.setBackground(Color.white);
        //p2.setOpaque(true);
        main_panel.add(ItemCard);
        BufferedImage chair_item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair2.png"));
        BackgroundPanel chair_item_background = new BackgroundPanel(chair_item_img, BackgroundPanel.SCALED, 0f, 0f);
        chair_item_background.setBounds(0, 0, ItemCard.getWidth(), ItemCard.getHeight()-50);
        ItemCard.add(chair_item_background);
        JLabel chair_label = new JLabel("Chair");
        chair_label.setBounds(30, ItemCard.getHeight()-39, 80,25);
        chair_label.setFont(new Font("Serif", Font.PLAIN, 20));
        ItemCard.add(chair_label);

        JLabel chair_price_label = new JLabel("$589");
        chair_price_label.setBounds(250, ItemCard.getHeight()-39, 80,25);
        chair_price_label.setFont(new Font("Serif", Font.PLAIN, 20));
        ItemCard.add(chair_price_label);

        BackgroundPanel cart_icon1 = new BackgroundPanel(cart_img, BackgroundPanel.SCALED, 0f, 0f);
        cart_icon1.setBackground(Color.white);
        cart_icon1.setBounds(300,ItemCard.getHeight()-39,27,27);
        ItemCard.add(cart_icon1);

        cart_icon1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cart_items_counter++;
                cart_label.setText("Cart (" + cart_items_counter +")");
                furniture_manger.buyChair();
                furniture_manger.displayStock();
                cart_items_counter_two.set(0, cart_items_counter_two.get(0) + 1);
                if(cart_item_panel.size() > 0) {
                    for (int i = 0; i < cart_item_panel.size(); i++) {
//                    ArrayList<Object> temp_array = new ArrayList<Object>();
//                    temp_array = cart_item_panel.get(i).getComponents();
//                    for(int j = 0; j < temp_array.length; j++){
//                        if(temp_array.)
//                    }
                        for (Component c : cart_item_panel.get(i).getComponents()) {
                            if (c instanceof JLabel) {
                                if (Objects.equals(((JLabel) c).getText(), "Chair")) {
                                    for (Component b : cart_item_panel.get(i).getComponents()) {
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
                else {
                    JPanel cart_panel_item = new JPanel();
                    cart_panel_item.setBounds(0, 10, 400, 100);
                    //cart_panel_item.setBackground(new Color(255,255,255,150));
                    cart_panel_item.setBackground(Color.green);
                    cart_panel_item.setLayout(null);

                    //BufferedImage chair_item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\chairs\\chair2.png"));
                    BackgroundPanel chair_item_background1 = new BackgroundPanel(chair_item_img, BackgroundPanel.SCALED, 0f, 0f);
                    chair_item_background1.setBounds(20, 10, 100, 80);
                    cart_panel_item.add(chair_item_background1);

                    JLabel test_label = new JLabel("Chair");
                    //System.out.println("size: " + test_label.getUIClassID());
                    test_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10, 10, 50, 20);
                    test_label.setFont(new Font("Serif", Font.BOLD, 20));
                    cart_panel_item.add(test_label);

                    JLabel remove_item_label = new JLabel("-");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    remove_item_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10, 57, 50, 20);
                    remove_item_label.setFont(new Font("Serif", Font.PLAIN, 30));
                    cart_panel_item.add(remove_item_label);

                    remove_item_label.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            System.out.println("IM HERE FUCKERS");
                            cart_items_counter--;
                            cart_label.setText("Cart (" + cart_items_counter +")");
                            furniture_manger.buyChair();
                            furniture_manger.displayStock();
                            cart_items_counter_two.set(0, cart_items_counter_two.get(0) - 1);
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

                    JLabel item_count_label = new JLabel(cart_items_counter_two.get(0).toString());
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    item_count_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10 + 30, 60, 50, 20);
                    item_count_label.setFont(new Font("Serif", Font.BOLD, 20));
                    cart_panel_item.add(item_count_label);

                    JLabel add_item_label = new JLabel("+");
                    //S//ystem.out.println("size: " + test_label.getUIClassID());
                    add_item_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 10 + 30 + 30, 60, 50, 20);
                    add_item_label.setFont(new Font("Serif", Font.BOLD, 30));
                    cart_panel_item.add(add_item_label);

                    add_item_label.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            cart_items_counter++;
                            cart_label.setText("Cart (" + cart_items_counter +")");
                            furniture_manger.buyChair();
                            furniture_manger.displayStock();
                            cart_items_counter_two.set(0, cart_items_counter_two.get(0) + 1);
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
                    price_label.setBounds(chair_item_background1.getWidth() + chair_item_background1.getX() + 200, 60, 50, 20);
                    price_label.setFont(new Font("Serif", Font.BOLD, 20));
                    cart_panel_item.add(price_label);

                    cart_item_panel.add(cart_panel_item);
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
        //-------------------------------------------------------------------------------
        JPanel table_item_card = new JPanel();
        table_item_card.setLayout(null);
        //ItemCard2.setBorder(new LineBorder(Color.lightGray, 3));
        table_item_card.setSize(350,350);
        table_item_card.setLocation(410, 350);
        //table_item_card.setOpaque(false);
        table_item_card.setBackground(Color.white);
        //p2.setOpaque(true);
        main_panel.add(table_item_card);
        BufferedImage table_item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\tables\\table2.jpg"));
        BackgroundPanel table_item_background = new BackgroundPanel(table_item_img, BackgroundPanel.SCALED, 0f, 0f);
        table_item_background.setBounds(0, 0, table_item_card.getWidth(), table_item_card.getHeight()-50);
        table_item_card.add(table_item_background);
        JLabel table_label = new JLabel("Table");
        table_label.setBounds(30, table_item_card.getHeight()-39, 80,25);
        table_label.setFont(new Font("Serif", Font.PLAIN, 20));
        table_item_card.add(table_label);
        BackgroundPanel cart_icon2 = new BackgroundPanel(cart_img, BackgroundPanel.SCALED, 0f, 0f);
        cart_icon2.setBackground(Color.white);
        cart_icon2.setBounds(300,ItemCard.getHeight()-39,27,27);
        table_item_card.add(cart_icon2);

        JLabel table_price_label = new JLabel("$189");
        table_price_label.setBounds(250, table_item_card.getHeight()-39, 80,25);
        table_price_label.setFont(new Font("Serif", Font.PLAIN, 20));
        table_item_card.add(table_price_label);
        //-------------------------------------------------------------------------------
        JPanel couch_item_card = new JPanel();
        couch_item_card.setLayout(null);
        //ItemCard2.setBorder(new LineBorder(Color.lightGray, 3));
        couch_item_card.setSize(350,350);
        couch_item_card.setLocation(770, 350);
        //couch_item_card.setOpaque(false);
        couch_item_card.setBackground(Color.white);
        //p2.setOpaque(true);
        main_panel.add(couch_item_card);
        BufferedImage couch_item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\couches\\couch2.jpg"));
        BackgroundPanel couch_item_background = new BackgroundPanel(couch_item_img, BackgroundPanel.SCALED, 0f, 0f);
        couch_item_background.setBounds(0, 0, couch_item_card.getWidth(), couch_item_card.getHeight()-50);
        couch_item_card.add(couch_item_background);
        JLabel couch_label = new JLabel("Couch");
        couch_label.setBounds(30, couch_item_card.getHeight()-39, 80,25);
        couch_label.setFont(new Font("Serif", Font.PLAIN, 20));
        couch_item_card.add(couch_label);
        BackgroundPanel cart_icon3 = new BackgroundPanel(cart_img, BackgroundPanel.SCALED, 0f, 0f);
        cart_icon3.setBackground(Color.white);
        cart_icon3.setBounds(300,ItemCard.getHeight()-39,27,27);
        couch_item_card.add(cart_icon3);

        JLabel couch_price_label = new JLabel("$3,750");
        couch_price_label.setBounds(235, couch_item_card.getHeight()-39, 80,25);
        couch_price_label.setFont(new Font("Serif", Font.PLAIN, 20));
        couch_item_card.add(couch_price_label);
        //-------------------------------------------------------------------------------
        JPanel bed_item_card = new JPanel();
        bed_item_card.setLayout(null);
        //ItemCard2.setBorder(new LineBorder(Color.lightGray, 3));
        bed_item_card.setSize(350,350);
        bed_item_card.setLocation(1180 -50, 350);
        //bed_item_card.setOpaque(false);
        bed_item_card.setBackground(Color.white);
        //p2.setOpaque(true);
        main_panel.add(bed_item_card);
        BufferedImage bed_item_img = ImageIO.read(new File("C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\images\\products\\beds\\bed2.png"));
        BackgroundPanel bed_item_background = new BackgroundPanel(bed_item_img, BackgroundPanel.SCALED, 0f, 0f);
        bed_item_background.setBounds(0, 0, bed_item_card.getWidth(), bed_item_card.getHeight()-50);
        bed_item_card.add(bed_item_background);
        JLabel bed_label = new JLabel("Bed");
        bed_label.setBounds(30, bed_item_card.getHeight()-39, 80,25);
        bed_label.setFont(new Font("Serif", Font.PLAIN, 20));
        bed_item_card.add(bed_label);
        BackgroundPanel cart_icon4 = new BackgroundPanel(cart_img, BackgroundPanel.SCALED, 0f, 0f);
        cart_icon4.setBackground(Color.white);
        cart_icon4.setBounds(300,ItemCard.getHeight()-39,27,27);
        bed_item_card.add(cart_icon4);

        JLabel bed_price_label = new JLabel("$226");
        bed_price_label.setBounds(250, bed_item_card.getHeight()-39, 80,25);
        bed_price_label.setFont(new Font("Serif", Font.PLAIN, 20));
        bed_item_card.add(bed_price_label);
//        main_panel.setSize(1541,800);
//        main_panel.setSize(1540,800);
        //-------------------------------------------------------------------------------

    }

//

//    private static Object supplyPanel(Object o) {
//    }

//    private static Object supplyPanel(final int panelIndex) {
//        JPanel cart_item_panel = new JPanel();
//        cart_item_panel.setBounds(10,10, 200,200);
//        cart_item_panel.setBackground(Color.red);
//        cart_item_panel.setLayout(null);
//        return cart_item_panel;
//    }


class PanelRenderer implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList comp, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JPanel renderer = (JPanel) value;
            //renderer.setBackground(isSelected ? Color.red : list.getBackground());
            //renderer.setBackground(Color.red);
            //list.getComponent(index).getX();
//            int index_two = list.getLastVisibleIndex();
//            if(index != 0){
//                JPanel temp_item = (JPanel) list.getModel().getElementAt(index-1);
//                renderer.setLocation(temp_item.getWidth() + 20, temp_item.getHeight() + 20);
//            }
            //renderer.setBorder(new LineBorder(Color.white, 10));
            ((JPanel) value).setBorder(new LineBorder(Color.white, 10));
//            //renderer.setBounds();
//            return renderer;
            //setEnabled(comp.isEnabled());
            renderer.setFont(comp.getFont());
            //renderer.setText(value.toString());
            renderer.setEnabled(comp.isEnabled());

//            if (isSelected)
//            {
//                renderer.setBackground(comp.getSelectionBackground());
//                renderer.setForeground(comp.getSelectionForeground());
//            }
//            else
//            {
//                renderer.setBackground(comp.getBackground());
//                renderer.setForeground(comp.getForeground());
//            }
            return renderer;
        }
    }

public void ShowItemList(ArrayList<JPanel> paneList, JPanel container) {


    DefaultListModel model = new DefaultListModel();


    //JPanel temp_panel = new JPanel();
    //temp_panel.setLayout(null);
    //temp_panel.setBounds(0,0,400,630);
    for (JPanel pane:paneList) {

        //model.addElement(pane);

        container.add(pane);
        container.revalidate();
        container.repaint();

    }
    JPanel test_panel = new JPanel();
    test_panel.setBounds(0,400,100,100);
    test_panel.setLayout(null);
    test_panel.setBackground(Color.black);
    container.add(test_panel);

    container.validate();
    container.revalidate();
    container.repaint();

    //cart_items.add(temp_panel);
    //container.add(temp_panel);

    //final JList list = new JList(model);
//    main_list = list;
//    list.setFixedCellHeight(100);
//    list.setFixedCellWidth(400);
//
//    list.setSelectedIndex(-1);

//    list.addMouseListener(new MouseListener() {
//        @Override
//        public void mouseClicked(MouseEvent e) {
//            ChairButton(e.getPoint());
//        }
//
//        @Override
//        public void mousePressed(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//
//        }
//
//        @Override
//        public void mouseExited(MouseEvent e) {
//
//        }
//    });

    //list.setCellRenderer(new PanelRenderer());
//    JScrollPane scroll1 = new JScrollPane(container);
//    final JScrollBar scrollBar = scroll1.getVerticalScrollBar();
//    scrollBar.addAdjustmentListener(new AdjustmentListener() {
//        @Override
//        public void adjustmentValueChanged(AdjustmentEvent e) {
//            System.out.println("JScrollBar's current value = " + scrollBar.getValue());
//        }
//    });


    //container.add(scroll1);


}
    private static JPanel supplyPanel(Object panel) {
        JPanel cart_item_panel = new JPanel();
        cart_item_panel.setBounds(10,10, 200,200);
        cart_item_panel.setBackground(Color.red);
        cart_item_panel.setLayout(null);
        return cart_item_panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(cart_item_panel.size() > 0) {
            for (int i = 0; i < cart_item_panel.size(); i++) {
//                    ArrayList<Object> temp_array = new ArrayList<Object>();
//                    temp_array = cart_item_panel.get(i).getComponents();
//                    for(int j = 0; j < temp_array.length; j++){
//                        if(temp_array.)
//                    }
                for (Component c : cart_item_panel.get(i).getComponents()) {
                    if (c instanceof JLabel) {
                        if (Objects.equals(((JLabel) c).getText(), "-")) {
                            if(e.getSource() == c){
                                System.out.println("IM HERE FUCKERS");
                                cart_items_counter--;
                                //cart_label.setText("Cart (" + cart_items_counter +")");
                                furniture_manger.buyChair();
                                furniture_manger.displayStock();
                                cart_items_counter_two.set(0, cart_items_counter_two.get(0) - 1);
                            }
                            c.addMouseListener(new MouseListener() {
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
                            });
                        }
                    }
                }
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


    public void ChairButton(Point point){
        int index = main_list.locationToIndex(point);
        Component test = (Component) main_list.getModel().getElementAt(index);
        System.out.println(index);
        if(test instanceof JLabel){
            System.out.println("kosmk");
        }
        test.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("kosmk");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("kosmk");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("kosmk");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("kosmk");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("kosmk");
            }
        });
        //CartLabelButton temp_label = (CartLabelButton) main_list.getModel().getElementAt(index);
        //temp_label.getLabel().addMouseListener();
//        temp_label.getLabel().addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("KOSOMK");
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });

    }
}
