package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {
    
    protected float x, y;
    //protected float velX = 0, velY = 0; 

    protected ObjectId id;

    public GameObject(float x, float y, ObjectId id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    

    public abstract void tick (LinkedList<GameObject> object);
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect((int)x, (int)y, 64, 64);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
  

}
