import java.awt.Graphics2D

class ObjectHandler {
    val gameObjects: MutableList<GameObject> = mutableListOf()

    fun addObject(gameObject: GameObject) {
        gameObjects.add(gameObject)
    }

    fun removeObject(gameObject: GameObject) {
        gameObjects.remove(gameObject)
    }

    fun updateAll() {
        for (gameObject in gameObjects) {
            gameObject.update()
        }
    }

    fun renderAll(graphics2D: Graphics2D) {
        for (gameObject in gameObjects) {
            gameObject.render(graphics2D)
        }
    }

}