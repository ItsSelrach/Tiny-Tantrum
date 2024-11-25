package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.KeybInput;

import java.awt.Graphics2D;
import java.awt.Rectangle; 

public class CharacterMovement extends Entity {
    
    GamePanel gamePanel;
    KeybInput keyIn;

    private boolean isJumpinga = false;
    private boolean isJumpingb = false;
    private int jumpStartYa;
    private int jumpStartYb;
    private int speed = 5;
    private double verticalVelocity = 0; 
    private final double gravity = 1;
    public int jumpStrength = 20;

    Character1 playerA = new Character1();
    Character2 playerB = new Character2();

        public CharacterMovement(GamePanel gamePanel, KeybInput keyIn) {
            this.gamePanel = gamePanel;
            this.keyIn = keyIn;
        
            setDefaultValues();
            getPlayerImage();

            playerACollision = new Rectangle();
            playerACollision.width =56;
            playerACollision.height = 53;

            playerBCollision = new Rectangle();
            playerBCollision.width =56;
            playerBCollision.height = 53;
        }

        public void CharacterMoving(Character1 player1, Character2 player2){
            this.playerA = player1;
            this.playerB = player2;
        }


public void update() {


    
    // Update the active player's position
        if (keyIn.aPressed) {
            playerA.x -= speed; // Move Player 1 left
            playerA.direction = "left"; // Update direction

        }
        if (keyIn.dPressed) {
            playerA.x += speed; // Move Player 1 right
            playerA.direction = "right"; // Update direction
        }
        
        if (keyIn.wPressed) {
            if (!isJumpinga) {
                verticalVelocity = -jumpStrength; // Set the initial upward velocity
                isJumpinga = true; // Set the jumping state
                System.out.println("jump");
            }
        }

        if (!keyIn.wPressed) {
            if (isJumpinga) {
                // Apply vertical velocity to the y position
                playerA.y += verticalVelocity; 
        
                // Apply gravity to the vertical velocity
                verticalVelocity += gravity; 
        
                // Check if the character has landed
                if (y >= jumpStartYa) {
                    playerA.y = jumpStartYa; // Reset to ground level
                    isJumpinga = false; // Reset jumping state
                    verticalVelocity = 0; // Reset vertical velocity
                }
            }
        }
    
        //player2
        if (keyIn.leftPressed) {
            playerB.x -= speed; // Move Player 2 left
            playerB.direction = "left"; // Update direction
        }
        if (keyIn.rightPressed) {
            playerB.x += speed; // Move Player 2 right
            playerB.direction = "right"; // Update direction
        }

        if (keyIn.upPressed) {
            if (!isJumpingb) {
                verticalVelocity = -jumpStrength; // Set the initial upward velocity
                isJumpingb = true; // Set the jumping state
                System.out.println("jump");
            }
        }
        if (!keyIn.upPressed) {
            if (isJumpingb) {
                // Apply vertical velocity to the y position
                playerB.y += verticalVelocity; 
        
                // Apply gravity to the vertical velocity
                verticalVelocity += gravity; 
        
                // Check if the character has landed
                if (y >= jumpStartYb) {
                    playerB.y = jumpStartYb; // Reset to ground level
                    isJumpingb = false; // Reset jumping state
                    verticalVelocity = 0; // Reset vertical velocity
                }
            }
        }    

    spritCounter ++;
    if (spritCounter > 10) {
        if (spriteNum ==1) {
            spriteNum = 2;
        } else 
        if (spriteNum ==2) {
            spriteNum = 3;
        } else
        if (spriteNum ==3) {
            spriteNum = 4;
        } else
        if (spriteNum ==4) {
            spriteNum = 5;
        } else
        if (spriteNum ==5) {
            spriteNum = 6; 
        } else
        if (spriteNum ==6) {
            spriteNum = 1;
        } 
    spritCounter = 0;

    }

}


       // Print player position for debugging
       // System.out.println("Player1 position: (" + player1.x + ", " + player1.y + ")");
       // System.out.println("Player2 position: (" + player2.x + ", " + player2.y + ")");
       // System.out.println("active player "+ playerA);

    public void setDefaultValues() {
        playerA.x = 100;
        playerA.y = 300;
        playerB.x = 200; 
        playerB.y = 300;
        jumpStartYa = playerA.y; // Set the jump start position for playerA
        jumpStartYb = playerB.y; // Set the jump start position for playerB
        direction = "left"; // Default direction
    }


    public void getPlayerImage() {
        try {
            //player1
            leftA1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left1.png"));
            leftA2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left2.png"));
            leftA3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left3.png"));
            leftA4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left4.png"));
            leftA5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left5.png"));
            leftA6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-left6.png"));

            rightA1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right1.png"));
            rightA2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right2.png"));
            rightA3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right3.png"));
            rightA4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right4.png"));
            rightA5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right5.png"));
            rightA6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerA-right6.png"));

            //plyer2
            leftB1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left1.png"));
            leftB2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left2.png"));
            leftB3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left3.png"));
            leftB4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left4.png"));
            leftB5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left5.png"));
            leftB6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-left6.png"));

            rightB1 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right1.png"));
            rightB2 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right2.png"));
            rightB3 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right3.png"));
            rightB4 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right4.png"));
            rightB5 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right5.png"));
            rightB6 = ImageIO.read(new File("C:/Users/User/Desktop/Tiny Tantrum/src/player1/playerB-right6.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public Rectangle getBoundsA() {
        return new Rectangle(playerA.x + 16, playerA.y + 8, playerACollision.width, playerACollision.height);
    }
    public Rectangle getBoundsRightA() {
        return new Rectangle(playerA.x + 16, playerA.y + 8, playerACollision.width, playerACollision.height);
    }
    public Rectangle getBoundsLeftA() {
        return new Rectangle(playerA.x + 16, playerA.y + 8, playerACollision.width, playerACollision.height);
    }
    public Rectangle getBoundsBottomA() {
        return new Rectangle(playerA.x + 16, playerA.y + 8, playerACollision.width, playerACollision.height);
    }

    public Rectangle getBoundsB() {
        return new Rectangle(playerB.x + 16, playerB.y + 8, playerACollision.width, playerACollision.height);
    }
    public Rectangle getBoundsRightB() {
        return new Rectangle(playerB.x + 16, playerB.y + 8, playerACollision.width, playerACollision.height);
    }
    public Rectangle getBoundsLeftB() {
        return new Rectangle(playerB.x + 16, playerB.y + 8, playerACollision.width, playerACollision.height);
    }
    public Rectangle getBoundsBottomB() {
        return new Rectangle(playerB.x + 16, playerB.y + 8, playerACollision.width, playerACollision.height);
    }

    public void Collision() {

    }


    public void draw(Graphics2D g2) {

        // Draw Player 1
        BufferedImage player1Image = null; 
        switch (playerA.direction) {
            case "left":
            if (spriteNum == 1) {
                player1Image = leftA1;
            }
            if (spriteNum == 2) {
                player1Image = leftA2;
            }
            if (spriteNum == 3) {
                player1Image = leftA3;
            }
            if (spriteNum == 4) {
                player1Image = leftA4;
            }
            if (spriteNum == 5) {
                player1Image = leftA5;
            }
            if (spriteNum == 6) {
                player1Image = leftA6;
            }
                break;
            case "right":
            if (spriteNum == 1) {
                player1Image = rightA1;
            }
            if (spriteNum == 2) {
                player1Image = rightA2;
            }
            if (spriteNum == 3) {
                player1Image = rightA3;
            }
            if (spriteNum == 4) {
                player1Image = rightA4;
            }
            if (spriteNum == 5) {
                player1Image = rightA5;
            }
            if (spriteNum == 6) {
                player1Image = rightA6;
            }
                break;
        }
        if (player1Image != null) {
            g2.drawImage(player1Image, playerA.x, playerA.y, gamePanel.playerSizeX, gamePanel.playerSizeY, null);
            g2.fillRect(playerACollision.x, playerACollision.y, playerACollision.width, playerACollision.height);
            Graphics2D g2d = (Graphics2D) g2;
    
            g2d.draw(getBoundsBottomA());
            g2d.draw(getBoundsLeftA());
            g2d.draw(getBoundsRightA());
            g2d.draw(getBoundsA());
        }
    
        // Draw Player 2
        BufferedImage player2Image = null;
        switch (playerB.direction) {
            case "left":
            if (spriteNum == 1) {
                player2Image = leftB1;
            }
            if (spriteNum == 2) {
                player2Image = leftB2;
            }
            if (spriteNum == 3) {
                player2Image = leftB3;
            }
            if (spriteNum == 4) {
                player2Image = leftB4;
            }
            if (spriteNum == 5) {
                player2Image = leftB5;
            }
            if (spriteNum == 6) {
                player2Image = leftB6;
            }
                break;
            case "right":
            if (spriteNum == 1) {
                player2Image = rightB1;
            }
            if (spriteNum == 2) {
                player2Image = rightB2;
            }
            if (spriteNum == 3) {
                player2Image = rightB3;
            }
            if (spriteNum == 4) {
                player2Image = rightB4;
            }
            if (spriteNum == 5) {
                player2Image = rightB5;
            }
            if (spriteNum == 6) {
                player2Image = rightB6;
            }
                break;
        }
        if (player2Image != null) {
            g2.drawImage(player2Image, playerB.x, playerB.y, gamePanel.playerSizeX, gamePanel.playerSizeY, null);
            Graphics2D g2d = (Graphics2D) g2;
    
            g2d.draw(getBoundsBottomB());
            g2d.draw(getBoundsLeftB());
            g2d.draw(getBoundsRightB());
            g2d.draw(getBoundsB());
        }
        }
    }

    
