package main;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;  
    final int scale = 3;  
    public final int tileSize = originalTileSize * scale;  
    final int maxScreenCol = 16;  
    final int maxScreenRow = 12;  
    final int screenWidth = tileSize * maxScreenCol;  
    final int screenHeight = tileSize * maxScreenRow;  

    int FPS = 60;  // Frames per second

    KeyHandler keyH = new KeyHandler();  
    Thread gameThread;  

    player player = new player(this, keyH);  

    public GamePanel() {
        this.setPreferredSize(new java.awt.Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);  
        this.setDoubleBuffered(true);  
        this.addKeyListener(keyH);  
        this.setFocusable(true);  
    }

    // Start the game thread
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS; 
        double delta = 0;  
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();  
                repaint(); 
                delta--;  
                drawCount++;  
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);  
                drawCount = 0;
                timer = 0;
            }
        }
    }

   
    public void update() {
        player.update();  
    }

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;  

        player.draw(g2);  

        g2.dispose();  
    }
}