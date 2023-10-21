import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //RENDER SETTINGS
    final int originalTileSize =  20;
    final int scale = 2;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 10;
    final int maxScreenRow= 10;
    final int screenWidth = maxScreenCol * tileSize;
    final int screenHeight = maxScreenRow * tileSize;

    int FPS = 60;

    int playerX = 0;
    int playerY = 0;

    int playerSpeed = 2;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    //GamePanel constructor for applying the window settings
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.red);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
       gameThread.start();
    }
    @Override
    public void run() {

        double drawInterval = (double) 1000000000 /FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            //System.out.println("Game Thread is active! LESGOO");
            //1. Update
            update();
            //2. DrawCall
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void update(){
        if(keyHandler.downPressed){
            playerY += playerSpeed;
        }
        if(keyHandler.upPressed){
            playerY -= playerSpeed;
        }
        if(keyHandler.leftPressed){
            playerX -= playerSpeed;
        }
        if(keyHandler.rightPressed){
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(playerX, playerY, tileSize, tileSize);

    }
}
