package q3_LucasRangel;

import java.awt.Color;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class RGB {
    public static final int ValorAumentado = 15;
    public static void main (String [] args) {
        String filepath = "";
        File file = new File(filepath);
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            for (int i = 0; i < width ; i++) {
                for(int j = 0; j < height ; j++) {
                    Color c = new Color (image.getRGB(i , j));
                    int cred = (c.getRed() + ValorAumentado <= 255) ? c.getRed() + ValorAumentado : 255;
                    int cblue = (c.getBlue() + ValorAumentado <= 255) ? c.getBlue() + ValorAumentado : 255;
                    int cgreen = (c.getGreen() + ValorAumentado <= 255) ? c.getGreen() + ValorAumentado : 255;
                    image.setRGB(i, j, new Color (cred, cgreen, cblue).getRGB());
                }
            }
            ImageIO.write(image, "jpg", file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}