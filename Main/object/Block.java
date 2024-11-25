package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;

import game.GamePanel;

public class Block {
    BufferedImage leveltile;

    GamePanel gamePanel;
    Tile[] tile;


    //image loader
    public void GameTiles() {
        try {
            leveltile = ImageIO.read(new File("src/level/level-tiles.png)"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SubImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = leveltile.getSubimage(0, 63,64,64);

            tile[1] = new Tile();
            tile[1].image = leveltile.getSubimage(64, 127, 64, 64);

            tile[2] = new Tile();
            tile[2].image = leveltile.getSubimage(128, 191, 64, 64);

            tile[3] = new Tile();
            tile[3].image = leveltile.getSubimage(192, 255, 64, 64);

            tile[4] = new Tile();
            tile[4].image = leveltile.getSubimage(256, 319, 64, 64);

            tile[5] = new Tile();
            tile[5].image = leveltile.getSubimage(0, 127, 64, 64);

            tile[6] = new Tile();
            tile[6].image = leveltile.getSubimage(64, 127, 64, 64);

            tile[7] = new Tile();
            tile[7].image = leveltile.getSubimage(128, 127, 64, 64);

            tile[8] = new Tile();
            tile[8].image = leveltile.getSubimage(192, 127, 64, 64);

            tile[9] = new Tile();
            tile[9].image = leveltile.getSubimage(256, 127, 64, 64);

            tile[10] = new Tile();
            tile[10].image = leveltile.getSubimage(0, 127, 64, 64);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
}   

    public void draw(Graphics2D g2) { 

        g2.drawImage(tile[0].image, 0, 0, gamePanel.gameTile, gamePanel.gameTile, null);
    }
    
}
