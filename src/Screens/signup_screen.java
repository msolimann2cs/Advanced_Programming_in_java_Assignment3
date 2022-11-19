package Screens;

import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import javax.mail.*;

import Components.BackgroundPanel;
import Managers.AccountManager;
import Users.Account;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup_screen extends JFrame implements ActionListener, KeyListener{
    //    JLabel label;
//    JButton b1;
//    JLabel l1;
//    JPanel panel1;
    AccountManager account_manager = new AccountManager();
    //Cache cache = new Cache();

    public signup_screen (BufferedImage bg_img) throws IOException {
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
        welcome_label.setBounds(p2.getX()+85, p2.getY()-80, 400,40);
        welcome_label.setFont(new Font("Serif", Font.BOLD, 40));
        Font welcome_label_font = welcome_label.getFont();
        welcome_label_font = welcome_label_font.deriveFont(Collections.singletonMap(
                TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRABOLD));
        welcome_label.setFont(welcome_label_font);
        welcome_label.setForeground(Color.black);
        main_panel.add(welcome_label);

        //----------------------------------------------------------------------------------
        JLabel email_label = new JLabel("Email");
        email_label.setBounds(30, 25, 80,25);
        email_label.setFont(new Font("Serif", Font.PLAIN, 17));
        p2.add(email_label);

        JTextField email_field = new JTextField(20);
        //email_field.setBorder(new LineBorder(Color.black, 2));
        email_field.setBounds(30,email_label.getY()+40,p2.getWidth()-60,45);
        //email_field.requestFocus(false);
        email_field.setBorder(new LineBorder(new Color(
                0,192,0), 2));
        //email_field.requestFocus();
        email_field.setFocusTraversalKeysEnabled(false);
        p2.add(email_field);





        JLabel password_label = new JLabel("Password");
        password_label.setBounds(30, email_field.getY()+60, 150,25);
        password_label.setFont(new Font("Serif", Font.PLAIN, 17));
        p2.add(password_label);
        //p2.revalidate();
        p2.setSize(450,349);
        p2.setSize(450,350);
        JPasswordField password_field = new JPasswordField(20);
        password_field.setBorder(new LineBorder(Color.black, 2));
        password_field.setBounds(30,password_label.getY()+40,p2.getWidth()-60,45);
        password_field.setFocusTraversalKeysEnabled(false);
        p2.add(password_field);

        email_field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email_field.setBorder(new LineBorder(new Color(
                        0,192,0), 2));
                password_field.setBorder(new LineBorder(Color.black, 2));
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
        password_field.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                email_field.setBorder(new LineBorder(Color.black, 2));
                password_field.setBorder(new LineBorder(new Color(
                        0,192,0), 2));
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

        JButton sign_in_button = new JButton("Sign Up");
        sign_in_button.setBackground(new Color(
                0,192,0));
        sign_in_button.setForeground(Color.white);
        sign_in_button.setFont(new Font("Serif", Font.PLAIN, 17));
        //sign_in_button.setBorder(new LineBorder(Color.black, 2));
        sign_in_button.setBounds(60, password_field.getY()+75, p2.getWidth()-120, 45);
        sign_in_button.setFocusTraversalKeysEnabled(false);
        //sign_in_button.setBorder(new RoundedBorder(30));
        p2.add(sign_in_button);
        p2.setSize(450,349);
        p2.setSize(450,350);

        JLabel create_account_label = new JLabel("Sign in?");
        create_account_label.setBounds(45, sign_in_button.getY()+63, 180,25);
        create_account_label.setFont(new Font("Serif", Font.PLAIN, 17));
        create_account_label.setForeground(Color.blue);
//        create_account_label.setBackground(new Color(0,0,0,0));
//        create_account_label.setOpaque(true);

        p2.add(create_account_label);

        create_account_label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                try {
                    new login_screen(bg_img);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
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
                setVisible(false);
                dispose();
                try {
                    new reset_password_screen(bg_img);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
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
                String password_field_value = String.valueOf(password_field.getPassword());
//                System.out.println(email_field_value);
//                System.out.println(password_field_value);

                Account user = new Account();
                boolean isEmpty = true;
                boolean isEmail = false;
                if(!email_field_value.isEmpty() && !password_field_value.isEmpty()){
                    isEmpty = false;
                    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
                    Pattern pattern = Pattern.compile(regexPattern);
                    Matcher matcher = pattern.matcher(email_field_value);
                    if(matcher.matches()){
                        isEmail = true;
                    }
                    else{
                        email_field.setBorder(new LineBorder(Color.red, 2));
                        password_field.setBorder(new LineBorder(Color.red, 2));
                    }
                }
                else
                {
                    email_field.setBorder(new LineBorder(Color.red, 2));
                    password_field.setBorder(new LineBorder(Color.red, 2));
                }




                try {
                    //&& !isEmpty &&isEmail
                    if(!account_manager.userExists(email_field_value, password_field_value) && !isEmpty &&isEmail){
                        user.setEmail(email_field_value);
                        user.setPassword(password_field_value);
                        user.setAccount_type("user");
                        int verification_code = generateCode();
                        sendConfirmation(email_field_value, verification_code);
                        setVisible(false);
                        try {
                            new email_confirmation_screen(bg_img, user, verification_code);
                            dispose();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
                    password_field.requestFocus();
                    password_field.setBorder(new LineBorder(new Color(
                            0,192,0), 2));

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        password_field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_TAB){
                    password_field.setBorder(new LineBorder(Color.black, 2));
                    sign_in_button.requestFocus();
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    String email_field_value = email_field.getText();
                    String password_field_value = String.valueOf(password_field.getPassword());
//                System.out.println(email_field_value);
//                System.out.println(password_field_value);
                    Account user = new Account();
                    try {
                        if(!account_manager.userExists(email_field_value, password_field_value)){
                            user.setEmail(email_field_value);
                            user.setPassword(password_field_value);
                            user.setAccount_type("user");
                            int verification_code = generateCode();
                            sendConfirmation(email_field_value,verification_code);
                            setVisible(false);
                            try {
                                new email_confirmation_screen(bg_img, user, verification_code);
                                dispose();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

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
                password_field.setBorder(new LineBorder(Color.black, 2));
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
                    password_field.setBorder(new LineBorder(Color.black, 2));
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

    int generateCode(){
        Random rand = new Random();
        int code = rand.nextInt(99999) + 10000;
        return code;
    }
    void sendConfirmation(String email ,int verification_code){
//        System.out.println("SimpleEmail Start");
//
//        String smtpHostServer = "smtp.example.com";
//        String emailID = "email_me@example.com";
//
//        Properties props = System.getProperties();
//
//        props.put("mail.smtp.host", smtpHostServer);
//
//        Session session = Session.getInstance(props, null);
//
//        //EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");
        // Recipient's email ID needs to be mentioned.
//        String to = "haruyukari2@gmail.com";
//
//        // Sender's email ID needs to be mentioned
//        String from = "m.solimann2@gmail.com";
//
//        // Assuming you are sending email from localhost
//        String host = "localhost";
//
//        // Get system properties
//        Properties properties = System.getProperties();
//
//        // Setup mail server
//        properties.setProperty("mail.smtp.host", host);
//
//        // Get the default Session object.
//        Session session = Session.getDefaultInstance(properties);
//
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            // Set Subject: header field
//            message.setSubject("This is the Subject Line!");
//
//            // Now set the actual message
//            message.setText("This is actual message");
//
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }

        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "haruderemail1@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("haruderemail1@gmail.com", "byetgaifrnntmmin");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("iFurnex Email Verification");

            // Now set the actual message
            message.setText("Thanks for signing up for an account on iFurnex!\nplease confirm your email address by typing this code "+ verification_code + " in the application");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }



    }
}
