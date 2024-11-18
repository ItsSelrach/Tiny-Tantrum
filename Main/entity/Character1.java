package entity;

import java.awt.Graphics2D;
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
            leftImage = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character1-left(standing).png"));
            rightImage = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character1-right(standing).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage character1 = null;
        
        switch (direction) {
            case "left":
                character1 = leftA1;
                break;
            case "right":
                character1 = rightA1;
                break;
                
        }

        if (character1 != null) {
            g2.drawImage(character1, x, y, null);
        }
    }

}