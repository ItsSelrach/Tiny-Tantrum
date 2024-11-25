package entity;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Character1 extends Entity {
    public BufferedImage leftImage;
    public BufferedImage rightImage;
    public String direction = "right"; // Default direction

    public Character1() {
        this.x = 100; // Initial position
        this.y = 300; // Initial position
        loadImages(); // Load images during construction
    }

    private void loadImages() {
        try {
            leftA1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left1.png"));
            leftA2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left2.png"));
            leftA3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left3.png"));
            leftA4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left4.png"));
            leftA5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left5.png"));
            leftA6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left6.png"));

            rightA1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right1.png"));
            rightA2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right2.png"));
            rightA3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right3.png"));
            rightA4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right4.png"));
            rightA5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right5.png"));
            rightA6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}