package Screens;

import Components.BackgroundPanel;
import Managers.AccountManager;
import Users.Account;

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

public class email_confirmation_screen extends JFrame implements ActionListener, KeyListener{
    //    JLabel label;
//    JButton b1;
//    JLabel l1;
//    JPanel panel1;
    AccountManager account_manager = new AccountManager();
    //Cache cache = new Cache();

    public email_confirmation_screen (BufferedImage bg_img, Account user, int verification_code) throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1540,800);
        this.setLayout (null);
        //this.setLayout(new BorderLayout());
        //Container content_pane = this.getContentPane();
        //content_pane.setLayout(new BorderLayout());
        //this.getContentPane().setBackground(Color.black);
        //BufferedImage img = ImageIO.read(new File("C:\\D Drive\\img1.jpg"));
        BackgroundPanel background_panel = new BackgroundPanel(bg_img, BackgroundPanel.SCALED, 0f, 0f);
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

        JLabel welcome_label = new JLabel("Create Account");
        welcome_label.setBounds(p2.getX()+50, p2.getY()-80, 400,40);
        welcome_label.setFont(new Font("Serif", Font.BOLD, 40));
        Font welcome_label_font = welcome_label.getFont();
        welcome_label_font = welcome_label_font.deriveFont(Collections.singletonMap(
                TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRABOLD));
        welcome_label.setFont(welcome_label_font);
        welcome_label.setForeground(Color.black);
        main_panel.add(welcome_label);

        //----------------------------------------------------------------------------------
        JLabel email_label = new JLabel("<HTML><p> An email with a verification code was just sent to <br> " + user.getEmail() + "</p></HTML> ");
        email_label.setBounds(30, 25, 400,50);
        email_label.setFont(new Font("Serif", Font.PLAIN, 17));
        p2.add(email_label);

        JTextField email_field = new JTextField("Enter Code");
        //email_field.setBorder(new LineBorder(Color.black, 2));
        email_field.setBounds(30,email_label.getY()+60,p2.getWidth()-60,45);
        //email_field.requestFocus(false);
        email_field.setBorder(new LineBorder(new Color(
                0,192,0), 2));
        //email_field.requestFocus();
        email_field.setFocusTraversalKeysEnabled(false);
        p2.add(email_field);





//        JLabel password_label = new JLabel("password");
//        password_label.setBounds(30, email_field.getY()+60, 150,25);
//        password_label.setFont(new Font("Serif", Font.PLAIN, 17));
//        p2.add(password_label);
//        //p2.revalidate();
//        p2.setSize(450,349);
//        p2.setSize(450,350);
//        JPasswordField password_field = new JPasswordField(20);
//        password_field.setBorder(new LineBorder(Color.black, 2));
//        password_field.setBounds(30,password_label.getY()+40,p2.getWidth()-60,45);
//        password_field.setFocusTraversalKeysEnabled(false);
//        p2.add(password_field);

        email_field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email_field.setBorder(new LineBorder(new Color(
                        0,192,0), 2));
               // password_field.setBorder(new LineBorder(Color.black, 2));
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
//        password_field.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                email_field.setBorder(new LineBorder(Color.black, 2));
//                password_field.setBorder(new LineBorder(new Color(
//                        0,192,0), 2));
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

        JButton sign_in_button = new JButton("Sign in");
        sign_in_button.setBackground(new Color(
                0,192,0));
        sign_in_button.setForeground(Color.white);
        sign_in_button.setFont(new Font("Serif", Font.PLAIN, 17));
        //sign_in_button.setBorder(new LineBorder(Color.black, 2));
        sign_in_button.setBounds(60, 200, p2.getWidth()-120, 45);
        sign_in_button.setFocusTraversalKeysEnabled(false);
        //sign_in_button.setBorder(new RoundedBorder(30));
        p2.add(sign_in_button);
        p2.setSize(450,349);
        p2.setSize(450,350);

        JLabel create_account_label = new JLabel("Don't have an account?");
        create_account_label.setBounds(45, sign_in_button.getY()+63, 180,25);
        create_account_label.setFont(new Font("Serif", Font.PLAIN, 17));
        create_account_label.setForeground(Color.blue);
//        create_account_label.setBackground(new Color(0,0,0,0));
//        create_account_label.setOpaque(true);

        p2.add(create_account_label);

        create_account_label.addMouseListener(new MouseListener() {
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
                //create_account_label.setBackground(new Color(255,255,255,190));
                create_account_label.setForeground(new Color(
                        0,192,0));
                main_panel.repaint();
                //p2.setBackground(new Color(0,255,255,190));
                //create_account_label.setOpaque(false);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //create_account_label.setBackground(new Color(255,255,255,190));
                create_account_label.setForeground(Color.blue);
                main_panel.repaint();
                //p2.setBackground(new Color(255,255,255,190));
                //create_account_label.setOpaque(false);

            }
        });

        JLabel forgot_password_label = new JLabel("Forgot password?");
        forgot_password_label.setBounds(create_account_label.getWidth()+100, sign_in_button.getY()+63, 150,25);
        forgot_password_label.setFont(new Font("Serif", Font.PLAIN, 17));
        forgot_password_label.setForeground(Color.blue);
        p2.add(forgot_password_label);

        forgot_password_label.addMouseListener(new MouseListener() {
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
                forgot_password_label.setForeground(new Color(
                        0,192,0));
                main_panel.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgot_password_label.setForeground(Color.blue);
                main_panel.repaint();
            }
        });

        sign_in_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email_field_value = email_field.getText();
                Integer code = verification_code;
                if(code.toString().equals(email_field_value)){
                    System.out.println("The code " + code + " is correct!!");
                    try {
                        account_manager.addUser(user.getEmail(), user.getPassword(), user.getAccount_type());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    System.out.println("The code " + email_field_value + " is incorrect!!");
                    System.out.println("The correct code is " + code);
                }

//                String password_field_value = String.valueOf(password_field.getPassword());
//                System.out.println(email_field_value);
//                System.out.println(password_field_value);
//                Account user = new Account();
//                try {
//                    user = account_manager.ValidateUser(email_field_value, password_field_value);
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//                if(user != null){
//                    try {
//                        setVisible(false);
//                        dispose();
//                        new main_screen(bg_img);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//                else{
//                    System.out.println("error");
//                }
            }
        });

        email_field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_TAB){
                    email_field.setBorder(new LineBorder(Color.black, 2));
                    email_field.requestFocus(false);
//                    password_field.requestFocus();
//                    password_field.setBorder(new LineBorder(new Color(
//                            0,192,0), 2));

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

//        password_field.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode() == KeyEvent.VK_TAB){
//                    password_field.setBorder(new LineBorder(Color.black, 2));
//                    sign_in_button.requestFocus();
//                }
//                if(e.getKeyCode() == KeyEvent.VK_ENTER)
//                {
//                    String email_field_value = email_field.getText();
//                    String password_field_value = String.valueOf(password_field.getPassword());
//                    System.out.println(email_field_value);
//                    System.out.println(password_field_value);
//                    Account user = new Account();
//                    try {
//                        user = account_manager.ValidateUser(email_field_value, password_field_value);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                    if(user != null){
//                        try {
//                            setVisible(false);
//                            dispose();
//                            new main_screen(bg_img);
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    }
//                    else{
//                        System.out.println("error");
//                    }
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });

        sign_in_button.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_TAB){
                    email_field.setBorder(new LineBorder(new Color(
                            0,192,0), 2));
                    email_field.requestFocus();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        main_panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email_field.setBorder(new LineBorder(Color.black, 2));
                //email_field.requestFocus(false);
                //password_field.setBorder(new LineBorder(Color.black, 2));
                //password_field.requestFocus(false);
                main_panel.requestFocus();
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
        main_panel.setFocusTraversalKeysEnabled(false);
        main_panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_TAB){
                    email_field.requestFocus();
                    email_field.setBorder(new LineBorder(new Color(
                            0,192,0), 2));
                    //password_field.setBorder(new LineBorder(Color.black, 2));
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
