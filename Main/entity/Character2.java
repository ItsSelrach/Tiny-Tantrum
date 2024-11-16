package entity;

import java.awt.Graphics2D;
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
            leftImage = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character2-left(standing).png"));
            rightImage = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character2-right(standing).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage character2 = null;

        switch (direction) {
            case "left":
                character2 = leftB1;
                break;
            case "right":
                character2 = rightB1;
                break;
        }

        if (character2 != null) {
            g2.drawImage(character2, x, y, null);
        }
    }
}