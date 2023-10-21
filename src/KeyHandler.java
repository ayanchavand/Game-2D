import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean rightPressed, leftPressed, upPressed, downPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP){
            System.out.println("UP PRESSED");
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN){
            System.out.println("DOWN PRESSED");
            downPressed = true;
        }
        if (code == KeyEvent.VK_LEFT){
            System.out.println("LEFT PRESSED");
            leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT PRESSED");
            rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if (code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
}
