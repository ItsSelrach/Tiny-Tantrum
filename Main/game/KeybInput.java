package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeybInput implements KeyListener {

    public boolean aPressed, dPressed, spacePressed, shiftPressed; 

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A){
            aPressed = true;
        }
        if(code == KeyEvent.VK_D){
            dPressed = true;
        }
        if(code == KeyEvent.VK_SPACE ){
            spacePressed = true;
        }
        if(code == KeyEvent.VK_SHIFT) {
            shiftPressed = true;
            System.out.println("shift key pressed"); // Debug statement
        }
        

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_A){
            aPressed = false;
        }
        if(code == KeyEvent.VK_D){
            dPressed = false;
        }
        if(code == KeyEvent.VK_SPACE ){
            spacePressed = false;
        }
        if(code == KeyEvent.VK_SHIFT) {
            shiftPressed = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}
}