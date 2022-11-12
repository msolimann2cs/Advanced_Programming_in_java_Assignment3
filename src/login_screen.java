import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import java.awt.*;

import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class login_screen extends JFrame implements ActionListener, KeyListener{
//    JLabel label;
//    JButton b1;
//    JLabel l1;
//    JPanel panel1;
    AccountManager account_manager = new AccountManager();
    Cache cache = new Cache();

    login_screen () throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1540,800);
        this.setLayout (null);
        //this.setLayout(new BorderLayout());
        //Container content_pane = this.getContentPane();
        //content_pane.setLayout(new BorderLayout());
        //this.getContentPane().setBackground(Color.black);
        BufferedImage img = ImageIO.read(new File("C:\\D Drive\\img1.jpg"));
        BackgroundPanel background_panel = new BackgroundPanel(img, BackgroundPanel.SCALED, 0f, 0f);
        //GradientPaint paint = new GradientPaint(0, 0, Color.BLUE, 600, 0, Color.RED);
        //background_panel.setPaint(paint);
        //content_pane.add(background_panel);
        background_panel.setLayout(null);
        this.setContentPane(background_panel);
        //this.add(background_panel);
        this.setVisible(true);

        //---------------------------------------------------------------------------------
        JPanel main_panel = new JPanel();
        main_panel.setLayout(null);
        //main_panel.setBorder(new LineBorder(Color.black, 3));
        main_panel.setSize(1540,800);
        main_panel.setLocation(0, 0);
        main_panel.setBackground(Color.red);
        main_panel.setOpaque(true);
        background_panel.add(main_panel);
        //----------------------------------------------------------------------------------

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        //p2.setBorder(new LineBorder(Color.lightGray, 3));
        p2.setSize(450,350);
        p2.setLocation((main_panel.getWidth()/2)-(p2.getWidth()/2), (main_panel.getHeight()/2)-(p2.getHeight()/2));
        //p2.setBackground(Color.white);
        p2.setBackground(new Color(255,255,255,190));
        //p2.setOpaque(true);
        main_panel.add(p2);

        JLabel welcome_label = new JLabel("Welcome to iFurnex");
        welcome_label.setBounds(p2.getX()+50, p2.getY()-80, 400,40);
        welcome_label.setFont(new Font("Serif", Font.BOLD, 40));
        Font welcome_label_font = welcome_label.getFont();
        welcome_label_font = welcome_label_font.deriveFont(Collections.singletonMap(
                TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRABOLD));
        welcome_label.setFont(welcome_label_font);
        welcome_label.setForeground(Color.black);
        main_panel.add(welcome_label);

        //----------------------------------------------------------------------------------
        JLabel email_label = new JLabel("Your email");
        email_label.setBounds(30, 25, 80,25);
        email_label.setFont(new Font("Serif", Font.PLAIN, 17));
        p2.add(email_label);

        JTextField email_field = new JTextField(20);
        email_field.setBorder(new LineBorder(Color.black, 2));
        email_field.setBounds(30,email_label.getY()+40,p2.getWidth()-60,45);
        p2.add(email_field);

        JLabel password_label = new JLabel("Your password");
        password_label.setBounds(30, email_field.getY()+60, 150,25);
        password_label.setFont(new Font("Serif", Font.PLAIN, 17));
        p2.add(password_label);
        //p2.revalidate();
        p2.setSize(450,349);
        p2.setSize(450,350);
        JPasswordField password_field = new JPasswordField(20);
        password_field.setBorder(new LineBorder(Color.black, 2));
        password_field.setBounds(30,password_label.getY()+40,p2.getWidth()-60,45);
        p2.add(password_field);

        JButton sign_in_button = new JButton("Sign in");
        sign_in_button.setBackground(new Color(
                0,192,0));
        sign_in_button.setForeground(Color.white);
        sign_in_button.setFont(new Font("Serif", Font.PLAIN, 17));
        //sign_in_button.setBorder(new LineBorder(Color.black, 2));
        sign_in_button.setBounds(60, password_field.getY()+75, p2.getWidth()-120, 45);
        //sign_in_button.setBorder(new RoundedBorder(30));
        p2.add(sign_in_button);
        p2.setSize(450,349);
        p2.setSize(450,350);

        JLabel create_account_label = new JLabel("Don't have an account?");
        create_account_label.setBounds(45, sign_in_button.getY()+63, 180,25);
        create_account_label.setFont(new Font("Serif", Font.PLAIN, 17));
        create_account_label.setForeground(Color.blue);
        p2.add(create_account_label);

        JLabel forgot_password_label = new JLabel("Forgot password?");
        forgot_password_label.setBounds(create_account_label.getWidth()+100, sign_in_button.getY()+63, 150,25);
        forgot_password_label.setFont(new Font("Serif", Font.PLAIN, 17));
        forgot_password_label.setForeground(Color.blue);
        p2.add(forgot_password_label);

        sign_in_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email_field_value = email_field.getText();
                String password_field_value = String.valueOf(password_field.getPassword());
                System.out.println(email_field_value);
                System.out.println(password_field_value);
                Account user = new Account();
                try {
                    user = account_manager.ValidateUser(email_field_value, password_field_value);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if(user != null){
                    try {
                        setVisible(false);
                        dispose();
                        new main_screen(img);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    System.out.println("error");
                }
            }
        });

        password_field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    String email_field_value = email_field.getText();
                    String password_field_value = String.valueOf(password_field.getPassword());
                    System.out.println(email_field_value);
                    System.out.println(password_field_value);
                    Account user = new Account();
                    try {
                        user = account_manager.ValidateUser(email_field_value, password_field_value);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(user != null){
                        try {
                            setVisible(false);
                            dispose();
                            new main_screen(img);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    else{
                        System.out.println("error");
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        //p2.revalidate();
        //----------------------------------------------------------------------------------
        //background_panel.add(main_panel, BorderLayout.CENTER);
        //background_panel.add(main_panel);
//        l1=new JLabel("Here is a button");
//        l1.setForeground(Color.white);
//        l1.setFont(new Font("Serif", Font.PLAIN, 50));
//        l1.setBackground(Color.green);
//        //l1.setBounds(0,0,200,20);
//        l1.setLocation(0,0);
//        main_panel.add(l1);
        //b1=new JButton("I am a button");
//        label = new JLabel();
//        //label.setFont(new Font("Serif", Font.PLAIN, 50));
//        //label.setForeground(Color.white);
//        label.setBounds(0, 0, 20, 20);
//        label.setBackground(Color.white);
//        label.setOpaque(true);
        //background_panel.add(l1);

        //background_panel.add(label);
        //background_panel.add(b1);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
