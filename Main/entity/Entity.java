package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    
    public int x;
    public int y;
    public int x1, y1, x2, y2;
    public int speed;
    public int jump;
    public int jumpSpeed;
    public int jumping;

    public BufferedImage leftA1, leftA2, leftA3, leftA4, leftA5, leftA6, rightA1, rightA2, rightA3, rightA4, rightA5, rightA6, leftB1, leftB2, leftB3, leftB4, leftB5, leftB6, rightB1, rightB2, rightB3, rightB4, rightB5, rightB6;
    public String direction;
    public boolean canSwitch;
    public String moveable;

    public Rectangle playerACollision;
    public Rectangle playerBCollision;
    
    public boolean collisionOn = false;
    public int spritCounter = 0;
    public int spriteNum = 1;

    public void paintComponent(Graphics g) {
    
    }
    public void moveLeft() {

    }
    public void moveRight() {

    }
    public void jump() {

    }

}