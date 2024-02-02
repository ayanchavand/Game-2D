import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JPanel

class GamePanel : JPanel(), Runnable {
    // RENDER SETTINGS
    val screenWidth = 1920
    val screenHeight = 1080
    var FPS = 60

    var gameThread: Thread? = null
    val objectHandler = ObjectHandler()
    var keyHandler = KeyHandler()


    fun initialize(){
        val obj1 = GameObject(color = Color.RED, keyHandler = keyHandler, speed = 6)
        val obj2 = GameObject(color = Color.BLUE, keyHandler = keyHandler)
        val obj3 = GameObject(color = Color.GREEN, keyHandler = keyHandler, speed = 4)

        objectHandler.addObject(obj1)
        objectHandler.addObject(obj2)
        objectHandler.addObject(obj3)
    }
    // GamePanel constructor for applying the window settings
    init {
        // Set JPanel properties
        this.preferredSize = Dimension(screenWidth, screenHeight) // Size
        setBackground(Color.black) // Background color
        this.isDoubleBuffered = true // Double buffering
        addKeyListener(keyHandler) // Add KeyListener
        setFocusable(true) // Set focusable
    }

    // Method to get the KeyHandler instance
    fun sendKeyHandler(): KeyHandler {
        return keyHandler
    }

    // Method to start the game thread
    fun startGameThread() {
        gameThread = Thread(this)
        gameThread!!.start()

    }

    // Main game loop
    override fun run() {
        // Timing variables for consistent frame rate
        val drawInterval = 1000000000.0 / FPS
        var nextDrawTime = System.nanoTime() + drawInterval

        // Game loop
        while (gameThread != null) {
            // Update game state
            update()
            // Repaint the screen
            repaint()
            // Control frame rate
            try {
                var remainingTime = nextDrawTime - System.nanoTime()
                remainingTime = remainingTime / 1000000
                if (remainingTime < 0) {
                    remainingTime = 0.0
                }
                Thread.sleep(remainingTime.toLong())
                nextDrawTime += drawInterval
            } catch (e: InterruptedException) {
                throw RuntimeException(e)
            }
        }
    }

    // Method to update game state
    fun update() {
        objectHandler.updateAll()
    }

    // Method to render graphics
    public override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)
        val graphics2D = graphics as Graphics2D
        objectHandler.renderAll(graphics2D)
    }
}