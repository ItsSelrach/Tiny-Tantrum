package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import game.GamePanel;
import game.KeybInput;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent; 

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

    Character1 player1 = new Character1();
    Character2 player2 = new Character2();

        public CharacterMovement(GamePanel gamePanel, KeybInput keyIn) {
            this.gamePanel = gamePanel;
            this.keyIn = keyIn;
            activePlayer = player1; // Set player1 as the initial active player
        
            setDefaultValues();
            setMovable();
            getPlayerImage();
        }

        public void CharacterMoving(Character1 player1, Character2 player2){
            this.player1 = player1;
            this.player2 = player2;
        }
             
        private void setMovable() {
            activePlayer = player1; //default player moving
            if(activePlayer != player1){
                activePlayer = player2;
            }
        }
            
        public void moveLeft() {
            activePlayer.x -= speed; // Move left
            direction = "left";
        }
    
        public void moveRight() {
            activePlayer.x += speed; // Move right
            direction = "right";
        }
    
        public void jump() {
            if (!isJumping) {
                verticalVelocity = -jumpStrength; // Set the initial upward velocity
                isJumping = true; // Set the jumping state
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
    
        public void handleKeyPress(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    if (activePlayer == player1) {
                        moveLeft();
                    } else if (activePlayer == player2) {
                        moveLeft();
                    }
                    break;
                case KeyEvent.VK_D:
                    if (activePlayer == player1) {
                        moveRight();
                    } else if (activePlayer == player2) {
                        moveRight();
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if (activePlayer == player1) {
                        jump();
                    } else if (activePlayer == player2) {
                        jump();
                    }
                    break;
                case KeyEvent.VK_TAB:
                    toggleActivePlayer();
                    break;
            }
        }
    
        private void toggleActivePlayer() {
            if (activePlayer == player1) {
                activePlayer = player2; // Switch to player2
                setMovable();
            } else {
                activePlayer = player1; // Switch back to player1
                setMovable();
            }
        }

    public void update() {
        // Update the active player's position
        if (activePlayer == player1) {
            if (keyIn.aPressed) {
                moveLeft();
            }

            if (keyIn.dPressed) {
                moveRight();
            }

            if (keyIn.spacePressed) {
                jump();
            }

            if (!keyIn.spacePressed) {
                fall();
            }
        } else if (activePlayer == player2) {
            // Implement movement for player2
            if (keyIn.aPressed) {
                moveLeft();
            }

            if (keyIn.dPressed) {
                moveRight();
            }

            if (keyIn.spacePressed) {
                jump();
            }

            if (!keyIn.spacePressed) {
                fall();
            }
        }



       // Print player position for debugging
        System.out.println("Player1 position: (" + player1.x + ", " + player1.y + ")");
        System.out.println("Player2 position: (" + player2.x + ", " + player2.y + ")");
 }

    public void setDefaultValues() {
        player1.x = 100;
        player1.y = 300;
        player2.x = 200; 
        player2.y = 300;
        jumpStartY = player1.y; // Set the jump start position for player1
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
        BufferedImage character1 = null;
        BufferedImage character2 = null;
        
        switch (direction) {
            case "left":
                character1 = leftA1;
                break;
            case "right":
                character1 = rightA1;
                break;
                
        }
        
        switch (direction) {
            case "left":
                character2 = leftB1;
                break;
            case "right":
                character2 = rightB1;
                break;
        }
        if (character1 != null) {
            g2.drawImage(character1, player1.x, player1.y, gamePanel.gameTile, gamePanel.gameTile, null);
        }

        if (character2 != null) {
            g2.drawImage(character2, player2.x, player2.y, gamePanel.gameTile, gamePanel.gameTile, null);
        }
    }
}