package main;


import javax.swing.JFrame;
public class main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        
        // Set window properties
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setResizable(false);  
        window.setTitle("Red Rectangle Movement"); 

        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

       
        window.pack();
        window.setLocationRelativeTo(null);  
        window.setVisible(true);

        
        gamePanel.startGameThread();
    }
}


