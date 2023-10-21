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
            System.out.println("Game Thread is active! LESGOO");
            //1. Update
            //2. DrawCall
        }
    }
}
