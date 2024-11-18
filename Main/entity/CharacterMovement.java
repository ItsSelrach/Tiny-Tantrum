package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.KeybInput;
import java.awt.Graphics2D; 

public class CharacterMovement extends Entity {
    
    GamePanel gamePanel;
    KeybInput keyIn;

    private boolean isJumping = false;
    private int jumpStartY;
    private int speed = 5;
    private double verticalVelocity = 0; 
    private final double jumpStrength = 20;
    private final double gravity = 1;

    public Entity activePlayer;

    Character1 playerA = new Character1();
    Character2 playerB = new Character2();

        public CharacterMovement(GamePanel gamePanel, KeybInput keyIn) {
            this.gamePanel = gamePanel;
            this.keyIn = keyIn;
            activePlayer = playerA; // Set player1 as the initial active player
        
            setDefaultValues();
            getPlayerImage();
        }

        public void CharacterMoving(Character1 player1, Character2 player2){
            this.playerA = player1;
            this.playerB = player2;
        }
            
            
        public void moveLeft() {
            activePlayer.x -= speed; // Move left
            direction = "left";
            System.out.println("left");
        }
    
        public void moveRight() {
            activePlayer.x += speed; // Move right
            direction = "right";
            System.out.println("right");
        }
    
        public void jump() {
            if (!isJumping) {
                verticalVelocity = -jumpStrength; // Set the initial upward velocity
                isJumping = true; // Set the jumping state
                System.out.println("jump");
            }
        }
        
        public void fall() {
            if (isJumping) {
                // Apply vertical velocity to the y position
                activePlayer.y += verticalVelocity; 
        
                // Apply gravity to the vertical velocity
                verticalVelocity += gravity; 
        
                // Check if the character has landed
                if (activePlayer.y >= jumpStartY) {
                    activePlayer.y = jumpStartY; // Reset to ground level
                    isJumping = false; // Reset jumping state
                    verticalVelocity = 0; // Reset vertical velocity
                }
            }
        }

        public void changePlayer(){
            if (canSwitch) {
                if (activePlayer == playerA) {
                    activePlayer = playerB; // Switch to player2
                    System.out.println("Switched to Player 2");
                } else {
                    activePlayer = playerA; // Switch back to player1
                    System.out.println("Switched to Player 1");
                }
                canSwitch = false; // Set cooldown
            }
        }
        
        

public void update() {
    // Update the active player's position
    if (activePlayer == playerA) {
        if (keyIn.aPressed) {
            playerA.x -= speed; // Move Player 1 left
            playerA.direction = "left"; // Update direction
        }
        if (keyIn.dPressed) {
            playerA.x += speed; // Move Player 1 right
            playerA.direction = "right"; // Update direction
        }
        
        if (keyIn.spacePressed) {
            jump(); // Player 1 jumps
        }

        if (!keyIn.spacePressed) {
            fall(); // Apply gravity if not jumping
        }
        
        if (keyIn.shiftPressed) {
            changePlayer(); // Switch to Player 2
            System.out.println("Switched to Player 2");
        }
    } else if (activePlayer == playerB) {
        if (keyIn.aPressed) {
            playerB.x -= speed; // Move Player 2 left
            playerB.direction = "left"; // Update direction
        }
        if (keyIn.dPressed) {
            playerB.x += speed; // Move Player 2 right
            playerB.direction = "right"; // Update direction
        }

        if (keyIn.spacePressed) {
            jump(); // Player 2 jumps
        }

        if (!keyIn.spacePressed) {
            fall(); // Apply gravity if not jumping
        }
        
        if (keyIn.shiftPressed) {
            changePlayer(); // Switch to Player 1
            System.out.println("Switched to Player 1");
        }
    }
}

       // Print player position for debugging
       // System.out.println("Player1 position: (" + player1.x + ", " + player1.y + ")");
       // System.out.println("Player2 position: (" + player2.x + ", " + player2.y + ")");
       // System.out.println("active player "+ activePlayer);

    public void setDefaultValues() {
        playerA.x = 100;
        playerA.y = 300;
        playerB.x = 200; 
        playerB.y = 300;
        jumpStartY = activePlayer.y; // Set the jump start position for activeplayer
        direction = "left"; // Default direction
    }

    public void getPlayerImage() {
        try {
            //player1
            leftA1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character1-left(standing).png"));
            rightA1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character1-right(standing).png"));

            //plyer2
            leftB1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character2-left(standing).png"));
            rightB1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/character2-right(standing).png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2) {
        // Draw Player 1
        BufferedImage player1Image = null; 
        switch (playerA.direction) {
            case "left":
                player1Image = leftA1;
                break;
            case "right":
                player1Image = rightA1; 
                break;
        }
        if (player1Image != null) {
            g2.drawImage(player1Image, playerA.x, playerA.y, gamePanel.gameTile, gamePanel.gameTile, null);
        }
    
        // Draw Player 2
        BufferedImage player2Image = null;
        switch (playerB.direction) {
            case "left":
                player2Image = leftB1;
                break;
            case "right":
                player2Image = rightB1;
                break;
        }
        if (player2Image != null) {
            g2.drawImage(player2Image, playerB.x, playerB.y, gamePanel.gameTile, gamePanel.gameTile, null);
        }
    }

    
}