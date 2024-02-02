import java.awt.event.KeyEvent
import java.awt.event.KeyListener

public class KeyHandler : KeyListener {
    // Boolean variables to track key states
    public  var rightPressed = false
    public var leftPressed = false
    public var upPressed = false
    public var downPressed = false
    override fun keyTyped(e: KeyEvent?) {}

    // Method called when a key is pressed
    override fun keyPressed(e: KeyEvent?) {
        val code = e?.keyCode
        when (code) {
            KeyEvent.VK_UP -> upPressed = true
            KeyEvent.VK_DOWN -> downPressed = true
            KeyEvent.VK_LEFT -> leftPressed = true
            KeyEvent.VK_RIGHT -> rightPressed = true
        }
    }

    // Method called when a key is released
    override fun keyReleased(e: KeyEvent?) {
        val code = e?.keyCode
        when (code) {
            KeyEvent.VK_UP -> upPressed = false
            KeyEvent.VK_DOWN -> downPressed = false
            KeyEvent.VK_LEFT -> leftPressed = false
            KeyEvent.VK_RIGHT -> rightPressed = false
        }
    }
}
