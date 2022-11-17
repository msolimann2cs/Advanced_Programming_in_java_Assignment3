import Screens.login_screen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        BufferedImage img = ImageIO.read(new File("C:\\D Drive\\img1.jpg"));
//        AccountManager account_manager = new AccountManager();
//        account_manager.LoadAccounts();
        new login_screen(img);
    }
}