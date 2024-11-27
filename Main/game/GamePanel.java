package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.CharacterMovement;
import game.level.LevelManager;


public class GamePanel extends JPanel implements Runnable{
        public int maxMap = 0;
        //set screen/object sizes
        final int setGameAssetSize = 64;
        final int assetScale = 1;
        public final int playerSizeX = 90;
        public final int playerSizeY = 64;
        private LevelManager levelManager;

        public final int gameTile = setGameAssetSize * assetScale;
        public int maxColumnSize = 16;
        public int maxRowSize = 28;
        final int gameScreenWdth = gameTile * maxColumnSize;
        final int gameScreenHgth = gameTile * maxRowSize;

    

        Color c =(Color.black);
        Thread gameThread;
        KeybInput keyIn = new KeybInput();
        CharacterMovement player1 = new CharacterMovement(this, keyIn);
        CharacterMovement player2 = new CharacterMovement(this, keyIn);

        //set player
        int player1X = 20;
        int player1Y = 20;
        int player1Speed = 5;
        
        

        int FPS = 60;

        //game panel
        public GamePanel() {

            initClasses();

            this.setPreferredSize(new Dimension(gameScreenWdth, gameScreenHgth));
            this.setBackground(c);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyIn);
            this.setFocusable(true);

        }
        public void startGameTread() {

            gameThread = new Thread(this);
            gameThread.start();
        }

        public void initClasses() {
            levelManager = new LevelManager(this);
        }

        //game loop
        @Override
        public void run() {

            double updateInterval = 1000000000/FPS;
            double remainingTime = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            long timer = 0;
            int updateCount = 0;
            


            while(gameThread != null) {

                currentTime = System.nanoTime();
                remainingTime += (currentTime - lastTime) / updateInterval;
                timer += (currentTime - lastTime);
                lastTime = currentTime;

                if (remainingTime >= 1) {
                    update();
                    repaint();
                    remainingTime--;
                }
                if (timer >= 1000000000){
                    System.out.println("FPS: " + updateCount);
                    updateCount = 0;
                    timer = 0;
                }
            }

        }
        
        public void update(){
            player1.update();
            player2.update();
            levelManager.update();
        }

        //player character
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            g.setColor(new Color(204, 255, 255)); // Set background color
            g.fillRect(0, 0, getWidth(), getHeight()); // Fill background

            levelManager.draw(g2);
            player1.draw(g2);
            player2.draw(g2);
            
            

        }
        
    }        


