package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Character1;

public class GamePanel extends JPanel implements Runnable{
        //set screen/object sizes
        final int setGameAssetSize = 64;
        final int assetScale = 1;

        public final int gameTile = setGameAssetSize * assetScale;
        final int maxColumnSize = 16;
        final int maxRowSize = 32;
        final int gameScreenWdth = gameTile * maxColumnSize;
        final int gameScreenHgth = gameTile * maxRowSize;

        Color c =(Color.black);
        Thread gameThread;
        KeybInput keyIn = new KeybInput();
        Character1 player1 = new Character1(this, keyIn);
        Character1 player2 = new Character1(this, keyIn);

        //set player
        int player1X = 20;
        int player1Y = 20;
        int player1Speed = 5;

        int FPS = 60;


        //game panel
        public GamePanel() {
            this.setPreferredSize(new Dimension(gameScreenHgth, gameScreenWdth));
            this.setBackground(c);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyIn);
            this.setFocusable(true);

        }
        public void startGameTread() {

            gameThread = new Thread(this);
            gameThread.start();
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
                    updateCount++;
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
        }

        //player character
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
        
            player1.draw(g2);
            player2.draw(g2);
            g.setColor(new Color(204, 255, 255)); // Set background color
            g.fillRect(0, 0, getWidth(), getHeight()); // Fill background
            player1.draw((Graphics2D) g); // Draw the player

        }
    }        


