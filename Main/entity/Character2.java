package entity;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Character2 extends Entity {
    public BufferedImage leftImage;
    public BufferedImage rightImage;
    public String direction = "right"; // Default direction

    public Character2() {
        
        this.x = 200; // Initial position
        this.y = 300; // Initial position
        loadImages(); // Load images during construction
        
    }

    private void loadImages() {
        try {
            leftB1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left1.png"));
            leftB2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left2.png"));
            leftB3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left3.png"));
            leftB4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left4.png"));
            leftB5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left5.png"));
            leftB6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left6.png"));

            rightB1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right1.png"));
            rightB2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right2.png"));
            rightB3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right3.png"));
            rightB4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right4.png"));
            rightB5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right5.png"));
            rightB6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}