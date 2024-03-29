import java.awt.Color
import java.awt.Graphics2D

open class GameObject(
    val mass: Float = 10f,
    var positionX: Int = 0,
    var positionY:Int = 0,
    var velocityX: Float = 0f,
    var velocityY: Float = 0f,
    var colliderX: Int = 40,
    var colliderY: Int = 40,
    var collidable: Boolean = true,
    val scaleX: Int = 40,
    val scaleY: Int = 40,
    val speed: Int = 2,
    val keyHandler: KeyHandler,
    val color: Color = Color.WHITE,
    val isKinematic: Boolean = true

){

    open fun render(graphics2D: Graphics2D){
        graphics2D.color = color
        graphics2D.fillRect(positionX, positionY, scaleX, scaleY)
        if(collidable){
            graphics2D.color = Color.green
            graphics2D.drawRect(positionX, positionY, colliderX, colliderY)
        }
    }
    open fun update(){
        if (keyHandler.downPressed) {
            positionY += speed
        }
        if (keyHandler.upPressed) {
            positionY -= speed
        }
        if (keyHandler.leftPressed) {
            positionX -= speed
        }
        if (keyHandler.rightPressed) {
            positionX += speed
        }
        // Prevent the object from moving outside the screen boundaries
        positionX = positionX.coerceIn(0, 1000 - scaleX)
        positionY = positionY.coerceIn(0, 800 - scaleY)


    }
}
