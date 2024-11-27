package game.level;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.GamePanel;
import game.LoadSave;

public class LevelManager {
    
    private GamePanel gamePanel;
    private BufferedImage levelSprite;

    public LevelManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        levelSprite = LoadSave.GetSpriteAtlas(LoadSave.LEVEL_ATLAS);
    }

    public void draw(Graphics g) {
        g.drawImage(levelSprite, 0, 0, null);
    }
    public void update() {

    }
}
