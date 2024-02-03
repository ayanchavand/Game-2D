import java.awt.*
import javax.swing.JPanel

class GamePanel : JPanel(), Runnable {
    // RENDER SETTINGS
    val screenWidth = 1000
    val screenHeight = 800
    var FPS = 60

    var gameThread: Thread? = null
    val objectHandler = ObjectHandler()
    var keyHandler = KeyHandler()
    var physics = Physics(objectHandler)


    fun initialize(){
        val obj1 = GameObject(color = Color	(219,100,100), keyHandler = keyHandler, speed = 6)
        val obj2 = GameObject(color = Color(46,117,130), keyHandler = keyHandler)
        val obj3 = GameObject(color = Color	(109,204,109), keyHandler = keyHandler, speed = 4)

        objectHandler.addObject(obj1)
        objectHandler.addObject(obj2)
        objectHandler.addObject(obj3)

        val cmd = cmd(objectHandler)
        cmd.start()
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

        var previousTime = System.nanoTime()
        // Timing variables for consistent frame rate
        val drawInterval = 1000000000.0 / FPS
        var nextDrawTime = System.nanoTime() + drawInterval

        // Game loop
        while (gameThread != null) {
            val currentTime = System.nanoTime() // Get the current time
            val deltaTime = (currentTime - previousTime) / 1_000_000_000.0 // Calculate delta time in seconds
            previousTime = currentTime

            // Update game state
            update(deltaTime)
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
    fun update(deltaTime: Double) {
        objectHandler.updateAll()
        physics.applyGravity()
    }

    // Method to render graphics
    public override fun paintComponent(graphics: Graphics) {
        super.paintComponent(graphics)
        val graphics2D = graphics as Graphics2D
        objectHandler.renderAll(graphics2D)
        graphics2D.font = Font("Arial", Font.BOLD, 30) // Change font size
        graphics2D.color = Color.white // Change text color
        graphics2D.drawString("Send help", 1370, 30)
    }
}