import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Cache {
    BufferedImage img;

    public Cache() throws IOException {
        //img = ImageIO.read(new File("C:\\D Drive\\img1.jpg"));
    }

    public void LoadCache() throws IOException {
        img = ImageIO.read(new File("C:\\D Drive\\img1.jpg"));
    }


}
