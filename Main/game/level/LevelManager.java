package game.level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.GamePanel;
import game.LoadSave;

public class LevelManager {
    
    private GamePanel gamePanel;
    private BufferedImage[] levelSprite;
    private Level levelOne;

    public LevelManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        importLevelTiles();
        levelOne = new Level(LoadSave.GetLevelData());
    }

    private void importLevelTiles() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[25];
        for ( int j = 0;j < 4; j++)
            for(int i = 0; i < 5; i++) {
                int index = j * 5 + i;
                levelSprite[index] = img.getSubimage(i * 64, j * 64, 64, 64);
            }
        }
        

    public void draw(Graphics g) {
    for(int j = 0; j < GamePanel.gameScreenHgth; j++) {
        for (int i = 0; i < GamePanel.gameScreenWdth; i++) {
            int index = levelOne.getSpriteIndex(i, j);
            if (index >= 0 && index < levelSprite.length) {
                g.drawImage(levelSprite[index], GamePanel.gameTile * i, GamePanel.gameTile * j, GamePanel.gameTile, GamePanel.gameTile, null);
            }
        }
    }
}
    public void update() {

    }
}
