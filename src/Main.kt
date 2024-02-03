import java.awt.Color
import javax.swing.JFrame

fun main() {
        // Create a new JFrame window
        val window = JFrame()

        // Set window properties
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) // Close operation
        window.setTitle("GAME") // Title
        window.setResizable(false) // Disable resizing

        // Create a new instance of GamePanel
        val gamePanel = GamePanel()
        // Add GamePanel to the JFrame window
        window.add(gamePanel)
        // Pack the components within the window
        window.pack()
        // Center the window on the screen
        window.setLocationRelativeTo(null)
        // Make the window visible
        window.isVisible = true
        // Start the game thread in the GamePanel instance
        gamePanel.startGameThread()

        gamePanel.initialize()

}

