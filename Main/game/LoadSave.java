package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadSave {
    
    public static final String LEVEL_ATLAS = "level-tiles.png";
    public static final String LEVEL_ONE_DATA = "level-one-data.png";

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        // Use relative path for resources
        File file = new File("C:/Users/User/Desktop/Tiny Tantrum/src/level/" + fileName);
    
        try {
            // Read the image directly from the file
            img = ImageIO.read(file);
            if (img == null) {
                System.err.println("Image not found or could not be read: " + file.getPath());
                return null; // Handle the case where the image could not be read
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return img;
    }

    public static int[][]GetLevelData () {
        int[][] lvlData = new int[GamePanel.setGameAssetSize][GamePanel.setGameAssetSize];
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);

        for (int j = 0 ; j < img.getHeight(); j++ )
        for (int i = 0 ; i < img.getWidth(); i++ ) {
        Color color = new Color(img.getRGB(i, j));
        int value = color.getRed();
        if (value >= 20) {
            value =0;
        }
        lvlData[j][i] = color.getRed();
        }
        return lvlData;
    }
}