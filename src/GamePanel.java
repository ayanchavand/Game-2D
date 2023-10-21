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

    Thread gameThread;

    //GamePanel constructor for applying the window settings
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.red);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
       gameThread.start();
    }
    @Override
    public void run() {
        while (gameThread != null) {
            //System.out.println("Game Thread is active! LESGOO");
            //1. Update
            update();
            //2. DrawCall
            repaint();
        }
    }

    public void update(){

    }

    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, tileSize, tileSize);
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(tileSize , 0, tileSize, tileSize);

    }
}
