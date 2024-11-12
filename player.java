package main;
import java.awt.Graphics2D;
import java.awt.Color;


public class player {  
    GamePanel gp;
    KeyHandler keyH;

    public int x, y;  
    public int speed = 4;  

    public player(GamePanel gp, KeyHandler keyH) {  
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
    }

    public void update() {
        if (keyH.upPressed) {
            y -= speed;  
        }
        if (keyH.downPressed) {
            y += speed;  
        }
        if (keyH.leftPressed) {
            x -= speed;  
        }
        if (keyH.rightPressed) {
            x += speed;  
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);  
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);  
    }
}
